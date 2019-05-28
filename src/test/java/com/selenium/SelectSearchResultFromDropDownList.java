package com.selenium;

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

import com.qa.base.TestBase;

public class SelectSearchResultFromDropDownList {
	
	
	
	Logger log = Logger.getLogger(SelectSearchResultFromDropDownList.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;
	
	
	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("https://www.google.com/");

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
	
	
	
	public void googleSearch(String word) {
		driver.findElement(By.cssSelector("[name='q']")).click();
		driver.findElement(By.cssSelector("[name='q']")).sendKeys(word);
		
		List<WebElement> searchResult = driver.findElements(By.cssSelector("[class='erkvQe']"));
		for(int i=0; i<searchResult.size(); i++) {
			if(searchResult.get(i).getText().contains(word)) {
				log.info("Search word exists");
				searchResult.get(i).click();
				break;
			}
		}
	}
		
	
	@Test
	public void validateGoogleSearch() {
		googleSearch("bmo online banking");
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
