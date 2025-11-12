package com.ui.listeners;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	 Logger logger= LoggerUtility.getLogger(this.getClass());
	 public void onTestStart(ITestResult result) {
		 logger.info(result.getMethod().getMethodName());
		  
		  }
		 
		  public void onTestSuccess(ITestResult result) {
			  logger.info(result.getMethod().getMethodName()+"Passed");
		  }

		  public void onTestFailure(ITestResult result) {
			  logger.error(result.getMethod().getMethodName()+"Passed");
			  logger.error(result.getThrowable().getMessage());
			 Object testClass= result.getInstance();
			BrowserUtility browserUtility=((TestBase)testClass).getInstance();
			try {
				String filepath=browserUtility.takesScreenshot();
				ChainTestListener.embed(filepath, "Image/png");;
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		  }

		 
		  public void onTestSkipped(ITestResult result) {
			  logger.warn(result.getMethod().getMethodName()+"Skipped");
		  }

		  public void onStart(ITestContext context) {
			  logger.info("Started the execution");
		  }
		  public void onFinish(ITestContext context) {
			  logger.info("Ended the execution");
		  }

}
