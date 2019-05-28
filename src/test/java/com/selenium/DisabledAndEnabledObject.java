package com.selenium;


import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class DisabledAndEnabledObject {

	Logger log = Logger.getLogger(DisabledAndEnabledObject.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;
	TestUtil util;
	
	
	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		util = new TestUtil();

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		driver.quit();
	}

	

	@Test (enabled = false)
	public void disabledAndEnabledObjectTest_1() {
		driver.get("https://www.olx.in/bangalore/cars/q-swift/");
		
		//get class attribute pre data entry
		String className = driver.findElement(By.xpath(".//*[@id='param_model']")).getAttribute("class");
		log.info("Class attribute before data entry: "+className);
		Assert.assertEquals(className, "param paramSelect disabled");
	}
	
	@Test
	public void disabledAndEnabledObjectTest_2() {
		driver.get("https://classic.crmpro.com/register/");
		String status1 = driver.findElement(By.xpath("//button[@id='submitButton']")).getAttribute("disabled");
		log.info("Class attribute before data entry: "+status1);
		Assert.assertEquals(status1, "true");
		
		driver.findElement(By.xpath("//input[@name='agreeTerms']")).click();
		util.waitFor(2);
		String status2 = driver.findElement(By.xpath("//button[@id='submitButton']")).getAttribute("disabled");
		log.info("Class attribute before data entry: "+status2);
		Assert.assertNull(status2);
		
	}

}
