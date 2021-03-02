package selenium_javaframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pratian.testclasses.AddFlightTest;



public class SignInAdmin extends BasePage {

	@FindBy(xpath="//*[@id=\"ContentFrame\"]/div[1]/div/h1")
	WebElement signInAdmin;
	@FindBy(xpath="//*[@id=\"username\"]")
	WebElement userName;
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement password;
	@FindBy(id="signInButton")
	WebElement signInButton;
	AddFlightTest addFlight;

	public SignInAdmin(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		
	}
	 
	public void clickSigninAdmin() {
		this.signInAdmin.click();
		addFlight.logger.info("navigated to sign in as admin page");
	}
	public void setuserName(String username) {
		this.userName.sendKeys(username);
		addFlight.logger.info("username textbox found");
	}
	public void setPassword(String pwd) {
		this.password.sendKeys(pwd);
		addFlight.logger.info("password field found");
	}
	public Home clickSignInButton() {
		this.signInButton.click();
		addFlight.logger.info("submit button found and navigating to home page");
		return new Home(driver);
	}

}
