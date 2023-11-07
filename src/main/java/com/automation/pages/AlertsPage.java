package com.automation.pages;

import org.openqa.selenium.By;

import com.automation.actions.ActionEngine;

public class AlertsPage extends ActionEngine{
	private By alertButton = By.id("alertButton");
	
	public void acceptWebAlert() throws Exception{
		click(alertButton, "Click Button to see alert");
		System.out.println("I'm in AlertsPage.acceptWebAlert()");
		acceptAlert();
	} 

}
