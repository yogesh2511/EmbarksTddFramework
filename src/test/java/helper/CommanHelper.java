package helper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;
import utilities.LoggerUtils;

public class CommanHelper extends TestBase {
	static JavascriptExecutor js = (JavascriptExecutor) driver;

	public static void selectDropdownOptionByText(String dropdownLabel, String optionText) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Find the dropdown using label text and click to open it
		WebElement dropdown = driver
				.findElement(By.xpath("//label[text()='" + dropdownLabel + "']/following-sibling::div"));
		dropdown.click();

		Thread.sleep(2000); // Optional: wait for the dropdown to populate
		// Wait for the options to be visible
		List<WebElement> options = dropdown.findElements(By.tagName("li"));

		// Iterate and select the option by visible text
		for (WebElement option : options) {
			if (option.findElement(By.tagName("span")).getText().equals(optionText)) {
				option.click();
				break;
			}
		}
	}

	public static void selectDropdownOptionByText2(WebElement dropdownxpath, String optionText)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Find the dropdown using label text and click to open it
		dropdownxpath.click();

		Thread.sleep(2000);
		// Wait for the options to be visible
		List<WebElement> options = dropdownxpath.findElements(By.tagName("li"));

		// Iterate and select the option by visible text
		for (WebElement option : options) {
			if (option.findElement(By.tagName("span")).getText().equals(optionText)) {
				option.click();
				break;
			}
		}
	}

	public static void selectAutoDropdownOptionByText(String labelText, String cityInput) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// 1. Find the input based on the label text
		WebElement input = driver
				.findElement(By.xpath("//label[normalize-space()='" + labelText + "']/following-sibling::div//input"));

		// 2. Type the city input
		input.clear();
		input.sendKeys(cityInput);

		Thread.sleep(2000); // Optional: wait for the dropdown to populate
		// 4. Press Arrow Down and Enter to select the first item
		input.sendKeys(Keys.ARROW_DOWN);
		input.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	public static void selectAutoDropdownOptionByText2(WebElement input, String cityInput) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		input.clear();
		input.sendKeys(cityInput);

		Thread.sleep(2000); // Optional: wait for the dropdown to populate
		// 4. Press Arrow Down and Enter to select the first item
		input.sendKeys(Keys.ARROW_DOWN);
		input.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	public static void selectCheckboxIfNotSelected(By checkboxLocator) {
		try {
			WebElement checkbox = driver.findElement(checkboxLocator);
			
			if (!checkbox.isSelected()) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.getElementById('terms_and_conditions').checked = true;");
			}
			else if (checkbox.isDisplayed()) {
				checkbox.click();
				LoggerUtils.info("Checkbox was not selected. Now selected.");
			} else {
				LoggerUtils.info("Checkbox is already selected. No action taken.");
			}
		} catch (Exception e) {
			LoggerUtils.info(e.getMessage());
		}
	}
	
	public static void verifyToastMessage(String expectedMessage) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Wait until the toast is visible
	    WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//div[contains(text(),'" + expectedMessage + "')]")
	    ));

	    // Assert the toast text
	    String actualMessage = toast.getText().trim();
	    Assert.assertEquals(actualMessage, expectedMessage, "Toast message mismatch!");

	    // Optionally: Wait until it disappears (if needed)
	    wait.until(ExpectedConditions.invisibilityOf(toast));
	}

	public static void switchToWindowByIndex(int windowIndex) {
	    Set<String> allWindows = driver.getWindowHandles();
	    List<String> windowList = new ArrayList<>(allWindows);

	    if (windowIndex < 0 || windowIndex >= windowList.size()) {
	        throw new IllegalArgumentException("Invalid window index: " + windowIndex);
	    }

	    driver.switchTo().window(windowList.get(windowIndex));
	    LoggerUtils.info("Switched to window at index: " + windowIndex + " | URL: " + driver.getCurrentUrl());
	}
	

}
