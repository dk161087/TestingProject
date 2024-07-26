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

public class FlipkartOrder1 extends BaseClass {
	
	public static String flipkartPrice;


	@Test
	public static void TC_001() {
		
		browserLaunch("edge");
		loadUrl("https://www.flipkart.com/");
		maxWindow();
		
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

		WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated
						(By.xpath("//div[@class='Nx9bqj CxhGGd']")));

		String price = getText(amount);

		StringBuilder sb = new StringBuilder(price);
		sb.deleteCharAt(0);
		
		String displayPrice = sb.toString();
		String actualPrice = displayPrice.replaceAll(",", "");
		flipkartPrice = actualPrice;
		System.out.println("Flipkart price is : "+flipkartPrice);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add to cart']"))).click();

	}

}
