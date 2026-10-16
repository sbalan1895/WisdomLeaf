package com.pomhotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POM_HOTEL {

	WebDriver driver;

	public POM_HOTEL(WebDriver driver) {

		this.driver= driver;
	}

	private By loginUser = By.id("username");
	private By loginPass = By.id("password");
	private By buttonLogin= By.id("login");

	public void enterUser(String user) {
		driver.findElement(loginUser).sendKeys(user);

	}

	public void enterPass(String pass) {
		driver.findElement(loginPass).sendKeys(pass);

	}
	
	public void clickLogin() {
		driver.findElement(buttonLogin).click();
		
	}

}
