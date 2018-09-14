package com.decoristLegacy.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;
import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import pageobjects.HeaderObjects;
import pageobjects.LoginPage;
import utilities.ExcelUtilities;

public class LoginWithInvalidPasswordTest extends RunnerTest{

	@Test(groups= {"regression","sanity"})
	public void loginWithInvalidPassword() throws InterruptedException {
		//Fetching data
		ExcelUtilities.setExcel();
		String validEemail=ExcelUtilities.getCellData("Login", 3, 0);
		String InvalidPassword=ExcelUtilities.getCellData("Login",3,1);
		String expText=ExcelUtilities.getCellData("Login",3,2);
		
		Log.startTestCase("Login with valid email and invalid password");
		Reports.setTestName("Login with valid email and invalid password");
		Reports.setMethodMessage("Navigated to the url");
		
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login button on landing page");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.form_signup);
	
		BusinessFunctions.setText(loginPage.txt_email,validEemail );
		Reports.setMethodMessage("Entered valid email id: "+validEemail);
		BusinessFunctions.setText(loginPage.txt_password,InvalidPassword);
		Reports.setMethodMessage("Entered Invalid password: "+InvalidPassword);
		
		BusinessFunctions.click(loginPage.btn_login,"Login button on login page");
		Thread.sleep(2000);
		Log.info("clicked on login button present on login form");
		Reports.setMethodMessage("clicked on login button present on login form");
		VerifiyAndAssert.isElementDisplayed(loginPage.block_errPass);
		System.out.println(driver.findElement(By.id("error-combination")).getAttribute("outerText"));
		VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(loginPage.block_errPass, "outerText"), expText);
		Log.info("Verified that error message displayed is same as expected:"+BusinessFunctions.getAttributeText(loginPage.block_errPass, "outerText"));
		Reports.setMethodMessage("Verified that error message displayed is same as expected:"+BusinessFunctions.getAttributeText(loginPage.block_errPass, "outerText"));
		Log.endTestCase("Pass: user could not login with invalid password");
	}
	
}
