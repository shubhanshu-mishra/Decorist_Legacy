package com.decoristLegacy.userTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import userPageObjects.HeaderObjects;
import userPageObjects.HomePage;
import userPageObjects.LoginPage;
import userPageObjects.SignupPage;
import utilities.ExcelUtilities;

public class Signup_Valid_Data_Test extends RunnerTest{

	@Test
	public void userSignupWithValidData() {
		
		Reports.setTestName("Signup_Valid_Data_Test");
		Log.startTestCase("Signup_Valid_Data_Test");
		ExcelUtilities.setExcel();
		String fName=ExcelUtilities.getCellData("Login", 6, 2);
		String lName=ExcelUtilities.getCellData("Login", 6, 3);
		String email=ExcelUtilities.getCellData("Login", 6, 4);
		String pwd=ExcelUtilities.getCellData("Login", 6, 5);
		
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
		homePage=PageFactory.initElements(driver,HomePage.class);
		BusinessFunctions.explctWaitTillElementVisibility(homePage.lnk_nameLogin);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(homePage.lnk_nameLogin),"Hi ");
		Reports.setMethodMessage("Validated that:"+BusinessFunctions.getElementText(homePage.lnk_nameLogin)+" is displayed");
		Log.endTestCase("Signup_Valid_Data_Test");
	}
	
}
