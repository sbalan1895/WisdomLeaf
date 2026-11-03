package com.baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pomutkadmin.POM_SchoolL;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(TestListerner.class)

public class Base_RecruiterL {

	public static WebDriver driver;

	public static WebDriverWait waits;
	
	POM_SchoolL pom_school;
	
	@BeforeClass
	public void login_School() {
		
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		driver.get("https://staging-www.ukteach.com/Recruiter/Signin");
		driver.manage().window().maximize();
		
		pom_school = new POM_SchoolL(driver);
		
		waits= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			
			pom_school.enterPassCode("Tal-UKTLive@2026!");
			
		}
		catch(Exception e) {
			System.out.println("Passcode page is not displayed, Continuing...,");
			
		}
	}
	
	@BeforeMethod
	public void handleCookiesPoup() {

		@NonNull
		@Nullable
		WebElement chPop = waits.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Reject All')]")));
		try {
			if(chPop.isDisplayed()) {

				Actions act= new Actions(driver);
				act.moveToElement(chPop).click().build().perform();

				System.out.println("Cookies constent banner dismissed using RejectAll");
			}
		}
		catch(StaleElementReferenceException | ElementClickInterceptedException e ) {
			
			System.out.println(
	                "Cookie banner interaction was interrupted: "
	                + e.getClass().getSimpleName());
			
			throw e;
		}
		//		chPop.isDisplayed();

	}
	
	@AfterMethod
	public void takeScreenshots() throws IOException {

		String screenshotName= "Screenshot_" + System.currentTimeMillis() + ".png";

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File destination= new File(System.getProperty("user.dir")+ "\\Screenshots\\" +screenshotName);

		FileUtils.copyFile(source, destination);

	} 
	
/*	@AfterClass(enabled= false)
	public void tearDown() {
		
		if(driver != null) {
			driver.close();
		}
		
	} */
	
}
