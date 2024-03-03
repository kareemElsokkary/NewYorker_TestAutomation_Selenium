package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Date;
import java.util.UUID;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Helper {

	// Method to take screenshot when the test cases fail
	public static void captureScreenshot(WebDriver driver, String screenshotname) {
		Path dest = Paths.get("./Screenshots", screenshotname + getCurrentDate()+ ".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Excpetion while taking screenshot" + e.getMessage());
		}
	}

	public static String getUniqueId() {
		return String.format("%s_%s", UUID.randomUUID().toString().substring(0, 5), System.currentTimeMillis() / 1000);
	}
	
	public static String getCurrentDate() {
		// Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("-dd-MM-yyyy HH-mm-ss ");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String today= dateFormat.format(date);
		return today;
	}

	public static void PrintStartTesting(String text) {
		System.out.println("Start Testing...");
		System.out.println("Test case : " + text);
	}

	public static void PrintEndTesting(String text) {
		System.out.println("Test case : "+ text +" is Finished");
		System.out.println("====================================");
		
	}

}
