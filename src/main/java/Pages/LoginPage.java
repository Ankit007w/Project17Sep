package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class LoginPage extends TestBase {

	//object repository
	@FindBy(xpath = "//div[@class='login_logo']") private WebElement loginLogo;
	@FindBy(xpath = "//div[@class='bot_column']") private WebElement botLogo;
	@FindBy(xpath = "//input[@name='user-name']") private WebElement username;
	@FindBy(xpath = "//input[@name='password']") private WebElement password;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginBtn;

	//constructor to initialize the elements of page
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String loginToApp() throws Exception
	{
		username.sendKeys(ReadData.readPropertyFile("username"));
//		username.sendKeys(ReadData.readExcelFile(0, 0));
		password.sendKeys(ReadData.readPropertyFile("password"));
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	
	public boolean verifyLoginLogo()
	{
		return loginLogo.isDisplayed();
	}
	
	public boolean verifyBotLogo()
	{
		return botLogo.isDisplayed();
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyLoginPageURL()
	{
		return driver.getCurrentUrl();
	}
}
