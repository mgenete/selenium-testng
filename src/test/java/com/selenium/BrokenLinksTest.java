package com.selenium;

import java.net.HttpURLConnection;
import java.net.URL;
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

import com.qa.base.TestBase;

public class BrokenLinksTest {

	Logger log = Logger.getLogger(BrokenLinksTest.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

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
	public void getLinks() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		List<WebElement> activeLinks = new ArrayList<WebElement>();

		for (int i = 0; i < allLinks.size(); i++) {
			if (allLinks.get(i).getAttribute("href") != null) {
				activeLinks.add(allLinks.get(i));
			}
		}
		
		log.info("size of all links is: " + allLinks.size());
		log.info("size of active links is: " + activeLinks.size());

		for (int j = 0; j < activeLinks.size(); j++) {
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href"))
						.openConnection();
				connection.connect();
			
				if (connection.getResponseCode() != 200) {
					log.info(activeLinks.get(j).getAttribute("href") + "-->" + connection.getResponseMessage());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
