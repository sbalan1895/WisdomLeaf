package com.pomutkadmin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class POM_CandLogin {
	
	WebDriver driver;
	WebDriverWait waits;

	public POM_CandLogin(WebDriver driver) {

		this.driver= driver;
		this.waits= new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}

	private By CandLoginE = By.xpath("//a[contains(text(),'Log in')]");
	private By CandText = By.xpath("//h1[contains(text(),'Candidate Login')]");

	
	public void clkCandLogin() {
	
		WebElement clkLoginCand = waits.until(ExpectedConditions.elementToBeClickable(CandLoginE));
		clkLoginCand.click();
	}
	
	public boolean validateCandLogin() {
	
		WebElement CandTxt = waits.until(ExpectedConditions.elementToBeClickable(CandText));
		return CandTxt.isDisplayed();
		
	}

	
}
