package com.decoristLegacy.userTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import userPageObjects.HeaderObjects;
import userPageObjects.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends RunnerTest {

	@Test(groups= {"sanity","regression"})
	public static void loginTest() {
		ExcelUtilities.setExcel();
		String email=ExcelUtilities.getCellData("Login", 1, 0);
		String password=ExcelUtilities.getCellData("Login",1,1);
		
		Log.startTestCase("Login with valid credentials");
		Reports.setTestName("Login with valid credentials");
		Reports.setMethodMessage("Navigated to the url");
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login button on landing page");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.form_signup);
		BusinessFunctions.setText(loginPage.txt_email,email);
		Reports.setMethodMessage("Entered valid email id: "+email);
		BusinessFunctions.setText(loginPage.txt_password,password);
		Reports.setMethodMessage("Entered valid password: "+password);
		BusinessFunctions.click(loginPage.btn_login,"Login button on login page");
		Reports.setMethodMessage("clicked on login button present on login form");
		Log.endTestCase("Pass: Login successful");
	}
	
}
