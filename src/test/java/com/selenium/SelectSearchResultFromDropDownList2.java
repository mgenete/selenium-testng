package com.selenium;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class SelectSearchResultFromDropDownList2 {
	
	
	
	Logger log = Logger.getLogger(SelectSearchResultFromDropDownList2.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;
	public TestUtil util;
	By fromCity = By.xpath("//input[@id='fromCity1']");
	
	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		util = new TestUtil();
		driver.get("https://www.alaskaair.com/");

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
	
	
	
	
	public void enterSearchText(String cityName) {
		driver.findElement(fromCity).click();
		driver.findElement(fromCity).sendKeys(cityName);
		util.waitFor(2);
		driver.findElement(fromCity).sendKeys(Keys.DOWN);
		
		//use JS DOM to  extract hidden elements, coz Se can not identify hidden elements (Ajax implementation)
		String script = "return document.getElementById(\"fromCity1\").value;";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String text = (String) js.executeScript(script);
		
		int i=0;
		while(!text.equalsIgnoreCase("New Haven, CT (HVN-New Haven)")) {
			i++;
			driver.findElement(fromCity).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);
			if(i>7) {
				break;
			}
		}
		if(i>7) {
			System.out.println("Element not found");
		}
		else {
			System.out.println("Element is found: "+text);
		}
	}
		
	
	@Test
	public void validateGoogleSearch() {
		enterSearchText("New");
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
