package com.automation.actions;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class ActionEngine extends BaseTest{

	public WebElement getWebElement(By locator) throws Exception {
		WebElement we = driver.findElement(locator);
		return we;
	}
	
	public void click(By locator, String locatorName) throws Exception {
		boolean flag = false;
		try {
			WebElement we = getWebElement(locator);
			if (we.isDisplayed() && we.isEnabled()) {
				we.click();
				flag =  true;
			} else {
				System.out.println("Requested element is not available on the web page!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if(flag) {
				extentTest.log(LogStatus.PASS, "Succefully clicked on "+locatorName);
			}else {
				extentTest.log(LogStatus.FAIL, "Failed to click on "+locatorName+extentTest.addScreenCapture(getScreenshot(locatorName)));
			}
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
		boolean flag = false;
		try {
			WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(5));
			Alert alert = wdw.until(ExpectedConditions.alertIsPresent());
			alert.accept();
			flag = true;
			System.out.println("Clicked on Alert OK button");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				extentTest.log(LogStatus.PASS, "Succefully clicked on OK button ");
			}else {
				extentTest.log(LogStatus.FAIL, "Failed to click on OK button"+extentTest.addScreenCapture(getScreenshot("acceptAlert")));
			}
		}
	}
	
	public void dismissAlert() throws Exception{
		boolean flag = false;
		try {
			WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(5));
			Alert alert = wdw.until(ExpectedConditions.alertIsPresent());
			alert.dismiss();
			flag = true;
			System.out.println("Clicked on Alert Cancel button");
		}catch(Exception e) {
			e.printStackTrace();
			flag= false;
		}finally {
			if(flag) {
				extentTest.log(LogStatus.PASS, "Succefully clicked on Cancel/Dismiss button ");
			}else {
				extentTest.log(LogStatus.FAIL, "Failed to click on Cancel/Dismiss button");
			}
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
	
	public void scrollPage(int pixelValue) throws Exception {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, "+pixelValue+")", "");
		
	}
	
	public void scrollPageIntoView(By locator) throws Exception{
		
		WebElement we = getWebElement(locator);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", we);
		
	}
	
	public void waitForElementToBeClickable(By locator, long waitTime) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void fluentWait(final By locator, long waitTime, long pollTime) throws Exception{
		Wait<WebDriver> wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofSeconds(pollTime)).ignoring(WebDriverException.class);
		wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver ) {
			return driver.findElement(locator);
			}
		});
	}
	
	public static String getScreenshot(String locatorName) throws Exception{
		String screenShotLocation = "";
		try {
			String projectPath = System.getProperty("user.dir");
			String dateFormat = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			screenShotLocation = projectPath+File.separator+"FailedScreenShots"+File.separator+locatorName+dateFormat+".png";
			File destination = new File(screenShotLocation);
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, destination);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return screenShotLocation;
		
	}
	
	public void drgAndDrop(By locator, String locatorName) throws Exception {
		boolean flag = false;
		try {
			Actions act = new Actions(driver);
			WebElement draggableObject = getWebElement(locator);
			//WebElement draggableObject = driver.findElement(locator);
			//act.dragAndDrop( locator, locatorName).perform();
			flag =true;
		}catch(Exception e) {
			e.printStackTrace();
			flag =false;
		}finally {
			if (flag) {
			} else {
		}
	}
	}
	
	public String getText(By blocator) throws Exception  {
		String text = "";
		try {
			text = getWebElement(blocator).getText();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return text;
	}
	
	public void switchToWindow(int windowIndex) throws Exception{
		boolean flag = false;
		try {
			System.out.println("I'm in switchToWindow().......!");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			System.out.println(tabs.size());
			if(windowIndex < tabs.size()) {
				driver.switchTo().window(tabs.get(windowIndex));
			}
			
			flag =true;
		}catch(Exception e) {
			e.printStackTrace();
			flag =false;
		}finally {
			if (flag) {
			} else {
			}
		}
	}
	
	
	public void switchToFrame(String frameId) throws Exception{
		boolean flag = false;
		try {
			System.out.println("I'm in switchToFrame.......!");
			driver.switchTo().frame(frameId);
			
			flag =true;
		}catch(Exception e) {
			e.printStackTrace();
			flag =false;
		}finally {
			if (flag) {
			} else {
			}
		}
	}
	
	public void tableData(By table, By body, By rows, By colomns) throws Exception{
		try {
			WebElement tbl = getWebElement(table);
			WebElement tbody = tbl.findElement(body);
			String data = "";
			List<WebElement> trs = tbody.findElements(rows);
			System.out.println("Number of rows:: "+trs.size());
			for(WebElement tr : trs) {
				List<WebElement> tds = tr.findElements(colomns);
				System.out.println("Number of cols:: "+tds.size());
				for(WebElement td: tds) {
					 data = td.getText();
					
				}
				
				System.out.println(data+" ");
			}
 			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
	}
	
}
