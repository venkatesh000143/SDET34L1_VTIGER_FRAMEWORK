package com.SDET34L1.GenericLibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * it is a listenerImplementation class
 * @author 7Hills
 *
 */
public class ListenerImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onstart");	
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentReport.html");
		spark.config().setDocumentTitle("Document_Title");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("ReportName");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("ReporterName", "venky");
		report.setSystemInfo("platform", "windows 10");
		report.setSystemInfo("unit testing tool", "TestNG");
		report.setSystemInfo("Build Management Tool", "Maven");
		report.setSystemInfo("Automation Tool", "selenium");

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onteststart");		
		test=report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("ontestsuccess");
		test.log(Status.PASS, result.getMethod().getMethodName()+"is pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("ontestfailure");		
		test.log(Status.FAIL, result.getMethod().getMethodName()+"is fail");
		test.log(Status.FAIL, result.getThrowable());
		try {
			test.addScreenCaptureFromPath(WebDriverUse.takeScreenShot(result.getMethod().getMethodName(),BaseClass.staticdriver));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("ontestskipped");		
		test.log(Status.SKIP, result.getMethod().getMethodName()+"is skipped");
		test.log(Status.SKIP,result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onfinish");	
		report.flush();
		
	}
	

}
