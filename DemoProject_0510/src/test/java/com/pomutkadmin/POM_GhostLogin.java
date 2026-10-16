package com.pomutkadmin;

import java.awt.Robot;
import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.Base_SiteAdmin;

public class POM_GhostLogin extends Base_SiteAdmin {

	Actions atn;


	//*[@id="page-wrapper"]/div/div[3]/section/div/div/article[2]/ul/li[1]/a

	public POM_GhostLogin() {

		this.driver= driver;
		this.waits= new WebDriverWait(driver, Duration.ofSeconds(20));
		this.atn= new Actions(driver);
	}

	private By sltSchool= By.xpath("//article[@class='dashboard-card']//a[@href='/siteadmin/ManageRecruiter']");
	private By clkSrch= By.xpath("//input[@type='search']");
	private By idnfSchl= By.xpath("//table//tbody//tr//td[contains(text(),'SB Educational Ins')]");
	private By clkBtn= By.xpath("//table//tbody//tr[1]//td//button[contains(text(),'Click here')]");
	private By GhostPopup = By.xpath("(//div[@class='modal-content'])[4]");
	private By gSclN= By.xpath("//div[@class='modal-content']//p[@id='ghostSchoolName']");
	private By trgBtn= By.xpath("//button[@id='trigGhostLogin']");

	private By popupExpl= By.xpath("//div[@id='popup']");
	private By clkExp= By.xpath("//div[contains(text(),'Explore on my own')]");
	private By popupL= By.xpath("//div[@id='popup']");
	private By clkLV= By.xpath("//div[contains(text(),'Live Vacancies')]");
	private By ghostLogU= By.xpath("//span[@class='name']");
	
	//span[@id='BtnDropdownArrow']
	
	
	public void selectSchool() {
		@NonNull
		WebElement sltSchl = waits.until(ExpectedConditions.elementToBeClickable(sltSchool));
		sltSchl.click();
	}

	public void clkSearch(String Tvalue) {
		WebElement clkSch = waits.until(ExpectedConditions.elementToBeClickable(clkSrch));

		atn.moveToElement(clkSch).click();
		atn.sendKeys(Tvalue).build().perform();

		System.out.println("Text entered: " + clkSch.getAttribute("value"));

		atn.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();

	}

	public void idSchool() {
		@NonNull
		WebElement idfScl = waits.until(ExpectedConditions.visibilityOfElementLocated(idnfSchl));
		idfScl.isDisplayed();

	}

	public void clickHereBtn() {
		WebElement clkH = waits.until(ExpectedConditions.elementToBeClickable(clkBtn));
		atn.moveToElement(clkH).click().build().perform();
	}

	public void idGhostPopup() {
		WebElement idGpopup = waits.until(ExpectedConditions.visibilityOfElementLocated(GhostPopup));
		idGpopup.isDisplayed();

		System.out.println("Ghost popup identified as opened");

	}

	public void getSchoolName() {

		WebElement idGpopup = waits.until(ExpectedConditions.visibilityOfElementLocated(gSclN));
		@Nullable
		String gShlAvalue = idGpopup.getAttribute("value");
		String gShlNm = idGpopup.getText();
		System.out.println("SchoolAtrB in ghost login is " +gShlAvalue);
		System.out.println("SchoolName in ghost login is " +gShlNm);
	}

	public void clkTriggerGhost() {
		WebElement clkTrGhost = waits.until(ExpectedConditions.elementToBeClickable(trgBtn));
		atn.moveToElement(clkTrGhost).click().build().perform();

	}

	public void idExplorePopup() {
		WebElement idPopupEpl = waits.until(ExpectedConditions.visibilityOfElementLocated(popupExpl));
		//		atn.moveToElement(clkPopupEpl).click().build().perform();
		idPopupEpl.isDisplayed();
		System.out.println("Explore popup is displayed");
	}

	public void clkExploreBtn() {
		WebElement clkExpB = waits.until(ExpectedConditions.elementToBeClickable(clkExp));
		atn.moveToElement(clkExpB).click().build().perform();

	}

	public void idLVpopup() {
		WebElement idLVp = waits.until(ExpectedConditions.visibilityOfElementLocated(popupL));
		atn.moveToElement(idLVp).click().build().perform();

	}

	public void clkLVpopup() {
		WebElement clkLVp = waits.until(ExpectedConditions.elementToBeClickable(clkLV));
		atn.moveToElement(clkLVp).click().build().perform();
	}
	
	public void getGhostU() {
		
		WebElement gosU = waits.until(ExpectedConditions.visibilityOfElementLocated(ghostLogU));
		
		String gosValue = gosU.getAttribute("value");
		String gosTxt = gosU.getText();
		System.out.println("Ghost schoolAtrbV in ghost login is " +gosValue);
		System.out.println("Ghost schoolName in ghost login is " +gosTxt);
		
	}


}
