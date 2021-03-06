package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class TestUtil {
	public static WebDriver driver;
	 public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT = 20;

	static Workbook book;
	static Sheet sheet;
	
public static Object[][] getTestData(String sheetName) {
	FileInputStream file = null;
	try {
		file = new FileInputStream("E:\\Selenium_Practice\\FrameWork\\FreeCRMTest\\src\\main"
				+ "\\java\\com\\crm\\qa\\testdata\\PNRExcelData.xlsx");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		book = WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	// System.out.println(sheet.getLastRowNum() + "--------" +
	// sheet.getRow(0).getLastCellNum());
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			// System.out.println(data[i][k]);
		}
	}
	return data;
}
public static void takeScreenshotAtEndOfTest() {
	
	File  srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
	try {
	FileUtils.copyFile(srcFile, new File("E:\\Selenium_Practice\\FrameWork\\FreeCRMTest\\ScreenShots"));
	}
	catch(IOException e) {
		e.printStackTrace();
	}
}
}