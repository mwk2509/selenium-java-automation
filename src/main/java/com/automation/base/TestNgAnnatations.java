package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnatations {

	// @BeforeSuite
	// @BeforeTest
	// @BeforeMethod
	// @BeforeClass
	
	// @Test
	
	// @AfterSuite
	// @AfterTest
	// @AfterMethod
	// @AfterClass
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod method");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest method");
	}
	
	WebDriver driver;
	
	@BeforeSuite
	public void setupSuite() {
	driver = new ChromeDriver();
	}
	 @Test
	 public void launch() 
	 { 
	   driver.get("https://www.google.com"); 
	  } 
	 
	 @AfterSuite 
	 public void closeDriver() 
	 { 
	   driver.close(); 
	  } 
	
	
		
	
	{
		System.out.println("chromedriver");
	}
	
	@Test
	public void test1() {
		System.out.println("Test1 method");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2 method");
	}
	
	@Test
	public void test3() {
		System.out.println("Test3 method");
	}
	
	@BeforeClass
	public void beforClass() {
		System.out.println("@BeforeClass method");
	}
	
	/** 
	beforeSuite method
	beforeTest method
	
	beforeMethod method
	Test1 method
	beforeMethod method
	Test2 method
	*/
	
}
