package selenium_javaframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BasePage{

	@FindBy(linkText="Log in as admin")
	WebElement logInAsAdmin;

	public Login(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	public SignInAdmin clickloginAsAdmin() {
		this.logInAsAdmin.click();
		return new SignInAdmin(driver);

	}
}
