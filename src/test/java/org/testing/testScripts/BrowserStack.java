package org.testing.testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.data.BaseClass;

public class BrowserStack extends BaseClass {
	
	@BeforeClass
	public static void beforeClass() {

		browserLaunch("chrome");
		loadUrl("https://www.browserstack.com/");
		maxWindow();

	}
	
	@Test
	public void TC_001() throws InterruptedException {
		
		String firstChildWindow = null;

		String title = driver.getTitle();
		System.out.println(title);
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window is " + parentWindow);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		WebElement link1 = driver.findElement(By.xpath("(//span[contains(text(),'Accessibility Testing')])[5]"));
		// js.executeScript("window.scrollBy(0,40)");
		actions.keyDown(Keys.SHIFT).click(link1).keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(3000);
		Set<String> windows1 = driver.getWindowHandles();
		System.out.println(windows1);
		System.out.println("a1");
		for (String x : windows1) {

			if (!parentWindow.equals(x)) {

				WebDriver window2 = driver.switchTo().window(x);
				String childWindow1 = window2.getWindowHandle();
				firstChildWindow = childWindow1;
				System.out.println("First child window is " + firstChildWindow);
				System.out.println("c1");
				// js.executeScript("window.scrollBy(0,400)");

			}

		}

		WebElement link2 = driver.findElement(By.xpath("//button[@id='products-dd-toggle']"));
		actions.moveToElement(link2).perform();
		WebElement live = driver.findElement(By.xpath("(//a[@aria-label='Live'])[1]"));
		actions.keyDown(Keys.SHIFT).click(live).keyUp(Keys.SHIFT).build().perform();
		// Thread.sleep(2000);
		// js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		Set<String> windows2 = driver.getWindowHandles();
		System.out.println(windows2);
		System.out.println("a2");
		for (String y : windows2) {

			// if (!((parentWindow.equals(y)) && (firstChildWindow.equals(y))))

			if (!parentWindow.equals(y)) {

				if (!firstChildWindow.equals(y)) {

					driver.switchTo().window(y);
					System.out.println("Second child window is " + y);
					System.out.println("c2");
					js.executeScript("window.scrollBy(0,400)");
				//	driver.manage().window().setPosition(new Point(2000, 0));

				}
			}
			
			Thread.sleep(3000);
			driver.switchTo().window(parentWindow);

		}
		
	}

}
