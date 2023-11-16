package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.actions.ActionEngine;
import com.automation.pages.TablePage;

public class TableTest extends ActionEngine {
	TablePage tablePage = new TablePage();
	
	@Test
	public void getTableDataTest() throws Exception{
		extentTest = extentReports.startTest("getTableDataTest", "getTableDataTest desc");
		tablePage.displayTableData();
	}

}
