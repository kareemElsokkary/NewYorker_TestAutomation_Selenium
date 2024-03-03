package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.MobileAppPage;
import pages.ProductPage;
import utilities.Helper;

public class MobileApp extends TestBase{
Login login= new Login();
Helper tools = new Helper();

String testCase1="veify New York App is Avaliable in App Store";
String testCase2="veify New York App is Avaliable in Google Play";
String testCase3="veify New York App is Avaliable in Galary";

@Test(priority=1)
public void VerifyNewYorkAppisAvailableatAppStore() {
	//define object Product 
	MobileAppPage app = new MobileAppPage(driver);
	
	//Start Login with username and password
	login.LoginwithValidCredential("Test035@test.com", "123456789");
	
	//print start testing
	tools.PrintStartTesting(testCase1);
	
	//Go to App page
	app.GotoMobilePage(driver);
	app.VerifythePageisloaded(driver);
	
	//open pp Store
	app.OpenAppStore();
	
	
	//verify the app is Available
	app.VerifytheAppisAvailableAppStore();
	
	//Print the End of test
	tools.captureScreenshot(driver, "AppStore");
	tools.PrintEndTesting(testCase1);	
}
@Test
public void VerifyNewYorkAppisAvailableatGoogleStore() {
	//define object Product 
	MobileAppPage app = new MobileAppPage(driver);
	
	//Start Login with username and password
	login.LoginwithValidCredential("Test035@test.com", "123456789");
	
	//print start testing
	tools.PrintStartTesting(testCase2);
	
	//Go to App page
	app.GotoMobilePage(driver);
	app.VerifythePageisloaded(driver);
	
	//open pp Store
	app.OpenGoogleStore();;
	
	
	//verify the app is Available
	app.VerifytheAppisAvailableGoogleStore();
	
	//Print the End of test
	tools.captureScreenshot(driver, "GoogleStore");
	tools.PrintEndTesting(testCase2);	
}

@Test
public void VerifyNewYorkAppisAvailableatGalaryStore() {
	//define object Product 
	MobileAppPage app = new MobileAppPage(driver);
	
	//Start Login with username and password
	login.LoginwithValidCredential("Test035@test.com", "123456789");
	
	//print start testing
	tools.PrintStartTesting(testCase3);
	
	//Go to App page
	app.GotoMobilePage(driver);
	app.VerifythePageisloaded(driver);
	
	//open pp Store
	app.OpenGalaryStore();
	
	
	//verify the app is Available
	app.VerifytheAppisAvailableGalaryStore();
	
	//Print the End of test
	tools.captureScreenshot(driver, "GalaryStore");
	tools.PrintEndTesting(testCase3);	
}



}
