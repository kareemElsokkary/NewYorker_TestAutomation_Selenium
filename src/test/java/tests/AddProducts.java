package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import utilities.Helper;

public class AddProducts extends TestBase {
	Login login = new Login();
	Helper tools = new Helper();

	String testCase1 = "Add Product";
	String testCase2 = "Verify the product is added to Fav";

	@Test(priority = 1)
	public void AddItemToFav() {
		// define object Product
		ProductPage product = new ProductPage(driver);

		// Start Login with username and password
		login.LoginwithValidCredential("Test035@test.com", "123456789");

		// print start testing
		tools.PrintStartTesting(testCase1);

		// Go to product page
		product.GotoProductPage(driver);
		product.VerifythePageisloaded(driver);

		// Select New Items
		product.SelectNewIN();

		// Get the name of Item and its price
		product.GetItemName();
		product.GetItemPrice();

		// Add the Item to Fav
		product.SelectfirstItem(driver);

		// Print the End of test
		tools.PrintEndTesting(testCase1);


	}

	@Test(priority = 2)
	public void VerifyProductisAddedtoFav() {
		// define object Product
		ProductPage product = new ProductPage(driver);

		// Start Login with username and password
		login.LoginwithValidCredential("Test035@test.com", "123456789");

		// print start testing
		tools.PrintStartTesting(testCase2);

		// Go to product page
		product.GotoProductPage(driver);
		product.VerifythePageisloaded(driver);

		// Open my Fav
		product.clickOnMyFav();

		// veify the Item is displayed in my fav
		product.VerifyProductisAddedtoFav(driver);

		// verify the Item name
		product.VerifyItemName();

		// verify the item Price
		product.verifyItemPrice();

		// ResetFavBasket
		product.GotoProductPage(driver);
		product.VerifythePageisloaded(driver);
		product.SelectNewIN();
		product.SelectfirstItem(driver);

		// Print End testing
		tools.PrintEndTesting(testCase2);

	}

	
}
