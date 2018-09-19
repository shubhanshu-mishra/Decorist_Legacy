package com.decoristLegacy.userTestcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.Reports;


public class RunnerTest extends Base{
	
	@BeforeClass(alwaysRun=true)
	public void setUp() {
		if (extent!=null) {
			PropertyConfigurator.configure("log4j.properties");
			BusinessFunctions.launchBrowser();
			BusinessFunctions.maximizeWindow();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}else {
			Reports.setReport();
			PropertyConfigurator.configure("log4j.properties");
			BusinessFunctions.launchBrowser();
			BusinessFunctions.maximizeWindow();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		
	}
	
	/*@AfterMethod(alwaysRun=true)
	public void verifyingResult(ITestResult result) {
		Reports.getResult(result);
	}*/
	
	/*@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.close();
		Reports.flush();
	}*/
}
