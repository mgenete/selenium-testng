package com.testng;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;


public class ExpectedExceptionsTest {
	
	Logger log = Logger.getLogger(ExpectedExceptionsTest.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

	
	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("https://www.bmo.com/main/personal");

	}

	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			log.info(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			log.info(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			log.info(result.getName() + " is pass");
		}

		if (driver != null) {
			driver.quit();
		}
	}
	
	
	@Test (expectedExceptions = NoSuchElementException.class )
	public void clickOnBankAccountLink() {
		driver.findElement(By.linkText("Bank Accounts ")).click();
	}


}
