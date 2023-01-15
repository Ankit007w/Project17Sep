package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.UtilityMethod;

public class LoginPageTest extends TestBase {

	LoginPage login; //= new LoginPage();
	
	@BeforeMethod (alwaysRun=true)
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test (dependsOnMethods = {"verifyTitleTest","verifyLoginPageURLTest"}, enabled=false)
	public void loginToAppTest() throws Exception
	{
		String expRes = "https://www.saucedemo.com/inventory.html";
		String actRes = login.loginToApp();
		Assert.assertEquals(actRes, expRes);
	}

	@Test (enabled=true)
	public void verifyLoginLogoTest()
	{
		boolean result = login.verifyLoginLogo();
		Assert.assertEquals(result, true);
	}
	
	@Test (enabled=false, priority=3)
	public void verifyBotLogoTest()
	{
		boolean result = login.verifyBotLogo();
//		Assert.assertEquals(result, true);
		Assert.assertTrue(result);
	}
	
	@Test (groups="Smoke", priority=2, enabled=true)
	public void verifyTitleTest()
	{
		String expTitle= "Swag Labs";
		String actTitle=login.verifyTitle();
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log(actTitle);
	}	
	
	@Test (groups= {"Smoke","Regression"}, priority=1, enabled=false)
	public void verifyLoginPageURLTest()
	{
		String expURL= "https://www.saucedemo.com/";
		String actURL= login.verifyLoginPageURL();
		Assert.assertEquals(actURL, expURL);
		Reporter.log(actURL);
	}
//	
	@AfterMethod (alwaysRun=true)
	public void closeBrowser(ITestResult a) throws Exception
	{
		if(ITestResult.FAILURE == a.getStatus())
			UtilityMethod.captureScreenshot(a.getName());
		driver.close();
	}
	
	
}
