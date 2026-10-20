package com.pomutkadmin;

import java.awt.Robot;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.baseclass.Base_RecruiterLogin;
import com.baseclass.Base_SiteAdmin;

public class POM_RecruiterLogin extends Base_RecruiterLogin {

	public static final String ATS_DASHBOARD = "ATS Dashboard";
	public static final String MANAGE_SCHOOLS = "Manage Schools";
	public static final String ADMIN_DASHBOARD = "Admin Dashboard";

	WebDriver driver;
	WebDriverWait waits;
	Actions atn;
	JavascriptExecutor jsE;

	private static final List<String> STAGES = Arrays.asList(
			"APPLIED", "IN-REVIEW", "SHORTLISTED", "INTERVIEW", "OFFER",
			"HIRED", "ON HOLD", "REJECTED", "WITHDRAWN");

	public POM_RecruiterLogin(WebDriver driver) {

		this.driver= driver;
		this.waits= new WebDriverWait(driver, Duration.ofSeconds(20));
		this.atn= new Actions(driver);
		this.jsE= (JavascriptExecutor) driver;
	}

	private By rctE = By.xpath("//input[@id='Input_Email']");
	private By rctP = By.xpath("//input[@id='passwordField']");
	private By rctlBtn = By.xpath("//button[@id='login-submit']");
	private By rctlUser = By.xpath("//div//span[@class='name']");
	private By viewAbtN = By.xpath("(//a[@href='/RecruitmentPipeline'])[2]");
	private By rcrtPipl = By.xpath("//div[@class='content-box']//div[@id='PipelineData']");
	private By breadDashB= By.xpath("(//div[@class='app-breadcrumb-container']//a[contains(text(),'ATS Dashboard')])[1]");
	private By rcntAp= By.xpath("//div[@class='content-box mb-4']//h3[contains(text(),'Recent Applications')]");
	private By viewAbRA= By.xpath("//div[@class='content-box mb-4']//h3[contains(text(),'Recent Applications')]");

	//(//div[@class='app-breadcrumb-container']//a[contains(text(),'ATS Dashboard')])[1]

	private By noRecords = By.xpath("//div[@id='ListData']//div[contains(@class,'page-empty')]"
			+ "//span[contains(normalize-space(),'No Records Found')]");


	// ONE element PER pipeline row (direct children of #PipelineData), not the container itself
	private By pipelineRows = By.xpath("//div[@id='PipelineData']/div[contains(@class,'pipeline-inner-content')]");

	// Empty state of the pipeline (adjust if your page shows the message elsewhere)
	private By pipelineEmpty = By.xpath("//div[@id='PipelineData']//*[contains(normalize-space(text()),'No Records Found')]");


	/** Locator for a breadcrumb link, found by its visible text. findElement already returns the first match. */
	private By breadcrumb(String linkText) {
		return By.xpath("//div[contains(@class,'app-breadcrumb-container')]"
				+ "//a[contains(normalize-space(.),'" + linkText + "')]");
	}
	
	 private By dashboardHeading(String heading) {
	        return By.xpath(
	            "//h3[normalize-space()='" + heading + "']"
	        );
	    }

	    private By dashboardSection(String heading) {
	        return By.xpath(
	            "//h3[normalize-space()='" + heading + "']" +
	            "/ancestor::div[contains(@class,'content-box')][1]"
	        );
	    }

	//===============================================

	public void enterRcE(String value) {

		@NonNull
		WebElement entE = waits.until(ExpectedConditions.elementToBeClickable(rctE));
		entE.sendKeys(value);	

	}

	public void enterRcP(String value) {
		@NonNull
		WebElement entP = waits.until(ExpectedConditions.elementToBeClickable(rctP));
		entP.sendKeys(value);
	}

	public void clkRctL() {

		waits.until(ExpectedConditions.elementToBeClickable(rctlBtn)).click();
	}

	public void getRecutU() {
		@NonNull
		WebElement userR = waits.until(ExpectedConditions.visibilityOfElementLocated(rctlUser));

		String recutUd = userR.getText();
		Reporter.log("Recruiter logged-in username: " +recutUd, true);
	}


	//====================================

	/** Splits row text into trimmed, non-empty lines. */
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

	/** The count (a number or "-") is read from the line shown just before each stage label. */
	private Map<String, String> parseStageCounts(List<String> lines) {

		Map<String, String> counts = new LinkedHashMap<>();
		for (int i = 1; i < lines.size(); i++) {
			for (String stage : STAGES) {
				if (lines.get(i).equalsIgnoreCase(stage)) {
					counts.put(stage, lines.get(i - 1));
				}
			}
		}
		return counts;
	}

	private String findExpiryLine(List<String> lines) {

		for (String l : lines) {
			if (l.startsWith("Advert Expires")) {
				return l;
			}
		}
		return "";
	}

	/** Ready when EITHER pipeline rows OR the empty message is showing. */
	private void waitForPipeline() {

		waits.until(ExpectedConditions.or(
				ExpectedConditions.numberOfElementsToBeMoreThan(pipelineRows, 0),
				ExpectedConditions.visibilityOfElementLocated(pipelineEmpty)));
	}

	/** Instant (non-animated) scroll to the middle of the viewport. */
	private void scrollToCenter(WebElement el) {
		jsE.executeScript(
				"arguments[0].scrollIntoView({block:'center', inline:'nearest', behavior:'instant'});", el);
	}

	public void clickBreadcrumb(String linkText) {

		WebElement oldPage = driver.findElement(By.tagName("html"));   // used to detect that a new page loaded

		waits.until(ExpectedConditions.elementToBeClickable(breadcrumb(linkText))).click();

		try {
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.stalenessOf(oldPage));
		} catch (Exception ignored) {
			// the page was updated without a full reload
		}
		Reporter.log("Breadcrumb clicked: " + linkText, true);
	}

	private WebElement readyEle (By locator) {

		clickBreadcrumb(ATS_DASHBOARD);

		scrollToCenter(driver.findElement(locator));

		return waits.until(ExpectedConditions.elementToBeClickable(locator));	

	}
	//===============================================

	/** Logs every pipeline row separately and returns "title | reference | status" entries. */
	public List<String> getRecrtPipLn(String listNameRpl) {

		waits.until(ExpectedConditions.elementToBeClickable(viewAbtN)).click();

		waitForPipeline();

		List<WebElement> rows = driver.findElements(pipelineRows);
		List<String> entries = new ArrayList<>();

		if (rows.isEmpty()) {
			String msg = waits.until(ExpectedConditions.visibilityOfElementLocated(pipelineEmpty)).getText().trim();
			Assert.assertEquals(msg, "No Records Found.", listNameRpl + ": unexpected message for an empty pipeline");
			Reporter.log("===== " + listNameRpl + ": 0 jobs - " + msg + " =====", true);
			return entries;
		}

		Assert.assertTrue(driver.findElements(pipelineEmpty).isEmpty(),
				listNameRpl + ": rows are listed but 'No Records Found.' is also displayed");

		Reporter.log("===== " + listNameRpl + ": " + rows.size() + " job(s) =====", true);

		int no = 1;
		for (WebElement row : rows) {

			List<String> lines = toLines(row.getText());
			Assert.assertFalse(lines.isEmpty(), "Pipeline row " + no + " has no text");

			String title = lines.get(0);
			String reference = lines.size() > 1 ? lines.get(1) : "";
			String status = (lines.size() > 2 && !lines.get(2).startsWith("Advert")) ? lines.get(2) : "";
			String expiry = findExpiryLine(lines);
			Map<String, String> stages = parseStageCounts(lines);

			Reporter.log("--- Pipeline row " + no + " of " + rows.size() + " ---", true);
			Reporter.log("Title    : " + title, true);
			Reporter.log("Reference: " + reference, true);
			Reporter.log("Status   : " + status, true);
			Reporter.log("Expires  : " + expiry, true);
			Reporter.log("Stages   : " + stages, true);

			if (stages.size() != STAGES.size()) {
				// helps to adjust the parsing if the page text is ordered differently
				Reporter.log("RAW row text: " + String.join(" | ", lines), true);
			}

			entries.add(title + " | " + reference + " | " + status);
			no++;
		}
		return entries;
	}



/*	public void recentAppl() {

		WebElement clkViewAllRa = readyEle(viewAbRA);
		clkViewAllRa.click();

	} */
	

    // ================= DASHBOARD DATA LOCATORS =================

   

    // Returns the section containing the requested dashboard heading.
    private WebElement getDashboardSection(String heading) {
        WebElement title = waits.until(
            ExpectedConditions.visibilityOfElementLocated(
                dashboardHeading(heading)
            )
        );

        jsE.executeScript(
            "arguments[0].scrollIntoView({" +
            "block:'center', inline:'nearest'});",
            title
        );

        return waits.until(
            ExpectedConditions.visibilityOfElementLocated(
                dashboardSection(heading)
            )
        );
    }

    // Splits visible text into clean, non-empty lines.
    private List<String> getCleanLines(WebElement section) {
        List<String> result = new ArrayList<>();

        for (String line : section.getText().split("\\R")) {
            String value = line.trim();

            if (!value.isEmpty()) {
                result.add(value);
            }
        }

        return result;
    }

    // ================= RECENT APPLICATIONS =================

    public List<String> getRecentApplications() {
    	
    	WebElement clkViewAllRa = readyEle(viewAbRA);
//		clkViewAllRa.click();

        WebElement section =
            getDashboardSection("Recent Applications");

        List<String> lines = getCleanLines(section);

        Reporter.log(
            "========== RECENT APPLICATIONS ==========", true
        );

        for (String line : lines) {
            Reporter.log(line, true);
        }

        Assert.assertFalse(
            lines.isEmpty(),
            "Recent Applications section contains no readable data"
        );

        return lines;
    }

    // ================= LIVE JOBS =================

    public List<String> getLiveJobs() {

        WebElement section = getDashboardSection("Live Jobs");

        List<String> lines = getCleanLines(section);

        Reporter.log(
            "========== LIVE JOBS ==========", true
        );

        for (String line : lines) {
            Reporter.log(line, true);
        }

        Assert.assertFalse(
            lines.isEmpty(),
            "Live Jobs section contains no readable data"
        );

        return lines;
    }

    // ================= RECRUITMENT REQUESTS =================

    public List<String> getRecruitmentRequests() {

        WebElement section =
            getDashboardSection("Recruitment Requests");

        List<String> lines = getCleanLines(section);

        Reporter.log(
            "========== RECRUITMENT REQUESTS ==========", true
        );

        for (String line : lines) {
            Reporter.log(line, true);
        }

        Assert.assertFalse(
            lines.isEmpty(),
            "Recruitment Requests section contains no readable data"
        );

        return lines;
    }


}






