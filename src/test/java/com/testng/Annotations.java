package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite method");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass method");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod - runs before every @Test method");
	}

	@Test
	public void testCaseOne() {
		System.out.println("@Test - test case one");
	}
	
	@Test (dependsOnMethods="testCaseOne")
	public void testCaseTwo() {
		System.out.println("@Test - test case two");
	}

	@Test (enabled=false)
	public void testCaseThree() {
		System.out.println("@Test - test case three");
	}

	@AfterMethod 
	public void afterMethod() {
		System.out.println("@AfterMethod - runs after every @Test method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass method");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest method");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite method");
	}

}
