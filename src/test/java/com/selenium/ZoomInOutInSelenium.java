package com.selenium;


import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class ZoomInOutInSelenium {

	Logger log = Logger.getLogger(ZoomInOutInSelenium.class.getName());

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
	public void zoomInOutTest() {
		TestUtil util = new TestUtil();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom = '40%'");
		
		util.waitFor(2);
		
		js.executeScript("document.body.style.zoom = '100%'");
				
	}
}
