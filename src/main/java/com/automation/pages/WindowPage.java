package com.automation.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.automation.actions.ActionEngine;

public class WindowPage extends ActionEngine {
	private By tabButton =By.id("tabButton");
	private By sampleHeading = By.id("sampleHeading");
	
	public void switchTab() throws Exception {
		click(tabButton, "Tab Button");
		switchToWindow(1);
		String text = getText(sampleHeading);
		Assert.assertEquals(text, "This is a sample page");
	}
	

}
