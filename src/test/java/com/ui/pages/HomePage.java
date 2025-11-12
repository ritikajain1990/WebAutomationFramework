package com.ui.pages;



import static java.util.Properties.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.constants.Browser;
import com.constants.Env;

import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;

import static com.utility.JsonUtility.*;

import static com.utility.ReadPropertyFile.*;

public final class HomePage extends BrowserUtility {

	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);
		goToWebsite(readJson(QA).getUrl());
		maximizeBrowser();
	}
	public HomePage(String browserName) {
		super(browserName);
		goToWebsite(JsonUtility.readJson(QA).getUrl());
		maximizeBrowser();
	}
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JsonUtility.readJson(QA).getUrl());
		maximizeBrowser();
	}
	private static final By SIGNIN_LOCATOR = By.xpath("//a[contains(.,'Sign')]");
	
	
	
	public LoginPage goToLoginPage()//page functions
	{
		clickOn(SIGNIN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
}
