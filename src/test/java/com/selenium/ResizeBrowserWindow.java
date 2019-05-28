package com.selenium;



import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class ResizeBrowserWindow {

	Logger log = Logger.getLogger(ResizeBrowserWindow.class.getName());

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
	public void windowResize() {
		//800 x 600
		//1024 X 768
		//1280 x 600
		//1280 x 720
		
		TestUtil util = new TestUtil();
		
		Dimension d = new Dimension(800, 600);
		driver.manage().window().setSize(d);
		util.waitFor(1);
	}

}
