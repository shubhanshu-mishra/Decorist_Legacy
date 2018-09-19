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

public class Start_A_Project_1_Test extends RunnerTest{

	/*"Validate start a project functionality with valid data.
	Room count:1
	design package name and quantity:classic,1
	Promo applied:No
	Is gift:No
	Payment status:successful"
*/	
	@Test
	public synchronized void start_a_project1_test(){
		Log.startTestCase("Start_A_Project_Test");
		
		//fetching data
		ExcelUtilities.setExcel();
		String designPackagePageUrl=ExcelUtilities.getCellData("URL",1,1);
		String shoppingCartPageUrl=ExcelUtilities.getCellData("URL",2,1);
		String paymentInfoPageUrl=ExcelUtilities.getCellData("URL",3,1);
		
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
		
		Log.startTestCase("Start_A_Project_Test");
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
			ShoppingCart.writeCartDetails("Start_A_Project_1_Test");
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
			
			//validating gift check box default state that should be un-checked
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getAttributeText(paymentInfoPage.chk_gift, "class"), "ng-empty");
			
			ExcelUtilities.writeCellData("Start_A_Project_1_Test", 1, 7, BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue));
			
			//Validating Order Total on Payment Info Page is same as Total on Shopping Cart page when promo/gift check boxes are unchecked
			String orderTotal=ExcelUtilities.getCellData("Start_A_Project_1_Test", 1, 7);
			VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue), orderTotal);
			
			BusinessFunctions.click(paymentInfoPage.btn_placeYourOrder,"Place Your Order");
			orderConfirmation=PageFactory.initElements(driver,OrderConfirmation.class);
			BusinessFunctions.explctWaitTillElementVisibility(orderConfirmation.str_thanksForOrdering);
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(orderConfirmation.str_thanksForOrdering), thanksForOrdering);
			Log.endTestCase("Start_A_Project_Test");
		}
		
	}
}