package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pages.LoginPage;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		}
@FindBy(xpath = "//*[@class=\"right-items\"]/customer-widget")
	WebElement myAccount;



public void clickOnmyAccount() {
	myAccount.click();	
}

public String getmyEmail() {
	 String info= myAccount.getText();
	 String email = extractEmail(info);
	 return email;
}

public void VerifyTheUserLoginsuccesfuly() {
	LoginPage login = new LoginPage(driver);
	myAccount.click();
	String myEmail=getmyEmail();
	String LoginEmail=  login.myEmail;
	printLoginEmail(LoginEmail);
	assert myEmail.equals(LoginEmail);
}

private void printLoginEmail(String Email) {
	System.out.println("-------------------------------------------------");
	System.out.println("------- Verify the user login succesfuly --------");	
	System.out.println("Email : " +Email);
	System.out.println("------------------------------------------------");
}

private static String extractEmail(String input) {
    // Define the regex pattern for matching an email address
    String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";

    // Compile the regex pattern
    Pattern pattern = Pattern.compile(regex);

    // Create a Matcher object
    Matcher matcher = pattern.matcher(input);

    // Find the first occurrence of the pattern in the input string
    if (matcher.find()) {
        // Return the matched email
        return matcher.group();
    }

    // Return null if no email is found
    return null;
}

}
