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

public class FeaturesPageTest {
	
	
	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;
	public RegistrationPage registrationPage;
	public FeaturesPage featurePage;
	
	
	
	
	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		driver.get("https://classic.crmpro.com/features.html");
		featurePage = new FeaturesPage(driver);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void validatePageTitle() {
	
		Assert.assertEquals(featurePage.validatePageTitle(), "CRM Pro Best Features and CRM Value Best ROI Web Hosted CRM Software");
	}
	
	

}
