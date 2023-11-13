package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.actions.ActionEngine;
import com.automation.pages.WindowsPage;

public class WindowsTest extends ActionEngine {
	
	WindowsPage windowsPage = new WindowsPage();
	
	@Test
	public void handleWithWindow() throws Exception{
		extentTest = extentReports.startTest("handleWithWindow", "Handle With Window desc");
		windowsPage.switchToTab();
	}

}
