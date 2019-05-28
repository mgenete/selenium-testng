package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverWithActionClass {
	
	
	public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver = new FirefoxDriver();
	Actions action = new Actions(driver);
	

	//==============DOUBLE CLICK====================================
	WebElement element = driver.findElement(By.xpath("//img[@src='http://www.mouseprogram.com/squrirel2.jpg']"));
	action.moveToElement(element).doubleClick().build().perform();
	
	
	//=========================DRAG AND DROP=========================
	WebElement sourceElement = driver.findElement(By.id("draggable"));
	WebElement targetElement = driver.findElement(By.id("droppable"));
	
	action.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();

	
	//================MOUSE OVER==================================
	WebElement contacts = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
	action.moveToElement(contacts).build().perform();
	
	
	//================RIGHT CLICK==================================
	action.moveToElement(element).contextClick().build().perform();
	
	
	//================WTIH KEYS CLASS ==================================
	WebElement firstname = driver.findElement(By.name("firstname"));
	WebElement lastname = driver.findElement(By.name("lastname"));
	WebElement email = driver.findElement(By.name("reg_email__"));
	WebElement pass = driver.findElement(By.name("reg_passwd__"));
	
	action = new Actions(driver);
	action.keyDown(firstname, Keys.SHIFT).sendKeys("Abebe").keyUp(firstname,Keys.SHIFT).build().perform();
	action.keyDown(lastname, Keys.SHIFT).sendKeys("Abera").keyUp(lastname, Keys.SHIFT).build().perform();
	action.keyDown(email, Keys.SHIFT).sendKeys("abera@gmail.com").keyUp(lastname, Keys.SHIFT).build().perform();
	action.keyDown(pass, Keys.SHIFT).sendKeys("0123456789").sendKeys(pass, Keys.SHIFT).build().perform();
	
	}
}
