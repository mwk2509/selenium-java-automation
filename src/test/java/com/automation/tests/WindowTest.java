package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.actions.ActionEngine;
import com.automation.pages.WindowPage;

public class WindowTest extends ActionEngine {
	WindowPage windowPage = new WindowPage();
	
	@Test
	public void switchToWindow() throws Exception{
		extentTest = extentReports.startTest("WindowTest", "Window Test desc");
		windowPage.switchTab();
	}

}
