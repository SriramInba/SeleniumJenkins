package Training.SeleniumFrameworkDesign;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Training.POM.CheckOut;
import Training.POM.ProductCatalog;
import Training.testcomponents.Baseclass;
import Training.testcomponents.*;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Errorvalidation extends Baseclass {

	@Test(groups = {"errortest"},retryAnalyzer=Retry.class)
	public void LoginCheck() throws InterruptedException, IOException {
		LP1.loginmethod("sriraminba04@gmail.com", "Test@123");
		Assert.assertEquals(LP1.geterrormsg(), "Incorrect email or password.");
	}

	@Test(groups = {"errortest"},retryAnalyzer=Retry.class)
	public void Cartcheck() throws InterruptedException, IOException {
		ProductCatalog PC = LP1.loginmethod("sriraminba03@gmail.com", "Test@123");
		CheckOut CO = PC.addToCart();
		Assert.assertFalse(CO.cart().stream().anyMatch(s -> s.getText().contains("ZARA1")));
	}

}
