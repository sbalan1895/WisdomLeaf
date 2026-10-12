package com.pomutkadmin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POM_Admin {

	WebDriver driver;
	
	WebDriverWait waits; 

	public POM_Admin(WebDriver driver) {

		this.driver= driver;
		this.waits= new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	private By loginUser= By.xpath("//input[@id='Input_Email']");
	private By loginPswd= By.xpath("//input[@id='passwordField']");
	private By loginBtn= By.xpath("//button[@id='loginButton']");
	
	public void verifyAdminTxt() {
		
		WebElement admText = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Admin Log in')]")));
			
	}

	public void enterUserN(String userEmail) {

		WebElement enterAemail = waits.until(ExpectedConditions.visibilityOfElementLocated(loginUser));
		enterAemail.sendKeys(userEmail);
		
//		driver.findElement(loginUser).sendKeys(userEmail);

	}
	
	public void enterPswd(String userPswd) {

		WebElement enterApswd = waits.until(ExpectedConditions.visibilityOfElementLocated(loginPswd));
		enterApswd.sendKeys(userPswd);
		
//		driver.findElement(loginPswd).sendKeys(userPswd);

	}
	public void clkAdmLogN() {

		driver.findElement(loginBtn).click();

	}


}
