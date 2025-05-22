package Training.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Training.POM.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public WebDriver driver;
	public LandingPage LP1;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\Studies\\Selenuim_JAVA_Udemy\\programs\\Training\\src\\test\\java\\Training\\resources\\Global.properties");
		prop.load(fis);
		//String browsername =  System.getProperty("browser")!=null ? System.getProperty("browser") : "firfox";
		
		String browsername = prop.getProperty("browser");
		//String browsername = "Firefox";
		if (browsername.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			if(browsername.contains("headless"))
			{
				options.addArguments("--headless");			
			}
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));

		} else if (browsername.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if(browsername.contains("headless"))
			{
				options.addArguments("--headless");
			}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver.manage().window().setSize(new Dimension(1440,900));
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	public List<HashMap<String, String>> getJsondata(String Filepath) throws IOException {
		String jsonfile = FileUtils.readFileToString(new File(Filepath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonfile,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getscreenshot(String testcasename,WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				"D:\\Studies\\Selenuim_JAVA_Udemy\\programs\\Training\\report\\" + testcasename + "image.png");
		FileUtils.copyFile(src, dest);
		return ("D:\\Studies\\Selenuim_JAVA_Udemy\\programs\\Training\\report\\" + testcasename + "image.png");

	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage landing() throws IOException {
		driver = initializeDriver();
		LP1 = new LandingPage(driver);
		LP1.launch();
		return LP1;
	}

	@AfterMethod(alwaysRun = true)
	public void close() {
		driver.close();
	}

}
