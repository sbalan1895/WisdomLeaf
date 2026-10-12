package com.utilitytest;

import org.testng.annotations.Test;

import com.baseclass.BaseCandidateLogin;
import com.baseclass.SelectLogin;
import com.pomutkadmin.POM_CandLogin;
import com.pomutkadmin.POM_CandRegister;
import com.pomutkadmin.POM_SignInCand;

public class CandidateRegister extends BaseCandidateLogin {
	
	POM_CandRegister pomCandReg;
	POM_SignInCand signCandidate;
	
	@Test (priority= 1)
	public void clkRegister() {
		
		POM_CandLogin candLogin = new POM_CandLogin(driver);
		 pomCandReg = new POM_CandRegister(driver);
		
		pomCandReg.clkRegButton();
		
		pomCandReg.enterCandEmail("sbdcand008@mailinator.com");
		
		pomCandReg.clkVerify();
		
		pomCandReg.selectTitle("Mr");
		pomCandReg.enterFirstName("Victoria");
		pomCandReg.enterLastName("John");
		pomCandReg.enterPhoneNo("8870753322");
		
		pomCandReg.enterPassword("Sbtest@123Sbtest@123");
		pomCandReg.enterCnfrmP("Sbtest@123Sbtest@123");
		
		pomCandReg.clkCheckB1();
		pomCandReg.clkCheckB2();
		pomCandReg.clkRegisterF();	
		pomCandReg.getCandRegConfirm();
	
	}
	
	@Test (priority= 2)
	public void signInCandidateReg() {
		
		signCandidate.clkSignCand();
		
	}
	
}
