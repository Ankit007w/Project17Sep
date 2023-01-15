package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class Checkout2 extends TestBase {

	@FindBy(id = "finish") private WebElement finishBtn;
	
	public Checkout2()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyFinish() throws Exception
	{
		finishBtn.click();
		Thread.sleep(1000);
		return driver.getCurrentUrl();
	}
	
}
