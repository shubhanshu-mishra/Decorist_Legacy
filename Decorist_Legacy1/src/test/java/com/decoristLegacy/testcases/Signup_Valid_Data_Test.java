package com.decoristLegacy.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.VerifiyAndAssert;
import pageobjects.HeaderObjects;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.SignupPage;

public class Signup_Valid_Data_Test extends RunnerTest{

	@Test
	public void userSignupWithValidData() {
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login Button");
		signupPage=PageFactory.initElements(driver,SignupPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(signupPage.form_signup);
		loginPage=PageFactory.initElements(driver,LoginPage.class);
		BusinessFunctions.click(loginPage.lnk_signup,"Sign Up on login page");
		BusinessFunctions.setText(signupPage.txt_fname,"shubhanshu");
		BusinessFunctions.setText(signupPage.txt_lname,"mishra");
		BusinessFunctions.setText(signupPage.txt_email,"pqrs@yopmail.com");
		BusinessFunctions.setText(signupPage.txt_password,"Abc@123");
		BusinessFunctions.click(signupPage.btn_signup, "Sign Up on signup page");
		homePage=PageFactory.initElements(driver,HomePage.class);
		BusinessFunctions.explctWaitTillElementVisibility(homePage.lnk_nameLogin);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(homePage.lnk_nameLogin),"Hi ");
	}
	
}
