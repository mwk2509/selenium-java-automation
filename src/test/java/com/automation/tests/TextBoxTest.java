package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.actions.ActionEngine;
import com.automation.pages.TextBoxPage;

public class TextBoxTest extends ActionEngine {
	TextBoxPage textBoxPage = new TextBoxPage();
	
	@Test
	public void submitTextBoxData() throws Exception {
		textBoxPage.submitTextBoxData();
	}
}
