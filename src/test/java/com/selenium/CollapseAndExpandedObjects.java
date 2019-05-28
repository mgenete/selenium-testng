package com.selenium;


import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class CollapseAndExpandedObjects {

	Logger log = Logger.getLogger(CollapseAndExpandedObjects.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("http://www.hdfcbank.com/htdocs/nri_banking/payments/BillPay/BillPay.htm");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		driver.quit();
	}

	

	@Test
	public void collapseAndExpandedObjectsTest() {
		String style = driver.findElement(By.xpath(".//*[@id='nre_savings_acc']/ul/li[2]/h3")).getCssValue("bg_collapsed_panel");
		System.out.println("Before Clicking" + style);
		/*
		if (style.contains("bg_collapsed_panel")) {
			Assert.assertTrue(true, style);
		} else {
			Assert.assertTrue(false, style);
		}*/
		
	}
	
	
	@Test
	public void collapseAndExpandedObjectsTest2() {
		
		String style = driver.findElement(By.xpath(".//*[@id='nre_savings_acc']/ul/li[2]/h3")).getCssValue("background-image");
		System.out.println("Before Clicking" + style);
	}

}
