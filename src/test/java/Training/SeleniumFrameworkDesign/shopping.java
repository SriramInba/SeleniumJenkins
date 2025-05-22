package Training.SeleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Training.POM.CheckOut;
import Training.POM.OrderPage;
import Training.POM.ProductCatalog;
import Training.testcomponents.Baseclass;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class shopping extends Baseclass{

	
	@Test(dataProvider="getdata",groups="logintest")
	public void purchase(HashMap <String,String> input) throws InterruptedException, IOException {
		ProductCatalog PC = LP1.loginmethod(input.get("email"),input.get("pwd"));	
		CheckOut CO = PC.addToCart();
		Assert.assertTrue(CO.cart().stream().anyMatch(s->s.getText().contains("ZARA")));
		OrderPage OP = CO.checkout();
		Assert.assertEquals(OP.placeorder(),"THANKYOU FOR THE ORDER.");
	}
	
	@Test(dependsOnMethods=("purchase"))
	public void OrderHistorycheck()
	{
		ProductCatalog PC = LP1.loginmethod("sriraminba03@gmail.com", "Test@123");	
		OrderPage OP = PC.gotoorderpage();
		Assert.assertTrue(OP.orderlists());
		
	}
	
	@DataProvider
	public Object[][] getdata() throws IOException
	{
		List<HashMap<String,String>> data = getJsondata("D:\\Studies\\Selenuim_JAVA_Udemy\\programs\\SeleniumFrameworkDesign\\src\\test\\java\\Automation\\data\\input.json");
		
		return new 	Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
	
	

}
