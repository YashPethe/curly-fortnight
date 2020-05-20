package com.SeleniumEasy.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent;
	
	public static ExtentReports TestNG_ReportObject() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//report.html");
		reporter.config().setDocumentTitle("My Custom Test Result");
		reporter.config().setReportName("My Organisation Automation Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Reporter", "Yash Pethe");
		return extent;
		
	}
	

}
