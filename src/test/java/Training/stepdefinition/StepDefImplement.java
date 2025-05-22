package Training.stepdefinition;

import io.cucumber.java.en.*;

import java.io.IOException;

import org.testng.Assert;

import Training.POM.CheckOut;
import Training.POM.LandingPage;
import Training.POM.OrderPage;
import Training.POM.ProductCatalog;
import Training.testcomponents.Baseclass;


public class StepDefImplement extends Baseclass{

	public LandingPage LP1;
	public ProductCatalog PC1;
	public CheckOut CO1;
	public OrderPage OP1;
	@Given("Land on Ecommerce page")
	public void Land_on_Ecommerce_page() throws IOException
	{
		LP1 = landing();
	}
	
	@Given("^Login with username (.+) and password (.+)$")
	public void Login_with_username_and_password(String username, String pwd)
	{
		PC1 = LP1.loginmethod(username, pwd);	
	}
	
	@When("I add the product ZARA to cart")
	public void I_add_the_product_ZARA_to_cart()
	{
		CO1 = PC1.addToCart();
	}
	@And("Checkout ZARA and submit")
	public void Checkout_ZARA_and_submit() throws InterruptedException {
		Assert.assertTrue(CO1.cart().stream().anyMatch(s->s.getText().contains("ZARA")));
		OP1 = CO1.checkout();
	}
	@Then("Verify the order confirmation and message displayed {string}")
	public void Verify_the_order_confirmation_and_message_displayed(String string)
	{
		Assert.assertEquals(OP1.placeorder(),string);
		driver.close();
	}
	
	@Then("{string} Popup display")
	public void errorpopup(String string)
	{
		Assert.assertEquals(LP1.geterrormsg(), string);
		driver.close();
	}
	
}
