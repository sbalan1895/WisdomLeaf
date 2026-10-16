package com.baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_SiteAdmin {
	
	public static WebDriver driver;
	public static WebDriverWait waits;
	
	@BeforeTest
	public void loginSite() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://staging-www.ukteach.com/SiteAdmin");
		driver.manage().window().maximize();

		waits = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {

			@NonNull
			WebElement passCodeHeading = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Enter site passcode')]")));

			if(passCodeHeading.getText().contains("Enter site passcode")) {

				@NonNull
				WebElement enterCode = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='passcode']")));
				enterCode.sendKeys("Tal-UKTLive@2026!");

				WebElement clkSubmit = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
				clkSubmit.click();

			}


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
	
	
	@AfterTest (enabled= false)
	public void closeAdmin() {
		
		WebElement AdmLogout = driver.findElement(By.xpath("//button[contains(text(),'Logout')]"));
		AdmLogout.click();
//		driver.close();
	}	

}
