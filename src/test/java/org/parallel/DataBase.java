package org.parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataBase {
	
	@Test
	private void tc1() {
		
		System.out.println("DB-tc1");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
	}
	
	@Test
	private void tc2() {
		
		System.out.println("DB-tc2");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
	}
	
	@BeforeSuite
	private void beforeSuite() {
		
		System.out.println("Before Suite");
		
	}
	
	@AfterSuite
	private void afterSuite() {
		
		System.out.println("After Suite");
		
	}
	
	@BeforeTest
	private void beforeTest() {
		
		System.out.println("Before Test");
		
	}
	
	@AfterTest
	private void afterTest() {
		
		System.out.println("After Test");
		
	}
	
	

}

//testng.xml code parallel execution (methods, classes, tests)
//
//<?xml version="1.0" encoding="UTF-8"?>
//<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
//<suite name="Suite" parallel="methods">
//  <test thread-count="5" name="Test">
//    <classes>
//      <class name="org.data.DataBase"/>
//      <class name="org.data.ApiTesting"/>
//    </classes>
//    </test>
//    <test thread-count="5" name="Test1">
//    <classes>
//      <class name="org.data.AppiumTesting"/>
//      <class name="org.data.PerformanceTesting"/>
//    </classes>
//  </test> <!-- Test -->
//</suite> <!-- Suite -->

