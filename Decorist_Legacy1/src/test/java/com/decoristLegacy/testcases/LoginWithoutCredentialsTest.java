package com.decoristLegacy.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import pageobjects.HeaderObjects;
import pageobjects.LoginPage;

public class LoginWithoutCredentialsTest extends RunnerTest{

	@Test(groups= {"regression","sanity"})
	public void loginWithoutCredentials() {
		Log.startTestCase("Login with blank email and blank password test");
		Reports.setTestName("Login with blank email and blank password test");
		Reports.setMethodMessage("Navigated to the url");
		FileInputStream file;
		Properties prop;
		String actText="";
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login button on landing page");
		Log.info("clicked on login link on landing page");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.form_signup);
		Log.info("login form is displayed");
		BusinessFunctions.setText(loginPage.txt_email, "");
		Log.info("email field is blank");
		Reports.setMethodMessage("email field is blank");
		BusinessFunctions.setText(loginPage.txt_password,"");
		Log.info("Password field is blank");
		Reports.setMethodMessage("Password field is blank");
		BusinessFunctions.click(loginPage.btn_login,"Login button on login page");
		Log.info("clicked on login button present on login form");
		Reports.setMethodMessage("clicked on login button present on login form");
		VerifiyAndAssert.isElementDisplayed(loginPage.block_errBlnkCred);
		Log.info("verified that error message is displayed");
		try {
			file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\config.properties");
			prop=new Properties();
			prop.load(file);
			actText=prop.getProperty("passwd_err_msg");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(loginPage.block_errBlnkCred),actText);
		Log.info("Verified that error message displayed is same as expected:"+BusinessFunctions.getElementText(loginPage.block_errBlnkCred));
		Reports.setMethodMessage("Verified that error message displayed is same as expected:"+BusinessFunctions.getElementText(loginPage.block_errBlnkCred));
		Log.endTestCase("Pass: user could not login with blank credentials");
	}
	
}
