package testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.TestBase;
import listeners.ReportHelperListener;
import pages.HomePage;
import pages.HostAndAdventurePage;
import pages.HostAndAdventurePageDetails;
import pages.LandingPage;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.AliasUtility;
import utilities.LoggerUtils;

@Listeners(ReportHelperListener.class)
public class EmbarkTestCase extends TestBase {

	@Test(priority = 0)
	public void UserRegistrationTest() throws InterruptedException {
		//Register a new user with randomly auto-generated data.
		// This method facing the issue with the click on Term and condition checkbox
		LoggerUtils.info("Starting User Registration test");
		test.info("Starting User Registration test");
		System.out.println("User Registration Test");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickRegisterButton();
		test.info("Clicking on Register button");
		LoggerUtils.info("Clicking on Register button");
		
		RegistrationPage registrationPage = new RegistrationPage(driver);
		LoggerUtils.info("Starting registration test");
		test.info("Starting registration test");
		registrationPage.userRegistering();
		LoggerUtils.info("User registration is completed");
		test.info("User registration is completed");
	}

	@Test(priority = 0, dependsOnMethods = { "UserRegistrationTest" })
	public void RegistedLoginTest() throws InterruptedException {
		//Login with the Random registered user
		System.out.println("User Login Test");
		LoggerUtils.info("Starting User Login test");
		test.info("Starting User Login test");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickLoginButton();
		LoggerUtils.info("Clicking on Login button");
		test.info("Clicking on Login button");
		LoginPage loginPage = new LoginPage(driver);
		LoggerUtils.info("Redirected to login page");
		test.info("Redirected to login page");
		String username = AliasUtility.getValue("email");
		String password = AliasUtility.getValue("password");
		loginPage.login(username, password);
		LoggerUtils.info("Logging in with email and password");
		test.info("Logging in with email and password");
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void UserLoginTest() throws InterruptedException {
		// Login with the Already Registered user
		// This method will removed when new Registered user Term and condition issue
		// will be resolved will.
		LoggerUtils.info("Starting User Login test");
		test.info("Starting User Login test");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickLoginButton();
		LoggerUtils.info("Clicking on Login button");
		test.info("Clicking on Login button");
		LoginPage loginPage = new LoginPage(driver);
		LoggerUtils.info("Redirected to login page");
		test.info("Redirected to login page");
		loginPage.login(Config.getProperty("username"), Config.getProperty("password"));
		LoggerUtils.info("Logging in with email and password");
		test.info("Logging in with email and password");
		Thread.sleep(2000);
	}

	@Test(priority = 1, dependsOnMethods = { "UserLoginTest" })
	public void verifyHostAndAdventure() throws InterruptedException {
		// Click on "Host an Adventure" link at the top right corner.Adventure Details
		LoggerUtils.info("Starting Host and Adventure test");
		test.info("Starting Host and Adventure test");
		HomePage homePage = new HomePage(driver);
		homePage.clickHostAndAdventure();
		LoggerUtils.info("Clicking on Host an Adventure");
		test.info("Clicking on Host an Adventure");
		HostAndAdventurePage hostAndAdventurePage = new HostAndAdventurePage(driver);
		LoggerUtils.info("Starting Host and Adventure test");
		test.info("Starting Host and Adventure test");
		hostAndAdventurePage.enterDetailsFromExcel();

		HostAndAdventurePageDetails hostAndAdventurePageDetails = new HostAndAdventurePageDetails(driver);
		LoggerUtils.info("Starting Host and Adventure test");
		test.info("Starting Host and Adventure test");
		hostAndAdventurePageDetails.fillAdventureDetails();
		HomePage homePage2 = new HomePage(driver);
		homePage2.clickLogo();
		LoggerUtils.info("Clicking on Logo");
		test.info("Clicking on Logo");
		homePage2.logout();
		LoggerUtils.info("Clicking on Logout");
		test.info("Clicking on Logout");
	}

}
