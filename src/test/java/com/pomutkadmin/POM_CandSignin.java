package com.pomutkadmin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class POM_CandSignin {

	WebDriver driver;
	WebDriverWait waits;

	public POM_CandSignin() {

		this.driver= driver;
		this.waits= new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	private By candE = By.xpath("//input[@id='Input_Email']");
	private By candP = By.xpath("//input[@id='passwordField']");
	private By candBtn = By.xpath("//button[@id='login-submit']");

	public void enterEmail(String value) {

		WebElement entE = waits.until(ExpectedConditions.elementToBeClickable(candE));
		entE.sendKeys(value);

		Reporter.log("Candidate EmailId signIn as: " + entE, true);
	}

	public void enterPass(String value) {

		WebElement entP = waits.until(ExpectedConditions.elementToBeClickable(candP));
		entP.sendKeys(value);

		Reporter.log("Candidate password for signIn: " + entP, true);
	}

	public void clkCandLogin() {

		WebElement entP = waits.until(ExpectedConditions.elementToBeClickable(candBtn));
		entP.click();
		Reporter.log("Candidate EmailId signIn as: " + entP, true);
	}




}
//https://staging-www.ukteach.com/Candidate/Signin


