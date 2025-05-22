package Training.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Training.Abstractcomp.Abstractcomponent;

public class CheckOut extends Abstractcomponent{

	WebDriver driver;
	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement gotocart;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartprod;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	By row = By.cssSelector(".totalRow button");
	
	public List<WebElement> cart() throws InterruptedException
	{
		Thread.sleep(5000);
		gotocart.click();
		return cartprod;	
	}
	public OrderPage checkout()
	{
		//Assert.assertTrue(cartprod.stream().anyMatch(s->s.getText().contains("ZARA")));
		waittovisible(row);
		checkout.click();
		OrderPage OP = new OrderPage(driver);
		return OP;
	}
	
	
	
}
