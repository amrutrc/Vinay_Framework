package com.signzy.testUtils;

import java.util.Arrays;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.signzy.loggers.SignzyLogger;
import com.signzy.resources.ExtentReporterNG;

public class Retry implements IRetryAnalyzer {
	SignzyLogger log;
	private int count = 0;
    private static int maxTry = 2; //Run the failed test 2 times

    
	public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                    
            if (count < maxTry) {                          
                count++;                                  
    		
                return true;                                 
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      
        }
        return false;
    }
	

}
