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

public class MultipleRooms_MultiplePackages_Test extends RunnerTest{
	 /*UX_7,TC_1*/
	
		@Test
		public static synchronized void multipleRoomsWithMultiplePackages(){
			Log.startTestCase("MultipleRooms_MultiplePackages_Test");
			
			//fetching data
			ExcelUtilities.setExcel();
			String thanksForOrdering=ExcelUtilities.getCellData("Messages", 2, 1);
			
			header=PageFactory.initElements(driver,HeaderObjects.class);
			Login.loginAsClient();
			BusinessFunctions.waitForSecs(2000);
			
			//Start A Project
			homePage=PageFactory.initElements(driver, HomePage.class);
			homePage.clickOnStartAProjectBtn();
				
			//Selecting Room
			addRoomPage=PageFactory.initElements(driver,AddRoomPage.class);
			addRoomPage.addRoom(6, "Home Office");
			addRoomPage.addRoom(9, "Nursery");
			addRoomPage.clickOnNextBtnOnAddRoom();
		
			//selecting design package
			selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
			selectYourDesign.selectEliteDesignPackageForLogin();
			BusinessFunctions.waitForSecs(2000);
				
			shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
			BusinessFunctions.explctWaitTillElementVisibility(shoppingCartPage.bttn_proceedToCheckout);
			BusinessFunctions.waitForSecs(1000);
				
			//Adding 1 more design packages by clicking on add product + button
			ShoppingCart.addProductButtonClick(1);
				
			//Adding 1 more room by clicking on "Add Another Room" link
			BusinessFunctions.clickUsingJS(shoppingCartPage.lnk_addAnotherRoom,"Add Another Room");
			BusinessFunctions.explctWaitTillElementVisibility(addRoomPage.bttn_next);
			addRoomPage.addRoom(11, "Other");
			addRoomPage.clickOnNextBtnOnAddRoom();
			BusinessFunctions.explctWaitTillElementVisibility(selectYourDesign.bttn_clasic);
			selectYourDesign.selectCelebrityDesignPackageForLogin();
			BusinessFunctions.waitForSecs(1000);
			shoppingCartPage.clickOnProceedToCheckoutForLogin();
			BusinessFunctions.waitForSecs(2000);
				
			//Making payment
			paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
			CardPayment.makingValidPaymentThroughCard();
			//validating promo check box default state that should be un-checked
			paymentInfoPage.validatePromoChkBxState();
			//validating gift check box default state that should be un-checked
			paymentInfoPage.validateGiftChkBxState();
				
			ExcelUtilities.writeCellData("ShoppingCart", 1, 7, BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue));
				
			//Writing Order Total in excel
			ExcelUtilities.writeCellData("ShoppingCart", 1, 8, BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue));
				
				//Applying promo code
				/*BusinessFunctions.clickUsingJS(paymentInfoPage.chk_promoCode, "Promo code check box");
				
				//Applying promocode
				BusinessFunctions.setText(paymentInfoPage.txt_promoCode,"TestCode19");
				BusinessFunctions.clickUsingJS(paymentInfoPage.btn_promoApply, "Apply");
				BusinessFunctions.explctWaitTillElementVisibility(paymentInfoPage.blck_promoAppliedMsg);
				VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(paymentInfoPage.blck_promoAppliedMsg), "Your promo code was successfully applied!");*/
				
				//Writing Order Total in excel after promo code is applied
			ExcelUtilities.writeCellData("ShoppingCart", 1, 8, BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue));
				
			paymentInfoPage.clickOnPlaceYourOrder();
			orderConfirmation=PageFactory.initElements(driver,OrderConfirmation.class);
			BusinessFunctions.explctWaitTillElementVisibility(orderConfirmation.str_thanksForOrdering);
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(orderConfirmation.str_thanksForOrdering), thanksForOrdering);
			Log.endTestCase("MultipleRooms_MultiplePackages_Test");
			
		}
	
}
