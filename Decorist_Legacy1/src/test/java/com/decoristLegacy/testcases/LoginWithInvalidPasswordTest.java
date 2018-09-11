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

public class LoginWithInvalidPasswordTest extends RunnerTest{

	@Test(groups= {"regression","sanity"})
	public void loginWithInvalidPassword() throws InterruptedException {
		String email="";
		String password="";
		String expText="";
		Log.startTestCase("Login with valid email and invalid password");
		Reports.setTestName("Login with valid email and invalid password");
		Reports.setMethodMessage("Navigated to the url");
		FileInputStream file;
		Properties prop;
		try {
			file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\config.properties");
			prop=new Properties();
			prop.load(file);
			email=prop.getProperty("validEmail");
			password=prop.getProperty("invalidPassword");
			expText=prop.getProperty("invalid_pass_err_msg");
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
		BusinessFunctions.setText(loginPage.txt_email,email );
		Log.info("Entered valid email id:"+email);
		Reports.setMethodMessage("Entered valid email id: "+email);
		BusinessFunctions.setText(loginPage.txt_password,password);
		Log.info("Entered Invalid password: "+password);
		Reports.setMethodMessage("Entered Invalid password: "+password);
		BusinessFunctions.click(loginPage.btn_login,"Login button on login page");
		Thread.sleep(2000);
		Log.info("clicked on login button present on login form");
		Reports.setMethodMessage("clicked on login button present on login form");
		VerifiyAndAssert.isElementDisplayed(loginPage.block_errPass);
		Log.info("verified that error message is displayed");
		System.out.println(driver.findElement(By.id("error-combination")).getAttribute("outerText"));
		VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(loginPage.block_errPass, "outerText"), expText);
		Log.info("Verified that error message displayed is same as expected:"+BusinessFunctions.getAttributeText(loginPage.block_errPass, "outerText"));
		Reports.setMethodMessage("Verified that error message displayed is same as expected:"+BusinessFunctions.getAttributeText(loginPage.block_errPass, "outerText"));
		Log.endTestCase("Pass: user could not login with invalid password");
	}
	
}
