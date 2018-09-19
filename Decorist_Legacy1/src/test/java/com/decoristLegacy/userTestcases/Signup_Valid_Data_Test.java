package com.decoristLegacy.userTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.VerifiyAndAssert;
import userPageObjects.HeaderObjects;
import userPageObjects.HomePage;
import userPageObjects.LoginPage;
import userPageObjects.SignupPage;
import utilities.ExcelUtilities;

public class Signup_Valid_Data_Test extends RunnerTest{

	@Test
	public void userSignupWithValidData() {
		//fetching data
		ExcelUtilities.setExcel();
		String fName=ExcelUtilities.getCellData("Signup", 1, 0);
		String lName=ExcelUtilities.getCellData("Signup", 1, 1);
		String email=ExcelUtilities.getCellData("Signup", 1, 2);
		String pwd=ExcelUtilities.getCellData("Signup", 1, 3);
		
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
		homePage=PageFactory.initElements(driver,HomePage.class);
		BusinessFunctions.explctWaitTillElementVisibility(homePage.lnk_nameLogin);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(homePage.lnk_nameLogin),"Hi ");
	}
	
}
