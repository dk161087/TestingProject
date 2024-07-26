package org.testing.testScripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.pages.AdactinLogin;
import org.pages.BookHotel;
import org.pages.BookingConfirmation;
import org.pages.SearchHotel;
import org.pages.SelectHotel;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.data.BaseClass;
import org.manage.PageManager;

public class AdactinHotel extends BaseClass {

	static String path = "D:\\JanBatch\\TestingProject\\TestData\\06062024.xlsx";
	PageManager page = new PageManager();

	@BeforeClass
	public static void beforeClass() {

		browserLaunch("chrome");
		loadUrl("https://adactinhotelapp.com/");
		maxWindow();

	}

	@Test
	public void TC_001() throws IOException {

		AdactinLogin loginPage = page.getAdactinLogin();

		WebElement userName = loginPage.getUserName();
		passValues(userName, excelRead(path, "LoginData", 1, 0));

		WebElement passWord = loginPage.getPassWord();
		passValues(passWord, excelRead(path, "LoginData", 1, 1));

		WebElement login = loginPage.getLogin();
		buttonClick(login);

	}

	@Test
	public void TC_002() throws IOException {

		SearchHotel searchPage = page.getSearchHotel();

		WebElement location = searchPage.getLocation();
		passValues(location, excelRead(path, "HotelData", 1, 0));

		WebElement hotels = searchPage.getHotels();
		passValues(hotels, excelRead(path, "HotelData", 2, 1));

		WebElement roomType = searchPage.getRoomType();
		passValues(roomType, excelRead(path, "HotelData", 3, 2));

		WebElement numOfRooms = searchPage.getNumOfRooms();
		passValues(numOfRooms, excelRead(path, "HotelData", 2, 3));

		WebElement checkInDate = searchPage.getCheckInDate();
		checkInDate.clear();
		passValues(checkInDate, excelRead(path, "HotelData", 1, 4));

		WebElement checkOutDate = searchPage.getCheckOutDate();
		checkOutDate.clear();
		passValues(checkOutDate, excelRead(path, "HotelData", 1, 5));

		WebElement adultsPerRoom = searchPage.getAdultsPerRoom();
		passValues(adultsPerRoom, excelRead(path, "HotelData", 2, 6));

		WebElement childrenPerRoom = searchPage.getChildrenPerRoom();
		passValues(childrenPerRoom, excelRead(path, "HotelData", 3, 7));

		WebElement search = searchPage.getSearch();
		buttonClick(search);

	}

	@Test
	public void TC_003() {

		SelectHotel hotelSelection = page.getSelectHotel();

		WebElement totalPrice = hotelSelection.getTotalPrice();
		String attributeValue = getAttributeValue(totalPrice);
		System.out.println(attributeValue);

		WebElement radioButton = hotelSelection.getRadioButton();
		buttonClick(radioButton);

		WebElement continueButton = hotelSelection.getContinueButton();
		buttonClick(continueButton);

	}
	
	@Test
	public void TC_004() throws IOException {
		
		BookHotel hotelBooking = page.getBookHotel();

		WebElement firstName = hotelBooking.getFirstName();
		passValues(firstName, excelRead(path, "BookingData", 1, 0));

		WebElement lastName = hotelBooking.getLastName();
		passValues(lastName, excelRead(path, "BookingData", 1, 1));

		WebElement billAddress = hotelBooking.getAddress();
		passValues(billAddress, excelRead(path, "BookingData", 1, 2));

		WebElement cardNum = hotelBooking.getCardNum();
		passValues(cardNum, excelRead(path, "BookingData", 2, 3));

		WebElement cardType = hotelBooking.getCardType();
		passValues(cardType, excelRead(path, "BookingData", 3, 4));

		WebElement expMonth = hotelBooking.getExpMonth();
		passValues(expMonth, excelRead(path, "BookingData", 4, 5));

		WebElement expYear = hotelBooking.getExpYear();
		passValues(expYear, excelRead(path, "BookingData", 5, 6));

		WebElement cvvNum = hotelBooking.getCvvNum();
		passValues(cvvNum, excelRead(path, "BookingData", 6, 7));

		WebElement bookNow = hotelBooking.getBookNow();
		buttonClick(bookNow);
		
		implicitlyWait();
		
	}
	
	@Test
	public void TC_005() {
		
		BookingConfirmation confirmBooking = page.getBookingConfirmation();

		WebElement orderNum = confirmBooking.getOrderNum();
		String attributeValue = getAttributeValue(orderNum);
		System.out.println(attributeValue);
		
	}

//	@BeforeTest
//	public void beforeTest() {
//
//		String expected = "Adactin.com - Hotel Reservation System";
//		String actual = getTheTitle();
//		Assert.assertEquals(expected, actual);
//
//	}
//
//	@AfterTest
//	public void afterTest() {
//
//		String expected = "https://adactinhotelapp.com/SearchHotel.php";
//		String actual = getCurrentUrl();
//		Assert.assertEquals(expected, actual);
//
//	}
//	
//	@AfterClass
//	public void afterClass() {
//
//		String expected = "https://adactinhotelapp.com/SearchHotel.php";
//		String actual = getCurrentUrl();
//		Assert.assertEquals(expected, actual);
//
//	}

}
