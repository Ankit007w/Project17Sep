package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.UtilityMethod;

public class InventoryPageTest extends TestBase {
	
	LoginPage login;
	InventoryPage inv;
	
	@BeforeMethod (alwaysRun=true)
	public void setup() throws Exception
	{
		initialization();
		login=new LoginPage();
		inv= new InventoryPage();
		login.loginToApp();

	}
	
	@Test 
	public void addProductTest() throws Exception
	{
		String result = inv.addProduct();
		Assert.assertEquals(result, "4");	//4
	}
	
//	@Test (priority=6)
//	public void verifySwagBotLogoTest() throws Exception
//	{
//		boolean result = inv.verifySwagBotLogo();
//		Assert.assertEquals(result, true);
//	}
//	
//	@Test (priority=5)
//	public void verifyLinkdInIconTest() throws Exception
//	{
//		boolean result = inv.verifyLinkdInIcon();
//		Assert.assertEquals(result, true);
//	}
//	
//	@Test (priority=4)
//	public void verifyFacebookIconTest() throws Exception
//	{
//		boolean result = inv.verifyFacebookIcon();
//		Assert.assertEquals(result, true);
//	}
//	
//	@Test (priority=3)
//	public void verifyTwitterIconTest() throws Exception
//	{
//		boolean result = inv.verifyTwitterIcon();
//		Assert.assertEquals(result, true);
//	}
//	
	@Test (groups="Smoke", priority=1)
	public void verifyProductsLogoTest() throws Exception
	{
		boolean result = inv.verifyProductsLogo();
		Assert.assertEquals(result, true);
		Thread.sleep(2000);
	}
	
//	@Test (priority=2)
//	public void verifyPeekLogoTest() throws Exception
//	{
//		boolean result = inv.verifyPeekLogo();
//		Assert.assertEquals(result, true);
//	}
	
	@AfterMethod (alwaysRun=true)
	public void closeBrowser(ITestResult a) throws Exception
	{
		if(ITestResult.FAILURE == a.getStatus())
			UtilityMethod.captureScreenshot(a.getName());
		driver.close();
	}
}
