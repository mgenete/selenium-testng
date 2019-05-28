package com.selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class LimitingWebDriverScope {

	Logger log = Logger.getLogger(LimitingWebDriverScope.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("https://www.usps.com/");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		driver.quit();
	}

	@Test
	public void limitingDriverScopeTest() {
		// find number of links in page
		int linksInPage = driver.findElements(By.tagName("a")).size();
		System.out.println("Number of links in the page: " + linksInPage);

		// get the footer links basket
		WebElement footerDriver = driver.findElement(By.id("global-footer--wrap"));
		int linksInFooter = footerDriver.findElements(By.tagName("a")).size();
		System.out.println("Number of links in the page footer: " + linksInFooter);

		// get the 'OTHER USPS SITES' column basket within the footer basket
		WebElement columnDriver = footerDriver.findElement(By.xpath("//div[@id='global-footer--wrap']//ol[2]/li[2]/ol"));
		int linksInColumn = columnDriver.findElements(By.tagName("a")).size();
		System.out.println("Number of links in the (OTHER USPS SITES) column: " + linksInColumn);
		
		List<WebElement> link = columnDriver.findElements(By.tagName("a"));
		
		for(int i=0; i<link.size(); i++) {
			link.get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		}
		
		Set<String> wind = driver.getWindowHandles();
		Iterator<String> it = wind.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			driver.close();
		}
	}

}
