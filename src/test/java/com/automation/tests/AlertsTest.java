package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.actions.ActionEngine;
import com.automation.pages.AlertsPage;

public class AlertsTest extends ActionEngine {
	AlertsPage alertsPage = new AlertsPage();

	@Test
	public void acceptWebAlert() throws Exception {
		extentTest = extentReports.startTest("acceptWebAlert", "acceptWebAlert desc");
		alertsPage.acceptWebAlert();
	}

	@Test
	public void dismissWebAlert() throws Exception {
		extentTest = extentReports.startTest("dismissWebAlert", "dismissWebAlert desc");
		alertsPage.dismissWebAlert();

	}
}