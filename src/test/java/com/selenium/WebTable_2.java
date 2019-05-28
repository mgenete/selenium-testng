package com.selenium;


import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class WebTable_2 {

	Logger log = Logger.getLogger(WebTable_2.class.getName());

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
		//driver.quit();
	}

	

	@Test
	public void clickOnCalculator() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Tools & Resources')]/parent::li[@id='headerNavSubItem602']"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Calculators')]/parent::li[@id='headerNavSubItem2038']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Get started')]")).click();
	}
	

}
