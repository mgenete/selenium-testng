package com.crm.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FeaturesPage;
import com.qa.pages.PricingPage;
import com.qa.pages.RegistrationPage;

public class PricingPageTest {
	
	
	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;
	public PricingPage pricingPage;
	
	
	
	
	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("https://classic.crmpro.com/pricing.html");
		pricingPage = new PricingPage(driver);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void validatePageTitle() {
	
		Assert.assertEquals(pricingPage.validatePageTitle(), "CRMPRO PRICING");
	}
	

}
