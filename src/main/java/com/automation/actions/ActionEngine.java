package com.automation.actions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.automation.base.BaseTest;

public class ActionEngine extends BaseTest{

	public WebElement getWebElement(By locator) throws Exception {
		WebElement we = driver.findElement(locator);
		return we;
	}
	
	public void click(By locator, String locatorName) throws Exception {
		
		try {
			WebElement we = getWebElement(locator);
			if (we.isDisplayed() && we.isEnabled()) {
				we.click();
			} else {
				System.out.println("Requested element is not available on the web page!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		
	}
	
	public void type(By locator, String locatorName, String data) throws Exception {
		try {
			WebElement we = getWebElement(locator);
			if (we.isDisplayed() && we.isEnabled()) {
				we.clear();
				we.sendKeys(data);
			} else {
				System.out.println("Requested element is not available on the web page!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	public void handleBrokenLinks() throws Exception {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement we : links) {
			System.out.println(we.getAttribute("href"));
			
			String u = we.getAttribute("href");
			if (u != null && !u.isEmpty()) {
				URL url = new URL(we.getAttribute("href"));
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.connect();
				int responseCode = connection.getResponseCode();

				System.out.println("Response code: " + responseCode);
			}
		}
	}
}
