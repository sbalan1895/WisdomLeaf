package com.pomutkadmin;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class POM_CandDashboard {

	WebDriver driver;
	WebDriverWait waits;

	public POM_CandDashboard(WebDriver driver) {

		this.driver= driver;
		this.waits= new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	private By applc= By.xpath("//div//h5[contains(text(),'Application')]");
	private By apld= By.xpath("//div[@title='View Applied']//span");
	private By apInc= By.xpath("//div//span[@title='View Incomplete']");
	private By allBtn= By.xpath("//div[@class='dashboard-panel-header']//a[contains(text(),'View All')]");
	private By allAp= By.xpath("//div[@id='ApplicationData']");	
	private By appCards = By.xpath("//div[@id='ApplicationData']/div[contains(@class,'thumbnail')]");
	private By appSt= By.xpath(".//div[contains(@class,'right-tag')]/span");
			
	
	//div[@id='ApplicationData']//div[@class='thumbnail position-relative mb-3']
	//div//span[@title='View Incomplete']

	private String getVisibleText(By locator) {

		return waits.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();	

	}

	private Optional<String> getOptionalText(By locator, Duration duration) {


		try {
			@NonNull
			WebElement ele = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));

			return Optional.of(ele.getText());	
		}
		catch (Exception e) {
			return Optional.empty();
		}
	}

	private int toCount(String text) {

		Matcher mat = Pattern.compile("\\d+").matcher(text);
		Assert.assertTrue(mat.find(), "No number found:" + text + "");
		return Integer.parseInt(mat.group());

	}
	
	private List<String> toLines(String text) {
		
		List<String> lines = new ArrayList<>();
		for (String l : text.split("\\r?\\n")) {
			String t = l.trim();
			if (!t.isEmpty()) {
				lines.add(t);
			}
		}
		return lines;
	}
	
	private String findDateLine(List<String> lines) {
		for (int i = 0; i < lines.size() - 1; i++) {
			String l = lines.get(i);
			if (l.startsWith("Application Submitted") || l.startsWith("Application Started")) {
				return l + ": " + lines.get(i + 1);
			}
		}
		return "";
	}
	
	private String applicationStatus(WebElement ele, List<String> lines) {
		
		for (String line : lines) {
			if (line.equalsIgnoreCase("Withdrawn")) {
				return "WITHDRAWN";
			}
		}
		
		List<WebElement> statusEle = ele.findElements(appSt);
		
		if(statusEle.isEmpty()) {
			
			WebElement aplbadge = statusEle.get(0);
			String cls = aplbadge.getDomAttribute("class");
			cls = (cls == null) ? "" : cls.toLowerCase();
			
			if (cls.contains("withdraw")) return "WITHDRAWN";
			if (cls.contains("draft")) return "DRAFT";
			if (cls.contains("applied")) return "APPLIED";
			
			return "UNKNOWN (badge class: " + cls + ")";
		}
		return "UNKNOWN (no badge found)";
		}
		
	
	
	
	//=========++++++++++//////+++++=========================

	public int validateAplCount() {

		String section = getVisibleText(applc);
		Assert.assertFalse(section.isEmpty(), "Application count is empty");

		Reporter.log( "Section:" +section, true);		

		int applied = toCount(getVisibleText(apld));
		Reporter.log("// Applicarion applied count is: "+ applied + "//", true);

		Optional<String> incompltApplText = getOptionalText(apInc, Duration.ofSeconds(3));

		if(incompltApplText.isPresent()) {

			Reporter.log("Application incomplete count is: " + toCount(incompltApplText.get()), true);
		}
		else {
			Reporter.log("No incomplete applicatios shown (all submitted) ", true );
		}
		return applied;
	}
	

	public List<String> getAllApplications() {
 
		// remember the first card currently on screen, so we can tell when the list has been replaced
		List<WebElement> before = driver.findElements(appCards);
		WebElement oldFirst = before.isEmpty() ? null : before.get(0);
 
		waits.until(ExpectedConditions.elementToBeClickable(allBtn)).click();
 
		if (oldFirst != null) {
			try {
				new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.stalenessOf(oldFirst));
			} catch (Exception ignored) {
				// the list was updated without re-creating the cards
			}
		}
 
		// wait for the cards themselves, not just the container
		waits.until(ExpectedConditions.numberOfElementsToBeMoreThan(appCards, 0));
 
		List<WebElement> cards = driver.findElements(appCards);
		List<String> result = new ArrayList<>();
		Map<String, Integer> byStatus = new LinkedHashMap<>();
 
		Reporter.log("=== All applications: " + cards.size() + " found ===", true);
 
		int no = 1;
		for (WebElement card : cards) {
 
			List<String> lines = toLines(card.getText());
			Assert.assertFalse(lines.isEmpty(), "Application card " + no + " has no text");
 
			String title = lines.get(0);
			String place = lines.size() > 1 ? lines.get(1) : "";
			String status = applicationStatus(card, lines);
			String dateLine = findDateLine(lines);
 
			Reporter.log("--- Application " + no + " of " + cards.size() + " ---", true);
			Reporter.log("Title   : " + title, true);
			Reporter.log("Location: " + place, true);
			Reporter.log("Status  : " + status, true);
			Reporter.log("Date    : " + dateLine, true);
 
			byStatus.merge(status, 1, Integer::sum);
			result.add(title + " | " + status);
			no++;
		}
 
		Reporter.log("Summary by status: " + byStatus, true);
		return result;
	}
	
	
}
	
/*	public void getAllApplications1() {
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(allBtn)).click();
		@NonNull
		WebElement getAllAp = waits.until(ExpectedConditions.visibilityOfElementLocated(allAp));
		
		String allAg = getAllAp.getText();
		System.out.println(allAg);
		
		Reporter.log( "=== All applied applications ===" +allAg, true);
	}
	
	public void getAllApplications2() {
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(allBtn)).click();
		@NonNull
//		WebElement getAllAp = waits.until(ExpectedConditions.visibilityOfElementLocated(allAp));
		
		List<WebElement> allApEle = driver.findElements(allAp);
		
		Reporter.log("All applcaitions: " +allApEle.size() + "found ===" , true);
	
		int num= 0;
		for(WebElement aEle: allApEle) {
			
			List<String> lines = toLines(aEle.getText());
			Assert.assertFalse(lines.isEmpty(), "Application card " +num +"has no text");
			
			String title = lines.get(0);
			String applStatus = applicationStatus(aEle, lines);
			String dateLine = findDateLine(lines);
			
			Reporter.log("--- Application " +num + "of" +allApEle.size() + "---", true);
			
			Reporter.log("Title: " + title, true);
			Reporter.log("Application Status : " + applStatus, true);
			Reporter.log("Date : " + dateLine, true);
			
			
			
//			byStatus.merge(status, 1, Integer::sum);
//			result.add(title + " | " + status);
//			no++;
		}
		
//		Reporter.log("Summary by status: " + byStatus, true);
//		return result;
		
	} */
	
//	====================+++++++++++++==========

 
	/** DRAFT / APPLIED / WITHDRAWN, or an UNKNOWN(...) value that says what was found instead. */

	// ---------- Page actions ----------
 
 

/*	public void validateApplicationCount() {

		@NonNull
		WebElement aSen = waits.until(ExpectedConditions.presenceOfElementLocated(applc));

		String asn = aSen.getText();
		System.out.println(asn);
		Reporter.log("Section: " +asn, true);

		@NonNull
		WebElement aplnt = waits.until(ExpectedConditions.presenceOfElementLocated(apld));	

		String alC = aplnt.getText();
		System.out.println(alC);
		Reporter.log("-- Applications applied count: " +alC + "--", true);

		WebElement apInca = waits.until(ExpectedConditions.presenceOfElementLocated(apInc));	
		try {
			if(apInca.isDisplayed()) {

				String incA = apInca.getText();
				System.out.println(incA);
				Reporter.log("-- Applications incompleted count: " +incA +"--", true);
			}
		} catch (Exception e) {
			System.out.println("Incomplete job not available, it might be all submitted");
		}



	} */






