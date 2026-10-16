package com.baseclass;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.pomutkadmin.POM_CandLogin;

public class BaseCandidateLogin extends SelectLogin {
	
	@BeforeMethod
	public void candidateLogN() {
		
		POM_CandLogin candLogin= new POM_CandLogin(driver);
		
		candLogin.clkCandLogin();
		candLogin.validateCandLogin();
		
		Assert.assertTrue(candLogin.validateCandLogin(), "Candidate Login is displayed");
	}
	

}
