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

public class LoginWithInvalidEmailTest extends RunnerTest{

	
	@Test(groups= {"sanity","regression"})
	public void loginWithInvalidEmail() {
		String email="";
		String password="";
		String actText="";
		Log.startTestCase("Login with Invalid email and Valid password Test");
		Reports.setTestName("Login with Invalid Email and Valid password Test");
		Reports.setMethodMessage("Navigated to the browser");
		FileInputStream file;
		Properties prop;
		try {
			file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\config.properties");
			prop=new Properties();
			prop.load(file);
			email=prop.getProperty("invalidEmail");
			password=prop.getProperty("validpassword");
			actText=prop.getProperty("email_err_msg");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login button on landing page");
		Log.info("clicked on login link on landing page");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.form_signup);
		Log.info("login form is displayed");
		BusinessFunctions.setText(loginPage.txt_email, email);
		Reports.setMethodMessage("Entered Invalid email id: "+email);
		Log.info("Entered Invalid email id: "+email);
		BusinessFunctions.setText(loginPage.txt_password,password);
		Log.info("Entered valid password:Abc@123");
		Reports.setMethodMessage("Entered valid password: "+password);
		BusinessFunctions.click(loginPage.btn_login,"Login button on login page");
		Log.info("clicked on login button present on login form");
		VerifiyAndAssert.isElementDisplayed(loginPage.block_errEmail);
		Log.info("verified that error message is displayed");
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(loginPage.block_errEmail),actText);
		Log.info("Verified that error message displayed is same as expected:"+BusinessFunctions.getElementText(loginPage.block_errEmail));
		Reports.setMethodMessage("Verified that error message displayed is same as expected:"+BusinessFunctions.getElementText(loginPage.block_errEmail));
		Log.endTestCase("Pass: User could not login");
	}
	
}
