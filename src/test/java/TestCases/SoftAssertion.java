package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Pages.LoginPage;

public class SoftAssertion extends TestBase {

	LoginPage login;
	
	@BeforeMethod 
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
	}	
	
	@Test 
	public void verifyLoginPageURLTest()
	{
		System.out.println("Execution started");
		String expURL= "1https://www.saucedemo.com/";
		String actURL= login.verifyLoginPageURL();
		SoftAssert s = new SoftAssert();
		s.assertEquals(expURL, actURL);
		System.out.println("Execution ended");
		s.assertAll();
	}
	
	@AfterMethod 
	public void closeBrowser()
	{
		driver.close();
	}

}
