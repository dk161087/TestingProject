package org.sample;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.data.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends BaseClass {
	
	static String path = "D:\\JanBatch\\TestingProject\\TestData\\21052024.xlsx";

	@Given("user is on Adactin Hotel application on chrome browser")
	public void user_is_on_adactin_hotel_application_on_chrome_browser() {

		browserLaunch("chrome");
		maxWindow();
		loadUrl("https://adactinhotelapp.com/");

	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String string, String string2) {

		elementFind("id", "username").sendKeys(string);
		elementFind("id", "password").sendKeys(string2);

	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {

		elementFind("name", "login").click();

	}

	@When("user selects location, hotels, room type, number of rooms, check in date, check out date, adults per room, children per room")
	public void user_selects_location_hotels_room_type_number_of_rooms_check_in_date_check_out_date_adults_per_room_children_per_room()
			throws IOException {

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

	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {

		WebElement search = elementFind("xpath", "//input[@id='Submit']");
		buttonClick(search);

	}

	@When("user selects a hotel")
	public void user_selects_a_hotel() {

		WebElement radioButton = elementFind("xpath", "//input[@type='radio']");
		buttonClick(radioButton);

	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() {

		WebElement submit = elementFind("xpath", "//input[@value='Continue']");
		buttonClick(submit);

	}

	@When("user enters first name, last name, billing address, credit card number, card type, month of expiry, year of expiry, cvv number")
	public void user_enters_first_name_last_name_billing_address_credit_card_number_card_type_month_of_expiry_year_of_expiry_cvv_number()
			throws IOException {

		WebElement firstName = elementFind("xpath", "//input[@id='first_name']");
		passValues(firstName, excelRead(path, "BookingData", 1, 0));

		WebElement lastName = elementFind("xpath", "//input[@id='last_name']");
		passValues(lastName, excelRead(path, "BookingData", 1, 1));

		WebElement billAddress = elementFind("xpath", "//textarea[@id='address']");
		passValues(billAddress, excelRead(path, "BookingData", 1, 2));

		WebElement cardNum = elementFind("xpath", "//input[@id='cc_num']");
		passValues(cardNum, excelRead(path, "BookingData", 2, 3));

		WebElement cardType = elementFind("xpath", "//select[@id='cc_type']");
		passValues(cardType, excelRead(path, "BookingData", 3, 4));

		WebElement expMonth = elementFind("xpath", "//select[@id='cc_exp_month']");
		passValues(expMonth, excelRead(path, "BookingData", 4, 5));

		WebElement expYear = elementFind("xpath", "//select[@id='cc_exp_year']");
		passValues(expYear, excelRead(path, "BookingData", 5, 6));

		WebElement cvvNum = elementFind("xpath", "//input[@id='cc_cvv']");
		passValues(cvvNum, excelRead(path, "BookingData", 6, 7));

	}

	@When("user clicks on book now button")
	public void user_clicks_on_book_now_button() {

		WebElement bookNow = elementFind("xpath", "//input[@value='Book Now']");
		buttonClick(bookNow);

		implicitlyWait();

	}

	@Then("user validates the order id in Booking Confirmation page")
	public void user_validates_the_order_id_in_booking_confirmation_page() {

		webdriverWait("visibilityofElementLocated", "xpath", "//input[@id='order_no']");
		WebElement orderNum = elementFind("xpath", "//input[@id='order_no']");
		String attributeValue = getAttributeValue(orderNum);
		System.out.println(attributeValue);

	}

}
