package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage extends PageBase {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[@onclick=\"handleClickRegisterFromMain()\"]")
	WebElement Register;

	@FindBy(xpath = "//*[@id=\"interstitial-register-email-input\"]")
	WebElement InputEMail;

	@FindBy(xpath = "//*[@id=\"interstitial-register-password-input\"]")
	WebElement InputPassword;

	@FindBy(xpath = "//*[@id=\"interstitial-register-password-repeat-input\"]")
	WebElement RepeatPassword;

	@FindBy(xpath = "//*[@id=\"interstitial-register-firstname-input\"]")
	WebElement InputFirstName;

	@FindBy(xpath = "//*[@id=\"interstitial-register-lastname-input\"]")
	WebElement InputLastName;

	@FindBy(xpath = "//*[@id=\"register_form\"]/div[2]/div[1]/div[1]/div/label")
	WebElement condition1;

	@FindBy(xpath = "//*[@id=\"register_form\"]/div[2]/div[1]/div[2]/div/label")
	WebElement condition2;

	@FindBy(xpath = "//*[@id=\"interstitial-register-button\"]")
	WebElement buttonRegister;

	
	@FindBy(xpath = "//*[@id=\"interstitial-completion-step\"]/div[1]/img")
	WebElement RegisterisCompleted;
	
	
	@FindBy(xpath = "//*[@id=\"interstitial-error-register\"]/div[2]/div")
	WebElement ErrorMsg;
	
	
	
	
	@FindBy(xpath = "//*[@id=\"interstitial-completion-step\"]/div[2]")
	WebElement RegisterMsg;
	
	public void StartRegister() {
		Register.click();
		
	}
	
public void EnterDataofuser(String Firstname, String Lastname, String Email, String password) {
		
		InputEMail.sendKeys(Email);
		InputPassword.sendKeys(password);
		RepeatPassword.sendKeys(password);
		InputFirstName.sendKeys(Firstname);
		InputLastName.sendKeys(Lastname);
		
	}

public void Agreeterms() {
	
	condition1.click();
	
}

public void Agreeprivacy() {
	

	condition2.click();
}

public void CompleteRegister() {
	buttonRegister.click();
	
}

public void VerifyRegisterisCompleted(WebDriver driver)  {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='completion-container show']")));
	RegisterisCompleted.isDisplayed();
	String msg= RegisterMsg.getText();
	System.out.println("---------------------------------");
	System.out.println("Verify Register is Completed");
	System.out.println("Messgae is : " + msg);
	System.out.println("---------------------------------");
		
}

public void VerifytheUserIsAlreadyExists(WebDriver driver)  {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"interstitial-error-register\"]/div[2]/div")));
	
	ErrorMsg.isDisplayed();
	String msg= ErrorMsg.getText();
	System.out.println("---------------------------------");
	System.out.println("Verify the user is already exists");
	System.out.println("Error Messgae : " + msg);
	System.out.println("---------------------------------");
		
}

}
