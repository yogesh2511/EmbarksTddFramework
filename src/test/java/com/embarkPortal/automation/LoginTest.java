package com.embarkPortal.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class LoginTest extends TestBase {

	@Test
	public void loginTest() {
		LoginPage loginPage = new LoginPage(driver);
		log.info("Starting login test");
		loginPage.login("solankiyogesh95@gmail.com", "Yogesh@2511");
		log.info("Logging in with email and password");
		Assert.assertTrue(loginPage.isLoginSuccessful());
		log.info("Login test completed");
	}

//	@Test
//	public void registerNewUser() {
//	    UserData user = UserData.generateRandomUser();
//	    RegistrationPage registration = new RegistrationPage(driver);
//	    registration.register(user);
//	    Assert.assertTrue(registration.isRegistrationSuccessful());
//	}

	//@Test(dependsOnMethods = "registerNewUser")
//	public void loginAndHostAdventure() {
//	     LoginPage loginPage = new LoginPage(driver);

	   // loginPage.login(UserData.getRegisteredUser());

//	    AdventurePage adventurePage = new AdventurePage(driver);
//	    adventurePage.clickHostAdventure();
//	    
//	    adventurePage.enterDetailsFromExcel("adventure_data.xlsx");
//	    adventurePage.saveAdventure();
//	    
//	    Assert.assertTrue(adventurePage.isValidationMessageDisplayed("Group Size"));
//	    adventurePage.enterGroupSize();
//	    adventurePage.saveAdventure();
//	    
//	    Assert.assertTrue(adventurePage.isSuccessMessageDisplayed("Tour updated successfully"));
//	}
//
//	@Test(dependsOnMethods = "loginAndHostAdventure")
//	public void verifyTourDetailsAndWishlist() {
//	    AdventurePage adventurePage = new AdventurePage(driver);
//	    adventurePage.clickViewTour();
//
//	    Assert.assertTrue(adventurePage.verifyTourDetails());
//
//	    adventurePage.clickSaveToWishlist();
//	    Assert.assertTrue(adventurePage.isWishlistUpdated());
	//	}

//	@Test(dependsOnMethods = "verifyTourDetailsAndWishlist")
//	public void logoutTest() {
//	    HomePage homePage = new HomePage(driver);
//	    homePage.logout();
//
//	    Assert.assertTrue(homePage.isUserLoggedOut());
//	}

}
