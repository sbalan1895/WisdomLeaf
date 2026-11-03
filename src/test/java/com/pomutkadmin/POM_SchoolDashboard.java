package com.pomutkadmin;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.accessibility.AccessibleStateSet;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.Assertion;

public class POM_SchoolDashboard {

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

	WebDriver driver;
	WebDriverWait waits;
	Actions actns;
	JavascriptExecutor jsE;

	public POM_SchoolDashboard(WebDriver driver) {

		this.driver= driver;
		this.waits= new WebDriverWait(driver, Duration.ofSeconds(20));
		this.actns= new Actions(driver);
		this.jsE= (JavascriptExecutor)driver;

	}

	private By proInfN= By.xpath("//div[@class='profile-info']//div[@class='name']");
	private By proInfR= By.xpath("//div[@class='profile-info']//div[@class='role']");
	private By sideB= By.xpath("//button[@id='hamburgerBtn']");
	private By sltJb= By.xpath("//ul/li//a[@data-bs-target='#atsJobsMenu']");
	private By slMJA= By.xpath("//ul/li//ul//li//following::a[contains(text(),'Manage Job Adverts')]");

	// Job Status dropdown (found by its label, not by position)
	private final String statusDropXp = "//div[contains(@class,'select-btn')][.//span[normalize-space()='Job Status']]";

	private By jobF= By.xpath("(//button[@type='button'])[6]//span[contains(text(),'Live Jobs')]");
	private By slJbAll= By.xpath("//div[@id='ListData']/div[contains(@class,'job-list-hold')]");

	private By jobStatusDrop     = By.xpath("//div[contains(@class,'select-btn')][.//span[normalize-space()='Job Status']]");
	private By jobStatusBtn      = By.xpath("//div[contains(@class,'select-btn')][.//span[normalize-space()='Job Status']]/button");
	private By jobStatusSelected = By.id("SelectedItem1");

	// Job list
	private By listData = By.id("ListData");
	private By loader = By.id("Loader");
	private By jobCards = By.xpath("//div[@id='ListData']/div[contains(@class,'job-list-hold')]");
	private By listFirstChild = By.xpath("//div[@id='ListData']/*[1]");   // first card OR the "No Records" box
	private By noRecords = By.xpath("//div[@id='ListData']//div[contains(@class,'page-empty')]"
			+ "//span[contains(normalize-space(),'No Records Found')]");

	private By allJobsOption     = By.xpath("//div[contains(@class,'select-btn')][.//span[normalize-space()='Job Status']]"
			+ "//*[contains(@class,'dropdown-menu')]//*[normalize-space(.)='All Jobs' and not(*[normalize-space(.)='All Jobs'])]");
	private By getAllJ = By.xpath("//div[@id='ListData']/div[contains(@class,'job-list-hold')]");
	private By selectClosedJ = By.xpath("//div[contains(@class,'select-btn')][.//span[normalize-space()='Job Status']]/div/a[contains(text(),'Closed')]");

	// =========== Helpers ================

	/**Instant scroll to the middle of the viewport. */
	private void scrollToCenter(WebElement elem) {
		jsE.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest', behavior:'instant'});", elem);
	}

	private void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}
	}

	/** Locator for one option inside the open Job Status menu, by its visible text. */
	private By statusOption(JobStatus status) {
		String t = status.label();
		return By.xpath(statusDropXp + "//*[contains(@class,'dropdown-menu')]"
				+ "//*[normalize-space(.)='" + t + "' and not(*[normalize-space(.)='" + t + "'])]");
	}

	private void openJobStatus() {

		for (int i = 1; i <= 3; i++) {

			WebElement btn = waits.until(ExpectedConditions.elementToBeClickable(jobStatusBtn));
			scrollToCenter(btn);
			btn.click();
			try {
				new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.attributeToBe(jobStatusBtn, "aria-expanded", "true"));
				return;                                   // menu is open
			} catch (Exception e) {
				System.out.println("Job Status dropdown did not open, attempt " + i);
			}
		}

		throw new AssertionError("Job Status dropdown never opened");
	}

	/**
	 * Waits until the list text stops changing (3 identical reads in a row). The page can re-draw the
	 * list more than once after a filter change, so the first set of cards is not always the final one.
	 */
	private void waitForListToSettle() {

		String last = null;
		int same = 0;
		long end = System.currentTimeMillis() + 10000;

		while (same < 3 && System.currentTimeMillis() < end) {
			String now;
			try {
				now = driver.findElement(listData).getText();
			} catch (StaleElementReferenceException | NoSuchElementException e) {
				now = "";
			}
			same = now.equals(last) ? same + 1 : 0;
			last = now;
			pause(300);
		}
	}

	/** The list is ready when EITHER job cards OR the "No Records Found." box is showing. */
	private void waitForListToLoad() {

		waits.until(ExpectedConditions.or(
				ExpectedConditions.numberOfElementsToBeMoreThan(jobCards, 0),
				ExpectedConditions.visibilityOfElementLocated(noRecords)));
		waits.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		waitForListToSettle();
	}

	private List<String> readTitles() {

		for (int attempt = 1; attempt <= 3; attempt++) {
			try {
				List<String> titles = new ArrayList<>();
				for (WebElement card : driver.findElements(jobCards)) {
					titles.add(card.getText().split("\\r?\\n")[0].trim());
				}
				return titles;
			} catch (StaleElementReferenceException e) {
				waitForListToSettle();
			}
		}
		throw new AssertionError("The job list kept changing while it was being read");
	}

	//==================================================

	public void profileInfo() {

		@NonNull
		WebElement profN = waits.until(ExpectedConditions.elementToBeClickable(proInfN));
		Reporter.log("Profile Info RegName is " + profN.getText(), true);

		WebElement profR = waits.until(ExpectedConditions.elementToBeClickable(proInfR));
		Reporter.log("Profile Info RegRole is " + profR.getText(), true);


	}

	public void selectJob() {

		waits.until(ExpectedConditions.elementToBeClickable(sideB)).click();
		waits.until(ExpectedConditions.elementToBeClickable(sltJb)).click();
		waits.until(ExpectedConditions.elementToBeClickable(slMJA)).click();

		Reporter.log("Manage Job Advert opened " + driver.getCurrentUrl(), true);

	}

	public void validateJobsF() {

		String selected = waits.until(ExpectedConditions.visibilityOfElementLocated(jobStatusSelected)).getText().trim();
		Reporter.log("Selected Job Status filter: " + selected, true);

	}

	/** Selects one Job Status option and waits until the list has refreshed. */
	public void selectJobStatus(JobStatus status) {

		// marker to detect that the list was replaced (works whether the list has cards or is empty)
		List<WebElement> marker = driver.findElements(listFirstChild);
		WebElement oldFirst = marker.isEmpty() ? null : marker.get(0);

		openJobStatus();
		waits.until(ExpectedConditions.elementToBeClickable(statusOption(status))).click();

		// the filter button must now show the chosen option
		waits.until(ExpectedConditions.textToBe(jobStatusSelected, status.label()));

		if (oldFirst != null) {
			try {
				new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.stalenessOf(oldFirst));
			} catch (Exception ignored) {
				// list was not re-created (for example the same option was selected again)
			}
		}
		waitForListToLoad();

		Reporter.log("Job Status filter set to: " + status.label(), true);
	}

	/**
	 * Reads the current list. Returns the job titles, or an empty list after checking that the
	 * page really shows "No Records Found.".
	 */

	/**
	 * Reads the current list. Returns the job titles, or an empty list after checking that the
	 * page really shows "No Records Found.".
	 */
	public List<String> getJobList(String listName) {

		waitForListToLoad();

		List<String> titles = readTitles();

		if (titles.isEmpty()) {
			String msg = waits.until(ExpectedConditions.visibilityOfElementLocated(noRecords)).getText().trim();
			Assert.assertEquals(msg, "No Records Found.", listName + ": unexpected message for an empty list");
			Reporter.log("===== " + listName + ": 0 jobs - " + msg + " =====", true);
			return titles;
		}

		Assert.assertTrue(driver.findElements(noRecords).isEmpty(),
				listName + ": jobs are listed but 'No Records Found.' is also displayed");

		Reporter.log("===== " + listName + ": " + titles.size() + " job(s) =====", true);

		int no = 1;
		for (String title : titles) {
			Reporter.log(no + ". " + title, true);
			no++;
		}
		return titles;
	}


}
