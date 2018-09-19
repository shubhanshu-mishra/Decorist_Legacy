package com.decoristLegacy.adminTestcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.decoristLegacy.userTestcases.RunnerTest;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import junit.framework.Assert;
import userPageObjects.HeaderObjects;
import userPageObjects.HomePage;
import userPageObjects.LandingPage;
import userPageObjects.LoginPage;
import utilities.ExcelUtilities;

public class AdminLoginTest extends RunnerTest{

	@Test
	public static void loginAsAdmin() {
		Log.startTestCase("Login as Admin with valid credential test");
		ExcelUtilities.setExcel();
		String email=ExcelUtilities.getCellData("Login", 7, 0);
		String password=ExcelUtilities.getCellData("Login", 7, 1);
		
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement value = (WebElement) js.executeScript("return document.evaluate( '//*[@id=\"nambar-links\"]/div[1]/span',document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue;");
	}
}
