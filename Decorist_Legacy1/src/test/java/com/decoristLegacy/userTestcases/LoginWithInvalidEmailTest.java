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

public class LoginWithInvalidEmailTest extends RunnerTest{

	
	@Test(groups= {"sanity","regression"})
	public void loginWithInvalidEmail() {
		Log.startTestCase("Login with Invalid email and Valid password Test");
		
		String invalidEemail=ExcelUtilities.getCellData("Login", 3, 0);
		String validPassword=ExcelUtilities.getCellData("Login",3,1);
		String expText=ExcelUtilities.getCellData("Login",3,6);
		
		
		Reports.setTestName("Login with Invalid Email and Valid password Test");
		Reports.setMethodMessage("Navigated to the browser");
		
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login button on landing page");
		
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.form_signup);
		
		BusinessFunctions.setText(loginPage.txt_email, invalidEemail);
		Reports.setMethodMessage("Entered Invalid email id: "+invalidEemail);
		
		BusinessFunctions.setText(loginPage.txt_password,validPassword);
		Reports.setMethodMessage("Entered valid password: "+validPassword);
		BusinessFunctions.click(loginPage.btn_login,"Login button on login page");
		
		VerifiyAndAssert.isElementDisplayed(loginPage.block_errEmail);
		
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(loginPage.block_errEmail), expText);
		Log.info("Verified that error message displayed is same as expected:"+BusinessFunctions.getElementText(loginPage.block_errEmail));
		Reports.setMethodMessage("Verified that error message displayed is same as expected:"+BusinessFunctions.getElementText(loginPage.block_errEmail));
		Log.endTestCase("Pass:LoginWithInvalidEmailTest");
	}
	
}
