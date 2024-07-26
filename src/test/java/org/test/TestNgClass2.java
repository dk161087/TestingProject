package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgClass2 {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	private void tc() {
		
		driver.get("https://www.facebook.com/");
		
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys("8072830083");
		
		WebElement passWord = driver.findElement(By.id("pass"));
		passWord.sendKeys("Testaccount@007");
		
	}
	
	@Test(dependsOnMethods = "tc")
	private void tc1() {
		
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
	}
	
	@AfterClass
	private void afterClass() {
		

		
	}

}
