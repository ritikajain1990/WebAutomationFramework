package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JsonUtility;
import com.utility.ReadPropertyFile;

public class MyRetryAnalyzer implements IRetryAnalyzer {


	//private static final int MAX_NUMBER_OF_ATTEMPS = Integer.parseInt(ReadPropertyFile.readProperty(Env.QA, "MAX_NUMBER_OF_ATTEMPS"));
	private static final int MAX_NUMBER_OF_ATTEMPS = JsonUtility.readJson(Env.QA).getMAX_NUMBER_OF_ATTEMPS();
	private int currentAttempt=1;
	
	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt<=MAX_NUMBER_OF_ATTEMPS)
		{
			currentAttempt++;
			return true;
		}
		return false;
	}
	
	
	

}
