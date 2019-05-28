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

public class RegistrationPageTest {
	
	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;
	public RegistrationPage registrationPage;
	public FeaturesPage featuresPage;
	public PricingPage pricingPage;
	
	
	
	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		registrationPage = new RegistrationPage(driver);
		featuresPage = new FeaturesPage(driver);
		pricingPage = new PricingPage(driver);
				
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	@Test
	public void validateRegistrationPageTitle() {
		Assert.assertEquals(registrationPage.validatePageTitle(), "CRMPRO - CRM Pro for customer relationship management, sales, and support");
	}
	
	@Test
	public void validatePricingLinkTest() {
		registrationPage.vaidatePricingLink();
		Assert.assertEquals(pricingPage.validatePageTitle(), "CRMPRO PRICING");
	}
	
	@Test
	public void validateFeaturesLinkTest() {
		registrationPage.vaidateFeaturesLink();
		Assert.assertEquals(featuresPage.validatePageTitle(), "CRM Pro Best Features and CRM Value Best ROI Web Hosted CRM Software");
	}

}
