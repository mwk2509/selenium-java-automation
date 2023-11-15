package com.automation.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.automation.actions.ActionEngine;

public class FramePage extends ActionEngine {
	private By sampleHeading = By.id("sampleHeading");
	
	public void switchFrame() throws Exception {
		switchToFrame("frame1");
		String text = getText(sampleHeading);
		Assert.assertEquals(text, "This is a sample page");
	}
	

}


