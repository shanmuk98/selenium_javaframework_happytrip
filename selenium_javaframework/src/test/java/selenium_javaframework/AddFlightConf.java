package selenium_javaframework;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddFlightConf extends BasePage{

	@FindBy(xpath="//*[@id=\"ContentFrame\"]/div[1]/div/h1")
	WebElement flightAddedSuccessfully;
	public AddFlightConf(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}

	public String getCurrentStatus() {
		return flightAddedSuccessfully.getText();
		
	}
}
