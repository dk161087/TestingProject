package org.step;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.data.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	WebDriver driver;

	@Given("user is on Adactin Hotel application on chrome browser")
	public void userIsOnAdactinHotelApplicationOnChromeBrowser() {
	    
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/");
		
	}
	@When("user enters {string} and {string}")
	public void userEntersAnd(String string, String string2) {
	    
		driver.findElement(By.id("username")).sendKeys(string);
		driver.findElement(By.id("password")).sendKeys(string2);
		
	}
	@When("user clicks on login button")
	public void userClicksOnLoginButton() {
	    
		driver.findElement(By.name("login")).click();
		
	}
	@When("user selects {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void userSelects(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
	    
		WebElement location = driver.findElement(By.xpath("//select[@id='location']"));
		
		Select s1 = new Select(location);
		
		s1.selectByVisibleText(string);
		
		WebElement hotels = driver.findElement(By.xpath("//select[@id='hotels']"));
		
		Select s2 = new Select(hotels);
		
		s2.selectByVisibleText(string2);
		
		WebElement roomType = driver.findElement(By.xpath("//select[@id='room_type']"));

		Select s3 = new Select(roomType);
		
		s3.selectByVisibleText(string3);
		
		WebElement roomCount = driver.findElement(By.xpath("//select[@id='room_nos']"));
		
		Select s4 = new Select(roomCount);
		
		s4.selectByVisibleText(string4);
		
		driver.findElement(By.xpath("//input[@id='datepick_in']")).clear();
		
		driver.findElement(By.xpath("//input[@id='datepick_in']")).sendKeys(string5);
		
		driver.findElement(By.xpath("//input[@id='datepick_out']")).clear();
		
		driver.findElement(By.xpath("//input[@id='datepick_out']")).sendKeys(string6);
		
		WebElement adultsCount = driver.findElement(By.xpath("//select[@id='adult_room']"));
		
		Select s5 = new Select(adultsCount);
		
		s5.selectByVisibleText(string7);
		
		WebElement childCount = driver.findElement(By.xpath("//select[@id='child_room']"));
		
		Select s6 = new Select(childCount);
		
		s6.selectByVisibleText(string8);
		
	}
	@When("user clicks on search button")
	public void userClicksOnSearchButton() {
	    
		driver.findElement(By.xpath("//input[@id='Submit']")).click();
		
	}
	@When("user selects a hotel")
	public void userSelectsAHotel() {
	    
		driver.findElement(By.xpath("//input[@id='radiobutton_0']")).click();
		
	}
	@When("user clicks on continue button")
	public void userClicksOnContinueButton() {
	    
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
	}
	@When("user enters {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void userEnters(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
	    
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(string);
		
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(string2);
		
		driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys(string3);
		
		driver.findElement(By.xpath("//input[@id='cc_num']")).sendKeys(string4);
		
		WebElement cardType = driver.findElement(By.xpath("//select[@id='cc_type']"));
		
		Select s7 = new Select(cardType);
		
		s7.selectByVisibleText(string5);
		
		WebElement expMonth = driver.findElement(By.xpath("//select[@id='cc_exp_month']"));
		
		Select s8 = new Select(expMonth);
		
		s8.selectByVisibleText(string6);
		
		WebElement expYear = driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
		
		Select s9 = new Select(expYear);
		
		s9.selectByVisibleText(string7);
		
		driver.findElement(By.xpath("//input[@id='cc_cvv']")).sendKeys(string8);
		
	}
	@When("user clicks on book now button")
	public void userClicksOnBookNowButton() {
	    
		driver.findElement(By.xpath("//input[@id='book_now']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	@Then("user validates the order id")
	public void userValidatesTheOrderId() {
	    
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='order_no']")));

		WebElement orderNum = driver.findElement(By.xpath("//input[@id='order_no']"));
		String attributeValue = orderNum.getAttribute("value");
		System.out.println(attributeValue);
		
	}

}
