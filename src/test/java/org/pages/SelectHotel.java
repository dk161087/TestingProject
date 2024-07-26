package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.data.BaseClass;

public class SelectHotel extends BaseClass {
	
public SelectHotel() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "radiobutton_0")
	private WebElement radioButton;
	
	@FindBy(id = "total_price_0")
	private WebElement totalPrice;
	
	@FindBy(id = "continue")
	private WebElement continueButton;

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public WebElement getRadioButton() {
		return radioButton;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

}
