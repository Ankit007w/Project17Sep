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

public class CaptureScreenshotforFailed extends TestBase {

LoginPage login;
	
	@BeforeMethod 
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test (enabled=true)
	public void verifyTitleTest()
	{
		String expTitle= "Swag Labs";
		String actTitle=login.verifyTitle();
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log(actTitle);
	}	
	
	@AfterMethod 
	public void closeBrowser(ITestResult a) throws Exception
	{
		if(ITestResult.FAILURE == a.getStatus())
			UtilityMethod.captureScreenshot(a.getName());
		driver.close();
	}
}
