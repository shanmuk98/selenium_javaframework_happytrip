package selenium_javaframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddFlight extends BasePage {

	@FindBy(name="airlineCode")
	WebElement airlineName;
	@FindBy(name="flightName")
	WebElement flightName;
	@FindBy(id="EconomySelect")
	WebElement economySelect;
	@FindBy(id="EconomyCapacity")
	WebElement economyCapacity; 
	@FindBy(id="signInButton")
	WebElement Add;

	
	public AddFlight(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void selectAirLineName() {
		Select airLine=new Select(airlineName);
		 airLine.selectByIndex(3);
	}
	public void addNewFight(String flight) {
		this.flightName.sendKeys(flight);
	}
	public void checkEconomyClass() {
		this.economySelect.click();
	}
	public void enterEconomyCapacity(String num) {
		this.economyCapacity.sendKeys(num);
	}
	public AddFlightConf clickAddButton() {
		this.Add.click();
		return new AddFlightConf(driver);
	}
}
