package com.selenium;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class AuthenticationPopUpHandle {
	
	
	
	Logger log = Logger.getLogger(sample.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		
		String username = "admin";
		String password = "admin";
		
		driver.get("http://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		//driver.quit();
	}
	
	
	@Test
	public void AuthenticationPopUpTest() {
		System.out.println(driver.getTitle());
	}

}
