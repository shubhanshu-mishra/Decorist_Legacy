package com.decoristLegacy.userTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Constants;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import businessActions.Login;
import userPageObjects.HeaderObjects;
import userPageObjects.HomePage;
import userPageObjects.LoginPage;
import userPageObjects.SignupPage;
import utilities.EmailUtils;
import utilities.ExcelUtilities;

public class VerifyEmail_AfterSignup_Test extends RunnerTest{

	@Test
	public static void verifySignupAfterSuccessfulSignup() {
		Reports.setTestName("VerifyEmail_AfterSignup_Test");
		Log.startTestCase("VerifyEmail_AfterSignup_Test");
		ExcelUtilities.setExcel();
		/*String fName=ExcelUtilities.getCellData("Login", 2, 7);
		String lName=ExcelUtilities.getCellData("Login", 2, 8);
		String email=ExcelUtilities.getCellData("Login", 2, 9);
		String pwd=ExcelUtilities.getCellData("Login", 2, 10);*/
		String hostName=ExcelUtilities.getCellData("Email", 1, 0);
		String username=ExcelUtilities.getCellData("Email", 1, 1);
		String from=ExcelUtilities.getCellData("Email", 1, 3);
		String subjectForSignup=ExcelUtilities.getCellData("Email", 2, 4);
		
		/*header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login Button");
		signupPage=PageFactory.initElements(driver,SignupPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(signupPage.form_signup);
		loginPage=PageFactory.initElements(driver,LoginPage.class);
		BusinessFunctions.click(loginPage.lnk_signup,"Sign Up on login page");
		BusinessFunctions.setText(signupPage.txt_fname,fName);
		BusinessFunctions.setText(signupPage.txt_lname,lName);
		BusinessFunctions.setText(signupPage.txt_email,email);
		BusinessFunctions.setText(signupPage.txt_password,pwd);
		BusinessFunctions.click(signupPage.btn_signup, "Sign Up on signup page");
		homePage=PageFactory.initElements(driver,HomePage.class);
		BusinessFunctions.explctWaitTillElementVisibility(homePage.lnk_nameLogin);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(homePage.lnk_nameLogin),"Hi ");*/
		/*Login.loginAsClient();*/
		EmailUtils.verifyReceivedEmail(hostName, username, Constants.password, from, subjectForSignup);
		Reports.setMethodMessage("Pass:Email Recived");
		Log.endTestCase("VerifyEmail_AfterSignup_Test");
	}
}
