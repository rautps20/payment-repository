package com.psr.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Report {
	
	public static void main(String []args) {
	ExtentReports report =new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Result/Result.html");
		report.attachReporter(spark);
		//report.createTest("Verify that user should be able to login with valid credential");
		ExtentTest test =report.createTest("Verify that user should be able to login with valid credential");
		test.log(Status.PASS, "Enter the url");
		test.log(Status.PASS,"Enter the username");
		test.log(Status.PASS, "Enter the password");
		report.flush();
		
		
	}

}
