package org.data;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.data.BaseClass;

public class FacebookLogin extends BaseClass {

//	@Test
//	@Parameters({ "userdata", "passdata" })
//	private void tc1(@Optional("dk1610")String userdata, @Optional("1234") String passdata) {
//		
//		WebElement userName = elementFind("id", "email");
//		passValues(userName, userdata);
//		
//		WebElement passWord = elementFind("id", "pass");
//		passValues(passWord, passdata);
//		
//	}

	@Test(dataProvider = "myData", dataProviderClass = com.data.Provider.class)
	private void tc2(String userdata, String passdata) {

		browserLaunch("chrome");
		loadUrl("https://www.facebook.com/");
		maxWindow();

		WebElement userName = elementFind("id", "email");
		passValues(userName, userdata);

		WebElement passWord = elementFind("id", "pass");
		passValues(passWord, passdata);
		Reporter.log("Facebook Login");

	}

	@Test
	private void tc4() {

		browserLaunch("edge");
		loadUrl("https://www.amazon.in/");
		maxWindow();

		elementFind("xpath", "//a[@id='nav-link-accountList']").click();
		Reporter.log("Amazon Login");
		
	}
	
//	@Test(retryAnalyzer = FailureClass.class)
//	private void tc3() {
//
//		browserLaunch("chrome");
//		loadUrl("https://www.facebook.com/");
//		maxWindow();
//
//		WebElement userName = elementFind("id", "email");
//		passValues(userName, "dk1610");
//
//		WebElement passWord = elementFind("id", "pass");
//		passValues(passWord, "12345");
//
//		Assert.assertTrue(false);
//		Reporter.log("Greens Technology");
//
//	}

}
