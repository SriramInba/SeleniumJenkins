package Training.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Training.Abstractcomp.Abstractcomponent;

public class ProductCatalog extends Abstractcomponent{
	
	WebDriver driver;
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(className="ngx-spinner")
	WebElement spinner;
	
	By productby = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toastmsg = By.id("toast-container");
	
	public List<WebElement> getprod()
	{
		waittovisible(productby);
		return products;
	}
	
	public WebElement getProdName()
	{
		WebElement prod = getprod().stream().filter(s->s.findElement(By.cssSelector("b")).getText().contains("ZARA")).findFirst().orElse(null);
		return prod;
		
	}
	
	public CheckOut addToCart()
	{
		WebElement prod = getProdName();
		prod.findElement(addtocart).click();
		waittovisible(toastmsg);
		waittoinvisible(spinner);
		CheckOut CO = new CheckOut(driver);
		return CO;
	}
	
	public CheckOut cartheader() {
		CheckOut CO = new CheckOut(driver);
		return CO;
	}
	
	}
