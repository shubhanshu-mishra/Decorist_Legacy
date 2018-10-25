package com.decoristLegacy.userTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import businessActions.Login;
import userPageObjects.HeaderObjects;
import userPageObjects.HomePage;
import userPageObjects.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends RunnerTest {	
	
	@Test
	public static void loginTest() {
	  Log.startTestCase("Login with valid credentials");
		Login.loginAsClient();
	  Log.endTestCase("Pass: Login successful");
	}
	
}
