package Stepdefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Tha;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeTest_Step {

	WebDriver driver;

	@Given("User navigate to PracticeTest login page")
	public void user_navigate_to_practice_test_login_page() {

		System.out.println("Inside Step --- User navigate to PracticeTest login page");

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();

	}

	@When("User able to enter Username and Password")
	public void user_able_to_enter_username_and_password() {
		System.out.println("Inside Step ---- User able to enter Username and Password");

		WebElement userN = driver.findElement(By.xpath("//input[@id='username']"));
		userN.sendKeys("student");

		WebElement passW = driver.findElement(By.xpath("//input[@id='password']"));
		passW.sendKeys("Password123");
	}

	@When("Click on Submit button")
	public void click_on_submit_button() {

		System.out.println("Inside Step--- Click on Submit button");
		WebElement submB = driver.findElement(By.xpath("//button[@id='submit']"));
		submB.click();
	}

	@When("Verify valid credential entered")
	public void verify_valid_credential_entered() {

		try {

			List<WebElement> invalidMsg= driver.findElements(By.xpath("//div[text()='Your username is invalid!']"));
			if(!invalidMsg.isEmpty()) {
				System.out.println("FAIL: Invalid username/password login fail");
			}
			else {
				System.out.println("PASS: Valid username/password login pass");
				System.out.println("Inside Step---- User successfully navigate to PracticeTest homepage");
			}
		}
		catch(Exception ex) {

			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
			ex.printStackTrace();

		}
	}

	@Then("User successfully navigate to PracticeTest homepage")
	public void user_successfully_navigate_to_practice_test_homepage() {

		//h1[text()='Logged In Successfully']
		//a[@class='custom-logo-link']
		//a[text()='Log out']
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement textLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Logged In Successfully']")));
		
		wait.until(ExpectedConditions.urlContains("//a[@class='custom-logo-link']"));
		
		WebElement logoutB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Log out']")));
		logoutB.click();
	}

}
