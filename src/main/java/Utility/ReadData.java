package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

	public static String readPropertyFile(String value) throws Exception
	{
		Properties p = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\ankit\\eclipse-workspace\\Project17Sep\\TestData\\config.properties");
		p.load(file);
		return p.getProperty(value);
	}
	
	public static String readExcelFile(int row, int col) throws Exception
	{
		FileInputStream file = new FileInputStream("C:\\Users\\ankit\\eclipse-workspace\\Project17Sep\\TestData\\Data.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = excel.getRow(row).getCell(col).getStringCellValue();
		return value;
	}
}
