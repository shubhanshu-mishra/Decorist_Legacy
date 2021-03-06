package com.decoristLegacy.userTestcases;

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
import userPageObjects.HeaderObjects;
import userPageObjects.LoginPage;
import utilities.ExcelUtilities;

public class LoginWithoutCredentialsTest extends RunnerTest{

	@Test(groups= {"regression","sanity"})
	public void loginWithoutCredentials() {
		Log.startTestCase("Login with blank email and blank password test");
		String email=ExcelUtilities.getCellData("Login", 5, 0);
		String expText=ExcelUtilities.getCellData("Login", 4, 6);
		
		Reports.setTestName("Login with blank email and blank password test");
		Reports.setMethodMessage("Navigated to the url");
		
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login button on landing page");
		Reports.setMethodMessage("Login button on landing page is clicked");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.form_signup);
		
		BusinessFunctions.setText(loginPage.txt_email, email);
		
		
		BusinessFunctions.setText(loginPage.txt_password,"");
		
		Reports.setMethodMessage("Password field is blank");
		BusinessFunctions.click(loginPage.btn_login,"Login button on login page");
		
		Reports.setMethodMessage("clicked on login button present on login form");
		VerifiyAndAssert.isElementDisplayed(loginPage.block_errBlnkCred);
		
		
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(loginPage.block_errBlnkCred),expText);
		Log.info("Verified that error message displayed is same as expected:"+BusinessFunctions.getElementText(loginPage.block_errBlnkCred));
		Reports.setMethodMessage("Verified that error message displayed is same as expected:"+BusinessFunctions.getElementText(loginPage.block_errBlnkCred));
		Log.endTestCase("Pass:LoginWithoutCredentialsTest");
	}
	
}
