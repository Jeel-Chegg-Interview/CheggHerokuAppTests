package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"form-validate\"]/div[2]/button")
	WebElement login_button;
	
	// Constructor to initialize driver and load web element using PageFactory
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement UsernameElement() {
		return username;
	}

	public WebElement PasswordElement() {
		return password;
	}

	public WebElement Login_buttonElement() {
		return login_button;
	}
}
