package com.selenium;


import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class SelectDropDownByXpath {

	Logger log = Logger.getLogger(SelectDropDownByXpath.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("http://www.facebook.com");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		driver.quit();
	}
	
	
	public void selectValueFromDropDown(WebElement element, String value){
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
	}
	
	@Test
	public void selectDropDownTest_1() {
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		String dob = "10-May-1995";
		String dobArr[] = dob.split("-");
		
		selectValueFromDropDown(day, dobArr[0]);
		selectValueFromDropDown(month, dobArr[1]);
		selectValueFromDropDown(year, dobArr[2]);
	}

	public void selectDropDownValue(String xpathValue, String value){
		List<WebElement> monthList = driver.findElements(By.xpath(xpathValue));
		for(int i=0; i<monthList.size(); i++){
			if(monthList.get(i).getText().equals(value)){
				monthList.get(i).click();
				break;
			}
		}
	}

	@Test
	public void selectDropDownTest_2() {
		String month_xpath = "//select[@id='month']//option";
		String year_xpath = "//select[@id='year']//option";
		String day_xpath = "//select[@id='day']//option";
		
		selectDropDownValue(month_xpath, "Feb");
		selectDropDownValue(year_xpath, "1999");
		selectDropDownValue(day_xpath, "23");
	}
	

}
