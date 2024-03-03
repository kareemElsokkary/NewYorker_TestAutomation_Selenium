package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileAppPage extends PageBase {
	public MobileAppPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"ny-app-button\"]/div/div[1]")
	WebElement Appstoreicon;

	@FindBy(xpath = "//*[@id=\"ny-app-button\"]/div/div[2]")
	WebElement GooglePlayicon;

	@FindBy(xpath = "//*[@id=\"ny-app-button\"]/div/div[3]")
	WebElement AppGalaryicon;

	@FindBy(xpath = "//h1[text()=\"NEW YORKER\"]")
	WebElement AppNameinAppStore;

	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[2]/div/div/div[1]/div[2]/div[1]/div/div/c-wiz/div[2]/div[1]/div/h1")
	WebElement AppNameinGooglePlay;

	@FindBy(xpath = "//div[text()=\"NEW YORKER\"]")
	WebElement AppNameinGalaryStore;

	public void OpenAppStore() {
		Appstoreicon.click();
	}

	public void OpenGoogleStore() {
		GooglePlayicon.click();
	}

	public void OpenGalaryStore() {
		AppGalaryicon.click();
	}

	public void VerifytheAppisAvailableAppStore() {
		WaituntiltheElementToBeClickable(driver, AppNameinAppStore);

		String App = AppNameinAppStore.getText();
		assert App.equalsIgnoreCase("NEW YORKER 4+");
		System.out.println("App in App Store : " + App);
	}

	public void VerifytheAppisAvailableGoogleStore() {
		WaituntiltheElementToBeClickable(driver, AppNameinGooglePlay);
		String App = AppNameinGooglePlay.getText();
		assert App.equalsIgnoreCase("NEW YORKER");
		System.out.println("App in Google Store: " + App);
	}

	public void VerifytheAppisAvailableGalaryStore() {
		WaituntiltheElementToBeClickable(driver, AppNameinGalaryStore);

		String App = AppNameinGalaryStore.getText();
		assert App.equalsIgnoreCase("NEW YORKER");
		System.out.println("App in Galary : " + App);
	}

	public void GotoMobilePage(WebDriver driver) {
		driver.get("https://www.newyorker.de/app/");
	}

	public void VerifythePageisloaded(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(Appstoreicon));
	}

	public void WaituntiltheElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
