package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utilities.LoggerUtils;

public class LoginPage extends TestBase {
	private WebDriver driver;

	// Locators
	private By usernameLocator = By.xpath(OR.getProperty("usernameLocator"));
	private By passwordLocator = By.xpath(OR.getProperty("passwordLocator"));
	private By loginButtonLocator = By.xpath(OR.getProperty("loginButtonLocator"));

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String username, String password) throws InterruptedException {
			WebElement usernameField = driver.findElement(usernameLocator);
			WebElement passwordField = driver.findElement(passwordLocator);
			WebElement loginButton = driver.findElement(loginButtonLocator);

			usernameField.sendKeys(username);
			LoggerUtils.info("Username is entered");
			test.info("Username is entered");
			passwordField.sendKeys(password);
			LoggerUtils.info("Password is entered");
			test.info("Password is entered");
			loginButton.click();
			Thread.sleep(2000);
			LoggerUtils.info("Login button is clicked");
			test.info("Login button is clicked");
		
	}
}
