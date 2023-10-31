package com.automation.base;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;

	@Parameters({"browserType"})
	@BeforeMethod
	public void seup(String browserType) throws Exception {
		
		try {
			if (driver != null) {
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demoqa.com/links");

		String elementHeaderText = driver.findElement(By.xpath("//div[@class='main-header']")).getText();
		
		System.out.println(driver.getTitle());
		System.out.println(elementHeaderText);
		
		//driver.findElement(By.xpath("//span[text()='Text Box']")).click();
		//driver.findElement(By.xpath("//label[@id='userName-label']/parent::div/following-sibling::div/input")).sendKeys("Metasebia");
		
		//driver.findElement(By.id("userEmail")).sendKeys("asdf");
		//driver.findElement(By.xpath("//span[text()='Links']")).click();
		
		//WebElement homeLink = driver.findElement(By.linkText("Home"));
		//homeLink.click();
		driver.findElement(By.xpath("//span[text()='Broken Links-Images']")).click();
		
				
		
		Thread.sleep(10000);
		
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
		
		
		//driver.close();
	}
	
	public void test() {}

}
