package com.selenium;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class SelectDropDownBootstrap {

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
	//	driver.quit();
	}

	@Test
	public void selectFromDropDown() {

		driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//a//label"));

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getText().contains("Angular")) {
				list.get(i).click();
				break;
			}
		}

	}

}
