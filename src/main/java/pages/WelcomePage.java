package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage extends PageBase {

	public WelcomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//*[@class=\"item-selector-container\"]")
	WebElement DropListCountry;

	// define Button Go
	@FindBy(xpath = "//button[.=\"GO\"]")
	WebElement buttonGo;

	@FindBy(xpath = "//*[text()='Alle Cookies akzeptieren']")
	WebElement acceptcookies;

	@FindBy(xpath = "//*[@onclick=\"NY_CUSTOMER_GROUP_SERVICE.setCustomerGroup('FEMALE')\"]")
	WebElement selectWomen;

	@FindBy(xpath = "//*[@class=\"cg-select men\"]")
	WebElement selectMen;

	
// Methods
	public void ClickOnDropListCountry() {
		DropListCountry.click();
	}
	public void ClickOnbuttonGo() {
		buttonGo.click();
	}
	public void AcceptCookies() {
		acceptcookies.click();
	}
	
	public void SelectWomenSection() {
		selectWomen.click();
	}
	
	public void SelectMenSection() {
		selectMen.click();
	}
	public void SelectCountry(WebDriver driver, String Country) {
		DropListCountry.click();
		String countryPath = "//div[contains(text(), '" + Country + "')]";
		driver.findElement(By.xpath(countryPath));
		buttonGo.click();

	}

}
