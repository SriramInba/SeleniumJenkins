package Training.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder*='Select Country']")
	WebElement Countrys;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectcountry;
	
	@FindBy(xpath="//a[normalize-space()='Place Order']")
	WebElement place;
	
	@FindBy(className="hero-primary")
	WebElement finalmsgs;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderlist;
	
	
	
	public String placeorder()
	{
		Actions a = new Actions(driver);
		//a.click(Country).build().perform();
		a.sendKeys(Countrys, "Ind").build().perform();
		selectcountry.click();
		place.click();
		return finalmsgs.getText();
	}
	public Boolean orderlists()
	{
		Boolean match = orderlist.stream().anyMatch(s->s.getText().contains("ZARA"));
		return match;
	}
	

}
