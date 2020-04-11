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
 * This class will test the presence of EDIT button post login
 * @author Jeel Patel
 * @version 1.0
 *
 */
public class TestNegativeEditButtonScenario {
	BrowserSetting brSet;
	WebDriver driver;

	@BeforeClass
	public void driverInitialization(){

		brSet = new BrowserSetting();
		driver = brSet.BrowserSettings();
	}
	@Test
	public void loginEditButtonNegativeflow() {
		// First logging in to get the URL : https://chegg-qachallenge.herokuapp.com/ 
		LoginPage lp = new LoginPage(driver);
		lp.UsernameElement().sendKeys(UserVariables.USER_EMAIL);
		lp.PasswordElement().sendKeys(UserVariables.USER_PASSWORD);
		lp.Login_buttonElement().click();
		
		// Once https://chegg-qachallenge.herokuapp.com/ URL is arrived, loading the whole page source to check for the word EDIT
		String pageSource = driver.getPageSource();
		
		// Expecting no EDIT word in page source to confirm that no edit button is present
		// Test will pass when no edit keyword is found
		Assert.assertFalse(pageSource.contains("Edit"));
	}
	@AfterClass
	public void driverClosure() {
		driver.close();
	}
}