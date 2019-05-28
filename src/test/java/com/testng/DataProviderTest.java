package com.testng;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class DataProviderTest {
	
	Logger log = Logger.getLogger(DataProviderTest.class.getName());
	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("https://register.theiia.org/");

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
	
	
	@DataProvider
	public Object [][] testData() {
		//fname lastname 
		//fname lastname 
		Object [][] data = new Object[3][2];
		//1st row
		data[0][0]="Mike";
		data[0][1]="Tyson";
		//2nd row
		data[1][0]="Kobe";
		data[1][1]="Bryant";
		//3rd row
		data[2][0]="Floyed";
		data[2][1]="Mayweather";
		return data;
	}
	
	
	@Test (dataProvider="testData")
	public void uspsSigninTestFromSchedulePickupPage(String firstName, String lastName) {
		driver.findElement(By.name("txtFirstName")).sendKeys(firstName);
		driver.findElement(By.name("txtLastName")).sendKeys(lastName);
	
	}

}
