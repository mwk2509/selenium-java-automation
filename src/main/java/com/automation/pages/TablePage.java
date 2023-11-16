package com.automation.pages;

import org.openqa.selenium.By;

import com.automation.actions.ActionEngine;

public class TablePage extends ActionEngine {
	private By table = By.xpath("//div[@class='rt-table']");
	private By body = By.xpath("//div[@class='rt-tbody']");
	private By rows = By.xpath("//div[@class='rt-tr-group']");
	private By colomns = By.xpath("//div[@class='rt-td']");
	
	public void displayTableData() throws Exception{
		//By table, By body, By rows, By colomns
		tableData(table, body, rows, colomns);
	}

}
