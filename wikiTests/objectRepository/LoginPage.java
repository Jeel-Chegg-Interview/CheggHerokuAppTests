package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(id = "login-user")
	WebElement username;

	@FindBy(id = "login-pass")
	WebElement password;
	
	@FindBy(xpath = "//button[text()='Log In']")
	WebElement login_button;
	
	@FindBy(xpath = "//*[text()='The email or password is invalid.']")
	WebElement loginUnsuccessful;
	
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
	
	public WebElement LoginUnsuccessful() {
		return loginUnsuccessful;
	}
}
