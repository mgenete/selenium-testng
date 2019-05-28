package com.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

public class FindLargestSmallestPrice {

	Logger log = Logger.getLogger(FindLargestSmallestPrice.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("https://washingtondc.craigslist.org");

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
	public void getPrice() {

		WebElement element = driver.findElement(By.xpath("//*[@id='query']"));
		element.sendKeys("cycle");
		element.sendKeys(Keys.ENTER);

		List<WebElement> priceList = driver.findElements(By.xpath("//*[@id='mapcontainer']/following-sibling::ul/li/a/span"));
		List<Integer> convPrice = new ArrayList<Integer>();

		for (int i = 0; i < priceList.size(); i++) {
			convPrice.add(Integer.parseInt(priceList.get(i).getText().substring(1)));
		}

		int largest = convPrice.get(0);
		int smallest = convPrice.get(0);

		for (int j = 0; j < convPrice.size(); j++) {
			if (convPrice.get(j) > largest) {
				largest = convPrice.get(j);

			} else if (convPrice.get(j) < smallest) {
				smallest = convPrice.get(j);
			}
		}
		System.out.println("largest is " + largest);
		System.out.println("smallest is " + smallest);
	}

}
