package com.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;

public class VerifyPresenceOfText {

	
	Logger log = Logger.getLogger(VerifyPresenceOfText.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;
	SoftAssert softAssert = new SoftAssert();
	
	
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
	
	
	
	@Test
	public void isTextPresent() {
		
		List<String> expected = new ArrayList<String>();
		expected.add("Bank Accounts ");
		expected.add("Credit Cards ");
		expected.add("Mortgages ");
		
		List<WebElement> name = driver.findElements(By.xpath("//li[@id='personal-site-wrapper']/section/nav/ul/li/a"));
		
		for(int i=0; i<name.size(); i++) {
			softAssert.assertTrue(expected.contains(name.get(i).getText()), "Text is present");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
