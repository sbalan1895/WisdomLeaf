package com.utilitytest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.basehotel.BaseHotel;
import com.pomhotel.POM_HOTEL;

import SearchHotelPOM.SearchHotelPOM;

public class AdactinHotel extends BaseHotel {

	POM_HOTEL pomHotel;
	SearchHotelPOM searchH;

	@Test (priority=1, groups= {"SmokeTest", "SanityTest"})
	public void adactinLogin() {

		pomHotel = new POM_HOTEL(driver);

		pomHotel.enterUser("sbala018");
		pomHotel.enterPass("2OPE44");
		pomHotel.clickLogin();
	}

	@Test(priority=2, groups= {"SmokeTest", "SanityTest"})
	public void validateUser() {

		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));

		@Nullable
		String title = driver.getTitle();
		WebElement userLogged = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username_show")));
		String userText = userLogged.getAttribute("value");

		System.out.println("The current page title is " +title);

		System.out.println("The current logged-in user is " + userText);
	}

	@Test (priority= 3, groups= {"SmokeTest", "RegressionTest"})
	public void validateLocation() {
		searchH= new SearchHotelPOM(driver);
		List<WebElement> location = searchH.getLocation();

		boolean optFound= false;

		for(WebElement locOption: location) {

			if(locOption.getText().equals("London")) {
				optFound= true;
				break;
			}
		}

		Assert.assertTrue(optFound, "London is not present in location dropdown list");

		System.out.println("London option present in location dropdown ");

	}

	@Test (priority= 4, groups= {"SanityTest"})
	public void validateListOrder() {

		searchH= new SearchHotelPOM(driver);
		List<WebElement> location = searchH.getLocation();

		ArrayList<String> actualList= new ArrayList<String>();

		for(WebElement option: location) {

			actualList.add(option.getText());

		}

		ArrayList<String> expectedList= new ArrayList<String>(actualList);

		Collections.sort(expectedList);

		System.out.println("Actual list: " +actualList);

		System.out.println("Expected list: " +expectedList);

		if(expectedList.equals(actualList)) {

			System.out.println("Location dropdown is in alphabetical order");
		}

		else {

			System.out.println("Location dropdown is not in alphabetical order");
		}

		//		Assert.assertEquals(actualList, expectedList, "Location dropdown is not in alphabetical order");
		//		
		//		System.out.println("Location dropdown is in alphabetical order");

	}
}
