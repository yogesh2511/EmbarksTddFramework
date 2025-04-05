package testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.TestBase;
import listeners.TestNGTestListener;
import pages.LoginPage;
import utilities.DataUtil;

@Listeners(TestNGTestListener.class)
public class LoginTest extends TestBase {

	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	public void loginTest(String username, String password) {
		try {
			log.info("Starting login test");
			LoginPage loginPage = new LoginPage(driver);
			log.info("Starting login test");
			loginPage.login("usernam", "password");
			log.info("Logging in with email and password");
			Assert.assertTrue(loginPage.isLoginSuccessful());
			log.info("Login test completed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info(e.fillInStackTrace().toString());
		}
	}
	
	@Test()
	public void loginTest3(String username, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		log.info("Starting login test");
		loginPage.login("username: ", "password");
		log.info("Logging in with email and password");
		Assert.assertTrue(loginPage.isLoginSuccessful());
		log.info("Login test completed");
	}
	
	@Test()
	public void loginTest2(String username, String password) {
		
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		LoginPage loginPage = new LoginPage(driver);
		log.info("Starting login test");
		loginPage.login(username+"1", password);
		log.info("Logging in with email and password");
		Assert.assertTrue(loginPage.isLoginSuccessful());
		log.info("Login test completed");
	}
}
