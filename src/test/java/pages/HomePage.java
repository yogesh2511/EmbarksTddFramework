package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.LoggerUtils;

public class HomePage {

	private WebDriver driver;

	// Locators
	private By HostAndAdventureHeader = By.xpath("//a[normalize-space()='Host an Adventure']");
	private By Logout = By.xpath("//a[@class='nav-link']");
	private By UserName = By.xpath("//div[@class='right-side']//div//div[@id='navExplore']");
	private By LogoLink = By.xpath("//img[@src='/build/images/logo.jpg']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickHostAndAdventure() {
		WebElement hostAndAdventureLink = driver.findElement(HostAndAdventureHeader);
		LoggerUtils.info("Clicking on Host an Adventure link");
		hostAndAdventureLink.click();
	}
	
		public void logout() {
			WebElement UserNameLink = driver.findElement(UserName);
			LoggerUtils.info("Clicking on UserName link");
			UserNameLink.click();
			WebElement logoutLink = driver.findElement(Logout);
			LoggerUtils.info("Clicking on Logout link");
			logoutLink.click();
	}

	public void clickLogo() {
		WebElement logoLink = driver.findElement(LogoLink);
		LoggerUtils.info("Clicking on Logo link");
		logoLink.click();
	}
	
	public boolean isUserLoggedOut() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
