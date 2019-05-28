package com.selenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class Popup_BrowserWindow {

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("https://classic.crmpro.com/index.html");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void browserPopTestUisngWindowHandler() {

		
		List<String> list = new ArrayList<String>();

		List<WebElement> navbar = driver.findElements(By.cssSelector("[id='navbar-collapse'] ul li a"));
		for (int i = 0; i < navbar.size(); i++) {
			navbar.get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
			
			
		}

		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		while (it.hasNext()) {
			list.add(it.next());
		}
		
		

		for (int i = 0; i < list.size(); i++) {
			driver.switchTo().window(list.get(i));
			System.out.println(list.get(i) + "->" + driver.getTitle());
			driver.close();
		}

	}

}
