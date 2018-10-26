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

public class MultipleRooms_MultiplePackages_Test extends RunnerTest{
	 /*UX_7,TC_1*/
	
		@Test
		public static synchronized void multipleRoomsWithMultiplePackages(){
			Reports.setTestName("MultipleRooms_MultiplePackages_Test");
			
			Log.startTestCase("MultipleRooms_MultiplePackages_Test");
			
			PaymentInfoPage.multipleRoomWithMultiplePackagesTest();
			
			Log.endTestCase("MultipleRooms_MultiplePackages_Test");
			
		}
	
}
