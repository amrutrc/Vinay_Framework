package com.signzy.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.signzy.genericutils.WaitUtils;
import com.signzy.loggers.SignzyLogger;

public class SearchResultsPage  {

	private WebDriver driver;
	private WaitUtils wait;
	private String quantity;
	private JavascriptExecutor js ;

	@FindBy(xpath="//span[@class='_2yAnYN']")
	private WebElement resultsTitle;

	@FindBy(xpath="//span[contains(text(),'CATEGORIES')]")
	private WebElement categoriesLink;

	@FindBy(xpath="//a[@class='_3O_Sek _32ZSYo']")
	private WebElement watchesFilter;

	@FindBy(xpath="//a[@class='_3XS1AH _32ZSYo']")
	private WebElement wristWatchFilter;

	@FindBy(xpath="//a[@class='_3XS1AH _32ZSYo']")
	private WebElement brandDropDown;

	@FindBy(xpath="//body/div[@id='container']/div/div[@class='t-0M7P _2doH3V']/div[@class='_3e7xtJ']/div[@class='_1HmYoV hCUpcT']/div[@class='_1HmYoV _35HD7C']/div[@class='_1HmYoV _35HD7C col-12-12']/div[@class='bhgxx2 col-12-12']/div[@class='_1YuAuf']/section[5]/div[2]/div[1]")
	private WebElement brandList;

	@FindBy(xpath="//div[@class='_1GEhLw'][contains(text(),'Titan')]")
	private WebElement titanFilter;

	public SearchResultsPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtils();
		js= (JavascriptExecutor) driver;
	}

	public void validateSearch(String itemSearched) {
		SignzyLogger.info("Validating Search result");
		quantity=resultsTitle.getText();
		quantity=quantity.split("Showing")[1];
		quantity=quantity.split("of")[1];
		quantity=quantity.split("results for")[0];

		if(quantity.contains(" ")){
			quantity=quantity.replace(",", "");
			quantity=quantity.trim();
		}

		int searchCount = Integer.parseInt(quantity);
		//System.out.println(searchCount);
		SignzyLogger.info("Total Number of items for "+ itemSearched +" retrieved  is "+ searchCount);
		SignzyLogger.info("Checking search result has some values");
		Assert.assertTrue(searchCount>0);		

		SignzyLogger.info("Validting Search results");
		Assert.assertTrue(resultsTitle.getText().trim().contains(itemSearched));
	}

	public void clickOnWristWatches() {
		wait.waitForWE(driver, wristWatchFilter);
		wristWatchFilter.click();
		SignzyLogger.info("Clicked on Wrist watch Filter");
	}

	public void selectWatchBrand()
	{
		js.executeScript("window.scrollBy(0,1000)");
		titanFilter.click();
		SignzyLogger.info("Clicked on Titan Watch Filter");
	}

	public void fetchProductDetails()
	{
		SignzyLogger.info("Executing fetchProductDetails method");
		driver.navigate().refresh();	
		List<WebElement> prodTitle = driver.findElements(By.xpath("//div[@class='_2LFGJH']"));
		wait.waitForWE(driver, prodTitle);
		SignzyLogger.info("Number of products in the search result is "+ prodTitle.size());
		SignzyLogger.info("Products in the search results are");
		for(int i=0; i<prodTitle.size();i++)
		{
			String productResults = prodTitle.get(i).getText();
			productResults = productResults.split("Titan")[1];
			productResults=productResults.replaceAll("[^a-zA-Z0-9\\s+]", "");
			productResults= productResults.split("off")[0];
			System.out.println(productResults);
		}

	}

	public void printProductOnDemand(String num)
	{
		int elementToClickOn = Integer.parseInt(num);
		int i;
		SignzyLogger.info("Fetching "+ num +" th element ");
		driver.navigate().refresh();	
		List<WebElement> prodTitle = driver.findElements(By.xpath("//div[@class='_2LFGJH']"));
		wait.waitForWE(driver, prodTitle);
		for(i=0; i<prodTitle.size();i++)
		{
			if(i==elementToClickOn-1)
			{
				String productResults = prodTitle.get(i).getText();
				productResults = productResults.split("Titan")[1];
				productResults=productResults.replaceAll("[^a-zA-Z0-9\\s+]", "");
				productResults= productResults.split("off")[0];
				System.out.println(productResults);
				prodTitle.get(i).click();
				break;
			}
		}
	}

	public void fetchAllProduct()
	{

		SignzyLogger.info("Executing fetchAllProductDetails method");
		driver.navigate().refresh();	
		List<WebElement> prodTitle = driver.findElements(By.xpath("//div[@class='_2LFGJH']"));
		wait.waitForWE(driver, prodTitle);
		js.executeScript("window.scrollBy(0,4000)");
		SignzyLogger.info("Below are the products for the search criteria");
		for(int i=0; i<prodTitle.size();i++)
		{
			String productResults = prodTitle.get(i).getText();
			productResults=productResults.replaceAll("[^a-zA-Z0-9\\s+]", "");
			productResults= productResults.split("off")[0];
			System.out.println(productResults);
		}

	}
}
















