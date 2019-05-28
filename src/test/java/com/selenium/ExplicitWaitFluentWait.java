package com.selenium;


import java.util.Properties;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class ExplicitWaitFluentWait {

	Logger log = Logger.getLogger(ExplicitWaitFluentWait.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("https://www.midwestone.com/");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		driver.quit();
	}

	

	@Test
	public void explicitWaitTest() {
		//NoSuchElementException
		WebDriverWait wait = new WebDriverWait(driver, 12);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[class='demo-frame']"))));
	}
	
	
	@Test
	public void fluentWaitTest() {
		
	}
	

}
