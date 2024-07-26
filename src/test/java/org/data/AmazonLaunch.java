package org.data;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.data.BaseClass;

public class AmazonLaunch extends BaseClass{
	public static String amazonPrice;

	@Test
	public static void amazon() {
		browserLaunch("edge");
		loadUrl("https://www.amazon.in/");
		maxWindow();
		WebElement search = elementFind("xpath","//input[@type='text']");
		passValues(search,"iphone15");
		WebElement searchbutton = elementFind("id","nav-search-submit-button");
		searchbutton.click();
		elementFind("xpath","//img[@data-image-index='3']").click();
		String parentwindowid = driver.getWindowHandle();
		System.out.println(parentwindowid);
		Set<String> allwindowid = driver.getWindowHandles();	
		System.out.println(allwindowid);
		for(String x:allwindowid) {
			if(!parentwindowid.equals(x)) {
				driver.switchTo().window(x);
				System.out.println("first window id:"+x);
			}
		}
		
	   elementFind("xpath","(//input[@id='add-to-cart-button'])[2]").click();
	   implicitlyWait();
		WebElement amount = elementFind("xpath","(//span[text()='₹73,100.00'])[3]");
		String price = getText(amount);
		System.out.println(price);
		StringBuilder sb = new StringBuilder(price);
		sb.deleteCharAt(0);
		sb.deleteCharAt(7);
		sb.deleteCharAt(6);
		sb.deleteCharAt(5);
		String displayPrice = sb.toString();
		String actualPrice = displayPrice.replaceAll(",", "");
		amazonPrice = actualPrice;
		System.out.println("Amazon price is : "+amazonPrice);
		}
}
