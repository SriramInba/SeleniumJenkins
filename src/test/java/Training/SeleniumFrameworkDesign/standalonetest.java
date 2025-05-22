package Training.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Training.POM.LandingPage;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class standalonetest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage LP = new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("Sriraminba03@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@123");
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement getprod = products.stream().filter(s->s.findElement(By.cssSelector("b")).getText().contains("ZARA")).findFirst().orElse(null);
		getprod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartprod = driver.findElements(By.cssSelector(".cartSection h3"));
		//cartprod.stream().anyMatch(s->s.getText().contains("ZARA"));
		Assert.assertTrue(cartprod.stream().anyMatch(s->s.getText().contains("ZARA")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.cssSelector("input[type='text']")).clear();
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("1234 5678 9123 4567");
		WebElement months = driver.findElement(By.cssSelector(".input.ddl"));
		Select month = new Select(months);
		month.selectByIndex(4);
		WebElement years = driver.findElement(By.cssSelector(".input.ddl:last-child"));
		Select year = new Select(years);
		year.selectByIndex(5);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Sriram");
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder*='Select Country']")), "ind").build().perform();
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
		driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
		
		//System.out.println(driver.findElement(By.className("hero-primary")).getText());
		Assert.assertEquals(driver.findElement(By.className("hero-primary")).getText(),"THANKYOU FOR THE ORDER.");
		
		
		
		
		
		
		
	}

}
