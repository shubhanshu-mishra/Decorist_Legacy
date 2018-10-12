package com.decoristLegacy.userTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.VerifiyAndAssert;
import userPageObjects.HeaderObjects;
import userPageObjects.LoginPage;
import userPageObjects.SignupPage;
import utilities.ExcelUtilities;

public class Signup_with_duplicate_data_Test extends RunnerTest{

	@Test
	public static void signupWithDuplicateData() {
		ExcelUtilities.setExcel();
		String fName=ExcelUtilities.getCellData("Login", 2, 2);
		String lName=ExcelUtilities.getCellData("Login", 2, 3);
		String email=ExcelUtilities.getCellData("Login", 2, 4);
		String pwd=ExcelUtilities.getCellData("Login", 2, 5);
		String errMsgDuplicateData=ExcelUtilities.getCellData("Messages", 1, 1);
		
		header=PageFactory.initElements(driver,HeaderObjects.class);
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
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.block_dupData);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(loginPage.block_dupData), errMsgDuplicateData);
	}
}
