package selenium_javaframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pratian.testclasses.AddFlightTest;

public class Home extends BasePage {

	@FindBy(xpath="//*[@id=\"global\"]/li[1]")
	WebElement Home;
	@FindBy(linkText="Add City")
	WebElement addCity;
	@FindBy(linkText="Add flight")
	WebElement addNewFlight;
	AddFlightTest addFlight;

	public Home(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);

	}

	public AddCity clickaddCityName() {
		this.addCity.click();
		addFlight.logger.info("clicked on add city link");
		return new AddCity(driver);
	}
	public AddFlight clickAddNewFlight() {
		this.addNewFlight.click();
		addFlight.logger.info("clicked on add flight link");
		return new AddFlight(driver);

	}

}
