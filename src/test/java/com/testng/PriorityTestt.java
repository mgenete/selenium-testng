package com.testng;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class PriorityTestt {
	
	Logger log = Logger.getLogger(PriorityTestt.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;
	public TestUtil util;

	
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
	
	
	@Test (priority = 1)
	public void clickOnWealth() {
		driver.findElement(By.xpath("//ul[@id='choose-site']/li[2]/a")).click();
		util.waitFor(2);
		log.info(driver.getTitle());
	}
	
	@Test (priority = 2)
	public void clickOnBusiness() {
		driver.findElement(By.xpath("//ul[@id='choose-site']/li[3]/a")).click();
		util.waitFor(2);
		log.info(driver.getTitle());
	}
	
	@Test (priority = 3)
	public void clickOnCommercial() {
		driver.findElement(By.xpath("//ul[@id='choose-site']/li[4]/a")).click();
		util.waitFor(2);
		log.info(driver.getTitle());
	}
	
	@Test (priority = 4)
	public void clickOnCapitalMarkets() {
		driver.findElement(By.xpath("//ul[@id='choose-site']/li[5]/a")).click();
		util.waitFor(2);
		log.info(driver.getTitle());
	}

}
