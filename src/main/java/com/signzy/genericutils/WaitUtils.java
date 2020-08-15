package com.signzy.genericutils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public WebDriver driver;
	
	
	
	public void waitForWE(WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}



	public void waitForWE(WebDriver driver, List<WebElement> element) {
		FluentWait<WebDriver> wait;
		 WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.visibilityOfAllElements(element));	
		
	}
	
	/*public void waitForWE(final WebElement element, int iTime) {
		WebDriverWait wait = new WebDriverWait(driver, iTime);  
		wait.until(ExpectedConditions.visibilityOf(element));
	}
*/
	
	
}