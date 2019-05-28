package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class IsDisplayedSelectedEnabled {

	public static void main(String[] args) {


		
		System.setProperty("webdriver.chrome.driver", "C:\\SITS\\selenium\\chromedriver_2.38.exe");
	    WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/index.html");
		
		WebElement signUp = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", signUp);
		
		
		Boolean success = driver.findElement(By.xpath("//button[@id='submitButton']")).isEnabled();
		if(success == true) {
			System.out.println("Submit button is enabled");
		}
		else {
			System.out.println("Submit button is not Enabled.");
		}
		
		
		WebElement edition = driver.findElement(By.xpath("//select[@id='payment_plan_id']"));
		String text = edition.getText();
		Boolean success2 = edition.isSelected();
		
		if(success2 == true && text.equals("Free Edition")) {
			System.out.println("Free Edition is selected by default");
		}
		else if(success2 == true && text.equals("CRMPRO - $29.95 user/mo. by default")){
			System.out.println("CRMPRO - $29.95 user/mo. by default");
		}
		else {
			System.out.println("Edition is seleted by default");
		}
		
		
		WebElement logo = driver.findElement(By.xpath("//img[@src='https://d19rqa8v8yb76c.cloudfront.net/img/freecrm.jpg']"));
		if(logo.isDisplayed()) {
			System.out.println("FreeCRM logo is displayed");
			
		}
		else {
			System.out.println("FreeCRM logo is missing grom the signup page");
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
