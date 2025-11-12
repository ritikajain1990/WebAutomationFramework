package com.ui.tests;

import static com.constants.Browser.CHROME;

import java.net.MalformedURLException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homepage;
	private boolean isLambdaTest;
	 Logger logger= LoggerUtility.getLogger(this.getClass());
	 WebDriver lambdaDriver;
	 @Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description = "Load  the home page of website")
	public void setup(@Optional("chrome")String browser,@Optional("false")boolean isLambdaTest,@Optional("false")boolean isHeadless ,ITestResult result) throws MalformedURLException {
		 this.isLambdaTest=isLambdaTest;
		if(isLambdaTest)
		{
			lambdaDriver=LambdaTestUtility.intializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homepage = new HomePage(lambdaDriver);
		}
		else
		{
		homepage = new HomePage(CHROME,isHeadless);
		}
	}
	
	public BrowserUtility getInstance()
	{
		return homepage;
		
	}
	@AfterMethod(description="tear down the browser")
	public void teardown()
	{

		if(isLambdaTest)
		{
			LambdaTestUtility.quitSession();
		}
		else
		{
		getInstance().getDriver().quit();
		}
	}
}
