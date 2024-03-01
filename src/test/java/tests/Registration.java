package tests;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.WelcomePage;
import utilities.*;


public class Registration extends TestBase{
	WelcomePage welcomePage ;
	RegisterPage registerPage;
	HomePage homePage;
	Helper tools = new Helper();
	
	@DataProvider (name = "Account Details")
	public Object[][] dpMethod (Method m){
		switch (m.getName()) {
		case "RegisterWithNewUser": 
			return new Object[][] {
				{"AutomationTesting", " Tester", "123456789"}
				};
		case "RegisterExistsUser": 
			return new Object[][] {
				{"NewFirstName", "NewLastName","Test035@test.com", "NewPassword"}
				};
		}
		return null;	
	}
	
	@Test (dataProvider = "Account Details", priority=1)
	public void RegisterWithNewUser(String firstName, String lastName, String Password)  {
		welcomePage = new WelcomePage(driver);
		registerPage = new RegisterPage(driver);
		homePage = new HomePage(driver);
		tools.PrintStartTesting("Register with new user");
		String Email  =String.format("%s@%s", tools.getUniqueId(), "test.com");
		System.out.println("The Unique Email :" + Email);
		welcomePage.ClickOnbuttonGo();
		welcomePage.SelectWomenSection();
		registerPage.StartRegister();
		registerPage.EnterDataofuser(firstName,lastName,Email,Password);
		registerPage.Agreeterms();
		registerPage.CompleteRegister();
	    registerPage.VerifyRegisterisCompleted(driver);
	    tools.captureScreenshot(driver, "NewUser");
	    tools.PrintEndTesting("Register with new user");
	}
	
	@Test (dataProvider = "Account Details", priority=2)
	public void RegisterExistsUser(String firstName, String lastName, String Email, String Password)  {
		welcomePage = new WelcomePage(driver);
		registerPage = new RegisterPage(driver);
		homePage = new HomePage(driver);
		tools.PrintStartTesting("Register With exists User");
		welcomePage.ClickOnbuttonGo();
		welcomePage.SelectWomenSection();
		registerPage.StartRegister();
		registerPage.EnterDataofuser(firstName,lastName,Email,Password);
		registerPage.Agreeterms();
		registerPage.CompleteRegister();	
	    registerPage.VerifytheUserIsAlreadyExists(driver);	
	    tools.PrintEndTesting("Register With exists User");
	    tools.captureScreenshot(driver, "ExistsUser");
	}

}
