package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CartPage extends TestBase{

	@FindBy(xpath = "//span[text()='Your Cart']") private WebElement yourCart;
	@FindBy(id = "checkout") private WebElement checkoutBtn;	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckout() throws Exception
	{
		checkoutBtn.click();
		Thread.sleep(1000);
		return driver.getCurrentUrl();
	}
	
	public boolean yourCartLogo()
	{
		return yourCart.isDisplayed();
	}
}
