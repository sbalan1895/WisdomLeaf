package com.pomutkadmin;

import java.time.Duration;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class POM_CandRegister {

	WebDriver driver;
	WebDriverWait waits;

	JavascriptExecutor jsE; 
	Actions actn;

	public POM_CandRegister(WebDriver driver) {

		this.driver= driver;
		this.waits= new WebDriverWait(driver, Duration.ofSeconds(20));
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
	private By clkRegF = By.xpath("//button[contains(text(),'Register')]");
	private By getConfT = By.xpath("//div//p[contains(text(),'Your email')]");
	

	public void clkRegButton() {

		WebElement presntR = waits.until(ExpectedConditions.presenceOfElementLocated(RegisterBtn));

		jsE.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", presntR);

		@NonNull
		WebElement clkR = waits.until(ExpectedConditions.elementToBeClickable(RegisterBtn));
//		actn.moveToElement(clkR).click().build().perform();
		clkR.click();
	}

	public void enterCandEmail(String candEmail) {

		@NonNull
		WebElement candE = waits.until(ExpectedConditions.elementToBeClickable(eCandEmail));
		candE.sendKeys(candEmail);
	}

	public void clkVerify() {

		@NonNull
		WebElement clkV = waits.until(ExpectedConditions.elementToBeClickable(verifyBtn));
//		actn.moveToElement(clkV).click().build().perform();
		clkV.click();
	}

	public void selectTitle(String Tvalue) {

		WebElement presentTitle = waits.until(ExpectedConditions.presenceOfElementLocated(selectTitle));

		jsE.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", presentTitle);

		WebElement sltTitle = waits.until(ExpectedConditions.elementToBeClickable(selectTitle));
		Select selectOp= new Select(sltTitle);

		selectOp.selectByVisibleText(Tvalue);

	}	

	public void enterFirstName(String Tvalue) {

		WebElement presentFN = waits.until(ExpectedConditions.presenceOfElementLocated(enterFN));

		jsE.executeScript("arguments[0].scrollIntoView({block:'center'});", presentFN);

		WebElement enterF = waits.until(ExpectedConditions.elementToBeClickable(enterFN));
		enterF.sendKeys(Tvalue);

	}

	public void enterLastName(String Tvalue) {

		WebElement presentLN = waits.until(ExpectedConditions.presenceOfElementLocated(enterLN));

		jsE.executeScript("arguments[0].scrollIntoView({block:'center'});", presentLN);

		WebElement enterL = waits.until(ExpectedConditions.elementToBeClickable(enterLN));
		enterL.sendKeys(Tvalue);

	}

	public void enterPhoneNo(String Tvalue) {

		WebElement presentPhN = waits.until(ExpectedConditions.presenceOfElementLocated(enterPhN));

		jsE.executeScript("arguments[0].scrollIntoView({block:'end'});", presentPhN);

		WebElement enterPh = waits.until(ExpectedConditions.elementToBeClickable(enterPhN));
		enterPh.sendKeys(Tvalue);

	}

	public void enterPassword(String Tvalue) {

		WebElement presentPsw = waits.until(ExpectedConditions.presenceOfElementLocated(enterPws));

		jsE.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", presentPsw);

		WebElement enterPsw = waits.until(ExpectedConditions.elementToBeClickable(enterPws));
		enterPsw.sendKeys(Tvalue);
		
		actn.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();

	}
	
	public void enterCnfrmP(String Tvalue) {

		WebElement presentCnfP = waits.until(ExpectedConditions.presenceOfElementLocated(enterCnfP));

		jsE.executeScript("arguments[0].scrollIntoView({block:'end'});", presentCnfP);

		WebElement enterCP = waits.until(ExpectedConditions.elementToBeClickable(enterCnfP));
		enterCP.sendKeys(Tvalue);
		
		System.out.println("Executed CP");
		actn.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();

	}

	public void clkCheckB1() {

		WebElement presentChkB1 = waits.until(ExpectedConditions.presenceOfElementLocated(clkChB1));
		
		jsE.executeScript("arguments[0].scrollIntoView({block:'end'});", presentChkB1);

		WebElement clkB1 = waits.until(ExpectedConditions.elementToBeClickable(clkChB1));
		
		System.out.println("Executing CkB1");
		
		clkB1.click();
		clkB1.isSelected();
		
		System.out.println("Executed CkB1");

	}
	
	public void clkCheckB2() {

//		WebElement presentChkB2 = waits.until(ExpectedConditions.presenceOfElementLocated(clkChB2));

		WebElement clkB2 = waits.until(ExpectedConditions.elementToBeClickable(clkChB2));
		jsE.executeScript("arguments[0].scrollIntoView({block:'end'});", clkB2);

		
		clkB2.click();
		clkB2.isSelected();
		
	}
	
	public void clkRegisterF() {

		WebElement presentRegF = waits.until(ExpectedConditions.presenceOfElementLocated(clkRegF));

		jsE.executeScript("arguments[0].scrollIntoView({block:'end'});", presentRegF);

		WebElement clkRFin = waits.until(ExpectedConditions.elementToBeClickable(clkRegF));
		clkRFin.click();

	}
	
	public void getCandRegConfirm() {
		@NonNull
		WebElement candCnf = waits.until(ExpectedConditions.presenceOfElementLocated(getConfT));
		@Nullable
		String candidateValidate = candCnf.getText();
//		System.out.println(""candidateValidate); 
		Reporter.log("Candidate Registeration successfully completed for the ID: " +candidateValidate, false);
	}

}
//candauto@mailinator.com clkChB1 clkRegF