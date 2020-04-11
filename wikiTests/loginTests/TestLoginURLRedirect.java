package loginTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import initialSettings.BrowserSetting;
import variablesData.UrlVariables;

/**
 * This class tests the URL redirect mechanism against expected
 * @author Jeel Patel
 * @version 1.0
 *
 */
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
		String baseURL = UrlVariables.BASE_URL;
		System.out.println("Base URL: "+baseURL);
		
		//navigating to https://chegg-qa-challenge.herokuapp.com/testuser-je8ds0dfd
		driver.get(baseURL);
		
		//getting current URL (expecting redirect by now)
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL: "+currentURL);
		
		String expectedURL = "https://chegg-qa-challenge.herokuapp.com/login";
		
		//Checking if the URL got redirected to expected, if so then the test will PASS
		Assert.assertEquals(currentURL, expectedURL);
		}
	
	@AfterClass
	public void driverClosure() {
		driver.close();
	}
}