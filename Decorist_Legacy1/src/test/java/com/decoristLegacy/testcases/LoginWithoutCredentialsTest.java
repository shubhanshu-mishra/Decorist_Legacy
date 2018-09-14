package com.decoristLegacy.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import pageobjects.HeaderObjects;
import pageobjects.LoginPage;
import utilities.ExcelUtilities;

public class LoginWithoutCredentialsTest extends RunnerTest{

	@Test(groups= {"regression","sanity"})
	public void loginWithoutCredentials() {
		//Fetching data
		ExcelUtilities.setExcel();
		String expText=ExcelUtilities.getCellData("Login", 4, 2);
		Log.startTestCase("Login with blank email and blank password test");
		Reports.setTestName("Login with blank email and blank password test");
		Reports.setMethodMessage("Navigated to the url");
		
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login button on landing page");
		
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.form_signup);
		
		BusinessFunctions.setText(loginPage.txt_email, "");
		
		Reports.setMethodMessage("email field is blank");
		BusinessFunctions.setText(loginPage.txt_password,"");
		
		Reports.setMethodMessage("Password field is blank");
		BusinessFunctions.click(loginPage.btn_login,"Login button on login page");
		
		Reports.setMethodMessage("clicked on login button present on login form");
		VerifiyAndAssert.isElementDisplayed(loginPage.block_errBlnkCred);
		
		
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(loginPage.block_errBlnkCred),expText);
		Log.info("Verified that error message displayed is same as expected:"+BusinessFunctions.getElementText(loginPage.block_errBlnkCred));
		Reports.setMethodMessage("Verified that error message displayed is same as expected:"+BusinessFunctions.getElementText(loginPage.block_errBlnkCred));
		Log.endTestCase("Pass: user could not login with blank credentials");
	}
	
}
