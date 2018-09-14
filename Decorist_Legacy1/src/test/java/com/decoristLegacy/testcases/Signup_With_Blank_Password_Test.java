package com.decoristLegacy.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.VerifiyAndAssert;
import pageobjects.HeaderObjects;
import pageobjects.LoginPage;
import pageobjects.SignupPage;
import utilities.ExcelUtilities;

public class Signup_With_Blank_Password_Test extends RunnerTest{

	@Test
	public void signupWithBlankPassword() {
		//fetching data
		ExcelUtilities.setExcel();
		String fName=ExcelUtilities.getCellData("Signup", 3, 0);
		String lName=ExcelUtilities.getCellData("Signup", 3, 1);
		String email=ExcelUtilities.getCellData("Signup", 3, 2);
		String pwd=ExcelUtilities.getCellData("Signup", 3, 3);
		String errMsg=ExcelUtilities.getCellData("Signup", 3, 4);
		
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
		VerifiyAndAssert.isElementDisplayed(loginPage.block_errBlnkCred);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(loginPage.block_errBlnkCred), errMsg);
		BusinessFunctions.click(loginPage.btn_closeForm,"Cross button to close form");
	}
}
