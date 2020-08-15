package com.signzy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.signzy.genericutils.WaitUtils;
import com.signzy.loggers.SignzyLogger;

public class LoginPage {

	private WaitUtils wait;
	private WebDriver driver;
	
	@FindBy(xpath="//div[@class='_1XBjg- row']")
	private WebElement loginPopUp;
	
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	private WebElement userNameTextBox;
	
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	private WebElement pwdTextBox;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtils();
	}

	public void login(String usrName, String pwd) {
		wait.waitForWE(driver, loginPopUp);
		loginPopUp.click();
		
		wait.waitForWE(driver, userNameTextBox);
		SignzyLogger.info("Entering "+ usrName +" to the username filed" );
		userNameTextBox.sendKeys(usrName);
		
		SignzyLogger.info("Entering "+ pwd +" to the password filed" );
		wait.waitForWE(driver, pwdTextBox);
		pwdTextBox.sendKeys(pwd);
		
		wait.waitForWE(driver, loginButton);
		loginButton.click();
	}
	
}
