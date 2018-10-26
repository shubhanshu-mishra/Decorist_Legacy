package businessActions;

import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import adminPageObjects.AdminHomePage;
import userPageObjects.HeaderObjects;
import userPageObjects.HomePage;
import userPageObjects.LandingPage;
import userPageObjects.LoginPage;
import utilities.ExcelUtilities;

public class Login extends Base{

	public static void loginAsAdmin() {
		ExcelUtilities.setExcel();
		String email=ExcelUtilities.getCellData("Login", 2, 11);
		String password=ExcelUtilities.getCellData("Login", 2, 12);
		String url=ExcelUtilities.getCellData("URL", 2, 3);
		String adminHomepageUrl=ExcelUtilities.getCellData("URL", 1, 3);
		
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
		BusinessFunctions.navigateToURL(url);
		VerifiyAndAssert.verifyUrlResponseCodeIs200(url);
		BusinessFunctions.navigateToURL(adminHomepageUrl);
		BusinessFunctions.explctWaitTillElementVisibility(adminHomePage.lnk_promoCodes);
	}
	
	public static void loginAsDesigner() {
		 Reports.setMethodMessage("loginAsDesigner method called");
		ExcelUtilities.setExcel();
		String email=ExcelUtilities.getCellData("Login", 2, 14);
		String password=ExcelUtilities.getCellData("Login", 2, 15);
		String url=ExcelUtilities.getCellData("URL", 2, 3);
		
		landingPage=PageFactory.initElements(driver,LandingPage.class);
		if (VerifiyAndAssert.isPopupDisplayed(landingPage.ele_popup)==true) {
			BusinessFunctions.clickUsingJS(landingPage.lnk_noThanks,"No Thanks Link on popup");
			BusinessFunctions.waitForSecs(5000);
		}
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login button on landing page");
		Reports.setMethodMessage("Login button on landing page is clicked");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.form_signup);
		BusinessFunctions.setText(loginPage.txt_email,email);
		BusinessFunctions.setText(loginPage.txt_password,password);
		BusinessFunctions.click(loginPage.btn_login,"Login button on login page");
		//Validating that Hi UserName element exists
		adminHomePage=PageFactory.initElements(driver, AdminHomePage.class);
		BusinessFunctions.explctWaitTillElementVisibility(adminHomePage.str_username);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(adminHomePage.str_username), "Hi");
		homePage=PageFactory.initElements(driver, HomePage.class);
		//Validating that Login As link is not displayed
		BusinessFunctions.mouseHover(homePage.lnk_nameLogin);
		VerifiyAndAssert.verifyIfLinkIsNotDisplayed("Login AS");
		Log.info("Pass:Designer Login Method");
	}
	
	public static void loginAsClient() {
	    Reports.setMethodMessage("loginAsClient method called");
		ExcelUtilities.setExcel();
		String email=ExcelUtilities.getCellData("Login", 2, 0);
		String password=ExcelUtilities.getCellData("Login",2,1);
		header=PageFactory.initElements(driver,HeaderObjects.class);
		landingPage=PageFactory.initElements(driver, LandingPage.class);
		if (VerifiyAndAssert.isPopupDisplayed(landingPage.ele_popup)==true) {
			BusinessFunctions.clickUsingJS(landingPage.lnk_noThanks,"No Thanks Link on popup");
			BusinessFunctions.waitForSecs(5000);
		}
		BusinessFunctions.click(header.lnk_login,"Login button on landing page");
		Reports.setMethodMessage("Login button on landing page is clicked");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(loginPage.form_signup);
		BusinessFunctions.setText(loginPage.txt_email,email);
		Reports.setMethodMessage(email+"is entered as email");
		BusinessFunctions.setText(loginPage.txt_password,password);
		Reports.setMethodMessage(password+"is entered as password");
		BusinessFunctions.click(loginPage.btn_login,"Login button on login page");
		Reports.setMethodMessage("clicked on login button present on login form");
		//Validating that Hi UserName element exists
		homePage=PageFactory.initElements(driver, HomePage.class);
		BusinessFunctions.explctWaitTillElementVisibility(homePage.lnk_nameLogin);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(homePage.lnk_nameLogin), "Hi");
		Reports.setMethodMessage("Hi [username] is displayed");
	}
	
	public static void userSignupWithValidDataTest() {
		
	}
}
