package com.selenium;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class FramesInSelenium {

	static Logger log = Logger.getLogger(FramesInSelenium.class.getName());

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		driver.quit();
	}

	@Test
	public void SwithToFrameTest_1() {
		driver.get("https://jqueryui.com/droppable/");
		List<WebElement> frameList = driver.findElements(By.cssSelector("[class='demo-frame']"));
		for (int i = 0; i < frameList.size(); i++) {
			driver.switchTo().frame(frameList.get(i));
		}

		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.id("draggable")))
				.moveToElement(driver.findElement(By.id("droppable"))).release().build().perform();

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[@id='sidebar']//ul//li/a[contains(text(),'Draggable')]")).click();
	}

	public static int findFrameNumber(WebDriver driver, By by) {
		int i;
		List<WebElement> iframe = driver.findElements(By.tagName("frame"));
		for (i = 0; i < iframe.size(); i++) {
			driver.switchTo().frame(i);

			if (driver.findElements(by).size() > 0) {
				break;

			} else {
				log.info("continue looping");
			}
		}
		driver.switchTo().defaultContent();
		return i;
	}

	@Test
	public void SwithToFrameTest_2() {
		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Tpeter");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Tpeter12");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@type='submit']")));

		int frameID = findFrameNumber(driver, By.xpath("//a[contains(text(),'Contacts')]"));
		driver.switchTo().frame(frameID);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")));
	}

}
