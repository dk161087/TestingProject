package org.testing.testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.data.BaseClass;

public class AmazonOrder extends BaseClass {

	String firstChildWindow = null;

	@BeforeClass
	public static void beforeClass() {

		browserLaunch("chrome");
		loadUrl("https://www.amazon.in/");
		maxWindow();

	}

	@Test
	public void TC_001() {

		// Sign-in

		/*
		 * driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		 * 
		 * driver.findElement(By.id("ap_email")).sendKeys("8608082862");
		 * 
		 * driver.findElement(By.xpath("//input[@id='continue']")).click();
		 * 
		 * driver.findElement(By.id("ap_password")).sendKeys("primepass@007");
		 * 
		 * driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		 * 
		 */
		
		elementFind("xpath", "//a[@id='nav-link-accountList']").click();
		
		elementFind("xpath", "//input[@type='email']").sendKeys("8608082862");

		elementFind("xpath", "//input[@id='continue']").click();

		elementFind("xpath", "//input[@type='password']").sendKeys("primepass@007");

		elementFind("xpath", "//input[@id='signInSubmit']").click();

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone13", Keys.ENTER);

		implicitlyWait();

		driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[1]")).click();

		implicitlyWait();

		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window id is : " + parentWindow);

		Set<String> windows1 = driver.getWindowHandles();
		System.out.println(windows1);

		for (String x : windows1) {

			if (!parentWindow.equals(x)) {

				WebDriver window1 = driver.switchTo().window(x);
				String childWindow1 = window1.getWindowHandle();
				firstChildWindow = childWindow1;
				System.out.println("First child window id is : " + firstChildWindow);

			}

		}

		driver.findElement(By.xpath("(//input[@title='Add to Shopping Cart'])[2]")).click();

		implicitlyWait();

		driver.switchTo().window(parentWindow);

		System.out.println("Parent window id is : " + parentWindow);

		driver.findElement(By.id("twotabsearchtextbox")).clear();

		implicitlyWait();

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone14", Keys.ENTER);

		implicitlyWait();

		driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[1]")).click();

		implicitlyWait();

		Set<String> windows2 = driver.getWindowHandles();
		System.out.println(windows2);

		for (String y : windows2) {

			if (!parentWindow.equals(y)) {

				if (!firstChildWindow.equals(y)) {

					driver.switchTo().window(y);
					System.out.println("Second child window id is : " + y);

				}

			}

		}

		driver.findElement(By.xpath("(//input[@title='Add to Shopping Cart'])[2]")).click();

		implicitlyWait();

		driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']")).click();

		// driver.findElement(By.xpath("//span[@class='nav-action-inner']")).click();

		// driver.close();

	}

}
