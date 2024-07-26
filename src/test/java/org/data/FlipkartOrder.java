package org.data;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.data.BaseClass;

public class FlipkartOrder extends BaseClass {
	
	public static String flipkartPrice;


	@Test
	public static void TC_001() {
		
		browserLaunch("edge");
		loadUrl("https://www.flipkart.com/");
	//	maxWindow();
		
		Point point = new Point(0, 0);

		driver.manage().window().setPosition(point);

		Dimension dimension = new Dimension(790, 900);

		driver.manage().window().setSize(dimension);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//input[@type='text']"))).sendKeys("iphone 15 pro max", Keys.ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Apple iPhone 15 Pro Max (Natural Titanium, 256 GB)')]"))).click();

		String parentWindow = driver.getWindowHandle();
		// System.out.println("Parent window id is : " + parentWindow);

		Set<String> windows1 = driver.getWindowHandles();
		// System.out.println(windows1);

		for (String x : windows1) {

			if (!parentWindow.equals(x)) {

				driver.switchTo().window(x);

			}

		}

		// WebElement mobilePrice = elementFind("xpath", "//div[@class='Nx9bqj CxhGGd']");
		// String price2 = getText(mobilePrice);
		// System.out.println(price2);

		WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated
						(By.xpath("//div[@class='Nx9bqj CxhGGd']")));

		String price = getText(amount);

	 // System.out.println(price.replace("?", ""));

		StringBuilder sb = new StringBuilder(price);
		sb.deleteCharAt(0);
		
	//	System.out.println("Mobile price in Flipkart : "+sb);

//		StringBuffer sb = new StringBuffer(price);
//		sb.delete(0, 1);
//		System.out.println(sb);
		
		String displayPrice = sb.toString();
		String actualPrice = displayPrice.replaceAll(",", "");
		flipkartPrice = actualPrice;
		System.out.println("Flipkart price is : "+flipkartPrice);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add to cart']"))).click();

	}

}
