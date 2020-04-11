package loginTests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import initialSettings.BrowserSetting;
import objectRepository.LoginPage;
import objectRepository.EditingPage;
import variablesData.UserVariables;

/**
 * This class tests the negative flow for login credentials.
 * @author Jeel Patel
 * @version 1.0
 *
 */
public class TestNegativeLoginCredentials {
	BrowserSetting brSet;
	WebDriver driver;

	@BeforeClass
	public void driverInitialization(){

		brSet = new BrowserSetting();
		driver = brSet.BrowserSettings();
	}
	@Test
	public void loginNegativeCredentialCheck() {
		LoginPage lp = new LoginPage(driver);
		
		// Adding extra characters to make the login credentials invalid.
		lp.UsernameElement().sendKeys(UserVariables.USER_EMAIL + "foo");
		lp.PasswordElement().sendKeys(UserVariables.USER_PASSWORD + "bar");
		lp.Login_buttonElement().click();
		
		// Checking for invalid login i.e. The email or password is invalid text.
		Assert.assertTrue(lp.LoginUnsuccessful().isDisplayed());
	}
	@AfterClass
	public void driverClosure() {
		driver.close();
	}
}
