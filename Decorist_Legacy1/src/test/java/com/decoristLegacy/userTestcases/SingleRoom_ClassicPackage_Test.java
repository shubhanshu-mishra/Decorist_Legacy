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

public class SingleRoom_ClassicPackage_Test extends RunnerTest{

	/*UX_4,TC_1*/
	
	@Test
	public synchronized void singleRoomWithClassicPackage(){
		Log.startTestCase("SingleRoom_ClassicPackage_Test");
		
		//fetching data
		ExcelUtilities.setExcel();
		String designPackagePageUrl=ExcelUtilities.getCellData("URL",3,1);
		String shoppingCartPageUrl=ExcelUtilities.getCellData("URL",4,1);
		String paymentInfoPageUrl=ExcelUtilities.getCellData("URL",5,1);
		
		String cardNum=ExcelUtilities.getCellData("CardDetails",1,0);
		System.out.println("card num:"+cardNum);
		String expiryDate=ExcelUtilities.getCellData("CardDetails",1,1);
		String phone=ExcelUtilities.getCellData("CardDetails",1,2);
		String zip=ExcelUtilities.getCellData("CardDetails",1,3);
		
		String thanksForOrdering=ExcelUtilities.getCellData("Messages", 2, 1);
		
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
			ImageUtils.clickOnImageByIndexUsingActions(3, "Dining Room");
			addRoomPage=PageFactory.initElements(driver,AddRoomPage.class);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.info("Next button disabled attribute is: "+addRoomPage.bttn_next.getAttribute("disabled"));
			Log.info("Next button is enabled");
			BusinessFunctions.click(addRoomPage.bttn_next,"Next bttn on add room page");
			
			//selecting design package
			selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
			BusinessFunctions.explctWaitTillElementVisibility(selectYourDesign.bttn_clasic);
			VerifiyAndAssert.verifyURL(designPackagePageUrl);
			BusinessFunctions.clickUsingJS(selectYourDesign.bttn_clasic, "Classic Button");	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			VerifiyAndAssert.verifyURL(shoppingCartPageUrl);
			
			shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
			BusinessFunctions.explctWaitTillElementVisibility(shoppingCartPage.bttn_proceedToCheckout);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ShoppingCart.writeCartDetails("ShoppingCart");
			BusinessFunctions.clickUsingJS(shoppingCartPage.bttn_proceedToCheckout, "Proceed To Checkout Button");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			VerifiyAndAssert.verifyURL(paymentInfoPageUrl);
			
			//Making payment
			paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
			CardPayment.makingPaymentThroughCard(cardNum, expiryDate, phone, zip);
			
			//validating promo check box default state that should be un-checked
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getAttributeText(paymentInfoPage.chk_promoCode, "class"), "ng-empty");
			
			//validating gift check box default state that should be un-checked
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getAttributeText(paymentInfoPage.chk_gift, "class"), "ng-empty");
			
			ExcelUtilities.writeCellData("ShoppingCart", 1, 7, BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue));
			
			//Validating Order Total on Payment Info Page is same as Total on Shopping Cart page when promo/gift check boxes are unchecked
			String orderTotal=ExcelUtilities.getCellData("ShoppingCart", 1, 7);
			VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue), orderTotal);
			
			BusinessFunctions.click(paymentInfoPage.btn_placeYourOrder,"Place Your Order");
			orderConfirmation=PageFactory.initElements(driver,OrderConfirmation.class);
			BusinessFunctions.explctWaitTillElementVisibility(orderConfirmation.str_thanksForOrdering);
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(orderConfirmation.str_thanksForOrdering), thanksForOrdering);
			Log.endTestCase("SingleRoom_ClassicPackage_Test");
		}
		
	}
}
