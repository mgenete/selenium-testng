package com.qa.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class FeaturesPage extends TestBase{
	
	
	
	
	
	public FeaturesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String validatePageTitle() {
		return driver.getTitle();
	}

}
