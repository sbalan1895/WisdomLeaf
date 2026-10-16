package com.seleniumproj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.basehotel.BaseHotel;

public class SeleniumTests extends BaseHotel{

	//	WebDriver driver;

	@Test(priority= 1)
	public void loginCred() {
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("sbala018");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("895S4A");

		driver.findElement(By.xpath("//input[@id='login']")).click();
	}

	@Test(priority= 2)
	public void validateList() {

		WebElement locElement = driver.findElement(By.xpath("//select[@id='location']"));

		Select select= new Select(locElement);
		List<WebElement> location = select.getOptions();

		List<String> actualList= new ArrayList<String>();

		for(WebElement options: location ) {
			actualList.add(options.getText());
		}

		List<String> expectedList= new ArrayList<String>(actualList);

		Collections.sort(expectedList);
		
		System.out.println("ActualList : " +actualList);
		System.out.println("ExpectedList : " +expectedList);

		if(actualList.equals(expectedList)) {	
			System.out.println("Location dropdown is in alphabetical order");

		}

		else {
			System.out.println("Location dropdown is not in alphabetical order");
		}

	}
}
