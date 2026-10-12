package com.pomutkadmin;

import java.time.Duration;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseCandidateLogin;

public class POM_SignInCand extends BaseCandidateLogin{
	
	WebDriver driver;
	WebDriverWait waits;
	Actions actns;
	
	public POM_SignInCand() {
		
		this.driver= driver;
		this.waits= new WebDriverWait(driver, Duration.ofSeconds(20));
		this.actns= new Actions(driver);
	}
	
	private By signBtn = By.xpath("//a[@class='btn btn-primary mt-2']");
	
	
	public void clkSignCand() {
		
		@NonNull
		WebElement sgnBtn = waits.until(ExpectedConditions.elementToBeClickable(signBtn));
		actns.click(sgnBtn).build().perform();
	}
	
}
