package com.decoristLegacy.adminTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.decoristLegacy.userTestcases.RunnerTest;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import userPageObjects.HeaderObjects;
import userPageObjects.LandingPage;
import userPageObjects.LoginPage;
import utilities.ExcelUtilities;

public class AdminLogin_BlankPwd_Test extends RunnerTest{
	
	@Test
	public static void adminLoginWithBlankPwdTest() {
		Log.startTestCase("AdminLogin_BlankPwd_Test");
		ExcelUtilities.setExcel();
		String email=ExcelUtilities.getCellData("Login", 3, 11);
		String password="";
		String errMsg=ExcelUtilities.getCellData("Login", 3, 13);
		
		landingPage=PageFactory.initElements(driver,LandingPage.class);
		if (VerifiyAndAssert.isPopupDisplayed(landingPage.ele_popup)==true) {
			BusinessFunctions.clickUsingJS(landingPage.lnk_noThanks,"No Thanks Link on popup");
		}
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login button on landing page");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.form_signup);
		BusinessFunctions.setText(loginPage.txt_email,email);
		BusinessFunctions.setText(loginPage.txt_password,password);
		BusinessFunctions.click(loginPage.btn_login,"Login button on login page");
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(loginPage.block_errBlnkCred), errMsg);
		Log.endTestCase("Pass:AdminLogin_BlankPwd_Test");
	}

}
