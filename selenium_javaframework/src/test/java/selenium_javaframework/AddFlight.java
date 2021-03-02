package selenium_javaframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pratian.testclasses.AddFlightTest;

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
	AddFlightTest addFlight;

	
	public AddFlight(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void selectAirLineName() {
		Select airLine=new Select(airlineName);
		 airLine.selectByIndex(3);
		addFlight.logger.info("selected an airlineline");	
	}
	public void addNewFight(String flight) {
		this.flightName.sendKeys(flight);
		addFlight.logger.info("added a new flight");	
	}
	public void checkEconomyClass() {
		this.economySelect.click();
		addFlight.logger.info("checked economic class");	
	}
	public void enterEconomyCapacity(String num) {
		this.economyCapacity.sendKeys(num);
		addFlight.logger.info("flight seat capacity is specified");	
	}
	public AddFlightConf clickAddButton() {
		this.Add.click();
		addFlight.logger.info("clicked on add button");	
		return new AddFlightConf(driver);
	}
}
