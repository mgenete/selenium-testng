package com.qa.pages;



import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.base.TestBase;

public class RegistrationPage extends TestBase{
	
	
	
	static Logger log = Logger.getLogger(RegistrationPage.class.getName());
	
	@FindBy(xpath = "//a[contains(text(),'Pricing')]")
	WebElement pricing;

	@FindBy(xpath = "//a[contains(text(),'Features')]")
	WebElement features;

	@FindBy(xpath = "//a[contains(text(),'Customers')]")
	WebElement customers;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement contacts;

	
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public PricingPage vaidatePricingLink() {
		pricing.click();
		return new PricingPage(driver);
	}
	
	public FeaturesPage vaidateFeaturesLink() {
		features.click();
		return new FeaturesPage(driver);
	}
	
	

}
