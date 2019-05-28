package com.selenium;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;


public class WebTable_1 {
	
	
	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;
	
	
	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("https://www.bbc.com/sport/football/tables");
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	@Test
	public void leagueTablePointsTest() {
		
		List<WebElement> row = driver.findElements(By.xpath("//tbody[@class='gel-long-primer ']//tr"));
		
		String beforePath = "//tbody[@class='gel-long-primer ']/tr[";
	
		for(int i=1; i<row.size(); i++) {
			String won = driver.findElement(By.xpath(beforePath+i+"]/td[5]")).getText();
			String drawn = driver.findElement(By.xpath(beforePath+i+"]/td[6]")).getText();
			String points = driver.findElement(By.xpath(beforePath+i+"]/td[11]")).getText();

			Assert.assertEquals(Integer.parseInt(points), (Integer.parseInt(won)*3)+Integer.parseInt(drawn));
			
		}
		
	}

}
