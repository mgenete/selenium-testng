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

public class GetAllLinksImagesFromPage {

	Logger log = Logger.getLogger(GetAllLinksImagesFromPage.class.getName());

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
	public void getLinksTest() {
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for(int i=0; i<links.size(); i++) {
			if(links.get(i).isDisplayed()) {
			System.out.println(links.get(i).getAttribute("title"));
			}
		}
	}
	

}
