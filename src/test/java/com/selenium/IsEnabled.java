package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class IsEnabled {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\SITS\\selenium\\chromedriver_2.38.exe");
	    WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		WebElement oneWay = driver.findElement(By.cssSelector("[input#ctl00_mainContent_rbtnl_Trip_0]"));
		WebElement roundTrip = driver.findElement(By.cssSelector("[input#ctl00_mainContent_rbtnl_Trip_1]"));
		WebElement returnDate = driver.findElement(By.cssSelector("[input#ctl00_mainContent_view_date2]"));
		
		//enabled style=display: block; opacity: 0.5;
		//disabled display: block; opacity: 1;
		
		if(driver.findElement(By.xpath("div[@id=Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("its enabled");
			
		} else {
			System.out.println("its disbaled");
		}
		

	}

}
