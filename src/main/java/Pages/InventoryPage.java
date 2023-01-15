package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.UtilityMethod;

public class InventoryPage extends TestBase{

	@FindBy(xpath = "//span[text()='Products']") private WebElement productsLogo;
	@FindBy(xpath = "//div[@class='peek']") private WebElement peekLogo;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterIcon;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookIcon;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement lindInIcon;
	@FindBy(xpath = "//img[@alt='Swag Bot Footer']") private WebElement swagBotLogo;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement productSortDrop;
	@FindBy(id = "add-to-cart-sauce-labs-backpack") private WebElement backpack;
	@FindBy(id = "add-to-cart-sauce-labs-bike-light") private WebElement bikeLight;
	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt") private WebElement boltTshirt;
	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket") private WebElement fleeceJacket;
	@FindBy(id = "shopping_cart_container") private WebElement prodCount;
	
	
	public InventoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String addProduct() throws Exception
	{
		UtilityMethod.selectClass(productSortDrop, "Name (Z to A)");
		Thread.sleep(2000);
		backpack.click();
		bikeLight.click();
		boltTshirt.click();
		fleeceJacket.click();
		Thread.sleep(2000);
		prodCount.click();
		return prodCount.getText();
	}
	
	public boolean verifySwagBotLogo()
	{
		return swagBotLogo.isDisplayed();
	}
	
	public boolean verifyLinkdInIcon()
	{
		return lindInIcon.isDisplayed();
	}
	
	public boolean verifyFacebookIcon()
	{
		return facebookIcon.isDisplayed();
	}
	
	public boolean verifyTwitterIcon()
	{
		return twitterIcon.isDisplayed();
	}
	
	public boolean verifyProductsLogo()
	{
		return productsLogo.isDisplayed();
	}
	
	public boolean verifyPeekLogo()
	{
		return peekLogo.isDisplayed();
	}
	
}
