package com.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


	

public class JsUtil {
	
	
	private static WebDriver driver;
	
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0; i<100; i++) {
			changeColor("rgb(200,0,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor ='"+color+"'", element);
		
		try {
			Thread.sleep(20);
		} catch(InterruptedException e) {
			
		}
	}

	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}

	
	
	public static void refreshBrowserBYJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		return js.executeScript("return document.title;").toString();
	}
	
	
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		return js.executeScript("return document.documentElement.innerText;").toString();
	}
	
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void zoomInBy60Percentage() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom = '40%'");
		
		
	}

	public static void zoomOutTo100Percentage() {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("documnet.body.style.zoom = '100%'");
	}
	
}
