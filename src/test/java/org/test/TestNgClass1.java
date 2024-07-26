package org.test;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.data.BaseClass;

public class TestNgClass1 extends BaseClass {
	
	static String path = "D:\\JanBatch\\TestingProject\\TestData\\06062024.xlsx";
	
	@BeforeClass
	private void beforeClass() {
		
		browserLaunch("chrome");
		loadUrl("https://adactinhotelapp.com/");
		maxWindow();
		
	}
//	
//	@Test(priority = 0, invocationCount = 3, dependsOnMethods = "tc1")
//	private void tc() {
//		
//		System.out.println("tc");
//		
//	}
//	
//	@Test(priority = 2)
//	private void tc1() {
//		
//		System.out.println("tc1");
//		
//	}
	
	@Test
	private void tc1() throws IOException {
		
		WebElement username = elementFind("xpath", "//input[@id='username']");
		passValues(username, excelRead(path, "LoginData", 1, 0));

		WebElement password = elementFind("xpath", "//input[@id='password']");
		passValues(password, excelRead(path, "LoginData", 1, 1));

		WebElement submit = elementFind("xpath", "//input[@type='Submit']");
		buttonClick(submit);

		WebElement location = elementFind("xpath", "//select[@id='location']");
		passValues(location, excelRead(path, "HotelData", 1, 0));

		WebElement hotels = elementFind("xpath", "//select[@id='hotels']");
		passValues(hotels, excelRead(path, "HotelData", 2, 1));

		WebElement roomType = elementFind("xpath", "//select[@id='room_type']");
		passValues(roomType, excelRead(path, "HotelData", 3, 2));

		WebElement roomCount = elementFind("xpath", "//select[@id='room_nos']");
		passValues(roomCount, excelRead(path, "HotelData", 2, 3));

		WebElement checkInDate = elementFind("xpath", "//input[@id='datepick_in']");
		checkInDate.clear();
		passValues(checkInDate, excelRead(path, "HotelData", 1, 4));

		WebElement checkOutDate = elementFind("xpath", "//input[@id='datepick_out']");
		checkOutDate.clear();
		passValues(checkOutDate, excelRead(path, "HotelData", 1, 5));

		WebElement adultsCount = elementFind("xpath", "//select[@id='adult_room']");
		passValues(adultsCount, excelRead(path, "HotelData", 2, 6));

		WebElement childCount = elementFind("xpath", "//select[@id='child_room']");
		passValues(childCount, excelRead(path, "HotelData", 3, 7));

		WebElement search = elementFind("xpath", "//input[@id='Submit']");
		buttonClick(search);

		WebElement totalPrice = elementFind("xpath", "//input[@id='total_price_0']");
		String text = getAttributeValue(totalPrice);
		System.out.println(text);
		
	}
	
//	@BeforeMethod
//	private void beforeMethod() {
//		
//		System.out.println("@BeforeMethod");
//		
//	}
//	
//	@AfterMethod
//	private void afterMethod() {
//		
//		System.out.println("@AfterMethod");
//		
//	}
//	
//	@AfterClass
//	private void afterClass() {
//		
//		System.out.println("@AfterClass");
//		
//	}

}
