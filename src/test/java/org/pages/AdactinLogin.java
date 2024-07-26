package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.data.BaseClass;

public class AdactinLogin extends BaseClass {
	
	public AdactinLogin() {

		PageFactory.initElements(driver, this);

	}

	@FindBys({ @FindBy(id = "username"), @FindBy(xpath = "//input[@type='text']") })
	private WebElement user;

	@FindAll({ @FindBy(id = "paswrd"), @FindBy(xpath = "//input[@type='password']") })
	private WebElement pass;

	@FindBy(id = "login")
	private WebElement login;

	public WebElement getUserName() {
		return user;
	}

	public WebElement getPassWord() {
		return pass;
	}

	public WebElement getLogin() {
		return login;
	}

}
