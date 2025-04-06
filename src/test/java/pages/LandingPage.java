package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;

import utilities.LoggerUtils;

public class LandingPage {

	private WebDriver driver;
	private By loginButton = By.xpath("//a[normalize-space()='Login']");
	private By registerButton = By.xpath("//a[normalize-space()='Register']");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLoginButton() {
	    driver.findElement(loginButton).click();
	    LoggerUtils.info("Clicking on Login button");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.urlContains("/login"));  // Change as per actual path

	    // Assert the current URL
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue(currentUrl.contains("/login"), "Redirection to login page failed.");
	    LoggerUtils.info("Successfully navigated to Login page: " + currentUrl);
	    
	       
	}

	public void clickRegisterButton() {
	    driver.findElement(registerButton).click();
	    LoggerUtils.info("Clicking on Register button");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.urlContains("/register")); // Change as per actual path

	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue(currentUrl.contains("/register"), "Redirection to registration page failed.");
	    LoggerUtils.info("Successfully navigated to Register page: " + currentUrl);
	}
}
