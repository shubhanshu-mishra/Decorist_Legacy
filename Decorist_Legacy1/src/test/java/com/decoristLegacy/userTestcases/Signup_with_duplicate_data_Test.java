package com.decoristLegacy.userTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import userPageObjects.HeaderObjects;
import userPageObjects.LoginPage;
import userPageObjects.SignupPage;
import utilities.ExcelUtilities;

public class Signup_with_duplicate_data_Test extends RunnerTest{

	@Test
	public static void signupWithDuplicateData() {
		Reports.setTestName("Signup_with_duplicate_data_Test");
		Log.startTestCase("Signup_with_duplicate_data_Test");
		ExcelUtilities.setExcel();
		String fName=ExcelUtilities.getCellData("Login", 5, 2);
		String lName=ExcelUtilities.getCellData("Login", 5, 3);
		String email=ExcelUtilities.getCellData("Login", 5, 4);
		String pwd=ExcelUtilities.getCellData("Login", 5, 5);
		String errMsgDuplicateData=ExcelUtilities.getCellData("Login", 5, 6);
		
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login Button");
		Reports.setMethodMessage("Login Button is clicked");
		signupPage=PageFactory.initElements(driver,SignupPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(signupPage.form_signup);
		loginPage=PageFactory.initElements(driver,LoginPage.class);
		BusinessFunctions.click(loginPage.lnk_signup,"Sign Up on login page");
		Reports.setMethodMessage("Sign Up link on login page is clicked");
		BusinessFunctions.setText(signupPage.txt_fname,fName);
		Reports.setMethodMessage("First name entered:"+fName);
		BusinessFunctions.setText(signupPage.txt_lname,lName);
		Reports.setMethodMessage("Last name entered:"+lName);
		BusinessFunctions.setText(signupPage.txt_email,email);
		Reports.setMethodMessage("Email entered:"+email);
		BusinessFunctions.setText(signupPage.txt_password,pwd);
		Reports.setMethodMessage("Password entered:"+pwd);
		BusinessFunctions.click(signupPage.btn_signup, "Sign Up on signup page");
		Reports.setMethodMessage("Clicked on Sign Up button on signup page");
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.block_dupData);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(loginPage.block_dupData), errMsgDuplicateData);
		Reports.setMethodMessage("Validated that Err Msg:"+BusinessFunctions.getElementText(loginPage.block_dupData)+" is displayed");
		Log.endTestCase("Signup_with_duplicate_data_Test");
	}
}
