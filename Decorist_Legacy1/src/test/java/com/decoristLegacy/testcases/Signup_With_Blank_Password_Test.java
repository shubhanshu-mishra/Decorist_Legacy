package com.decoristLegacy.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.VerifiyAndAssert;
import pageobjects.HeaderObjects;
import pageobjects.LoginPage;
import pageobjects.SignupPage;

public class Signup_With_Blank_Password_Test extends RunnerTest{

	@Test
	public void signupWithBlankPassword() {
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login Button");
		signupPage=PageFactory.initElements(driver,SignupPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(signupPage.form_signup);
		loginPage=PageFactory.initElements(driver,LoginPage.class);
		BusinessFunctions.click(loginPage.lnk_signup,"Sign Up on login page");
		BusinessFunctions.setText(signupPage.txt_fname,"shubhanshu");
		BusinessFunctions.setText(signupPage.txt_lname,"mishra");
		BusinessFunctions.setText(signupPage.txt_email,"pqrs@yopmail.com");
		BusinessFunctions.setText(signupPage.txt_password,"");
		BusinessFunctions.click(signupPage.btn_signup, "Sign Up on signup page");
		VerifiyAndAssert.isElementDisplayed(loginPage.block_errBlnkCred);
		System.out.println(BusinessFunctions.getElementText(loginPage.block_errBlnkCred));
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(loginPage.block_errBlnkCred), "Please enter a valid password. Note that passwords are case-sensitive.");
		BusinessFunctions.click(loginPage.btn_closeForm,"Cross button to close form");
	}
}