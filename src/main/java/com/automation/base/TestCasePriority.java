package com.automation.base;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestCasePriority {

	
	@Parameters({"name"})
	@Test(priority=1)
	public void test5(String test) {
		System.out.println("Test5 method:: "+test);
	}
	
	@Test(priority=2)
	public void test2() {
		System.out.println("Test2 method");
	}
	
	@Test(priority=3)
	public void test3() {
		System.out.println("Test3 method");
	}	
	
	@Test(priority=4)
	public void test4() {
		System.out.println("Test4 method");
	}
	
	@Test(priority=5)
	public void test1() {
		System.out.println("Test1 method");
	}
	
}
