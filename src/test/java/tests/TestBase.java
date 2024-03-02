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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase 
{
	public static WebDriver driver ; 

	 private String getApplicationURL() {
	        // You can read this from a configuration file or pass it as a system property
	        return "https://www.newyorker.de/";
	    }
	 
	 
	@Parameters("browser")
	@BeforeMethod
	public void startDriver(@Optional("chrome-headless") String browser) {
		 if(browser.equalsIgnoreCase("chrome"))
			{
		 String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver();
		driver.get(getApplicationURL());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			}
		 else if(browser.equalsIgnoreCase("chrome-headless"))
			{
			 String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				driver = new ChromeDriver(options);
				driver.get(getApplicationURL());
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
					
			}
			}
	
	
		@AfterMethod
	public void quitDriver() {

			driver.quit();
	}

	
	

}
