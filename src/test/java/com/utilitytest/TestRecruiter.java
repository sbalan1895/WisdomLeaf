package com.utilitytest;

import java.util.List;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.baseclass.Base_RecruiterLogin;
import com.baseclass.Base_SiteAdmin;
import com.pomutkadmin.POM_Admin;
import com.pomutkadmin.POM_GhostDashboard;
import com.pomutkadmin.POM_GhostDashboard2;
import com.pomutkadmin.POM_GhostLogin;
import com.pomutkadmin.POM_RecruiterLogin;

public class TestRecruiter extends Base_RecruiterLogin{

	POM_RecruiterLogin pomRecut;

	@Test(priority= 1)
	public void admLogN() {

		pomRecut= new POM_RecruiterLogin(driver);	
		pomRecut.enterRcE("sivabalat@mailinator.com");
		pomRecut.enterRcP("Sbtest@123Sbtest@123");
		pomRecut.clkRctL();

		Reporter.log("Recruiter login successfully", true);
	}	
	
	@Test(priority= 2)
	public void validateRcutUser() {
		
		pomRecut.getRecutU();	
		
	}
	
	@Test(priority= 3)
	public void getRecruiterPipline() {
		List<String> pipeline = pomRecut.getRecrtPipLn("Recruitment Pipeline");
	    Assert.assertFalse(pipeline.isEmpty(), "No jobs in the recruitment pipeline");
	
	}	
	
	@Test(priority= 4)
	public void getRecentAppl() {
		
		List<String> applications =
	            pomRecut.getRecentApplications();

	  Assert.assertFalse(
	            applications.isEmpty(),
	            "Recent Applications data was not fetched"
	        );
	}
	
	@Test(priority = 5)
    public void getLiveJobs() {

        List<String> jobs = pomRecut.getLiveJobs();

        Assert.assertFalse(
            jobs.isEmpty(),
            "Live Jobs data was not fetched"
        );
    }

    @Test(priority = 6)
    public void getRecruitmentRequests() {

        List<String> requests =
            pomRecut.getRecruitmentRequests();

        Assert.assertFalse(
            requests.isEmpty(),
            "Recruitment Requests data was not fetched"
        );
    }

	
}