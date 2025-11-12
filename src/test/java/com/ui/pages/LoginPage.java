package com.ui.pages;

import java.security.KeyStore.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility{

	private static final By EMAIL_TEXT_LOCATOR =By.xpath("//input[@id='email']");
	private static final By PASSWORD_TEXT__LOCATOR =By.xpath("//input[@id='passwd']");
	private static final  By SUBMIT_LOCATOR = By.xpath("//button[@type='submit']//span[contains(.,'Sign')]");


	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public MyAccountPage doLoginWith(String emailAddress, String password)
	{
		enterText(EMAIL_TEXT_LOCATOR, emailAddress);
	 enterText(PASSWORD_TEXT__LOCATOR, password);
	 clickOn(SUBMIT_LOCATOR);
	 MyAccountPage myAccountPage = new MyAccountPage(getDriver());
	 return myAccountPage;
	}

}
