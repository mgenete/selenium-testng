package com.testng;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class ParameterAnnotation {

	
	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;
	public TestUtil util;

	
	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		util = new TestUtil();
		

	}
	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}
	
	
	@Parameters({"url","username","password"})
	@Test
	public void uspsSignin(String url, String username, String password) {
		driver.get(url);	
		driver.findElement(By.xpath("//a[@id='login-register-header']")).click();
		driver.findElement(By.cssSelector("input#username")).sendKeys(username);
		driver.findElement(By.cssSelector("input#password")).sendKeys(password);
		driver.findElement(By.cssSelector("button#btn-submit")).click();
		System.out.println(driver.getTitle());
	}
	
	
	
	
	
	
	
	
	
}
