package com.decoristLegacy.userTestcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.Reports;

public class NL_RunnerTest extends Base{

	
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
}
