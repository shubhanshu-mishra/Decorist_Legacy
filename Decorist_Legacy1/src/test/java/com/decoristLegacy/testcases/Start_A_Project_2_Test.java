package com.decoristLegacy.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import businessActions.CardPayment;
import businessActions.ShoppingCart;
import pageobjects.AddRoomPage;
import pageobjects.HeaderObjects;
import pageobjects.PaymentInfoPage;
import pageobjects.SelectYourDesignPage;
import pageobjects.ShoppingCartPage;
import utilities.ExcelUtilities;
import utilities.ImageUtils;

public class Start_A_Project_2_Test extends RunnerTest{

	/*Validate start a project functionality with valid data.
	Room count:3 (initially 2 and later 1 more added)
	design package name and quantity:Elite,3
	Promo applied:Yes
	Is gift:No
	Payment status:successful*/
	
	@Test
	public void start_a_project2_test() {
		Log.startTestCase("Start_A_Project_Test");
		
		//fetching data
		ExcelUtilities.setExcel();
		String name=ExcelUtilities.getCellData("CardDetails",1,0);
		String cardNum=ExcelUtilities.getCellData("CardDetails",1,1);
		String month=ExcelUtilities.getCellData("CardDetails",1,2);
		int reqMonth=Integer.parseInt(month);
		String year=ExcelUtilities.getCellData("CardDetails",1,3);
		int reqYear=Integer.parseInt(year);
		String cvv=ExcelUtilities.getCellData("CardDetails",1,4);
		String phone=ExcelUtilities.getCellData("CardDetails",1,5);
		String zip=ExcelUtilities.getCellData("CardDetails",1,6);
		String cvvMsg=ExcelUtilities.getCellData("CardDetails",1,7).trim();
		
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
				// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			VerifiyAndAssert.verifyURL(shoppingCartPageUrl);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ShoppingCart.writeCartDetails("Start_A_Project_2_Test");
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
			CardPayment.makingPaymentThroughCard(name, cardNum, reqMonth, reqYear, cvv, phone, zip);
			
			//Validating CVV string is displayed and its text
			VerifiyAndAssert.isElementDisplayed(paymentInfoPage.str_cvv);
			VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(paymentInfoPage.str_cvv),cvvMsg);
			
			//validating promo check box default state that should be un-checked
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getAttributeText(paymentInfoPage.chk_promoCode, "class"), "ng-empty");
			
			//Applying promo code
			BusinessFunctions.clickUsingJS(paymentInfoPage.chk_promoCode, "Promo code check box");
	    }
	}
}
