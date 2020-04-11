package loginTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import initialSettings.BrowserSetting;
import objectRepository.LoginPage;
import variablesData.UserVariables;

public class TestLoginURLRedirect {
	BrowserSetting brSet;
	WebDriver driver;

	@BeforeClass
	public void driverInitialization(){

		brSet = new BrowserSetting();
		driver = brSet.BrowserSettings();
	}
	@Test
	public void loginURLRedirect() {

		LoginPage lp = new LoginPage(driver);
		lp.UsernameElement().sendKeys(UserVariables.USER_EMAIL);
		lp.PasswordElement().sendKeys(UserVariables.USER_PASSWORD);
		lp.Login_buttonElement().click();
		
		}
}
