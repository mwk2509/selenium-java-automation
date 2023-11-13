package com.automation.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.utilities.LoadProperties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static String startDate;
	public String reportFilePath;

	@BeforeSuite
	public void beforeAll() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM_dd_yyyy_z_HH_mm_ss");
		startDate = sdf.format(new Date());
		reportFilePath = System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"Report_"+startDate+".html";
		extentReports = new ExtentReports(reportFilePath);
		
	}
	
	@Parameters({"browserType"})
	@BeforeMethod
	public void seup(String browserType) throws Exception {
		try {
			//if (driver == null) {
				if ("chrome".equals(browserType)) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				} else if ("ie".equals(browserType)) {
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
				} else if ("edge".equals(browserType)) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(LoadProperties.getData("url"));

	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
		extentReports.flush();
	}

}
