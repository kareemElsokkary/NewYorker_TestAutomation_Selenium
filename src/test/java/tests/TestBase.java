package tests;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;



public class TestBase 
{
	public static WebDriver driver ; 

	 private String getApplicationURL() {
	        // You can read this from a configuration file or pass it as a system property
	        return "https://www.newyorker.de/";
	    }
	 
	 
	
	@BeforeMethod
	public void startDriver() {
		String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	   driver = new ChromeDriver();
		driver.get(getApplicationURL());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
	}
	
	@AfterMethod
	public void quitDriver() {

			driver.quit();
	}

	
	

}
