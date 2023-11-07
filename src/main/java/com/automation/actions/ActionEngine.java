package com.automation.actions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public void selectByIndex(By locator, String locatorName, int index) throws Exception {
		try {
			WebElement we = getWebElement(locator);
			Select dropDown = new Select(we);
			dropDown.selectByIndex(index);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public void selectByValue(By locator, String locatorName, String dropDownValue) throws Exception {
		try {
			WebElement we = getWebElement(locator);
			Select dropDown = new Select(we);
			dropDown.selectByValue(dropDownValue);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public void selectByVisibleText(By locator, String locatorName, String dropDownVisibleText) throws Exception {
		try {
			WebElement we = getWebElement(locator);
			Select dropDown = new Select(we);
			dropDown.selectByVisibleText(dropDownVisibleText);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public void acceptAlert() throws Exception{
		try {
			WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(5));
			Alert alert = wdw.until(ExpectedConditions.alertIsPresent());
			alert.accept();
			System.out.println("Clicked on Alert OK button");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
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
	
	public void scrollPage(int pixelValue) {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, "+pixelValue+")", "");
		
	}
	
	public void scrollPageIntoView(By locator) throws Exception{
		
		WebElement we = getWebElement(locator);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", we);
		
	}
	
}
