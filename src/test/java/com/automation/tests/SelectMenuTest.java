package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.actions.ActionEngine;
import com.automation.pages.SelectMenuPage;

public class SelectMenuTest extends ActionEngine {
	SelectMenuPage selectMenuPage = new SelectMenuPage();
	
	@Test
	public void selectByIndex() throws Exception {
		selectMenuPage.selectByIndex();
	}
	
	@Test
	public void selectByValue() throws Exception {
		selectMenuPage.selectByValue();
}
}