package org.data;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.data.BaseClass;

public class FlipkartLaunch extends BaseClass{
	public static String flipkartPrice;

	@Test
	public static void flipkart() {
		browserLaunch("chrome");
		loadUrl("https://www.flipkart.com/");
		maxWindow();	
		WebElement search = elementFind("xpath","//input[@type='text']");
		passValues(search,"iphone15");
		WebElement searchicon = elementFind("xpath","//button[@type='submit']");
		searchicon.click();
		elementFind("xpath","//img[@alt='Apple iPhone 15 (Black, 128 GB)']").click();

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
		elementFind("xpath","//button[@class='QqFHMw vslbG+ In9uk2']").click();
		implicitlyWait();
		WebElement amount = elementFind("xpath","//span[@class='LAlF6k re6bBo']");
		String price = getText(amount);
		System.out.println(price);
		StringBuilder sb = new StringBuilder(price);
		sb.deleteCharAt(0);
		String displayPrice = sb.toString();
		String actualPrice = displayPrice.replaceAll(",", "");
		flipkartPrice = actualPrice;
		System.out.println("Flipkart price is : "+flipkartPrice);
	}
}
