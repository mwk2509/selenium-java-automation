package com.automation.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.automation.actions.ActionEngine;

public class WindowsPage extends ActionEngine {
	
	private By tabButton = By.id("tabButton");
	private By headerText = By.id("sampleHeading");
	
	public void switchToTab() throws Exception{
		click(tabButton, "TabButton");
		switchToWindow(1);
		String hText = getText(headerText);
		System.out.println("Actual text:: "+hText);
		Assert.assertEquals(hText, "This is a sample page");
	}

}
