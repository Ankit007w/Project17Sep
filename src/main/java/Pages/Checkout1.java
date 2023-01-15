package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class Checkout1 extends TestBase {

	@FindBy(id = "first-name") private WebElement firstName;
	@FindBy(id = "last-name") private WebElement lastName;
	@FindBy(id = "postal-code") private WebElement postalCode;
	@FindBy(id = "continue") private WebElement continueBtn;
	
	public Checkout1()
	{
		PageFactory.initElements(driver, this);
	}

	public String verifyContinue() throws Exception
	{
		firstName.sendKeys(ReadData.readPropertyFile("firstName"));
		lastName.sendKeys(ReadData.readPropertyFile("lastName"));
		postalCode.sendKeys(ReadData.readPropertyFile("postalCode"));
		Thread.sleep(1000);
		continueBtn.click();
		return driver.getCurrentUrl();
	}
	
	
}
