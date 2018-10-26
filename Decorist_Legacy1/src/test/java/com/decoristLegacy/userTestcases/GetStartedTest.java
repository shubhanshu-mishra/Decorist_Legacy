package com.decoristLegacy.userTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import businessActions.CardPayment;
import businessActions.Login;
import userPageObjects.AddRoomPage;
import userPageObjects.HeaderObjects;
import userPageObjects.HomePage;
import userPageObjects.LandingPage;
import userPageObjects.OrderConfirmation;
import userPageObjects.PaymentInfoPage;
import userPageObjects.SelectYourDesignPage;
import userPageObjects.ShoppingCartPage;
import userPageObjects.StyleQuizPage;
import utilities.ExcelUtilities;

public class GetStartedTest extends NL_RunnerTest{

	@Test
	public void getStartedTest() {
		Reports.setTestName("GetStartedTest Non-login End To End Flow");
		Log.startTestCase("GetStartedTest");
		ExcelUtilities.setExcel();
		String thanksForOrdering=ExcelUtilities.getCellData("Messages", 2, 1);
		landingPage=PageFactory.initElements(driver, LandingPage.class);
		landingPage.clickGetStartedButton();
		styleQuizPage=PageFactory.initElements(driver, StyleQuizPage.class);
		styleQuizPage.styleQuizTest();
		addRoomPage=PageFactory.initElements(driver,AddRoomPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(addRoomPage.str_whichRooms);
		
		//Start A Project
		homePage=PageFactory.initElements(driver, HomePage.class);
		addRoomPage=PageFactory.initElements(driver,AddRoomPage.class);
		addRoomPage.addRoom(3, "Dining Room");
		addRoomPage.clickOnNextBtnOnAddRoom();
			
		//selecting design package
		selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
		selectYourDesign.selectCelebrityDesignPackageForNonLogin();
			
		shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
		shoppingCartPage.clickOnProceedToCheckoutForNonLogin();
	
		paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
		VerifiyAndAssert.isElementDisplayed(paymentInfoPage.lnk_login);
		paymentInfoPage.signupNonLoginCase();
		
		//Making payment
		CardPayment.makingValidPaymentThroughCard();
		//validating promo check box default state that should be un-checked
		paymentInfoPage.validatePromoChkBxState();
		//validating gift check box default state that should be un-checked
		paymentInfoPage.validateGiftChkBxState();
		ExcelUtilities.writeCellData("ShoppingCart", 1, 7, BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue));
			
		//Validating Order Total on Payment Info Page is same as Total on Shopping Cart page when promo/gift check boxes are unchecked
		String orderTotal=ExcelUtilities.getCellData("ShoppingCart", 1, 7);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue), orderTotal);
			
		paymentInfoPage.clickOnPlaceYourOrder();
		orderConfirmation=PageFactory.initElements(driver,OrderConfirmation.class);
		BusinessFunctions.explctWaitTillElementVisibility(orderConfirmation.str_thanksForOrdering);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(orderConfirmation.str_thanksForOrdering), thanksForOrdering);
	}
	
}
