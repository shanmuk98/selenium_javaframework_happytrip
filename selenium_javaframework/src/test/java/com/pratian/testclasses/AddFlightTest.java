package com.pratian.testclasses;

import java.io.File;





import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pratian.happytrip.automation.filehandling.PropertyManager;


import selenium_javaframework.AddFlight;
import selenium_javaframework.AddFlightConf;
import selenium_javaframework.Home;

import selenium_javaframework.Login;
import selenium_javaframework.SignInAdmin;

@Listeners(ListenerTest.class)
public class AddFlightTest  {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extentReports;
	ExtentTest test1;


	//private static Logger logger=LogManager.getLogger(AddFlightTest.class);

	public static Logger logger=LogManager.getLogger(AddFlightTest.class);

	WebDriver driver;
		@Parameters("browserName")
		@BeforeTest
		public void setup(String browserName) {
		System.out.println("Browser Name is: " +browserName);
			
			if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\wedriver\\chromedriver.exe");
				driver=new ChromeDriver();
				
			}else if(browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecho.driver","C:\\wedriver\\geckodriver.exe");
				driver=new FirefoxDriver();
			
			}else if(browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver","C:\\wedriver\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}
		}
		
	@Test
	public  void webPageNavigation() throws IOException {


		logger.info("testcase add flight started");
		htmlReporter=new ExtentHtmlReporter("extentReport2.html");
		logger.debug("extent report generated");

		extentReports=new ExtentReports();
		extentReports.attachReporter(htmlReporter);
		test1=extentReports.createTest("happy trip app","this is a test to validate happy trip login");
		test1.log(Status.INFO, "starting test case");
		driver.get(PropertyManager.getProperty("url.app"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		test1.pass("happy trip page navigation successfull");
		Login logIn=new Login(driver);

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		logIn.clickloginAsAdmin();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test(priority = 2, dataProvider = "signIn")

	public void signInuser(String username,String password) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//ExtentTest test1=extentReports.createTest("happy trip app","this is a test to validate happy trip login");
		test1.log(Status.INFO, "starting test case");
		SignInAdmin signinAdmin=new SignInAdmin(driver);
		//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		signinAdmin.setuserName(username);
		test1.pass("entered the username");
		//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		signinAdmin.setPassword(password);
		test1.pass("entered the password");
		//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		signinAdmin.clickSignInButton();
		test1.pass("sign in successfull");
		//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 4, dataProvider = "Flight name")
	public void clickAddFlight(String flightname) throws IOException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test1.log(Status.INFO, "starting homepeage");
		Home home =new Home(driver);

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		test1.pass("snavigated to home page");
		AddFlight addFlight=home.clickAddNewFlight();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test1.pass("add flight action successfull");
		addFlight.selectAirLineName();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test1.pass("added airline name");
		addFlight.addNewFight(flightname);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test1.pass("added flight name");
		addFlight.checkEconomyClass();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test1.pass("checked economic class");
		addFlight.enterEconomyCapacity("120");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test1.pass("entered economic capacity");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		AddFlightConf addFlightConf=addFlight.clickAddButton();
		Assert.assertEquals(addFlightConf.getCurrentStatus(), "Flight added successfuly");	
		test1.pass("added flight successfully");
		//test1.log(Status.FAIL,"flight not added");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();

		//		WebElement element = driver.findElement(By.xpath("//*[@id=\"ContentFrame\"]/div[1]/div/h1"));
		//		String strng = element.getText();
		//
		//
		//		Assert.assertEquals("Airline added successfully", strng,"Airline is  addded successfully");
		test1.pass("browser hasbeen closed");
		test1.info("testcase1 completed");
		extentReports.flush();
		test1.info("extent report hasbeen generated ");
	
		//		File screenshotFile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//
		//		FileUtils.copyFile(screenshotFile, new File(".//screenshots/screen.png"));
		//		


	}
	@DataProvider(name = "signIn")
	public Object[][] getCredentials() {

		return new Object[][] {

			{ "admin@mindtree.com", "admin" },

		};
	}
	@DataProvider(name = "Flight name")
	public Object[][] addNewFlight(){
		return new Object[][] 
				{
			{"deccan240"},
				};

	}
}

