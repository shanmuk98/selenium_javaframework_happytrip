package selenium_javaframework;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pratian.testclasses.AddFlightTest;
public class Login extends BasePage{

	
	AddFlightTest addFlight;
	@FindBy(linkText="Log in as admin")
	WebElement logInAsAdmin;

	public Login(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	public SignInAdmin clickloginAsAdmin() {
		this.logInAsAdmin.click();
	addFlight.logger.info("logged in admin");
		return new SignInAdmin(driver);

	}
}
