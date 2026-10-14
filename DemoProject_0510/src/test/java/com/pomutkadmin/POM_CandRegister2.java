package com.pomutkadmin;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class POM_CandRegister2 {

	WebDriver driver;
	WebDriverWait waits;

	JavascriptExecutor jsE; 
	Actions actn;
	
	private static final int MAX_ATTEMPTS = 3;

	public POM_CandRegister2(WebDriver driver) {

		this.driver= driver;
		this.waits= new WebDriverWait(driver, Duration.ofSeconds(50));
		this.jsE = (JavascriptExecutor) driver;
		this.actn= new Actions(driver);

	}

	private By RegisterBtn = By.xpath("//p[contains(normalize-space(),'have an account')]/following-sibling::a[normalize-space()='Register']");
	private By eCandEmail = By.xpath("//input[@id='emailInput']");
	private By verifyBtn = By.xpath("//button[@id='verifyBtn']");
	private By selectTitle = By.xpath("//select[@id='Input_SalutationTitle']");
	private By enterFN = By.xpath("//input[@id='Input_FirstName']");
	private By enterLN = By.xpath("//input[@id='Input_LastName']");
	private By enterPhN = By.xpath("//input[@id='Input_Phone']");
	private By enterPws = By.xpath("//input[@name='Input.Password']");
	private By enterCnfP = By.xpath("//input[@name='Input.ConfirmPassword']");
	private By clkChB1 = By.xpath("//input[@id='receive']");
	private By clkChB2 = By.xpath("//input[@id='updates']");
	private final By clkRegF = By.id("createBtn");
	private By getConfT = By.xpath("//div//p[contains(text(),'Your email')]");
	//button[contains(text(),'Register')]
	//form//button[@type='submit'][contains(normalize-space(.),'Register')]

	//https://staging-www.ukteach.com/Candidate/RegisterConfirmation?email=sbdcand1791876737906@mailinator.com

	// ---------- Reusable helpers ----------

	/** Instant (non-animated) scroll to the middle of the viewport. */
	private void scrollToCenter(WebElement el) {
		jsE.executeScript(
				"arguments[0].scrollIntoView({block:'center', inline:'nearest', behavior:'instant'});", el);
	}



	/** Types into a field with retries; last resort is setting the value via JS. */
	private void typeInto(By locator, String text) {
		for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
			try {
				WebElement el = readyElement(locator);
				el.clear();
				el.sendKeys(text);
				return;
			} catch (ElementNotInteractableException 
					| StaleElementReferenceException | TimeoutException e) {
				if (attempt == MAX_ATTEMPTS) {
					setValueByJs(locator, text); // fallback
					return;
				}
			}
		}
	} 

	private void setValueByJs(By locator, String text) {
		WebElement el = waits.until(ExpectedConditions.presenceOfElementLocated(locator));
		jsE.executeScript(
				"arguments[0].value=arguments[1];"
						+ "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));"
						+ "arguments[0].dispatchEvent(new Event('change',{bubbles:true}));"
						+ "arguments[0].dispatchEvent(new Event('blur',{bubbles:true}));", el, text);
	}

	/** Clicks with retries; last resort is a JS click. */
	private void safeClick(By locator) {
		for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
			try {
				readyElement(locator).click();
				return;
			} catch (ElementNotInteractableException 
					| StaleElementReferenceException | TimeoutException e) {
				if (attempt == MAX_ATTEMPTS) {
					WebElement el = waits.until(ExpectedConditions.presenceOfElementLocated(locator));
					jsE.executeScript("arguments[0].click();", el);
					return;
				}
			}
		}
	}

	/** Ticks a checkbox only if it is not already ticked, and verifies the result. */
	private void tick(By locator) {
		WebElement box = waits.until(ExpectedConditions.presenceOfElementLocated(locator));
		if (!box.isSelected()) {
			safeClick(locator);
		}
		if (!waits.until(ExpectedConditions.presenceOfElementLocated(locator)).isSelected()) {
			WebElement again = driver.findElement(locator);
			jsE.executeScript("arguments[0].click();", again);
		}
	}

	private WebElement waitUntilStable(By locator) {
		waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
		double last = -1;
		int stable = 0;
		long end = System.currentTimeMillis() + 5000;
		while (stable < 3 && System.currentTimeMillis() < end) {
			WebElement el = driver.findElement(locator);
			double top = ((Number) jsE.executeScript(
					"return arguments[0].getBoundingClientRect().top + window.pageYOffset;", el)).doubleValue();
			stable = (Math.abs(top - last) < 1) ? stable + 1 : 0;
			last = top;
			try { Thread.sleep(150); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); break; }
		}
		return driver.findElement(locator);
	}

	/** Waits until visible, scrolls it to centre, then waits until clickable. Re-finds the element each time. */
	private WebElement readyElement(By locator) {
		waitUntilStable(locator);

		//		WebElement el = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
		scrollToCenter(driver.findElement(locator));
		return waits.until(ExpectedConditions.elementToBeClickable(locator));
	}

	private void reportFailureState() {
		System.out.println("URL: " + driver.getCurrentUrl());
		List<WebElement> errs = driver.findElements(By.cssSelector(
				".text-danger, .field-validation-error, .validation-summary-errors, .alert, [role='alert'], .invalid-feedback"));
		boolean scrolled = false;
		for (WebElement e : errs) {
			if (e.isDisplayed() && !e.getText().isBlank()) {
				System.out.println("PAGE ERROR: " + e.getText().trim());
				if (!scrolled) { scrollToCenter(e); scrolled = true; }
			}
		}
		try {
			Files.createDirectories(Paths.get("Screenshots"));
			File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(shot.toPath(), Paths.get("Screenshots", "register-fail.png"), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception ignored) { }
	}

	//================================================

	public void clkRegButton() {

		safeClick(RegisterBtn);

	}

	public void enterCandEmail(String candEmail) {

		typeInto(eCandEmail, candEmail);


	}

	public void clkVerify() {
		safeClick(verifyBtn);

	}

	public void selectTitle(String title) {

		WebElement el = readyElement(selectTitle);
		new Select(el).selectByVisibleText(title);

	}	

	public void enterFirstName(String Tvalue) {

		typeInto(enterFN, Tvalue);

	}

	public void enterLastName(String Tvalue) {

		typeInto(enterLN, Tvalue);

	}

	public void enterPhoneNo(String Tvalue) {

		typeInto(enterPhN, Tvalue);

	}

	// NOTE: no ENTER key here. Enter inside a password field submits/validates the
	// form and re-renders the page, which is what made the next field flaky.
	public void enterPassword(String Tvalue) {

		typeInto(enterPws, Tvalue);
		waitUntilStable(enterCnfP);

	}

	public void enterCnfrmP(String Tvalue) {

		typeInto(enterCnfP, Tvalue);
		waitUntilStable(clkChB1);

	}

	public void clkCheckB1() {

		tick(clkChB1);
		waitUntilStable(clkChB2);

	}

	public void clkCheckB2() {

		tick(clkChB2);

		waitUntilStable(clkRegF);

		actn.sendKeys(Keys.ENTER);

	} 

	public void clkRegisterF() {

		try { Thread.sleep(3000);} 
		catch (InterruptedException ie) { 
			Thread.currentThread().interrupt();}

		@NonNull
		WebElement regck = waits.until(ExpectedConditions.elementToBeClickable(clkRegF));
		actn.moveToElement(regck).click(regck).build().perform();
		System.out.println("Register clicked");

		try { Thread.sleep(5000); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); } 
		System.out.println("Register clicked, URL: " + driver.getCurrentUrl());
	} 

	public void getCandRegConfirm() {
		try {
			waits.until(ExpectedConditions.urlContains("RegisterConfirmation"));
			Reporter.log("Registered OK: " + driver.getCurrentUrl(), true);
		} catch (TimeoutException e) {
			reportFailureState();      // prints PAGE ERROR lines and saves Screenshots/register-fail.png
			Assert.fail("Registration not completed. URL: " + driver.getCurrentUrl());
		}
	}


}


//candauto@mailinator.com clkChB1 clkRegF