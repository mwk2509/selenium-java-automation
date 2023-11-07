package com.automation.pages;

import org.openqa.selenium.By;

import com.automation.actions.ActionEngine;

public class SelectMenuPage extends ActionEngine{
	
	private By oldStyleSelectMenu = By.id("oldSelectMenu");
	
	public void selectByIndex() throws Exception{
		selectByIndex(oldStyleSelectMenu, "Old Style Select Menu", 2);
	}
	public void selectByValue() throws Exception{
		selectByValue(oldStyleSelectMenu, "Old Style Select Menu", "7");
}
	public void selectByVisibleText() throws Exception{
		selectByVisibleText(oldStyleSelectMenu, "Old Style Select Menu", "Purple");
}
}