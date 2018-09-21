package com.decoristLegacy.userTestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.decoristLegacy.adminTestcases.AddPromocodeTest;
import com.decoristLegacy.adminTestcases.AdminLoginTest;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import businessActions.AddPromoCode;
import businessActions.AddRoomActions;
import businessActions.CardPayment;
import businessActions.ShoppingCart;
import userPageObjects.AddRoomPage;
import userPageObjects.HeaderObjects;
import userPageObjects.OrderConfirmation;
import userPageObjects.PaymentInfoPage;
import userPageObjects.RoomDetailsPage;
import userPageObjects.SelectYourDesignPage;
import userPageObjects.ShoppingCartPage;
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
	public void start_a_project2_test() throws InterruptedException{
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
		
		String letsGetSomeDetails=ExcelUtilities.getCellData("UI", 1, 1);
		String overallGoals=ExcelUtilities.getCellData("UI", 2, 1);
		String keepItBrief=ExcelUtilities.getCellData("UI", 3, 1);
		String didYouMove=ExcelUtilities.getCellData("UI", 4, 1);
		String currentlyUseRoomString=ExcelUtilities.getCellData("UI", 5, 1);
		String itemNameToggle1=ExcelUtilities.getCellData("Start_A_Project_2_Test", 3, 10);
		String itemNameToggle2=ExcelUtilities.getCellData("Start_A_Project_2_Test", 1, 10);
		String wantUseRoomString=ExcelUtilities.getCellData("UI", 6, 1);
		String newFurnitureLayoutString=ExcelUtilities.getCellData("UI", 7, 1);
		String roomPhotosString=ExcelUtilities.getCellData("UI", 8, 1);	
		String fourRoomPhotosString=ExcelUtilities.getCellData("UI", 9, 1);
		String uploadPhotosString=ExcelUtilities.getCellData("UI", 10, 1);
		
		String imagePath=System.getProperty("user.dir")+"\\src\\main\\jav\\TestData\\Images\\image1.jpeg";
		System.out.println("img path:"+imagePath);
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
			CardPayment.makingPaymentThroughCard(name, cardNum, reqMonth, reqYear, cvv, phone, zip);
			
			//Validating CVV string is displayed and its text
			VerifiyAndAssert.isElementDisplayed(paymentInfoPage.str_cvv);
			VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(paymentInfoPage.str_cvv),cvvMsg);
			
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
			BusinessFunctions.click(orderConfirmation.btn_iamReadyLetsGo, "I am Ready Lets Go");
			BusinessFunctions.explctWaitTillElementVisibility(orderConfirmation.blck_pickRoomToStartWith);
			
			/*String linkText=ExcelUtilities.getCellData("Start_A_Project_2_Test", 1, 1);
			int linkCount=BusinessFunctions.countAllItemsInABlock(orderConfirmation.blck_pickRoomToStartWith, "a");
			List<WebElement> links=orderConfirmation.blck_pickRoomToStartWith.findElements(By.tagName("a"));*/
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Room Details Page
			roomDetails=PageFactory.initElements(driver,RoomDetailsPage.class);
			          //verifying UI elements on Room Details page
			VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_letsGetSomeDetails), letsGetSomeDetails);
			VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_overallGoals), overallGoals);
			VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_keepItBrief), keepItBrief);
			VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(roomDetails.txt_roomTextBox, "placeholder"), didYouMove);
			
			BusinessFunctions.setText(roomDetails.txt_roomTextBox, letsGetSomeDetails);
			Thread.sleep(2000);
			BusinessFunctions.click(roomDetails.bttn_readyToContinue, "Ready To Continue");
			BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_currentlyUseRoom);
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(roomDetails.blck_currentlyUseRoomText), currentlyUseRoomString);
			         //Selecting toggle item
			AddRoomActions.selectItemByName(roomDetails.blck_currentlyUseRoom, itemNameToggle1);
			Thread.sleep(2000);
			BusinessFunctions.clickUsingJS(roomDetails.bttn_readyToContinue, "Ready To Continue");
			Thread.sleep(1000);
			BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_wantUseRoom);
			         //Selecting toggle item
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(roomDetails.blck_wantUseRoomText), wantUseRoomString);
			AddRoomActions.selectItemByName(roomDetails.blck_wantUseRoom, itemNameToggle2);
			Thread.sleep(2000);
			BusinessFunctions.clickUsingJS(roomDetails.bttn_readyToContinue, "Ready To Continue");
			BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_newFurniture);
			VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_newFurnitureText), newFurnitureLayoutString);
			BusinessFunctions.clickUsingJS(roomDetails.btn_No, "Furniture Layout No");
			Thread.sleep(2000);
			BusinessFunctions.clickUsingJS(roomDetails.bttn_readyToContinue, "Ready To Continue");
			BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_roomPhotos);
			          //Validating Your Room Photos block UI
			VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_roomPhotosText), roomPhotosString);
			VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_4roomPhotosText), fourRoomPhotosString);
			
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(roomDetails.blck_uploadPhotosOrDragDrop), uploadPhotosString);
			//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_uploadPhotosOrDragDrop),uploadPhotosString);
			BusinessFunctions.click(roomDetails.btn_uploadPhotos, "Upload Photos");
			Thread.sleep(2000);
			ImageUtils.uploadImage("C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image1.jpeg","Image1");
	    }
	}
}
