package com.ui.tests;

import static com.constants.Browser.*;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

import static org.testng.Assert.*;

import java.lang.ProcessHandle.Info;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
@Listeners(ChainTestListener.class)
public class LoginTest extends TestBase{

	

	
	  @Test(description ="Verifies a valid user can login to system ",groups=
	  {"e2e","sanity"},dataProviderClass =
	  com.ui.dataprovider.LoginProvider.class,dataProvider =
	  "LoginTestDataProvider",retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class) public void loginTest(User user) {
	  assertEquals(homepage.goToLoginPage().doLoginWith(user.getUsername(),
	  user.getPassword()).getUserName(), "Ritika Jain");
	 
	  
	  }
	  
	  
//	  @Test(description ="Verifies a valid user can login to system ",groups=
//	  {"e2e","sanity"},dataProviderClass =
//	  com.ui.dataprovider.LoginProvider.class,dataProvider =
//	  "LoginTestDataProviderwithCSV") public void loginTestwithCSV(User user) {
//	  assertEquals(homepage.goToLoginPage().doLoginWith(user.getUsername(),
//	  user.getPassword()).getUserName(), "Ritika Jain");
//	  
//	  }
//	 
//	@Test(description = "Verifies a valid user can login to system ", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataprovider.LoginProvider.class, dataProvider = "LoginTestDataProviderwithExcel")
//	public void loginTestwithExcel(User user) {
//		assertEquals(homepage.goToLoginPage().doLoginWith(user.getUsername(), user.getPassword()).getUserName(),
//				"Ritika Jain");

//}

}
