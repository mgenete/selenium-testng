package com.selenium;


import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class Calendar_2 {

	Logger log = Logger.getLogger(Calendar_2.class.getName());

	 TestBase testBase;
	 WebDriver driver;
	 Properties prop;
	 TestUtil util;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		util = new TestUtil();
		driver.get("https://www.bmo.com/main/personal");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		driver.quit();
	}

	

	public void selectMonth(String month) {
		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);
	}
	
	
	public void selectYear(String year) {
		Select select = new Select(driver.findElement(By.name("slctYear")));
		select.selectByVisibleText(year);
		
	}
	
	
	public String[] enterDate(String date) { //3-April_2018
		String[] dateArray = date.split("-");
		return dateArray;
	}
	
	
	@Test
	public void clickOnDate() {

//		String date = "3-April_2018";
//		String[] dateArray = date.split("-");
//		String day = dateArray[0];
//		String month = dateArray[1];
//		String year = dateArray[2];
		
		String[] dateArray = enterDate("3-April_2018");

		selectMonth(dateArray[1]);
		selectYear(dateArray[2]);

		String beforeXpath = "//div[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath = "]/td[";
		final int totalWeekDays = 7;

		boolean flag = false;
		String dayVal = null;

		for (int i = 2; i <= 7; i++) {
			for (int j = 1; j <= totalWeekDays; j++) {

				try {
					dayVal = driver.findElement(By.xpath(beforeXpath + i + afterXpath + j + "]")).getText();
				} catch (NoSuchElementException e) {
					log.info("Please enter a correct date value");
					flag = false;
					break;
				}

				if (dayVal.equals(dateArray[0])) {
					driver.findElement(By.xpath(beforeXpath + i + afterXpath + j + "]")).click();
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}

		}

	}
	
	
	@Test
	public void clickOnDate_2() {

		String date = "3-April_2018";
		String[] dateArray = date.split("-");
		String day = dateArray[0];
		String month = dateArray[1];
		String year = dateArray[2];
		
		Select select1 = new Select(driver.findElement(By.name("slctMonth")));
		select1.selectByVisibleText(month);
		
		Select select2 = new Select(driver.findElement(By.name("slctYear")));
		select2.selectByVisibleText(year);
		
		String beforeXpath = "//div[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath = "]/td[";
		final int totalWeekDays = 7;
		
		boolean flag = false;
		int dayVal;
		for(int rowNum=2; rowNum<=7; rowNum++) {
			for(int colNum=1; colNum<=totalWeekDays; colNum++) {
				WebElement element = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]"));
				
				String value = element.getText();
				dayVal = Integer.parseInt(value);
				if (dayVal < 1 || dayVal > 31) {
					System.out.println("Please enter correct day value.");
					flag = false;
					break;
				}
				
				if(dayVal == Integer.parseInt(day)) {
					element.click();
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}

		}


	}
	
	

}
