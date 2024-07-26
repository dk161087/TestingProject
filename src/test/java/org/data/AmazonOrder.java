package org.data;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.data.BaseClass;

public class AmazonOrder extends BaseClass {
	
	public static String amazonPrice;

	@Test
	public static void TC_001() {

		browserLaunch("chrome");
		loadUrl("https://www.amazon.in/");
	//	maxWindow();
		
		Point point = new Point(810, 0);

		driver.manage().window().setPosition(point);

		Dimension dimension = new Dimension(800, 900);

		driver.manage().window().setSize(dimension);

		// Sign-in

//		elementFind("xpath", "//a[@id='nav-link-accountList']").click();
//		
//		elementFind("xpath", "//input[@type='email']").sendKeys("8608082862");
//
//		elementFind("xpath", "//input[@id='continue']").click();
//
//		elementFind("xpath", "//input[@type='password']").sendKeys("primepass@007");
//
//		elementFind("xpath", "//input[@id='signInSubmit']").click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")))
				.sendKeys("iphone 15 pro max", Keys.ENTER);

		// elementFind("id", "twotabsearchtextbox").sendKeys("iphone 15 pro max",
		// Keys.ENTER);

		implicitlyWait();

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//span[text()='Apple iPhone 15 Pro Max (512 GB) - White Titanium'])[3]"))).click();

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

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement amount = elementFind("xpath", "(//span[@class='a-price-whole'])[5]");

		String price = getText(amount);
		String actualPrice = price.replaceAll(",", "");
		
//		StringBuffer sb = new StringBuffer(price);
//		sb.delete(0, 1);
//		System.out.println(sb);
		
//		String mobilePrice = sb.toString();
//		Integer valueOfMobile = Integer.valueOf(mobilePrice);
		amazonPrice = actualPrice;
		System.out.println("Amazon price is : "+amazonPrice);

		elementFind("xpath", "(//input[@title='Add to Shopping Cart'])[2]").click();

//		driver.switchTo().window(parentWindow);

//		System.out.println("Parent window id is : " + parentWindow);
//
//		driver.findElement(By.id("twotabsearchtextbox")).clear();
//
//		implicitlyWait();
//
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone14", Keys.ENTER);
//
//		implicitlyWait();
//
//		driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[1]")).click();
//
//		implicitlyWait();
//
//		Set<String> windows2 = driver.getWindowHandles();
//		System.out.println(windows2);
//
//		for (String y : windows2) {
//
//			if (!parentWindow.equals(y)) {
//
//				if (!firstChildWindow.equals(y)) {
//
//					driver.switchTo().window(y);
//					System.out.println("Second child window id is : " + y);
//
//				}
//
//			}
//
//		}
//
//		driver.findElement(By.xpath("(//input[@title='Add to Shopping Cart'])[2]")).click();
//
//		implicitlyWait();
//
//		driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']")).click();
//
//		// driver.findElement(By.xpath("//span[@class='nav-action-inner']")).click();
//
//		// driver.close();

	}

}
