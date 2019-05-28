package com.selenium;


import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class FileUploadInSelenium {

	Logger log = Logger.getLogger(FileUploadInSelenium.class.getName());

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
		driver.get("https://www.camerashuttercount.com/");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		driver.quit();
	}

	

	@Test
	public void uploadFileTest() {
		driver.findElement(By.cssSelector("input#file")).sendKeys(System.getProperty("user.dir") + "/imageOnejpg.jpg");
		util.waitFor(2);
		driver.findElement(By.xpath("//input[@type='submit' and @name='commit']")).click();
		
		String message = driver.findElement(By.xpath("//div[@class='information' ]//preceding-sibling::h3[contains(text(),'Results')]")).getText();
		Assert.assertEquals(message,"RESULTS");
	}
	

}
