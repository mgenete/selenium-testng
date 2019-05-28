package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class TestUtil {
	
	private static WebDriver driver;
	public static long Implicit_TimeOut = 15;
	public static long PageLoad_TimeOut = 15;
	public static Workbook book;
	public static Sheet sheet;
	
	
	public static void getScreenShot(String result) {
		
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshot\\"+result+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\testdata\\TestData.xlsx");
		book = WorkbookFactory.create(fis);
		sheet = book.getSheet(sheetName);
		
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	public void waitFor(int sec)  {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void explicitWait(int timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement getWebElement( int timeOutInSeconds, By element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		
	}
	
	public void switchFrame(String frame) {
		driver.switchTo().frame(frame);
		
	}

}
