package org.test;

import org.testng.annotations.Test;

public class GroupsClass {
	
	@Test(groups = "sanity")
	public void tc() {
		
		System.out.println("sanity");
		
	}
	
	@Test(groups = { "smoke", "sanity" })
	public void tc1() {
		
		System.out.println("smoke, sanity");
		
	}
	
	@Test(groups = "regression")
	public void tc2() {
		
		System.out.println("regression");
		
	}
	
	@Test(groups = { "sanity", "regression" })
	public void tc3() {
		
		System.out.println("sanity, regression");
		
	}

}
