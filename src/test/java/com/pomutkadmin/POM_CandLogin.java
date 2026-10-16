package com.pomutkadmin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class POM_CandLogin {
	
	WebDriver driver;
	WebDriverWait waits;

	public POM_CandLogin(WebDriver driver) {

		this.driver= driver;
		this.waits= new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}

	private By CandLoginE = By.xpath("//a[contains(text(),'Log in')]");
	private By CandText = By.xpath("//h1[contains(text(),'Candidate Login')]");
	private By entEm = By.xpath("//input[@id='Input_Email']");
	private By entPsw = By.xpath("//input[@id='passwordField']");
	private By clkLg= By.xpath("//button[@id='login-submit']");
	private By getCanU= By.xpath("(//button[@class='btn btn-primary'])[1]");
	
	//(//button[@class="btn btn-primary"])[1]
	//(//button[@class='btn btn-primary'])[1]
	
	
	public void clkCandLogin() {
	
		WebElement clkLoginCand = waits.until(ExpectedConditions.elementToBeClickable(CandLoginE));
		clkLoginCand.click();
	}
	
	
	public void enterEmID(String value) {
		WebElement entE = waits.until(ExpectedConditions.elementToBeClickable(entEm));
		entE.sendKeys(value);
		
	}
	
	public void enterPsw(String value) {
		WebElement entP = waits.until(ExpectedConditions.elementToBeClickable(entPsw));
		entP.sendKeys(value);
		
	}

	public void clkLoginBtn() {
		
		WebElement clkLc = waits.until(ExpectedConditions.elementToBeClickable(clkLg));
		clkLc.click();
	}
	
	public void getCandUser() {
		
		WebElement candU = waits.until(ExpectedConditions.visibilityOfElementLocated(getCanU));
		String canduser = candU.getText();
		System.out.println(canduser);
		Reporter.log("Logged candidate UserName is: " +canduser, true);
		
		
	}
	
}
