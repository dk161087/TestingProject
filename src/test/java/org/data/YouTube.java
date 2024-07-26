package org.data;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.data.BaseClass;

public class YouTube extends BaseClass {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		implicitlyWait();
		elementFind("id", "search").sendKeys("hridayam song", Keys.ENTER);
		implicitlyWait();
		elementFind("xpath", "yt-simple-endpoint inline-block style-scope ytd-thumbnail").click();
		
	}
	

}
