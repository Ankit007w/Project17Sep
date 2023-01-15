package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class FailedTest extends TestBase {

LoginPage login;
	
	@BeforeMethod 
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test (enabled=true)
	public void test1()
	{
		boolean result = login.verifyLoginLogo();
		Assert.assertEquals(result, true);
	}
	
	@Test (enabled=true)
	public void test2()
	{
		boolean result = login.verifyLoginLogo();
		Assert.assertEquals(result, false);
	}
	
	@Test (enabled=true)
	public void test3()
	{
		boolean result = login.verifyLoginLogo();
		Assert.assertEquals(result, true);
	}
	
	@Test (enabled=true)
	public void test4()
	{
		boolean result = login.verifyLoginLogo();
		Assert.assertEquals(result, false);
	}
	
	@Test (enabled=true)
	public void test5()
	{
		boolean result = login.verifyLoginLogo();
		Assert.assertEquals(result, true);
	}
	
	@AfterMethod 
	public void closeBrowser()
	{
		driver.close();
	}
}
