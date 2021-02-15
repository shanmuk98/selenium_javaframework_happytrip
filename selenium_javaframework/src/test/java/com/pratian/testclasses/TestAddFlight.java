package com.pratian.testclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAddFlight {

	WebDriver driver=null;

	String projectpath=System.getProperty("user.dir");

	@org.testng.annotations.Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		System.out.println("Browser Name is: " +browserName);

		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectpath+"C:\\wedriver\\chromedriver.exe");
			driver=new ChromeDriver();

		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecho.driver", projectpath+"C:\\wedriver\\geckodriver.exe");
			driver=new FirefoxDriver();

		}else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectpath+"C:\\wedriver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
	}

	@Test
	public void addNewFlight() throws Exception  {

		driver.get("https://google.com");
		Thread.sleep(4000);

	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
