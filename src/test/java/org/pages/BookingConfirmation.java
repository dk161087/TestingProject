package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.data.BaseClass;

public class BookingConfirmation extends BaseClass {
	
	public BookingConfirmation() {

		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id = "order_no")
	private WebElement orderNum;

	public WebElement getOrderNum() {
		return orderNum;
	}

}
