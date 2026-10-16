package com.baseclass;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class TestListerner implements ITestListener {
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Passed" +result.getName());
		takeScreenshot(result, "PASS");
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Failed" +result.getName());
		takeScreenshot(result, "FAIL");
		
	}
	
	public void takeScreenshot(ITestResult result, String status) {
		
		TakesScreenshot ts= (TakesScreenshot) Base_Demo.driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File destination= new File("C:\\Users\\sivabalan\\eclipse-workspace\\DemoProject_0510\\src\\test\\resources\\Output_Screenshot\\img.png");
		
		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
