package com.utilitytest;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.baseclass.Base_SiteAdmin;
import com.pomutkadmin.POM_Admin;
import com.pomutkadmin.POM_GhostDashboard;
import com.pomutkadmin.POM_GhostLogin;

public class TestAdminUKT extends Base_SiteAdmin {

	POM_GhostLogin pomGhost;
	POM_GhostDashboard pomGDashB;

	@Test(priority= 1)
	public void admLogN() {
		
		POM_Admin pomAdmin= new POM_Admin(driver);	
		pomAdmin.verifyAdminTxt();
		pomAdmin.enterUserN("admin@talenetic.com");
		pomAdmin.enterPswd("Maxx@123");
		pomAdmin.clkAdmLogN();

		System.out.println("Successfully logged in to UKTeach-SiteAdmin");
		

	}	

	@Test(priority= 2)
	public void validateAdmHome() {	

		@NonNull
		WebElement adminLogo = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/siteadmin/dashboard']")));

		Assert.assertTrue(true, "SiteAdmin navigated to Dashboard page");

	}
	
	@Test (priority= 3)
public void performGhostLogin() {
		
		pomGhost= new POM_GhostLogin();
		
		pomGhost.selectSchool();
		pomGhost.clkSearch("SB Educational Institute");
//		System.out.println("-----Entered school-----");
		Reporter.log("--Entered school--", true);
		
		pomGhost.idSchool();
//		System.out.println("----Identifed school----");
		Reporter.log("----Identifed school----", true);
		
		pomGhost.clickHereBtn();
//		System.out.println("----Button Click Here performed----");
		Reporter.log("----Button Click Here performed----", true);
		
		pomGhost.idGhostPopup();
//		System.out.println("----Ghost popup identified----");
		Reporter.log("----Ghost popup identified----", true);
		
		pomGhost.getSchoolName();
//		System.out.println("----Ghost school name validated----");
		Reporter.log("----GhostSchool name validated----", true);
		
		pomGhost.clkTriggerGhost();
//		System.out.println("----Ghost login successfully triggered----");
		Reporter.log("----GhostLogin successfully triggered----", true);
		
//		pomGhost.idExplorePopup();
		System.out.println("-----Explore popup identified------");
		
//		pomGhost.clkExploreBtn();
		System.out.println("-----Explore popup button clicked------");
		
//		pomGhost.idLVpopup();
		System.out.println("-----LiveVacancy popup identified------");
		
//		pomGhost.clkLVpopup();
		System.out.println("-----LiveVacancy popup button clicked------");
		
		pomGhost.getGhostU();
//		System.out.println("----Ghost user name validated----");
		Reporter.log("----Ghost user name validated----", true);
		
	}
	
	@Test(priority= 4)
	public void regDashboard() {
		
		pomGDashB= new POM_GhostDashboard(driver);
		pomGDashB.profileInfo();	
	
	}

}
