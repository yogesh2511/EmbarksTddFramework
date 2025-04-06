package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import base.TestBase;
import helper.CommanHelper;
import listeners.TestNGTestListener;
import pages.HomePage;
import pages.HostAndAdventurePage;
import pages.HostAndAdventurePageDetails;
import pages.LandingPage;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.AliasUtility;
import utilities.LoggerUtils;

@Listeners(TestNGTestListener.class)
public class LoginTest extends TestBase {

	@Test(enabled=false)
	public void UserRegistrationTest() throws InterruptedException {
		//Register a new user with randomly auto-generated data.
		// This method facing the issue with the Term and condition
		System.out.println("User Registration Test");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickRegisterButton();
		
		LoggerUtils.info("Clicking on Login button");

		RegistrationPage registrationPage = new RegistrationPage(driver);
		LoggerUtils.info("Starting registration test");
		registrationPage.userRegistering();
		LoggerUtils.info("User registration is completed");
	}

	@Test(enabled =false)
	public void RegistedLoginTest() throws InterruptedException {
		//Login with the registered user
		System.out.println("User Registration Test");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickLoginButton();;
		LoggerUtils.info("Clicking on Login button");
		LoginPage loginPage = new LoginPage(driver);
		LoggerUtils.info("Starting login test");
		String username = AliasUtility.getValue("email");
		String password = AliasUtility.getValue("password");
		loginPage.login(username, password);
		LoggerUtils.info("Logging in with email and password");
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void UserLoginTest() throws InterruptedException {
		// Login with the Already Registered user
		// This method will removed when new Registered user Term and condition issue
		// will be resolved will.
		System.out.println("User Registration Test");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickLoginButton();
		;
		LoggerUtils.info("Clicking on Login button");
		LoginPage loginPage = new LoginPage(driver);
		LoggerUtils.info("Starting login test");
		loginPage.login(Config.getProperty("username"), Config.getProperty("password"));
		LoggerUtils.info("Logging in with email and password");
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void verifyHostAndAdventure() throws InterruptedException {

		// Click on "Host an Adventure" link at the top right corner.Adventure Details
		// Entry
		LoggerUtils.info("Starting Host and Adventure test");
		HomePage homePage = new HomePage(driver);
		homePage.clickHostAndAdventure();
		LoggerUtils.info("Clicking on Host an Adventure");

		HostAndAdventurePage hostAndAdventurePage = new HostAndAdventurePage(driver);
		LoggerUtils.info("Starting Host and Adventure test");
		hostAndAdventurePage.enterDetailsFromExcel();

		HostAndAdventurePageDetails hostAndAdventurePageDetails = new HostAndAdventurePageDetails(driver);
		LoggerUtils.info("Starting Host and Adventure test");
		hostAndAdventurePageDetails.fillAdventureDetails();
		HomePage homePage2 = new HomePage(driver);
		homePage2.clickLogo();
		homePage2.logout();
	}

//	@Test(priority = 3)
//	public void CompleteAdventureDetailsTest() throws InterruptedException {
//		
//		String TitleValue= excel.getCellData("Overview", "Title", 2);
//		
//		WebElement title = driver.findElement(By.xpath("//input[@placeholder='Enter the name of your tour']"));
//		title.sendKeys(TitleValue);
//		
//		String CategoryValue= excel.getCellData("Overview", "Category", 2);
//		CommanHelper.selectDropdownOptionByText("Category", CategoryValue);
//		LoggerUtils.info("Difficulty is selected");
//		
//		String SummaryValue= excel.getCellData("Overview", "Summary", 2);
//		WebElement Summary = driver.findElement(By.xpath("//textarea[@placeholder='Brief summary of the tour and other helpful details']"));
//		Summary.sendKeys(SummaryValue);
//		LoggerUtils.info("Summary is entered");
//		
//		String IncludedyValue= excel.getCellData("Overview", "Included", 2);
//		WebElement Included = driver.findElement(By.xpath("//textarea[@placeholder='List of things that are included in the tour. Enter each item on a new line to display as a bulleted list.']"));
//		Included.sendKeys(IncludedyValue);
//		LoggerUtils.info("Included is entered");
//		
//		String NotincludedValue= excel.getCellData("Overview", "Not included", 2);
//		WebElement NotIncluded = driver.findElement(By.xpath("//textarea[@placeholder='List of things that are included in the tour. Enter each item on a new line to display as a bulleted list.']"));
//		NotIncluded.sendKeys(NotincludedValue);
//		LoggerUtils.info("Not included is entered");
//		
//		WebElement Save = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
//		Save.click();
//		LoggerUtils.info("Clicking on Save button");
//		
//		
//		String City2Value= excel.getCellData("Location", "City", 2);
//		
//		
//		
//		String DurationValue= excel.getCellData("Details", "Duration", 2);
//		WebElement Duration = driver.findElement(By.xpath("//input[@type='number']"));
//		Duration.sendKeys(DurationValue);
//		LoggerUtils.info("Duration is entered");
//		
//		String DaysAndTimeValue= excel.getCellData("Details", "DaysAndTime", 2);
//		WebElement DaysAndTime = driver.findElement(By.xpath("//div[@class='multiselect select-embark inline-select multiselect--above']"));
//		CommanHelper.selectDropdownOptionByText2(DaysAndTime, DaysAndTimeValue);
//		LoggerUtils.info("Days and Time is selected");
//		
//		String Difficulty2Value= excel.getCellData("Details", "Difficulty", 2);
//		CommanHelper.selectDropdownOptionByText("Difficulty", Difficulty2Value);
//		LoggerUtils.info("Difficulty is selected");
//		
//		String GroupSizeminValue= excel.getCellData("Details", "Group Size min", 2);
//		WebElement GroupSizemin = driver.findElement(By.xpath("//input[@placeholder='Min']"));
//		GroupSizemin.sendKeys(GroupSizeminValue);
//		LoggerUtils.info("Minimum group size is entered");
//		
//		String GroupSizemaxValue= excel.getCellData("Details", "Group Size max", 2);
//		WebElement GroupSizemax = driver.findElement(By.xpath("//input[@placeholder='Max']"));
//		GroupSizemax.sendKeys(GroupSizemaxValue);
//		LoggerUtils.info("Maximum group size is entered");
//		
//		String PriceValue= excel.getCellData("Details", "Price", 2);
//		WebElement Price = driver.findElement(By.xpath("//input[@placeholder='Price']"));
//		Price.sendKeys(PriceValue);
//		LoggerUtils.info("Price is entered");
//		
//		String Group2Value= excel.getCellData("Details", "Group", 2);
//		WebElement Group2 = driver.findElement(By.xpath("//div[@class='group-input']/following-sibling::div[1]"));
//		CommanHelper.selectDropdownOptionByText2(Group2, Group2Value);
//		LoggerUtils.info("Group is selected");
//		
//		String CurrencytypeValue= excel.getCellData("Details", "Currency  type", 2);
//		WebElement CurrencyType = driver.findElement(By.xpath("//input[@class='input-text price_input']/following-sibling::div[1]"));
//		CommanHelper.selectDropdownOptionByText2(CurrencyType, CurrencytypeValue);
//		LoggerUtils.info("City is selected");
//		
//		String Availability2Value= excel.getCellData("Details", "Availability", 2);
//		WebElement Availability = driver.findElement(By.xpath("(//label[normalize-space(text())='Availability']/following::textarea)[1]"));
//		
//		String WhatqualifiesValue= excel.getCellData("Details", "What qualifies you to give this tour?", 2);
//		WebElement WhatQualifies = driver.findElement(By.xpath("(//label[normalize-space(text())='What qualifies you to give this tour?']/following::textarea)[1]"));
//		WhatQualifies.sendKeys(WhatqualifiesValue);
//		
//		String AdditionalinfoValue= excel.getCellData("Details", "Additional info", 2);
//		WebElement AdditionalInfo = driver.findElement(By.xpath("(//label[normalize-space(text())='Additional info']/following::textarea)[1]"));
//		AdditionalInfo.sendKeys(AdditionalinfoValue);
//		
//		
//		String CancellationValue= excel.getCellData("Details", "Cancellation", 2);
//		WebElement Cancellation = driver.findElement(By.xpath("//label[normalize-space(text())='Cancellation']/following::textarea"));
//		Cancellation.sendKeys(CancellationValue);
//		
//		
//		
//		
//		String MeetupLocationValue= excel.getCellData("Itinerary", "Meetup Location", 2);
//		Thread.sleep(3000);
//		CommanHelper.selectAutoDropdownOptionByText("City", MeetupLocationValue);
//		LoggerUtils.info("City is selected");
//		
//		String ItineraryValue= excel.getCellData("Itinerary", "Itinerary", 2);
//		WebElement Itinerary = driver.findElement(By.xpath("//div[@class='itinerary-day']//textarea"));
//		Itinerary.sendKeys(ItineraryValue);
//		LoggerUtils.info("Itinerary is entered");
//		
//		
//	}

//	@Test()
//	public void loginTest3(String username, String password) {
//		
//		LoginPage loginPage = new LoginPage(driver);
//		LoggerUtils.info("Starting login test");
//		loginPage.login("username: ", "password");
//		LoggerUtils.info("Logging in with email and password");
//		Assert.assertTrue(loginPage.isLoginSuccessful());
//		LoggerUtils.info("Login test completed");
//	}
//	
//	@Test()
//	public void loginTest2(String username, String password) {
//		
//		System.out.println("username: " + username);
//		System.out.println("password: " + password);
//		LoginPage loginPage = new LoginPage(driver);
//		LoggerUtils.info("Starting login test");
//		loginPage.login(username+"1", password);
//		LoggerUtils.info("Logging in with email and password");
//		Assert.assertTrue(loginPage.isLoginSuccessful());
//		LoggerUtils.info("Login test completed");
//	}
}
