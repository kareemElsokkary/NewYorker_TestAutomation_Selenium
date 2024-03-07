package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends PageBase{

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath = "//span[@class='_filter-selected-icon_9wdpr_12']")
	WebElement checkmark;
	
	@FindBy(xpath = "//span[text()=\"NEW IN\"]")
	WebElement newIn;
	
	@FindBy(xpath = "//span[text()=\"Coming soon\"]")
	WebElement comingSoon;
	
	@FindBy(xpath = "//*[@id=\"filter-content\"]/div[2]/div[1]/div[4]")
	WebElement sale;
	
	
	@FindBy(xpath = "//*[@id=\"products-client\"]/div/div/div[2]/div[2]/div/a[1]")
	WebElement firstItem;
	
	@FindBy(xpath = "//*[@class=\"_grid-container_6q2xs_1\"]/div/a/div")
	WebElement firstIteminMyFav;
	
	@FindBy(xpath = "(//*[@class='_description_1pvjg_23'])[1]")
	WebElement descriptionofFirstItem;
	
	@FindBy(xpath = "//*[@class=\"_current-price-container_1pvjg_159\"]")
	WebElement PriceofFirstItem;

	@FindBy(xpath = "//*[@id=\"products-client\"]/div/div/div/div[2]/div[2]/div/div[5]/button")
	WebElement AddtoFav;
	
	@FindBy(xpath = "//*[@id=\"filter-content\"]/div[2]/div[2]/div")
	WebElement MyFav;
	
	@FindBy(xpath = "(//span[text()=\"1\"])[1]")
	WebElement FilterisApplied;
	
	@FindBy(xpath = "//*[@id=\"products-client\"]/div/div/div[1]/div/div[2]/div[2]/div[1]")
	WebElement Filter;
	
	@FindBy(xpath = "//*[@id=\"products-client\"]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div/div[1]/span")
	WebElement ResetFilter;

	@FindBy(xpath = "//div[@class=\"_button-content_1vzv1_11\"]")
	WebElement RemoveItem;
	
	@FindBy(xpath = "//*[@class=\"_like_bu09j_5 _fill_bu09j_21\"]")
	WebElement unlike;
	
	@FindBy(xpath = "//*[@id=\"products-client\"]/div/div/div[2]/div[2]/div/div[2]/button")
	WebElement ButtonBackFilter;
	
	
	private static String Item1, PriceItem1;
	
	public void VerifythePageisloaded(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"NEW IN\"]")));	
	}
	
	public void SelectNewIN() {
		newIn.click();
		WaittoVisibleElment(driver,checkmark);
		checkmark.isDisplayed();
		
	}
	
	public void clickOnComingSoon() {
		comingSoon.click();	
		WaittoVisibleElment(driver,checkmark);
		checkmark.isDisplayed();
	}
	
	public void clickOnSale() {
		sale.click();
		WaittoVisibleElment(driver,checkmark);
		checkmark.isDisplayed();
	}
	
	public void clickOnMyFav() {
		MyFav.click();	
		WaittoVisibleElment(driver,checkmark);
		checkmark.isDisplayed();
	}

	public void SelectfirstItem(WebDriver driver) {
		WaittoVisibleElment(driver,firstItem);
		firstItem.click();
		WaittoVisibleElment(driver,AddtoFav);
		AddtoFav.click();		
	}
	
	public void VerifyProductisAddedtoFav(WebDriver driver) {
		WaittoVisibleElment(driver,firstItem);
		firstItem.isDisplayed();
		
	}
	
	public void GetItemName() {
		WaittoVisibleElment(driver,descriptionofFirstItem);
		 Item1 = descriptionofFirstItem.getText();
		System.out.println("Item's description : "+Item1);
		
	}
	
	public void GetItemPrice() {
		
		PriceItem1 = PriceofFirstItem.getText();
		System.out.println("Price of Item 1 : "+PriceItem1);	
	}
	
	public void VerifyItemName() {
		String ExpectedItem1 = descriptionofFirstItem.getText();
		System.out.println("Expected Item's description  : "+ExpectedItem1);
		System.out.println("Actual Item's description  : "+Item1);
        assert ExpectedItem1.equals(Item1);
        System.out.println("Item's description  : "+Item1);
        System.out.println("The Item is added to Fav correctly");
	}
	
	public void verifyItemPrice() {
		String ExpectedPriceItem1 = PriceofFirstItem.getText();
        assert ExpectedPriceItem1.equals(PriceItem1) ;
		System.out.println("The Item's price is added to Fav correctly");
		System.out.println("Price of Item 1 : "+PriceItem1);	
	}

	public void PrintITem() {
		String Item1 = descriptionofFirstItem.getText();
		System.out.println("Item's description : "+Item1);
		
		String PriceItem1 = PriceofFirstItem.getText();
		System.out.println("Price of Item 1 : "+PriceItem1);
		
	}

	public void RemoveItemsfromFav(WebDriver driver) {
		MyFav.click();
		WaitInSecond(driver,5);
		//WaituntiltheElementToBeClickable(driver,FilterisApplied);
		unlike.click();
		
	//	firstIteminMyFav.click();
	//	WaituntiltheElementToBeClickable(driver,RemoveItem);
	//	RemoveItem.click();
		GotoProductPage(driver);
	}
	
	public void BackToProducts(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void GotoProductPage(WebDriver driver) {
		driver.get("https://www.newyorker.de/products/#/?gender=FEMALE");
		driver.navigate().refresh();
	}
	
	public void WaittoVisibleElment(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));	
	}
	
	public void WaitInSecond(WebDriver driver, int timer) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timer));	
	}
}
