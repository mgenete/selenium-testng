package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLcertificateConcept {

	public static void main(String[] args) {

		//used to set general browser capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.acceptInsecureCerts();
		
		
		//belongs to local browser, used to set local browser settings
		ChromeOptions option = new ChromeOptions(); 
		
		//--method-1
		//option.merge(cap);
		
		//--method-2
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		/*
		static java.lang.String	ACCEPT_INSECURE_CERTS 
		static java.lang.String	ACCEPT_SSL_CERTS 
		static java.lang.String	APPLICATION_NAME 
		static java.lang.String	BROWSER_NAME 
		static java.lang.String	BROWSER_VERSION 
		static java.lang.String	VERSION */
		
		
		
	}

}
