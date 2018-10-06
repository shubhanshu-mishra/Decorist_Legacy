package com.decoristLegacy.userTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import businessActions.CardPayment;
import businessActions.ShoppingCart;
import userPageObjects.AddRoomPage;
import userPageObjects.HeaderObjects;
import userPageObjects.OrderConfirmation;
import userPageObjects.PaymentInfoPage;
import userPageObjects.SelectYourDesignPage;
import userPageObjects.ShoppingCartPage;
import utilities.ExcelUtilities;
import utilities.ImageUtils;

public class Ordering_Multiple_Design_Product_Test extends RunnerTest{

	
	@Test
	public static void orderMultipleDesignProductTest() throws InterruptedException {
		Log.startTestCase("Ordering_Multiple_Design_Product_Test");
		
		//fetching excel data
		ExcelUtilities.setExcel();
		
		String cardNum=ExcelUtilities.getCellData("CardDetails",1,0);
		String expiryDate=ExcelUtilities.getCellData("CardDetails",1,1);
		String phone=ExcelUtilities.getCellData("CardDetails",1,2);
		String zip=ExcelUtilities.getCellData("CardDetails",1,3);
		
				
		String thanksForOrdering=ExcelUtilities.getCellData("Messages", 1, 1);
		String designPackagePageUrl=ExcelUtilities.getCellData("URL",1,1);
		String shoppingCartPageUrl=ExcelUtilities.getCellData("URL",2,1);
		String paymentInfoPageUrl=ExcelUtilities.getCellData("URL",3,1);
		
		header=PageFactory.initElements(driver,HeaderObjects.class);
		LoginTest.loginTest();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Start A Project
		BusinessFunctions.click(header.bttn_startaProject,"Start A Project button on header");
		if(ImageUtils.countBrokenImages("font-size", "14px")==0) {
			
			//Selecting Room
			ImageUtils.clickOnImageByIndexUsingActions(6, "Home Office");
			ImageUtils.clickOnImageByIndexUsingActions(9, "Nursery");
			addRoomPage=PageFactory.initElements(driver,AddRoomPage.class);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Log.info("Next button disabled attribute is: "+addRoomPage.bttn_next.getAttribute("disabled"));
			BusinessFunctions.click(addRoomPage.bttn_next,"Next bttn on add room page");
			
			//selecting design package
			selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
			BusinessFunctions.explctWaitTillElementVisibility(selectYourDesign.bttn_clasic);
			VerifiyAndAssert.verifyURL(designPackagePageUrl);
			BusinessFunctions.clickUsingJS(selectYourDesign.bttn_elite, "Elite Button");	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			VerifiyAndAssert.verifyURL(shoppingCartPageUrl);
			
			shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
			BusinessFunctions.explctWaitTillElementVisibility(shoppingCartPage.bttn_proceedToCheckout);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//Adding 1 more design packages by clicking on add product + button
			ShoppingCart.addProductButtonClick(1);
			
			//Adding 1 more room by clicking on "Add Another Room" link
			BusinessFunctions.clickUsingJS(shoppingCartPage.lnk_addAnotherRoom,"Add Another Room");
			BusinessFunctions.explctWaitTillElementVisibility(addRoomPage.bttn_next);
			ImageUtils.clickOnImageByIndexUsingActions(11, "Other");
			BusinessFunctions.clickUsingJS(addRoomPage.bttn_next, "Next");
			BusinessFunctions.explctWaitTillElementVisibility(selectYourDesign.bttn_clasic);
			VerifiyAndAssert.verifyURL(designPackagePageUrl);
			BusinessFunctions.clickUsingJS(selectYourDesign.bttn_celebrity, "Celebrity Button");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			VerifiyAndAssert.verifyURL(shoppingCartPageUrl);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			ShoppingCart.writeCartDetails("Start_A_Project_2_Test");
			BusinessFunctions.clickUsingJS(shoppingCartPage.bttn_proceedToCheckout, "Proceed To Checkout Button");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			VerifiyAndAssert.verifyURL(paymentInfoPageUrl);
			
			//Making payment
			paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
			CardPayment.makingPaymentThroughCard(cardNum, expiryDate, phone, zip);
			Thread.sleep(20000);
			//validating promo check box default state that should be un-checked
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getAttributeText(paymentInfoPage.chk_promoCode, "class"), "ng-empty");
			
			//Writing Order Total in excel
			ExcelUtilities.writeCellData("Start_A_Project_2_Test", 1, 7, BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue));
			
			//Applying promo code
			BusinessFunctions.clickUsingJS(paymentInfoPage.chk_promoCode, "Promo code check box");
			
			//Applying promocode
			BusinessFunctions.setText(paymentInfoPage.txt_promoCode,"TestCode19");
			BusinessFunctions.clickUsingJS(paymentInfoPage.btn_promoApply, "Apply");
			BusinessFunctions.explctWaitTillElementVisibility(paymentInfoPage.blck_promoAppliedMsg);
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(paymentInfoPage.blck_promoAppliedMsg), "Your promo code was successfully applied!");
			
			//Writing Order Total in excel after promo code is applied
			ExcelUtilities.writeCellData("Start_A_Project_2_Test", 1, 8, BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue));
			
			BusinessFunctions.click(paymentInfoPage.btn_placeYourOrder,"Place Your Order");
			orderConfirmation=PageFactory.initElements(driver,OrderConfirmation.class);
			BusinessFunctions.explctWaitTillElementVisibility(orderConfirmation.str_thanksForOrdering);
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(orderConfirmation.str_thanksForOrdering), thanksForOrdering);
			Log.endTestCase("Ordering_Multiple_Design_Product_Test");
		}
	}
	
}
