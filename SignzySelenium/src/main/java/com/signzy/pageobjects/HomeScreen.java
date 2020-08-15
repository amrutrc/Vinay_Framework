package com.signzy.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.signzy.genericutils.WaitUtils;
import com.signzy.loggers.SignzyLogger;

public class HomeScreen {
	private WebDriver driver;
	private WaitUtils wait;
	private Actions act;

	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	private WebElement searchTextBox;
	
	@FindBy(xpath="//span[contains(text(),'Cart')]")
	private WebElement cartLink;
	
	@FindBy(xpath="//div[contains(text(),'My Account')]")
	private WebElement myAccountLink;
	
	@FindBy(xpath="//div[text()='More']")
	private WebElement moreLink;
	
	public HomeScreen(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtils();
		act= new Actions(driver);
		}
	
	public void search(String searchQuery) {
		wait.waitForWE(driver, searchTextBox);
		searchTextBox.clear();
		searchTextBox.sendKeys(searchQuery, Keys.ENTER);
		SignzyLogger.info("Entered "+ searchQuery +" to the search field");
	}
	
	/*public void search(String searchQuery) {
		wait.waitForWE(driver, serachTextBox);
		serachTextBox.clear();
		act.moveToElement(serachTextBox).sendKeys(searchQuery, Keys.ENTER).build().perform();
		SignzyLogger.info("Entered "+ searchQuery +" to the search field");
	}*/
	
	
	public boolean isCartLinkDisplayed()
	{
		return cartLink.isDisplayed();
	}
	
	public boolean isMoreLinkDisplayed()
	{
		return moreLink.isDisplayed();
	}
	
}
