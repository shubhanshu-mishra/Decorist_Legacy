package com.decoristLegacy.userTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import userPageObjects.HeaderObjects;
import userPageObjects.HomePage;
import userPageObjects.LoginPage;
import utilities.ExcelUtilities;

public class Signup_With_Facebook_Test extends RunnerTest{

	@Test
	public void clientLoginWithFacebook() {
		Log.startTestCase("Login_With_Facebook_Test");
		
		ExcelUtilities.setExcel();
		String clientFacebookEmail=ExcelUtilities.getCellData("Login", 6, 0);
		String clientFacebookPassword=ExcelUtilities.getCellData("Login", 6, 1);
		
		header=PageFactory.initElements(driver, HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.form_signup);
		BusinessFunctions.click(loginPage.lnk_facebook, "Login with Facebook Button");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BusinessFunctions.switchToWindow(1);
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.txt_facebookEmail);
		BusinessFunctions.setText(loginPage.txt_facebookEmail,clientFacebookEmail);
		BusinessFunctions.setText(loginPage.txt_facebookPassword,clientFacebookPassword);
		BusinessFunctions.click(loginPage.btn_facebookLogin, "Facebook Login");
		if (BusinessFunctions.getWindowsSize()>=2) {
			BusinessFunctions.isElementDisplayed(loginPage.btn_facebookConfirm, "Facebook Confirm");
			BusinessFunctions.click(loginPage.btn_facebookConfirm, "Facebook Confirm");
		}
		BusinessFunctions.switchToParentWindow();
		homePage=PageFactory.initElements(driver,HomePage.class);
		BusinessFunctions.explctWaitTillElementVisibility(homePage.lnk_nameLogin);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(homePage.lnk_nameLogin),"Hi ");
		
		Log.endTestCase("Pass:Login_With_Facebook_Test");
	}
}
