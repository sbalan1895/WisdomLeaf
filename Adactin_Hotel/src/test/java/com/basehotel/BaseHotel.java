package com.basehotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseHotel {
	
	public static WebDriver driver;
	
	@BeforeClass (alwaysRun = true)
	public void loginAdactin() {
		
		System.out.println("======== BeforeClass Executed ===========");

		WebDriverManager.chromedriver().setup();

		driver= new ChromeDriver();
		
		System.out.println("Driver ==== " +driver);

		driver.get("https://adactinhotelapp.com/HotelAppBuild2/");

		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {

		if(driver!= null) {
			driver.quit();
		}

	}

}



