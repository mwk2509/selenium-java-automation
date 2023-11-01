package com.automation.pages;

import org.openqa.selenium.By;
import com.automation.actions.ActionEngine;

public class TextBoxPage extends ActionEngine {
	
	private By fullName = By.id("userName");
	private By email = By.id("userEmail");
	private By currentAddress = By.id("currentAddress");
	private By permanentAddress = By.id("permanentAddress");
	private By submit = By.id("submit");
	
	public void submitTextBoxData()throws Exception {
		type(fullName, "Full Name", "Metasebiya");
		type(email, "Email", "metasebiya@gmail.com");
		type(currentAddress, "Current Address", "Metasebiya Addess");
		type(permanentAddress, "permanent Address", "Metasebiya Addess2");
		click(submit, "Submit Button");
		
	}

}
