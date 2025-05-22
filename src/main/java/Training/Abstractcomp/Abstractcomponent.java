package Training.Abstractcomp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Training.POM.OrderPage;

public class Abstractcomponent {
	
	WebDriver driver;
	
	public Abstractcomponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}

	@FindBy(css="[routerlink*=myorders]")
	WebElement myorders;

	public void waittovisible(By findby) {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waittovisiblewebelement(WebElement findby) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
		}
	
	public void waittoinvisible(WebElement webby) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(webby));
		
		}
	public OrderPage gotoorderpage()
	{
		myorders.click();
		OrderPage OP = new OrderPage(driver);
		return OP;
	}
	 
}
 