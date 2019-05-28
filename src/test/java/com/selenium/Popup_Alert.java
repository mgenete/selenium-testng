package com.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Popup_Alert {

	public static void main(String[] args) {


		
		System.setProperty("webdriver.chrome.driver", "C:\\SITS\\selenium\\chromedriver_2.38.exe");
	    WebDriver driver = new ChromeDriver();



		/*Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		alert.dismiss();*/
		
	   /* WebDriverWait wait = new WebDriverWait(driver, 10);
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	    alert.authenticateUsing(new UserAndPassword("username","password"));
*/

	}

}
