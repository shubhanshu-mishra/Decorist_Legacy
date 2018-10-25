package com.decoristLegacy.adminTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.decoristLegacy.userTestcases.RunnerTest;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import adminPageObjects.AdminHomePage;
import userPageObjects.HeaderObjects;
import userPageObjects.LandingPage;
import userPageObjects.LoginPage;
import utilities.ExcelUtilities;

public class AdminLogin_WithInvalidData_Test extends RunnerTest{

	@Test
	public static void adminLoginWithInvalidData() {
		Log.startTestCase("AdminLogin_WithInvalidData_Test");
		
		String email=ExcelUtilities.getCellData("Login", 2, 0);
		String password=ExcelUtilities.getCellData("Login", 2, 1);
		String homePageUrl=ExcelUtilities.getCellData("URL", 1, 1);
		String adminUrl=ExcelUtilities.getCellData("URL", 1, 3);
		
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
		//Validating that Hi UserName element exists
		adminHomePage=PageFactory.initElements(driver, AdminHomePage.class);
		BusinessFunctions.explctWaitTillElementVisibility(adminHomePage.str_username);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(adminHomePage.str_username), "Hi");
		BusinessFunctions.navigateToURL(adminUrl);
		VerifiyAndAssert.verifyStringsShouldNotSame(BusinessFunctions.getCurrentURL(), adminUrl);
		VerifiyAndAssert.verifyText(BusinessFunctions.getCurrentURL(), homePageUrl);
		Log.endTestCase("Pass:AdminLogin_WithInvalidData_Test");
	}
}
