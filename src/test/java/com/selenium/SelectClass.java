package com.selenium;


import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class SelectClass {

	Logger log = Logger.getLogger(SelectClass.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("https://www.freecrm.com/index.html");

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Tpeter");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Tpeter12");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@type='submit']")));
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		driver.quit();
	}

	
	
	@Test
	public void select() {
		driver.switchTo().frame("mainpanel");
		
//		WebElement month = driver.findElement(By.xpath("//select[@name='slctMonth']"));
//		WebElement year = driver.findElement(By.xpath("//select[@name='slctYear']"));
//		
//		Select sMth = new Select(month);
//		sMth.selectByVisibleText("August");
		
		
//		Select sYr = new Select(year);
//		sYr.selectByVisibleText("2000");
//		sYr.deselectAll();
		
		
		
		List<WebElement> monthList = driver.findElements(By.xpath("//select[@name='slctMonth']//option"));
		
		for(int i=0; i<monthList.size(); i++) {
			String mthList = monthList.get(i).getText();
			if(mthList.equals("October")) {
				monthList.get(i).click();
				break;
			}
		}
	}
	

	

}
