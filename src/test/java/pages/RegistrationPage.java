package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.github.javafaker.Faker;

import base.TestBase;
import helper.CommanHelper;
import utilities.AliasUtility;
import utilities.LoggerUtils;

public class RegistrationPage extends TestBase {

	private WebDriver driver;

	// Locators
	private By FullName = By.xpath("//input[@placeholder='Full Name']");
	private By Username = By.xpath("//input[@placeholder='username09']");
	private By EmailName = By.xpath("//input[@placeholder='username@gmail.com']");
	private By Password = By.xpath("(//input[@type='password'])[1]");
	private By ConfirmPassword = By.xpath("(//input[@type='password'])[2]");
	private By Location = By.xpath("//input[@placeholder='Enter a location']");
	private By TermsAndCondition = By.id("terms_and_conditions");
	private By RegisterButton = By.xpath("//button[normalize-space()='Register']");
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void userRegistering() throws InterruptedException {
		WebElement FullNameElement = driver.findElement(FullName);
		Faker faker = new Faker();
		FullNameElement.sendKeys(faker.name().fullName());
		LoggerUtils.info("Full Name is entered");
		//test.createTest("Full Name is entered");

		WebElement usernameElement = driver.findElement(Username);
		String usernameValue = faker.name().firstName() + faker.number().numberBetween(1, 1000);
		usernameElement.sendKeys(usernameValue);
		LoggerUtils.info("Username is entered");
		//test.createTest("Username is entered");
		
		WebElement EmailElement = driver.findElement(EmailName);
		String emailValue = faker.internet().emailAddress();
		EmailElement.sendKeys(emailValue);
		LoggerUtils.info("Email is entered");
		//test.createTest("Email is entered");
		AliasUtility.storeAlias("email", emailValue);

		WebElement PasswordElement = driver.findElement(Password);
		String passwordValue = faker.internet().password();
		PasswordElement.sendKeys(passwordValue);
		LoggerUtils.info("Password is entered");
		//test.createTest("Password is entered");
		AliasUtility.storeAlias("password", passwordValue);

		WebElement ConfirmPasswordElement = driver.findElement(ConfirmPassword);
		ConfirmPasswordElement.sendKeys(passwordValue);
		LoggerUtils.info("Confirm Password is entered");
		//test.createTest("Confirm Password is entered");
		
		WebElement LocationElement = driver.findElement(Location);
		CommanHelper.selectAutoDropdownOptionByText2(LocationElement, "New York");
		LoggerUtils.info("Location is selected");
		//test.createTest("Location is selected");
		
		CommanHelper.selectCheckboxIfNotSelected(TermsAndCondition);
		LoggerUtils.info("Clicking on Terms and Condition checkbox");
		//test.createTest("Clicking on Terms and Condition checkbox");
		
		WebElement RegisterButtonElement = driver.findElement(RegisterButton);
		RegisterButtonElement.click();
		LoggerUtils.info("Clicking on Register button");
		//test.createTest("Clicking on Register button");

		Thread.sleep(3000);
		HomePage homePage = new HomePage(driver);
		homePage.clickLogo();
		LoggerUtils.info("Clicking on Logo");
		//test.createTest("Clicking on Logo");
		Thread.sleep(3000);
		homePage.logout();
		LoggerUtils.info("Clicking on Logout");
		//test.createTest("Clicking on Logout");
	}

	

	public boolean isRegistrationSuccessful() {
		// TODO Auto-generated method stub

		return false;
	}

}
