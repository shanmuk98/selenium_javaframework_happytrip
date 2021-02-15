package selenium_javaframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home extends BasePage {

	@FindBy(xpath="//*[@id=\"global\"]/li[1]")
	WebElement Home;
	@FindBy(linkText="Add City")
	WebElement addCity;
	@FindBy(linkText="Add flight")
	WebElement addNewFlight;

	public Home(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);

	}

	public AddCity clickaddCityName() {
		this.addCity.click();
		return new AddCity(driver);
	}
	public AddFlight clickAddNewFlight() {
		this.addNewFlight.click();
		return new AddFlight(driver);

	}

}
