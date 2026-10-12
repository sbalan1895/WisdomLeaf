package com.pomutkadmin;

import java.time.Duration;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class POM_GhostDashboard {
	
	WebDriver driver;
	WebDriverWait waits;
	Actions actns;
	
	public POM_GhostDashboard(WebDriver driver) {
		
		this.driver= driver;
		this.waits= new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}

	private By proInfN= By.xpath("//div[@class='profile-info']//div[@class='name']");
	private By proInfR= By.xpath("//div[@class='profile-info']//div[@class='role']");
	
	public void profileInfo() {
		
		@NonNull
		WebElement profN = waits.until(ExpectedConditions.elementToBeClickable(proInfN));
		String textPN = profN.getText();
		Reporter.log("Profile Info RegName is " + textPN, true);
		
		WebElement profR = waits.until(ExpectedConditions.elementToBeClickable(proInfR));
		String textPR = profR.getText();
		Reporter.log("Profile Info RegRole is " + textPR, true);
		
	}
	//div[@class='profile-info']//div[@class='name']
	//div[@class='profile-info']//div[@class='role']
}
