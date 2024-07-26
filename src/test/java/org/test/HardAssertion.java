package org.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

	@Test
	public void assertEquals() {
		Assert.assertEquals("same", "same");
		System.out.println("This line is executed because assertEquals " + "passed since both the strings are same");

	}

	@Test
	public void assertEquals2() {
		Assert.assertEquals("same", "not same");
		System.out.println(
				"This line will not be executed because " + "assertEquals failed as both the strings are different."
						+ "Also the test/method will be declared failed");

	}

	@Test
	public void assertNotEquals() {
		Assert.assertNotEquals("same", "not same");
		System.out
				.println("This line is executed because assertNotEquals" + " assertion passed for the given situation");
	}

	@Test
	public void assertNotEquals2() {
		Assert.assertNotEquals("same", "same");
		System.out.println("This line will not be executed because assertNotEquals"
				+ " assertion failed for the given situation" + "Also the test/method will be declared failed");
	}

	@Test
	public void assertTrue() {
		Assert.assertTrue(3 < 5);
		System.out.println(
				"This line will be executed as assertTrue will" + " pass because the 3<5(which will return true)");
	}

	@Test
	public void assertTrue2() {
		Assert.assertTrue(3 > 5);
		System.out.println(
				"This line will not be executed as assertTrue will" + " fail because the 3>5(which will return false)");
	}

	@Test
	public void assertFalse() {
		Assert.assertFalse(3 > 5);
		System.out.println("This line is executed because assertFalse"
				+ "assertion passed as the given condition will return false");
	}

	@Test
	public void assertFalse2() {
		Assert.assertFalse(3 < 5);
		System.out.println("This line will not be executed because assertFalse"
				+ "assertion failed as the given condition will return true");
	}

	@Test
	public void assertNull() {
		Assert.assertNull(null);
		System.out.println("Since we set null in the condition, the assertion " + "assertNull will pass");
	}

	@Test
	public void assertNull2() {
		Assert.assertNull("not null");
		System.out.println("Since we set some value in the condition, the assertion " + "assertNull will fail");
	}

	@Test
	public void assertNotNull() {
		Assert.assertNotNull("not null");
		System.out.println("Since we set some value in the condition, the assertion " + "assertNotNull will pass");
	}

	@Test
	public void assertNotNull2() {
		Assert.assertNotNull(null);
		System.out.println("Since we set null in the condition, the assertion " + "assertNotNull will fail");
	}

}
