package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.Checkout1;
import Pages.InventoryPage;
import Pages.LoginPage;

public class Checkout1Test extends TestBase {
	
	LoginPage login;
	InventoryPage inv;
	CartPage cart;
	Checkout1 check1;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
		inv = new InventoryPage();
		cart = new CartPage();
		login.loginToApp();
		inv.addProduct();
		cart.verifyCheckout();
		check1 = new Checkout1(); 
	}
	
	@Test
	public void verifyContinueTest() throws Exception
	{
		String expResult = "https://www.saucedemo.com/checkout-step-two.html";
		String actResult = check1.verifyContinue();
		Assert.assertEquals(expResult, actResult);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
}
