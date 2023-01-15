package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class UtilityMethod extends TestBase {

	public static void selectClass(WebElement ele, String opt)
	{
		Select s = new Select(ele);
		s.selectByVisibleText(opt);
	}
	
	public static void captureScreenshot(String name) throws Exception
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ankit\\eclipse-workspace\\Project17Sep\\Screenshots/"+name+".jpeg");
		FileHandler.copy(source, dest);
	}
}


