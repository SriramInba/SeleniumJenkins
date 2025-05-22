package Training.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Training.Abstractcomp.Abstractcomponent;

public class LandingPage extends Abstractcomponent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement pwd;
	
	@FindBy(id="login")
	WebElement loginbutton;
	
//	ng-tns-c4-10 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error
	@FindBy(css="[class*='flyInOut']")
	WebElement errormsg;
	
	
	public ProductCatalog loginmethod(String emailid,String pwds)
	{
		email.sendKeys(emailid);
		pwd.sendKeys(pwds);
		loginbutton.click();
		ProductCatalog PC = new ProductCatalog(driver);
		return PC;
	}
	
	public String geterrormsg()
	{
		waittovisiblewebelement(errormsg);
		return errormsg.getText();
	}
	
	
	
	public void launch()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
