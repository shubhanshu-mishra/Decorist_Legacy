package com.decoristLegacy.userTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import businessActions.CardPayment;
import businessActions.Login;
import businessActions.ShoppingCart;
import userPageObjects.AddRoomPage;
import userPageObjects.HeaderObjects;
import userPageObjects.HomePage;
import userPageObjects.OrderConfirmation;
import userPageObjects.PaymentInfoPage;
import userPageObjects.SelectYourDesignPage;
import userPageObjects.ShoppingCartPage;
import utilities.ExcelUtilities;
import utilities.ImageUtils;

public class SingleRoom_CelebrityPackage_Test extends RunnerTest{

	/*UX_6,TC_1*/
	@Test
	public synchronized void singleRoomWithCelebrityPackage(){
		Log.startTestCase("SingleRoom_CelebrityPackage_Test");
		
		//fetching data
		ExcelUtilities.setExcel();
		String thanksForOrdering=ExcelUtilities.getCellData("Messages", 2, 1);
		
		header=PageFactory.initElements(driver,HeaderObjects.class);
		Login.loginAsClient();
		BusinessFunctions.waitForSecs(2000);
		
		//Start A Project
		homePage=PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnStartAProjectBtn();
		addRoomPage=PageFactory.initElements(driver,AddRoomPage.class);
		addRoomPage.addRoom(3, "Dining Room");
		addRoomPage.clickOnNextBtnOnAddRoom();
			
		//selecting design package
		selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
		selectYourDesign.selectCelebrityDesignPackageForLogin();
		//VerifiyAndAssert.verifyURL(shoppingCartPageUrl);
			
		shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
		shoppingCartPage.clickOnProceedToCheckoutForLogin();
	
		//Making payment
		paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
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
		Log.endTestCase("SingleRoom_CelebrityPackage_Test");
		}
		
	
}
