package org.data;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailureClass implements IRetryAnalyzer {
	
	int min = 1;
	int max = 2;

	@Override
	public boolean retry(ITestResult result) {
		
		if(min<=max) {
			
			min++;
			return true;
			
		}
		
		return false;
	}

}
