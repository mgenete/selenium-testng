package com.selenium;


import java.util.Arrays;
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

public class Calendar_3 {

	boolean dateNotFound = true;
	List<String> monthList = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sept","Oct","Nov","Dec");
	Logger log = Logger.getLogger(Calendar_3.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("https://www.redbus.in/");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		//driver.quit();
	}

	
	
	public void enterSourceAndDestinationCity() {
		driver.findElement(By.id("src")).clear();
		driver.findElement(By.id("src")).click();
		driver.findElement(By.id("src")).sendKeys("Pune");
		driver.findElement(By.xpath(".//*[@id='search']/div/div[1]/div/ul/li[1]")).click(); //select 1st search result from drop down list
		
		driver.findElement(By.id("dest")).clear();
		driver.findElement(By.id("dest")).click();
		driver.findElement(By.id("dest")).sendKeys("Bangalore");
		driver.findElement(By.xpath(".//*[@id='search']/div/div[2]/div/ul/li[1]")).click();  //select 1st search result from drop down list
	}
	
	public void selectDate(String date) {
		WebElement datePicker = driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']"));
		List<WebElement> dates = datePicker.findElements(By.tagName("td"));
		for(WebElement temp : dates) {
			if(temp.getText().equals(date)) {
				temp.click();
				break;
			}
		}
	}
	
	
	public void selectDate_Month_Year(String expDate, int expMonth, int expYear) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//input[@id='onward_cal']")));
		
		while(dateNotFound) {
			String monthYear = driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']//table//td[@class='monthTitle']")).getAttribute("innerHTML");
			String[] monthYearArray = monthYear.split(" ");
			String month = monthYearArray[0];
			int year = Integer.parseInt(monthYearArray[1]);
			
			//If the current(displayed) month and year are same as expected month and year then go Inside this condition.
			if(monthList.indexOf(month)+1 == expMonth && year == expYear) {
				selectDate(expDate);
				dateNotFound = false;
			
			//If current(displayed) month and year are less than expected month and year then go Inside this condition. //Click on next button of date picker.
			} else if (monthList.indexOf(month)+1 < expMonth && expYear == year || expYear > year) {
				js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']//button[.='>']")));
			
				//If current selected month and year are greater than expected month and year then go Inside this condition.
			} else if (monthList.indexOf(month)+1 > expMonth && year == expYear || year < expYear) {
				js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']//button[.='<']")));
			}
		}
	}
	
	

	@Test
	public void selectDate_Month_YearTest() {
		selectDate_Month_Year("4", 5, 2019);
	}
}
