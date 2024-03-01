package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	static public String myEmail;

	@FindBy(xpath = "//button[@onclick=\"handleClickLoginFromMain()\"]")
	WebElement Login;

	@FindBy(xpath = "//*[@id=\"interstitial-login-email-input\"]")
	WebElement InputEmail;

	@FindBy(xpath = "//*[@id=\"interstitial-login-password-input\"]")
	WebElement InputPassword;

	@FindBy(xpath = "//*[@id=\"interstitial-login-button\"]")
	WebElement ButtonLogin;

	@FindBy(xpath = "(//div[@class=\"error-message\"])[1]")
	WebElement ErrorMsg;

	public void StartLogin() {
		Login.click();
	}

	public void EnterEmail(String Email) {
		InputEmail.sendKeys(Email);
		myEmail = getEmail();

	}

	public String getEmail() {
		return InputEmail.getAttribute("value");
	}

	public void EnterPassword(String password) {
		InputPassword.sendKeys(password);
	}

	public void clickOnButtonLogin() {
		ButtonLogin.click();
	}

	public void verifyTheErrorMsgIsDisplayed() {
		
		ErrorMsg.isDisplayed();
		printErrorMsg(ErrorMsg.getText());
	}

	private void printErrorMsg(String text) {
		System.out.println("------------------------------------------------");
		System.out.println("-----Verify the Error message is displayed------");
		System.out.println("Error Message : " + text);
		System.out.println("------------------------------------------------");
	}

}
