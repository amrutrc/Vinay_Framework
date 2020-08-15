package com.signzy.Init;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.signzy.genericutils.Readprop;
import com.signzy.genericutils.WaitUtils;
import com.signzy.loggers.SignzyLogger;



public class Setup {

	public SignzyLogger log ;
	public  WebDriver driver;
	static String targetBrowser;
	static String url;
	public  Readprop readprop;
	public WaitUtils waitUtils;
	
	
	@BeforeMethod
	public void launchBrowser() throws IOException {
		readprop = new Readprop();		
		targetBrowser=readprop.fetchproperty("browser");
		url = readprop.fetchproperty("url");
		
		SignzyLogger.info("Browser is "+targetBrowser);
		if(targetBrowser.contains("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chrome\\win32\\chromedriver.exe");
			driver = new ChromeDriver();
			SignzyLogger.info("Path to  chrome file: "+System.getProperty("user.dir"));
		}
		else if (targetBrowser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\FireFox\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			driver.get(url);
			SignzyLogger.info("Target URL "+url);

			SignzyLogger.info("Validate URL");
			String actualUrl = driver.getCurrentUrl();
			SignzyLogger.info("Current URl is " + actualUrl);
			//Assert.assertTrue(actualUrl.contains(url));
				
		}
	
	
	@AfterMethod
	public void postExecution(){
		SignzyLogger.info("shutting down browser");
		driver.quit();
		}
	
}