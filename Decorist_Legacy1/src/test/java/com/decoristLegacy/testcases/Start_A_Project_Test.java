package com.decoristLegacy.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import businessActions.CardPayment;
import pageobjects.AddRoomPage;
import pageobjects.HeaderObjects;
import pageobjects.SelectYourDesignPage;
import pageobjects.ShoppingCartPage;
import utilities.ImageUtils;
import utilities.PropertyFilesUtils;

public class Start_A_Project_Test extends RunnerTest{

	@Test
	public void start_a_project_test() throws InterruptedException{
		Log.startTestCase("Start_A_Project_Test");
		header=PageFactory.initElements(driver,HeaderObjects.class);
		BusinessFunctions.click(header.lnk_login,"Login button on landing page");
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
			Thread.sleep(2000);
			Log.info("Next button disabled attribute is: "+addRoomPage.bttn_next.getAttribute("disabled"));
			Log.info("Next button is enabled");
			BusinessFunctions.click(addRoomPage.bttn_next,"Next bttn on add room page");
			
			//selecting design package
			selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
			BusinessFunctions.explctWaitTillElementVisibility(selectYourDesign.bttn_clasic);
			VerifiyAndAssert.verifyURL(PropertyFilesUtils.getPropertyFromUrlFile("select_design_package_page_url"));
			BusinessFunctions.click(selectYourDesign.bttn_clasic,"Classic Button");	
			VerifiyAndAssert.verifyURL(PropertyFilesUtils.getPropertyFromUrlFile("shopping_cart_page"));
			shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
			BusinessFunctions.explctWaitTillElementVisibility(shoppingCartPage.bttn_proceedToCheckout);
			BusinessFunctions.click(shoppingCartPage.bttn_proceedToCheckout, "Proceed To Checkout Button");
			VerifiyAndAssert.verifyURL(PropertyFilesUtils.getPropertyFromUrlFile("payment_info_page"));
			
			//Making payment
			CardPayment.makingPaymentThroughCard("shubhanshu","4111111111111111", 3,3, "332", "8663878648","72201");
		}
		
	}
}
