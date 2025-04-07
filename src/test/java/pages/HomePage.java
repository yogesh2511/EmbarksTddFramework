package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utilities.LoggerUtils;

public class HomePage extends TestBase {

	private WebDriver driver;

	// Locators
	private By HostAndAdventureHeader = By.xpath(OR.getProperty("HostAndAdventureHeader"));
	private By Logout = By.xpath(OR.getProperty("Logout"));
	private By UserName = By.xpath(OR.getProperty("UserNameLogo"));
	private By LogoLink = By.xpath(OR.getProperty("LogoLink"));
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickHostAndAdventure() {
		WebElement hostAndAdventureLink = driver.findElement(HostAndAdventureHeader);
		hostAndAdventureLink.click();
		LoggerUtils.info("Clicking on Host an Adventure link");
		////test.createTest("Clicking on Host an Adventure link");
	}
	
		public void logout() throws InterruptedException {
			WebElement UserNameLink = driver.findElement(UserName);
			UserNameLink.click();
			LoggerUtils.info("Clicking on UserName link");
			//test.createTest("Clicking on UserName link");
			Thread.sleep(2000);
			WebElement logoutLink = driver.findElement(Logout);
			LoggerUtils.info("Clicking on Logout link");
			//test.createTest("Clicking on Logout link");
			logoutLink.click();
			LoggerUtils.info("Logout link clicked");
			//test.createTest("Logout link clicked");
	}

	public void clickLogo() {
		WebElement logoLink = driver.findElement(LogoLink);
		LoggerUtils.info("Clicking on Logo link");
		//test.createTest("Clicking on Logo link");
		logoLink.click();
	}
	
}
