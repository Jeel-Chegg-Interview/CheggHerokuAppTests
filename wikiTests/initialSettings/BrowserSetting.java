package initialSettings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import variablesData.UrlVariables;

public class BrowserSetting {

	public WebDriver BrowserSettings() {
		WebdriverSettings wds = new WebdriverSettings();
		WebDriver driver = wds.driverSettings();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(UrlVariables.BASE_URL);
		return driver;
	}
}