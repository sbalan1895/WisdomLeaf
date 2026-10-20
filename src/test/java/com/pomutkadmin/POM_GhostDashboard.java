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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.Assertion;

public class POM_GhostDashboard {

	WebDriver driver;
	WebDriverWait waits;
	Actions actns;
	JavascriptExecutor jsE;

	public POM_GhostDashboard(WebDriver driver) {

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
	private By jobF= By.xpath("(//button[@type='button'])[6]//span[contains(text(),'Live Jobs')]");
	private By slJbAll= By.xpath("//div[@id='ListData']/div[contains(@class,'job-list-hold')]");
//	private By JSF = By.xpath("(//button[@type='button'])[6]");
//	private By JSal = By.xpath("//div[@class='dropdown-menu show']//a[contains(text(),'All Jobs')]");

	private By jobStatusDrop     = By.xpath("//div[contains(@class,'select-btn')][.//span[normalize-space()='Job Status']]");
	private By jobStatusBtn      = By.xpath("//div[contains(@class,'select-btn')][.//span[normalize-space()='Job Status']]/button");
	private By jobStatusSelected = By.id("SelectedItem1");
	private By allJobsOption     = By.xpath("//div[contains(@class,'select-btn')][.//span[normalize-space()='Job Status']]"
			+ "//*[contains(@class,'dropdown-menu')]//*[normalize-space(.)='All Jobs' and not(*[normalize-space(.)='All Jobs'])]");
	private By getAllJ = By.xpath("//div[@id='ListData']/div[contains(@class,'job-list-hold')]");
	private By selectClosedJ = By.xpath("//div[contains(@class,'select-btn')][.//span[normalize-space()='Job Status']]/div/a[contains(text(),'Closed')]");
	private By selectDraftJ = By.xpath("//div[contains(@class,'select-btn')][.//span[normalize-space()='Job Status']]/div/a[contains(text(),'Draft Jobs')]");
	private By selectTemplateJ = By.xpath("//div[contains(@class,'select-btn')][.//span[normalize-space()='Job Status']]/div/a[contains(text(),'Job Templates')]");
	
	
	
	
	/**Instant scroll to the middle of the viewport. */
	private void scrollToCenter(WebElement elem) {
		jsE.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest', behavior:'instant'});", elem);
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

	//==================================================

	public void profileInfo() {

		@NonNull
		WebElement profN = waits.until(ExpectedConditions.elementToBeClickable(proInfN));
		String textPN = profN.getText();
		Reporter.log("Profile Info RegName is " + textPN, true);

		WebElement profR = waits.until(ExpectedConditions.elementToBeClickable(proInfR));
		String textPR = profR.getText();
		Reporter.log("Profile Info RegRole is " + textPR, true);

	}

	public void selectJob() {

		waits.until(ExpectedConditions.elementToBeClickable(sideB)).click();
		waits.until(ExpectedConditions.elementToBeClickable(sltJb)).click();
		waits.until(ExpectedConditions.elementToBeClickable(slMJA)).click();

		Reporter.log("Manage Job Advert opened" + driver.getCurrentUrl(), true);

	}

	public void validateJobsF() {

		@NonNull
		WebElement jobFl = waits.until(ExpectedConditions.presenceOfElementLocated(jobF));
		@Nullable
		String attribute = jobFl.getAttribute("value");
		String textF = jobFl.getText();

		Reporter.log("AttributeValue of selected JobFilter: " +attribute, true);
		Reporter.log("SelectedOption Text in JobFilter: " +textF, true);

		//		Assert.assertEquals(true, textF, "==== Live Jobs Option selected in jobstatus filter");
	}

	public List<String> getLiveJobList() {
		waits.until(ExpectedConditions.numberOfElementsToBeMoreThan(slJbAll, 0));

		List<String> jobs = new ArrayList<>();
		List<WebElement> allJobList = driver.findElements(slJbAll);

		Reporter.log("Jobs found: " +allJobList.size(), true);
		System.out.println("=====Live Jobs list=====");

		for (WebElement card : allJobList) {
			String fullText = card.getText().split("\n")[0];  
			String firstLine = fullText.split("\n")[0].trim();

			jobs.add(fullText);

			Reporter.log(fullText, true);

		}
		return jobs;	

	}

	public void selectAllJob() {
		WebElement firstOld = driver.findElements(slJbAll).get(0);   // used to detect the list refresh

		openJobStatus();
		System.out.println("DROPDOWN TEXT: " + driver.findElement(jobStatusDrop).getText().replace("\n", " | "));

		waits.until(ExpectedConditions.elementToBeClickable(allJobsOption)).click();

		@NonNull
		Boolean allJobsSltd = waits.until(ExpectedConditions.textToBe(jobStatusSelected, "All Jobs"));

		try {
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.stalenessOf(firstOld));
		} catch (Exception e) { }

		waits.until(ExpectedConditions.numberOfElementsToBeMoreThan(slJbAll, 0));

		Assert.assertEquals(true, allJobsSltd, "==== All Jobs Option selected in jobstatus filter");

	}
	
	public List<String> getAllJobList() {
		waits.until(ExpectedConditions.numberOfElementsToBeMoreThan(getAllJ, 0));

		List<String> jobsA = new ArrayList<>();
		List<WebElement> allJobListA = driver.findElements(getAllJ);

		Reporter.log("AllJobs found: " +allJobListA.size(), true);
		
		System.out.println("=====All_Jobs list=====");

		for (WebElement cardA : allJobListA) {
			String fullTextA = cardA.getText().split("\n")[0];  
			String firstLineA = fullTextA.split("\n")[0].trim();

			jobsA.add(fullTextA);

			Reporter.log(fullTextA, true);

		}
		return jobsA;	

	}

	public void selectClosedJob() {
		
		WebElement firstOldC = driver.findElements(slJbAll).get(0);   // used to detect the list refresh

		openJobStatus();
		System.out.println("DROPDOWN TEXT: " + driver.findElement(jobStatusDrop).getText().replace("\n", " | "));

		waits.until(ExpectedConditions.elementToBeClickable(selectClosedJ)).click();

//		Boolean closeJobsSltd = waits.until(ExpectedConditions.textToBe(jobStatusSelected, "Closed Jobs"));

		try {
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.stalenessOf(firstOldC));
		} catch (Exception e) { }

		waits.until(ExpectedConditions.numberOfElementsToBeMoreThan(slJbAll, 0));

//		Assert.assertEquals(true, closeJobsSltd, "==== Closed_Jobs Option selected in jobstatus filter");

	}
	
	public List<String> getClosedJobList() {
		waits.until(ExpectedConditions.numberOfElementsToBeMoreThan(getAllJ, 0));

		List<String> jobsC = new ArrayList<>();
		List<WebElement> allJobListC = driver.findElements(getAllJ);

		Reporter.log("CloseJobs found: " +allJobListC.size(), true);
		
		System.out.println("=====ClosedJobs list=====");

		for (WebElement cardC : allJobListC) {
			String fullTextC = cardC.getText().split("\n")[0];  
			String firstLineC = fullTextC.split("\n")[0].trim();

			jobsC.add(fullTextC);

			Reporter.log(fullTextC, true);

		}
		return jobsC;	

	} 
	
public void selectDrafJob() {
		
		WebElement firstOldD = driver.findElements(slJbAll).get(0);   // used to detect the list refresh

		openJobStatus();
		System.out.println("DROPDOWN TEXT: " + driver.findElement(jobStatusDrop).getText().replace("\n", " | "));

		waits.until(ExpectedConditions.elementToBeClickable(selectDraftJ)).click();

//		Boolean closeJobsSltd = waits.until(ExpectedConditions.textToBe(jobStatusSelected, "Closed Jobs"));

		try {
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.stalenessOf(firstOldD));
		} catch (Exception e) { }

		waits.until(ExpectedConditions.numberOfElementsToBeMoreThan(slJbAll, 0));

//		Assert.assertEquals(true, closeJobsSltd, "==== Closed_Jobs Option selected in jobstatus filter");

	}
	
	public List<String> getDraftJobList() {
		waits.until(ExpectedConditions.numberOfElementsToBeMoreThan(getAllJ, 0));

		List<String> jobsD = new ArrayList<>();
		List<WebElement> allJobListD = driver.findElements(getAllJ);

		Reporter.log("Draft_Jobs found: " +allJobListD.size(), true);
		
		System.out.println("=====Draft Jobs list=====");

		for (WebElement cardD : allJobListD) {
			String fullTextD = cardD.getText().split("\n")[0];  
			String firstLineD = fullTextD.split("\n")[0].trim();

			jobsD.add(fullTextD);

			Reporter.log(fullTextD, true);

		}
		return jobsD;	

	} 

public void selectTemplateJob() {
		
		WebElement firstOldT = driver.findElements(slJbAll).get(0);   // used to detect the list refresh

		openJobStatus();
		System.out.println("DROPDOWN TEXT: " + driver.findElement(jobStatusDrop).getText().replace("\n", " | "));

		waits.until(ExpectedConditions.elementToBeClickable(selectTemplateJ)).click();

//		Boolean closeJobsSltd = waits.until(ExpectedConditions.textToBe(jobStatusSelected, "Closed Jobs"));

		try {
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.stalenessOf(firstOldT));
		} catch (Exception e) { }

		waits.until(ExpectedConditions.numberOfElementsToBeMoreThan(slJbAll, 0));

//		Assert.assertEquals(true, closeJobsSltd, "==== Closed_Jobs Option selected in jobstatus filter");

	}
	
	public List<String> getTemplateJobList() {
		waits.until(ExpectedConditions.numberOfElementsToBeMoreThan(getAllJ, 0));

		List<String> jobsT = new ArrayList<>();
		List<WebElement> allJobListT = driver.findElements(getAllJ);

		Reporter.log("Draft_Jobs found: " +allJobListT.size(), true);
		
		System.out.println("=====Draft Jobs list=====");

		for (WebElement cardT : allJobListT) {
			String fullTextT = cardT.getText().split("\n")[0];  
			String firstLineT = fullTextT.split("\n")[0].trim();

			jobsT.add(fullTextT);

			Reporter.log(fullTextT, true);

		}
		return jobsT;	

	} 
}
