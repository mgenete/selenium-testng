package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;

public class KillProcessesRunningInBackground {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SITS\\selenium\\chromedriver_2.38.exe");
	    WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("https://www.bbc.com/sport/football/tables");
		
		//to kill excel
		WindowsUtils.killByName("excel.exe");
		//WindowsUtils.killByName("word.exe");
	}

}
