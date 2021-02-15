package selenium_javaframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SignInAdmin extends BasePage {

	@FindBy(xpath="//*[@id=\"ContentFrame\"]/div[1]/div/h1")
	WebElement signInAdmin;
	@FindBy(xpath="//*[@id=\"username\"]")
	WebElement userName;
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement password;
	@FindBy(id="signInButton")
	WebElement signInButton;
	

	public SignInAdmin(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		
	}
	 
	public void clickSigninAdmin() {
		this.signInAdmin.click();
	}
	public void setuserName(String username) {
		this.userName.sendKeys(username);
	}
	public void setPassword(String pwd) {
		this.password.sendKeys(pwd);
	}
	public Home clickSignInButton() {
		this.signInButton.click();
		return new Home(driver);
	}

}
