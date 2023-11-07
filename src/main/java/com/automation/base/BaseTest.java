package com.automation.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.automation.utilities.LoadProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;

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
		driver.close();
	}

}
