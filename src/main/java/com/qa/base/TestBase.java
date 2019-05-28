package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;




	public class TestBase {

	
	public WebDriver driver;
	public Properties prop;
	
	static Logger log = Logger.getLogger(TestBase.class.getName());
	public static final String USERNAME = "xxx";
	public static final String AUTOMATE_KEY = "xxx";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	
	public Properties initProperties() {
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	
	public WebDriver initBrowser(String browserName) {
		
		if (browserName.equalsIgnoreCase("firefox")) {
			log.info("Executing on firefox");
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver =  new FirefoxDriver();
			
		} else if (browserName.equalsIgnoreCase("chrome")) {
			log.info("Executing on chrome");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("ie")) {
			log.info("Executing on IE");
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		} else if (browserName.equalsIgnoreCase("edge")) {
			log.info("Executing on Edge");
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "/drivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitlyWait")), TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	
	
	public WebDriver initSeGrid(String browserName) {
		
		if (browserName.equalsIgnoreCase("firefox")) {
			log.info("Executing on Firefox");
			 DesiredCapabilities caps = new DesiredCapabilities();
			 caps.setCapability("browser", "Firefox");
			 caps.setCapability("browser_version", "62.0");
			 caps.setCapability("os", "Windows");
			 caps.setCapability("os_version", "10");
			 caps.setCapability("resolution", "1024x768");
			 FirefoxOptions options = new FirefoxOptions();
			 options.merge(caps);
			 
			 try {
				driver = new RemoteWebDriver(new URL(URL), options);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			 
		} else if (browserName.equalsIgnoreCase("chrome")) {
			log.info("Executing on Chrome");
			 DesiredCapabilities caps = new DesiredCapabilities();
			    caps.setCapability("browser", "Chrome");
			    caps.setCapability("browser_version", "69.0");
			    caps.setCapability("os", "Windows");
			    caps.setCapability("os_version", "10");
			    caps.setCapability("resolution", "1024x768");
			    ChromeOptions options = new ChromeOptions();
			    options.merge(caps);
			    
			    try {
			    	driver = new RemoteWebDriver(new URL(URL), options);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			    
		} else if (browserName.equalsIgnoreCase("edge")) {
			log.info("Executing on MS Edge");
			 DesiredCapabilities caps = new DesiredCapabilities();
			    caps.setCapability("browser", "Edge");
			    caps.setCapability("browser_version", "17.0");
			    caps.setCapability("os", "Windows");
			    caps.setCapability("os_version", "10");
			    caps.setCapability("resolution", "1024x768");
			    EdgeOptions options = new EdgeOptions();
			    options.merge(caps);
			    
			    try {
			    	driver = new RemoteWebDriver(new URL(URL), options);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}    
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitlyWait")), TimeUnit.SECONDS);
		
		return driver;
	}
	
}
