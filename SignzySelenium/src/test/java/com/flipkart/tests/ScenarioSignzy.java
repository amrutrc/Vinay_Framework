package com.flipkart.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.signzy.Init.Setup;
import com.signzy.genericutils.Readprop;
import com.signzy.genericutils.WaitUtils;
import com.signzy.loggers.SignzyLogger;
import com.signzy.pageobjects.HomeScreen;
import com.signzy.pageobjects.LoginPage;
import com.signzy.pageobjects.SearchResultsPage;

public class ScenarioSignzy extends Setup {


	public  Readprop readprop;
	public WaitUtils wait;
	private LoginPage log;
	private HomeScreen home;
	private SearchResultsPage search;


	public void initialiseRef()
	{
		SignzyLogger.info("Executing flows by creating instance members of all page objects");		

		wait = new WaitUtils();
		readprop = new Readprop();
		log = new LoginPage(driver);
		home = new HomeScreen(driver);
		search = new SearchResultsPage(driver);
	}


	/*
	 * Test Case
		 1.Navigate to www.flipkart.com
		 2.Enter valid creds to login
		 3.Enter watch brand in the search box
		 4.Select Wrist Watch from Category
		 5.Select Titan brand filter
	 	 6. Validate Search result has some value
	 	 7. Validate Search result is based on the search criteria

	 */
	@Test(priority=1)
	public void searchWatch() throws IOException, InterruptedException
	{			
		initialiseRef();		
		SignzyLogger.info("Login to FlipKart with credentials");
		log.login(readprop.fetchproperty("user"), readprop.fetchproperty("password"));

		SignzyLogger.info("Entering "+ readprop.fetchproperty("searchString") +" to the search field");
		home.search(readprop.fetchproperty("searchString"));

		SignzyLogger.info("Verify Search result value is not empty");
		search.validateSearch(readprop.fetchproperty("searchString"));

		SignzyLogger.info("Select Wrist Watch Filter from the categories");
		search.clickOnWristWatches();

		SignzyLogger.info("Select Titan from the Brand Filter");
		search.selectWatchBrand();
	}


	/* Test Case
	 	1.Fetch product details from the search results of the above method
	 	2.Select and Print product on demand 
	 */
	@Test(priority=2 )
	public void printProdDescription() throws  InterruptedException, IOException
	{
		initialiseRef();		
		searchWatch();

		SignzyLogger.info("Print all the products in the search results page");
		search.fetchProductDetails();

		SignzyLogger.info("Printing and select " + readprop.fetchproperty("searchNumber") + "th element");
		search.printProductOnDemand(readprop.fetchproperty("searchNumber"));
	}

	
	/* Test Case
	 * Fetch all the products from the search results 
	 */
	@Test(priority=3)
	public void printAllProducts() throws IOException, InterruptedException
	{
		initialiseRef();		
		searchWatch();
		SignzyLogger.info("Printing all the products from the search results with scroll down");
		search.fetchAllProduct();
	}

}