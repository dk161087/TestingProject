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
import org.testng.annotations.Test;

import com.data.BaseClass;

public class AmazonOrder1 extends BaseClass {

	public static String amazonPrice;

	@Test
	public static void TC_001() {

		browserLaunch("chrome");
		loadUrl("https://www.amazon.in/");
		maxWindow();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")))
				.sendKeys("iphone 15 pro max", Keys.ENTER);

		implicitlyWait();

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//span[text()='Apple iPhone 15 Pro (1 TB) - Black Titanium'])[1]"))).click();

		implicitlyWait();

		String parentWindow = driver.getWindowHandle();
		// System.out.println("Parent window id is : " + parentWindow);

		Set<String> windows1 = driver.getWindowHandles();
		// System.out.println(windows1);

		for (String x : windows1) {
			if (!parentWindow.equals(x)) {
				driver.switchTo().window(x);
			}
		}

		WebElement amount = elementFind("xpath", "(//span[@class='a-price-whole'])[5]");

		String price = getText(amount);
		String actualPrice = price.replaceAll(",", "");
		amazonPrice = actualPrice;
		System.out.println("Amazon price is : " + amazonPrice);

		elementFind("xpath", "(//input[@title='Add to Shopping Cart'])[2]").click();

	}

}
