package tests;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.WelcomePage;
import pages.HomePage;
import pages.LoginPage;
import utilities.*;

public class Login extends TestBase{
	WelcomePage welcomePage ;
	LoginPage login;
	HomePage homePage;
	Helper tools = new Helper();
	
	@DataProvider (name = "Account")
		public Object[][] dpMethod (Method m){
			switch (m.getName()) {
			case "LoginwithValidCredential": 
				return new Object[][] {
					{"Test035@test.com", "123456789"}};
			case "LoginWithInvalidCredential": 
				return new Object[][] {
					{"Test021@test.com", "Wrongpassword"},
				    {"Test021test.com", "123456789"}};
			}
			return null;
			
		}
	
	@Test (dataProvider = "Account",priority=1)
	public void LoginwithValidCredential(String username, String password) {
		welcomePage = new WelcomePage(driver);
		login = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		tools.PrintStartTesting("Login with Valid Credential");
		welcomePage.ClickOnbuttonGo();
		welcomePage.SelectWomenSection();
		
		login.StartLogin();
		login.EnterEmail(username);
		login.EnterPassword(password);
		login.clickOnButtonLogin();
		homePage.VerifyTheUserLoginsuccesfuly();
		tools.captureScreenshot(driver, "Valid Credential");
		tools.PrintEndTesting("Login with Valid Credential");
		
	}
	@Test (dataProvider = "Account",priority=2)
	public void LoginWithInvalidCredential(String username, String password) {
		welcomePage = new WelcomePage(driver);
		login = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		tools.PrintStartTesting("Login With Invalid Credential");
		welcomePage.ClickOnbuttonGo();
		welcomePage.SelectWomenSection();
		
		login.StartLogin();
		login.EnterEmail(username);
		login.EnterPassword(password);
		login.clickOnButtonLogin();
		login.verifyTheErrorMsgIsDisplayed();
		tools.captureScreenshot(driver, "Invalid Credential");
		tools.PrintEndTesting("Login With Invalid Credential");

	}
	
}
