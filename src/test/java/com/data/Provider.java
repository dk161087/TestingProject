package com.data;

import org.testng.annotations.DataProvider;

public class Provider {
	
	@DataProvider(name = "myData")
	private String[][] data() {

		String data[][] = { { "ruby@111", "111" }, { "josh@222", "222" }, { "krish@333", "333" } };

		return data;

	}

}
