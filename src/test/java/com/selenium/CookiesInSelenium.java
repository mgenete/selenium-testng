package com.selenium;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CookiesInSelenium {
	
	/*cookies are used to store user's identity and track where the user navigated through out the page
	stored in client's hard disk by web server
	contains cookies lifetime,value name of server
	stores info in the form of key-value pair*/
	
	@Test
	public void enterText() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\SITS\\selenium\\chromedriver_2.38.exe");
	    WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/index.html");
		
		//Cookie cookie = new Cookie(name, value)
		Cookie cookie = new Cookie("customeCookie", "12345");
		driver.manage().addCookie(cookie);
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cook: cookies) {
			System.out.println(cook);
		}
	}
	
	@Test
	public void getCookie() throws IOException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\SITS\\selenium\\chromedriver_2.38.exe");
	    WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/index.html");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Tpeter");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Tpeter12");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@type='submit']")));
	
		
		File file = new File("Cookies.data");
		file.createNewFile();
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bWriter = new BufferedWriter(fileWriter);
		
		
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie getCookes : cookies) {
			bWriter.write(getCookes.getName()+";"+getCookes.getValue()+";"+getCookes.getDomain()+";"+getCookes.getPath()+";"+getCookes.getExpiry()+";"+getCookes.isSecure());
			bWriter.newLine();
		}
		bWriter.close();
		fileWriter.close();
		
	}

}
