package com.selenium;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class CompareImages {
	
	
	Logger log = Logger.getLogger(sample.class.getName());

	TestBase testBase;
	WebDriver driver;
	Properties prop;
	TestUtil util;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop = testBase.initProperties();
		driver = testBase.initBrowser(prop.getProperty("browser"));
		util = new TestUtil();
		driver.get("https://www.midwestone.com/");
		util.waitFor(3);
	}

	
	@AfterMethod
	public void tearDown(ITestResult result) {
		driver.quit();
	}

	
	public boolean compareImagePixel(String fileOne, String fileTwo) throws IOException {
		BufferedImage imgA = ImageIO.read(new File(fileOne));
		BufferedImage imgB = ImageIO.read(new File(fileTwo));

		if(imgA.getWidth() == imgB.getWidth() && imgA.getHeight() == imgB.getHeight()) {
			for(int x=0; x<imgA.getWidth(); x++) {
				for(int y=0; y<imgA.getHeight(); y++) {
					
					if(imgA.getRGB(x, y) != imgB.getRGB(x, y)) {
						
						log.info("pixel issue");
						return false;
					}
				}
			}
		}
			else {
				log.info("size issue");
				return false;
			}
			return true;
		}
	
	
	
	
	@Test
	public void compareImagesTest() throws IOException, InterruptedException {
		
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("HomePage_2.jpg"));
		if(compareImagePixel("HomePage_2.jpg", "HomePage_1.jpg")) {
			System.out.println("test is pass");
		}
		else {
			System.out.println("test is fail");
		}
	}
	
	
	
	
	
	
	
}
