package com.automation.base;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgExample {

	@Test
	public void test1() {
		System.out.println("Test Ng1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test Ng2");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test3() {
		Assert.assertTrue(true);
		System.out.println("Test Ng3");
	}
	
	@Test
	public void test4() {
		Assert.assertTrue(true);
		System.out.println("Test Ng4");
	}
	
}
