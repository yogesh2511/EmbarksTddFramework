package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By usernameLocator = By.xpath("//input[@type='email']");
    private By passwordLocator = By.xpath("//input[@type='password']");
    private By loginButtonLocator = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        WebElement usernameField = driver.findElement(usernameLocator);
        WebElement passwordField = driver.findElement(passwordLocator);
        WebElement loginButton = driver.findElement(loginButtonLocator);

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        // Add logic to verify successful login (e.g., presence of a logout button, dashboard text, etc.)
        return true;
    }
}
