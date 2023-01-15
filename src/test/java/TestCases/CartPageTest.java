package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;

public class CartPageTest extends TestBase {
	LoginPage login;
	InventoryPage inv;
	CartPage cart;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
		inv = new InventoryPage();
		cart = new CartPage();
		login.loginToApp();
		inv.addProduct();
	}
	
	@Test
	public void verifyCheckoutTest() throws Exception
	{
		String expResult = "https://www.saucedemo.com/checkout-step-one.html";
		String actResult = cart.verifyCheckout();
		Assert.assertEquals(expResult, actResult);
	}
	
//	@Test
//	public void yourCartLogoTest()
//	{
//		boolean result = cart.yourCartLogo();
//		Assert.assertEquals(result, true);
//	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
