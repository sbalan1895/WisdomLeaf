package com.utilitytest;

import org.testng.annotations.Test;

import com.baseclass.BaseCandidateLogin;
import com.baseclass.SelectLogin;
import com.pomutkadmin.POM_CandLogin;
import com.pomutkadmin.POM_CandRegister2;
import com.pomutkadmin.POM_CandSignin;
import com.pomutkadmin.POM_SignInCand;

public class CandidateRegister extends BaseCandidateLogin {
	
//	POM_CandRegister pomCandReg;
	POM_SignInCand signCandidate;
	POM_CandSignin pomCandSign;
	POM_CandRegister2 pomCandReg2;
	
	@Test (priority= 1)
	public void clkRegister() {
		
		POM_CandLogin candLogin = new POM_CandLogin(driver);
		 pomCandReg2 = new POM_CandRegister2(driver);
		
		pomCandReg2.clkRegButton();
		
//		pomCandReg2.enterCandEmail("sbdcand009@mailinator.com");
		String email = "sbdcand" + System.currentTimeMillis() + "@mailinator.com";
		pomCandReg2.enterCandEmail(email);
		
		pomCandReg2.clkVerify();
		
		pomCandReg2.selectTitle("Mr");
		pomCandReg2.enterFirstName("Victoria");
		pomCandReg2.enterLastName("John");
		
		pomCandReg2.enterPhoneNo("8870753322");
		System.out.println("====Entered PhoneNo===");
		
		pomCandReg2.enterPassword("Sbtest@123Sbtest@123");
		System.out.println("====Entered Password====");
		
		pomCandReg2.enterCnfrmP("Sbtest@123Sbtest@123");
		System.out.println("====Entered ConfPswd====");
		
		pomCandReg2.clkCheckB1();
		System.out.println("====CheckBox1 clicked===");
		
		pomCandReg2.clkCheckB2();
		System.out.println("====CheckBox2 clicked===");
		
		pomCandReg2.clkRegisterF();
		System.out.println("====FinalRegister clicked===");
	}
	
	@Test (priority= 2, enabled= true)
	public void signInCandidateReg() {
		pomCandSign = new POM_CandSignin();
		signCandidate = new POM_SignInCand(driver);
		
		pomCandReg2.getCandRegConfirm();
		System.out.println("====Candidate Registeration completed===");
		
		signCandidate.clkSignCand();
		System.out.println("====Candidate SignInBtn clicked===");
		
	} 
	
}
