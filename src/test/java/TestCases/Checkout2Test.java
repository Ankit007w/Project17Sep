package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.Checkout1;
import Pages.Checkout2;
import Pages.InventoryPage;
import Pages.LoginPage;

public class Checkout2Test extends TestBase {

	LoginPage login;
	InventoryPage inv;
	CartPage cart;
	Checkout1 check1;
	Checkout2 check2;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
		inv = new InventoryPage();
		cart = new CartPage();
		check1 = new Checkout1(); 
		check2 = new Checkout2();
		login.loginToApp();
		inv.addProduct();
		cart.verifyCheckout();
		check1.verifyContinue();
	}
	
	@Test
	public void verifyFinishTest() throws Exception
	{
		String expResult = "https://www.saucedemo.com/checkout-complete.html";
		String actResult = check2.verifyFinish();
		Assert.assertEquals(expResult, actResult);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
	
}
