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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestListerner.class)
public class Base_Demo {

	public static WebDriver driver;

	public static WebDriverWait waits;

	@Test(priority= 1)
	public void login_regSchool() {

		WebDriverManager.chromedriver().setup();

		driver= new ChromeDriver();

		driver.get(" https://staging-www.ukteach.com/Recruiter/Signin");

		driver.manage().window().maximize();

		waits = new WebDriverWait(driver, Duration.ofSeconds(10));

		// First scenario, if asking for EnterPassCode 

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

	@Test(priority= 3)
	public void enterCredential() {

		@NonNull
		WebElement schoolText = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='School Login']")));

		try {

			if(schoolText.isDisplayed()) {

				WebElement enterEmail = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Input_Email']")));
				enterEmail.sendKeys("sivabalat@mailinator.com");

				WebElement enterPassword = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='passwordField']")));
				enterPassword.sendKeys("Sbtest@123Sbtest@123");

				WebElement clkLoginBtn = driver.findElement(By.xpath("//button[@id='login-submit']"));
				clkLoginBtn.click();

			}

		}
		catch(Exception e) {
			System.out.println("Login as Register in School, successfully done");
		}


	}

	@Test (enabled= false)
	public void selectSchool() {

		//If the landing on LogIn page

		WebElement logIn = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Log in')]")));

		if(logIn.isDisplayed()) {

			WebElement clkArrowButton = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='arrow-btn']")));
			clkArrowButton.click();

			WebElement selectSchool = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu shadow show']//li[2]")));
			selectSchool.click();

		}

	}

	@Test(priority= 4)
	public void validateHome() {

		WebElement dashboard = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), 'Dashboard')]")));

		if(dashboard.isDisplayed()) {

			WebElement logInUser = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[@class='name']")));
			String userName = logInUser.getText();

			System.out.println("Logged in register for school is " +userName);

		}

	}

	@Test(enabled= false)
	public void closeSchool() {

		WebElement clkSelect = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='BtnDropdownArrow']")));
		clkSelect.click();

		WebElement clkLogout = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-empty p-0 d-flex justify-content-start']")));
		clkLogout.click();
	}

	@Test(priority= 5)
	public void getTotalJobCount() {
		WebElement totalJobC = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"stat-body\"]//a[.//div[contains(text(),'Total jobs')]]//div[1]")));
		String tJobv= totalJobC.getText();
		System.out.println("----Total job value is " +tJobv +"----");

	}

	@Test(priority= 6)
	public void getActiveJobCount() {
		WebElement actJobC = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"stat-body\"]//a[.//div[contains(text(),'Active Jobs')]]//div[1]")));
		String aJobv= actJobC.getText();
		System.out.println("----Total job value is " +aJobv +"----");

	}

	@Test(priority= 5)
	public void getAppilcationsCount() {
		WebElement applC = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"stat-body\"]//a[.//div[contains(text(),'Applications')]]//div[1]")));
		String applicC= applC.getText();
		System.out.println("----Total job value is " +applicC +"----");

	}

	@Test(priority= 2)
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

	//div[@class="stat-body"]//a[.//div[contains(text(),'Total jobs')]]

	//div[@class="stat-body"]//a[.//div[contains(text(),'Total jobs')]]//div[1]


	//button[@aria-label='Close']
	//button[contains(text(),'Reject All')]





























	@AfterMethod
	public void takeScreenshots() throws IOException {

		String screenshotName= "Screenshot_" + System.currentTimeMillis() + ".png";

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File destination= new File(System.getProperty("user.dir")+ "\\Screenshots\\" +screenshotName);

		FileUtils.copyFile(source, destination);

	}
}
