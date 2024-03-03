package tests;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.WelcomePage;
import pages.HomePage;
import pages.LoginPage;
import utilities.*;

public class Login extends TestBase{
	
	//define object for pages
	WelcomePage welcomePage ;
	LoginPage login;
	HomePage homePage;
	Helper tools = new Helper();
	
	
	//define Test Cases
	private String testcas1 ="Login with Valid Credential";
	private String testcas2 ="Login With Invalid Credential";
	
	//define Test Data
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
	
	//define Test Case 1 
	@Test (dataProvider = "Account",priority=1)
	public void LoginwithValidCredential(String username, String password) {
		//define objects of Pages
		welcomePage = new WelcomePage(driver);
		login = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		//print start Testing
		
		tools.PrintStartTesting(testcas1);
		
		//Prerequest to login
		welcomePage.ClickOnbuttonGo();
		welcomePage.SelectWomenSection();
		
		//start login
		login.StartLogin();
		login.EnterEmail(username);
		login.EnterPassword(password);
		login.clickOnButtonLogin();
		
		//verify the login is succeeded
		homePage.VerifyTheUserLoginsuccesfuly();
		
		//take screenshot..
		tools.captureScreenshot(driver, "Valid Credential");
		
		//print End Testing
		tools.PrintEndTesting(testcas1);
		
	}
	
	//start Test case 2
	@Test (dataProvider = "Account",priority=2)
	public void LoginWithInvalidCredential(String username, String password) {
		//define Objects
		welcomePage = new WelcomePage(driver);
		login = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		//start Printing
		tools.PrintStartTesting(testcas2);
		
		//pre testing
		welcomePage.ClickOnbuttonGo();
		welcomePage.SelectWomenSection();
		
		//start login
		login.StartLogin();
		login.EnterEmail(username);
		login.EnterPassword(password);
		login.clickOnButtonLogin();
		
		//verify the login is failed
		login.verifyTheErrorMsgIsDisplayed();
		
		//take screenshot..
		tools.captureScreenshot(driver, "Invalid Credential");
		
		//End Test
		tools.PrintEndTesting(testcas2);

	}
	
}
