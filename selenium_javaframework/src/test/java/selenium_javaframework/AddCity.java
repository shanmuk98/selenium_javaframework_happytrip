package selenium_javaframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCity extends BasePage{

	@FindBy(xpath="//*[@id=\"ContentFrame\"]/div[1]/div/h1")
	WebElement AddCity;
	@FindBy(id="states")
	WebElement stateName;
	@FindBy(id="cityName")
	WebElement cityName;
	@FindBy(id="signInButton")
	WebElement Add;

	public AddCity(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	public void selectState() {
		Select states=	new Select(stateName);
		states.selectByIndex(3);
	}
	public void addCityName(String city) {
		this.cityName.sendKeys(city);
	}
	public AddCityConfirmation clickAddButton() {
		this.Add.click();
		return new AddCityConfirmation(driver);
	}
}
