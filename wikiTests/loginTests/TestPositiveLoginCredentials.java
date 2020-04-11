package loginTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import initialSettings.BrowserSetting;
import objectRepository.LoginPage;
import variablesData.UserVariables;

/**
 * This class does the "happy-path" scenario for login
 * @author Jeel Patel
 * @version 1.0
 *
 */
public class TestPositiveLoginCredentials {
	BrowserSetting brSet;
	WebDriver driver;

	@BeforeClass
	public void driverInitialization() {

		brSet = new BrowserSetting();
		driver = brSet.BrowserSettings();
	}

	@Test
	public void loginPositiveFlow() {
		LoginPage lp = new LoginPage(driver);
		lp.UsernameElement().sendKeys(UserVariables.USER_EMAIL);
		lp.PasswordElement().sendKeys(UserVariables.USER_PASSWORD);
		lp.Login_buttonElement().click();

		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://chegg-qa-challenge.herokuapp.com/";
		
		// If the URL after login is as per the expectation then the test will PASS
		Assert.assertEquals(currentURL, expectedURL);
	}

	@AfterClass
	public void driverClosure() {
		driver.close();
	}
}
