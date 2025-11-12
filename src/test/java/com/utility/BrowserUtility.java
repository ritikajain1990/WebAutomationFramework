package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxCommandContext;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private WebDriver driver;
	public BrowserUtility(WebDriver driver)
	{
		super();
		this.driver=driver;
		
	}
	public BrowserUtility(String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		
		}
		else if (browserName.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser name ");
		}
	}
	public BrowserUtility(Browser browserName)
	{
		if(browserName==Browser.CHROME)
		{
			driver=new ChromeDriver();
		
		}
		else if (browserName==Browser.FIREFOX)
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser name ");
		}
	}
	public BrowserUtility(Browser browserName,boolean isHeadeless)
	{
		if(browserName==Browser.CHROME)
		{
			if(isHeadeless)
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				driver= new ChromeDriver(options);
			}
			else
			{
			driver=new ChromeDriver();
			}
		}
		else if (browserName==Browser.FIREFOX)
		{
			if(isHeadeless)
			{
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				driver= new FirefoxDriver(options);
			}
			else
			{
			driver=new FirefoxDriver();
			}
		}
		else
		{
			System.out.println("Invalid browser name ");
		}
	}
	public WebDriver getDriver()
	{
		return driver;
	}
	public void goToWebsite(String url)
	{
		driver.get(url);
	}
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	public void clickOn(By locator)
	{
	driver.findElement(locator).click();
	}
	public void enterText(By locator, String text)
	{
		driver.findElement(locator).sendKeys(text);
	}
	public String getVisibleText(By locator)
	{
		return driver.findElement(locator).getText();
	}
	public String takesScreenshot() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		String screenshotdata=ts.getScreenshotAs(OutputType.BASE64);
		
		return screenshotdata;
	}
}

