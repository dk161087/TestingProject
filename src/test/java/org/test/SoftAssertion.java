package org.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	
	SoftAssert s = new SoftAssert();
	
	@Test
	public void assertEquals() {
		s.assertEquals("same", "same");
		System.out.println("This line is executed because assertEquals " + "passed since both the strings are same");
		
	}
	
	@Test
	public void assertEquals2() {
	s.assertEquals("same", "not same");
	System.out.println("This line will not be executed because " + "assertEquals fails both the strings are different."
					+ "Also the test/method will be declared failed");
		
		
	}

	@Test
	public void assertNotEquals() {
		s.assertNotEquals("same", "not same");
		System.out.println("This line is executed because assertNotEquals" + " assertion pass for the given situation");
	}
	
	@Test
	public void assertNotEquals2() {
		s.assertNotEquals("same", "same");
		System.out.println("This line will not be executed because assertNotEquals" + " assertion fails for the given situation" 
							+ "Also the test/method will be declared failed");
	}

	@Test
	public void assertTrue() {
		s.assertTrue(3 < 5);
		System.out.println(
				"This line will be executed as assertTrue will" + " pass because the 3<5(which will return true)");
	}
	
	@Test
	public void assertTrue2() {
		s.assertTrue(3 > 5);
		System.out.println(
				"This line will not be executed as assertTrue will" + " fail because the 3>5(which will return false)");
	}

	@Test
	public void assertFalse() {
		s.assertFalse(3 > 5);
		System.out.println("This line is executed because assertFalse"
				+ "assertion passes as the given condition will return false");
	}
	
	@Test
	public void assertFalse2() {
		s.assertFalse(3 < 5);
		System.out.println("This line will not be executed because assertFalse"
				+ "assertion fails as the given condition will return true");
	}

	@Test
	public void assertNull() {
		s.assertNull(null);
		System.out.println("Since we set null in the condition, the assertion " + "assertNull will pass");
	}
	
	@Test
	public void assertNull2() {
		s.assertNull("not null");
		System.out.println("Since we set some value in the condition, the assertion " + "assertNull will fail");
	}

	@Test
	public void assertNotNull() {
		s.assertNotNull("not null");
		System.out.println("Since we set some value in the condition, the assertion " + "assertNotNull will pass");
	}
	
	@Test
	public void assertNotNull2() {
		s.assertNotNull(null);
		System.out.println("Since we set null in the condition, the assertion " + "assertNotNull will fail");
	}
	
	@AfterTest
	public void afterTest() {
		
		s.assertAll();
		
	}

}
