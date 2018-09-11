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
import pageobjects.HeaderObjects;
import pageobjects.LoginPage;

public class LoginTest extends RunnerTest {

	@Test(groups= {"sanity","regression"})
	public static void loginTest() {
		String email="";
		String password="";
		FileInputStream file;
		try {
			file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\config.properties");
			Properties prop;
			prop=new Properties();
			prop.load(file);
			email=prop.getProperty("validEmail");
			password=prop.getProperty("validpassword");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.startTestCase("Login with valid credentials");
		Reports.setTestName("Login with valid credentials");
		Reports.setMethodMessage("Navigated to the url");
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login button on landing page");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.form_signup);
		BusinessFunctions.setText(loginPage.txt_email,email);
		Log.info("Entered valid email id: "+email);
		Reports.setMethodMessage("Entered valid email id: "+email);
		BusinessFunctions.setText(loginPage.txt_password,password);
		Log.info("Entered valid password: "+password);
		Reports.setMethodMessage("Entered valid password: "+password);
		BusinessFunctions.click(loginPage.btn_login,"Login button on login page");
		Log.info("clicked on login button present on login form");
		Reports.setMethodMessage("clicked on login button present on login form");
		Log.endTestCase("Pass: Login successful");
	}
	
}
