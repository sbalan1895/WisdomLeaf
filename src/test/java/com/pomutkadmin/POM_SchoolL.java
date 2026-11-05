package com.pomutkadmin;

import java.time.Duration;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class POM_SchoolL {

	/** Options of the Job Status filter. The label must match the text shown in the dropdown. */
	public enum JobStatus {
		LIVE("Live Jobs"),
		ALL("All Jobs"),
		CLOSED("Closed/Expired Jobs"),
		DRAFT("Draft Jobs"),
		TEMPLATE("Job Templates");

		private final String label;

		JobStatus(String label) {
			this.label = label;
		}

		public String label() {
			return label;
		}
	}

	//======Locators=============


	WebDriver driver;
	WebDriverWait waits;
	Actions actns;
	JavascriptExecutor jsE;


	public POM_SchoolL(WebDriver driver) {

		this.driver = driver;
		this.waits= new WebDriverWait(driver, Duration.ofSeconds(10));
		this.actns= new Actions(driver);
		this.jsE= (JavascriptExecutor)driver;

	}

	private By ePassF = By.xpath("//h1[contains(text(),'Enter site passcode')]");
	private By ePassC = By.xpath("//input[@name='passcode']");
	private By clkEC = By.xpath("//button[@type='submit']");

	private By entEm = By.xpath("//input[@id='Input_Email']");
	private By entEp = By.xpath("//input[@id='passwordField']");
	private By clkLgn = By.xpath("//button[@id='login-submit']");

	private By sessionPopup = By.xpath("//div[@class='modal-header']//h5[contains(text(), 'Session already active')]");
	private By sessionCnfrm = By.xpath("//div[@class='modal-footer']//button[contains(text(),'Sign out other session')]");
	private By userN = By.xpath("//div[@id='greetingBtn']//span[@class='name']");

	//span[@id="passwordField-error"]



	public void enterPassCode(String value) {

		waits.until(ExpectedConditions.presenceOfElementLocated(ePassF));

		@NonNull
		WebElement entPC = waits.until(ExpectedConditions.elementToBeClickable(ePassC));
		entPC.sendKeys(value);

		@NonNull
		WebElement clkSubm = waits.until(ExpectedConditions.elementToBeClickable(clkEC));
		clkSubm.click();

	}

	public void enterSchlEid(String value) {

		WebElement entEid = waits.until(ExpectedConditions.elementToBeClickable(entEm));
		entEid.sendKeys(value);

	}

	public void enterSchlPsw(String value) {

		WebElement entPsw = waits.until(ExpectedConditions.elementToBeClickable(entEp));
		entPsw.sendKeys(value);

	}

	public void clkLogN() {

		WebElement clkL = waits.until(ExpectedConditions.elementToBeClickable(clkLgn));
		clkL.click();
	}

	public void sessionAlAct() {
		WebElement sesnPop = waits.until(ExpectedConditions.presenceOfElementLocated(sessionPopup));

		if(sesnPop.isDisplayed()) {

			try {

				WebElement cnfrmSns = waits.until(ExpectedConditions.elementToBeClickable(sessionCnfrm));
				cnfrmSns.click();

			}
			catch(Exception e) {

				System.out.println("==== Session already active not display ====");
				Reporter.log("==== Session already active not display ====");

			}

		}

	}

	public void getlogedUserN() {

		WebElement lUn = waits.until(ExpectedConditions.presenceOfElementLocated(userN));
		String getUN = lUn.getText();

		System.out.println("==== School LoggedIn user is" +getUN);
		Reporter.log(getUN, false);

	}


}
