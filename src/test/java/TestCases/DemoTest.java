package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class DemoTest extends TestBase {

LoginPage login; //= new LoginPage();
	
	@BeforeMethod 
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
	}	
	
	@Test (invocationCount=1, timeOut=200)
	public void verifyLoginPageURLTest()
	{
		System.out.println("Execution started");
		String expURL= "https://www.saucedemo.com/";
		String actURL= login.verifyLoginPageURL();
		Assert.assertEquals(actURL, expURL, "Whether test case fail");
		System.out.println("Execution ended");
	}
	
	@AfterMethod 
	public void closeBrowser()
	{
		driver.close();
	}

}
