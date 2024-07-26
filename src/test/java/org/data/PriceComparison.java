package org.data;

import org.testng.annotations.Test;

public class PriceComparison {

	@Test
	public void TC_001() {

		String amazon = AmazonOrder1.amazonPrice;
		String flipkart = FlipkartOrder1.flipkartPrice;

		int amazonMobilePrice = Integer.parseInt(amazon);
		int flipkartMobilePrice = Integer.parseInt(flipkart);

		if (amazonMobilePrice > flipkartMobilePrice) {

			System.out.println("Amazon mobile price is costlier than Flipkart mobile price");

		}

		else if (flipkartMobilePrice > amazonMobilePrice) {

			System.out.println("Flipkart mobile price is costlier than Amazon mobile price");

		}
		
		else {
			
			System.out.println("Both are same price");
			
		}

	}

}
