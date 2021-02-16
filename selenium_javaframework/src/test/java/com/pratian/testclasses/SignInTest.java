package com.pratian.testclasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pratian.happytrip.automation.filehandling.PropertyManager;

import selenium_javaframework.AddCity;
import selenium_javaframework.AddCityConfirmation;
import selenium_javaframework.AddFlight;
import selenium_javaframework.AddFlightConf;
import selenium_javaframework.Home;
import selenium_javaframework.Login;
import selenium_javaframework.SignInAdmin;

@Test
public class SignInTest extends BaseTest{
	@Test(priority = 1)
	public void signInToHappytrip() throws IOException {
		driver.get(PropertyManager.getProperty("url.app"));
		Login logIn=new Login(driver);

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		logIn.clickloginAsAdmin();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}
	@Test(priority = 2, dataProvider = "signIn")
	public void signInuser(String username,String password) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		SignInAdmin signinAdmin=new SignInAdmin(driver);
		//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		signinAdmin.setuserName(username);
		//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		signinAdmin.setPassword(password);
		//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		signinAdmin.clickSignInButton();
		//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 3, dataProvider = "City name")
	public void clickAddNewCity(String city) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Home home=new Home(driver);
		AddCity addCity=home.clickaddCityName();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		addCity.selectState();
		addCity.addCityName(city);
		AddCityConfirmation conf=addCity.clickAddButton();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//home.clickAddNewFlight();
		//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//		WebElement element=driver.findElement(By.xpath("//*[@id=\"ContentFrame\"]/div[1]/div/h1"));
		//		String acctual=element.getText();
		//		String expected="City added successfuly";
		//		Assert.assertEquals(expected, acctual);

	}
	@Test(priority = 4, dataProvider = "Flight name")
	public void clickAddFlight(String flightname) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Home home =new Home(driver);
		AddFlight addFlight=home.clickAddNewFlight();
		addFlight.selectAirLineName();
		addFlight.addNewFight(flightname);
		addFlight.checkEconomyClass();
		addFlight.enterEconomyCapacity("150");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		AddFlightConf addFlightConf=addFlight.clickAddButton();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@DataProvider(name = "signIn")
	public Object[][] getCredentials() {

		return new Object[][] {

			{ "admin@mindtree.com", "admin" },

		};
	}
	@DataProvider(name = "City name")
	public Object[][] addNewCity() {

		return new Object[][] {

			{"agra_z"},

		};
	}
	@DataProvider(name = "Flight name")
	public Object[][] addNewFlight(){
		return new Object[][] 
				{
			{"deccan0011"},
				};

	}
}
