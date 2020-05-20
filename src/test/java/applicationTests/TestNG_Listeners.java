package applicationTests;

import java.io.IOException;

import com.SeleniumEasy.common.ExtentReportNG;
import com.SeleniumEasy.common.SeleniumEasyBaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNG_Listeners extends SeleniumEasyBaseClass implements ITestListener {
	
	ExtentReports extent = ExtentReportNG.TestNG_ReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getName());
		thread.set(test);
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		thread.get().pass("Test Pass Successfully");
		
	}

	public void onTestFailure(ITestResult result) {
		thread.get().fail(result.getThrowable());
		WebDriver driver = null;
		// TODO Auto-generated method stub
		String failedMethod = result.getName().toString();
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			thread.get().addScreenCaptureFromPath(takeScreenshot(failedMethod,driver), result.getName().toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		thread.get().skip(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
