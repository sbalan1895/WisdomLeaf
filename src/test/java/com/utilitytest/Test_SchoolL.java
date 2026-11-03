package com.utilitytest;

import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.baseclass.Base_RecruiterL;
import com.pomutkadmin.POM_GhostDashboard;
import com.pomutkadmin.POM_SchoolDashboard;
import com.pomutkadmin.POM_SchoolL;

public class Test_SchoolL extends Base_RecruiterL {

	POM_SchoolL pom_school;
	POM_SchoolDashboard pom_dashboardsl;


	@Test(priority= 1)
	public void loginSchoolT() {

		pom_school = new POM_SchoolL(driver);
		pom_school.enterSchlEid("sivabalat@mailinator.com");
		pom_school.enterSchlPsw("Sbtest@123Sbtest@123");
		pom_school.clkLogN();

		//		pom_school.sessionAlAct();
		pom_school.getlogedUserN();

	}

	@Test(priority= 2)
	public void regDashboard() {

		pom_dashboardsl= new POM_SchoolDashboard(driver);

		pom_dashboardsl.profileInfo();

	}

	@Test(priority= 3)
	public void menuButton() {

		pom_dashboardsl.selectJob();
		pom_dashboardsl.validateJobsF();

	}

	@Test(priority= 4)
	public void verifyJobStatusList() {

		for(POM_SchoolDashboard.JobStatus s : POM_SchoolDashboard.JobStatus.values()) {
			pom_dashboardsl.selectJobStatus(s);

			List<String> jobList = pom_dashboardsl.getJobList(s.label());

			Reporter.log(s.label() + " -> " + jobList.size() + " job(s)", true);
		}
	}


}
