package selenium_javaframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCityConfirmation extends BasePage {
	@FindBy(xpath="//*[@id=\"ContentFrame\"]/div[1]/div/h1")
	WebElement AddCitySuccessfully;
	@FindBy(linkText="Add a new flight")
	WebElement addNewFlight;
	public AddCityConfirmation(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver,this);
	}
	public AddFlight clickAddNewFlight() {
		this.addNewFlight.click();
		return new AddFlight(driver);

	}

}
