package com.decoristLegacy.userTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
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

public class SingleRoom_ElitePackage_Test extends RunnerTest{

/*UX_5,TC_1*/
	
	@Test
	public synchronized void singleRoomWithElitePackage(){
		Reports.setTestName("SingleRoom_ElitePackage_Test");
		Log.startTestCase("SingleRoom_ElitePackage_Test");
		
		//fetching data
		ExcelUtilities.setExcel();
		String thanksForOrdering=ExcelUtilities.getCellData("Messages", 2, 1);
		
		header=PageFactory.initElements(driver,HeaderObjects.class);
		Login.loginAsClient();
		BusinessFunctions.waitForSecs(2000);
		
		//Start A Project
		homePage=PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnStartAProjectBtn();
		Reports.setMethodMessage("Start a Project button is clicked");
		addRoomPage=PageFactory.initElements(driver,AddRoomPage.class);
		addRoomPage.addRoom(3, "Dining Room");
		Reports.setMethodMessage("Dining Room is selected");
		addRoomPage.clickOnNextBtnOnAddRoom();
		Reports.setMethodMessage("Next button is clicked");
			
		//selecting design package
		selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
		selectYourDesign.selectEliteDesignPackageForLogin();
		Reports.setMethodMessage("Elite Design Package is selected");
		//VerifiyAndAssert.verifyURL(shoppingCartPageUrl);
		shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
		shoppingCartPage.clickOnProceedToCheckoutForLogin();
		Reports.setMethodMessage("Proceed to checkout button is clicked");
		
		//Making payment
		paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
		CardPayment.makingValidPaymentThroughCard();
		Reports.setMethodMessage("Payment through card done");
		//validating promo check box default state that should be un-checked
		paymentInfoPage.validatePromoChkBxState();
		//validating gift check box default state that should be un-checked
		paymentInfoPage.validateGiftChkBxState();
		ExcelUtilities.writeCellData("ShoppingCart", 1, 7, BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue));
					
		//Validating Order Total on Payment Info Page is same as Total on Shopping Cart page when promo/gift check boxes are unchecked
		String orderTotal=ExcelUtilities.getCellData("ShoppingCart", 1, 7);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue), orderTotal);
					
		paymentInfoPage.clickOnPlaceYourOrder();
		Reports.setMethodMessage("Place your order button is clicked");
	    orderConfirmation=PageFactory.initElements(driver,OrderConfirmation.class);
		BusinessFunctions.explctWaitTillElementVisibility(orderConfirmation.str_thanksForOrdering);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(orderConfirmation.str_thanksForOrdering), thanksForOrdering);
			Log.endTestCase("SingleRoom_ElitePackage_Test");
		
		
	}
}
