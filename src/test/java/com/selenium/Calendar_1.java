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
import com.qa.util.TestUtil;

public class Calendar_1 {

	Logger log = Logger.getLogger(Calendar_1.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;
	TestUtil util;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		util = new TestUtil();
	
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		//driver.quit();
	}

	@Test
	public void selectdate1() {
		String month = "June 2019";

		driver.get("http://www.phptravels.net");
		driver.findElement(By.xpath("//div[@id='dpd1']/div/input")).click();
		util.waitFor(2);

		while (true) {
			String currentMonth = driver
					.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div/table/thead/tr/th[2]"))
					.getText();
			if (currentMonth.equals(month)) {
				break;

			} else {
				driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div/table/thead/tr/th[3]"))
						.click();
			}
			driver.findElement(By
					.xpath("//div[@class='datepicker dropdown-menu'][1]/div/table/tbody/tr/td[contains(text(),'21')]"))
					.click();
		}
	}
	
	@Test
	public void selectdate2() {
		String day = "21";
		
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.xpath("//*[@id='travel_date']")).click();
		WebElement element = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"));
		
		while(!element.getText().contains("July")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
		
		//Grab common attribute//Put into list and iterate
		List<WebElement> days = driver.findElements(By.className("day"));
		for(int i=0; i<days.size(); i++) {
			if(days.get(i).getText().equalsIgnoreCase(day)) {
				days.get(i).click();
				break;
			}
		}
		
	}

}
