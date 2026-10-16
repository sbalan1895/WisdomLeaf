package com.utilitytest;

import org.testng.annotations.Test;

import com.baseclass.BaseCandidateLogin;
import com.baseclass.SelectLogin;
import com.pomutkadmin.POM_CandDashboard;
import com.pomutkadmin.POM_CandLogin;

public class Test_CandidateLogin extends SelectLogin {
	
	POM_CandLogin pomCandL;
	POM_CandDashboard pomDashb;
	
	@Test(priority= 1)
	public void validCandL() {
		
		pomCandL= new POM_CandLogin(driver);
		
		
		pomCandL.clkCandLogin();
		pomCandL.enterEmID("sbdcand@mailinator.com");
		pomCandL.enterPsw("Sbtest@123Sbtest@123");
		pomCandL.clkLoginBtn();
		pomCandL.getCandUser();
		
	}
	
	@Test(priority= 2)
	public void validateDashB() {
		
		pomDashb= new POM_CandDashboard(driver);
//		pomDashb.validateApplicationCount();
		pomDashb.validateAplCount();
		pomDashb.getAllApplications();
		
	}
	
	

}
