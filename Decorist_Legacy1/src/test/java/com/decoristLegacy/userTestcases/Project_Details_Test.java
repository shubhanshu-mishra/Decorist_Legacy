package com.decoristLegacy.userTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import businessActions.HandleToggleElement;
import userPageObjects.RoomDetailsPage;
import utilities.ExcelUtilities;
import utilities.ImageUtils;

public class Project_Details_Test extends RunnerTest{
	
	@Test
	public static void projectDetailsTest() throws InterruptedException {
		Log.startTestCase("Project_Details_Test");
		
		ExcelUtilities.setExcel();
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
		String clickOnAnyRoomPhotoString=ExcelUtilities.getCellData("UI", 11, 1);
		String yourFloorPlanString=ExcelUtilities.getCellData("UI", 12, 1);
		String aPhotoOfLegible=ExcelUtilities.getCellData("UI", 13, 1);
		
		String imagePath1="C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image1.jpeg";
		String imagePath2="C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image2.jpeg";
		String imagePath3="C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image3.jpeg";
		String imagePath4="C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image4.jpeg";
		
		Ordering_Multiple_Design_Product_Test.orderMultipleDesignProductTest();
		BusinessFunctions.click(orderConfirmation.btn_iamReadyLetsGo, "I am Ready Lets Go");
		BusinessFunctions.explctWaitTillElementVisibility(orderConfirmation.blck_pickRoomToStartWith);
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
		HandleToggleElement.selectItemByName(roomDetails.blck_currentlyUseRoom, itemNameToggle1);
		Thread.sleep(2000);
		BusinessFunctions.clickUsingJS(roomDetails.bttn_readyToContinue, "Ready To Continue");
		Thread.sleep(1000);
		BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_wantUseRoom);
		         //Selecting toggle item
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(roomDetails.blck_wantUseRoomText), wantUseRoomString);
		HandleToggleElement.selectItemByName(roomDetails.blck_wantUseRoom, itemNameToggle2);
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
		
		
		
		//uploading four images for YOUR ROOM PHOTOS
		//ImageUtils.uploadMultipleImages("\"C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image1.jpeg\"","\"C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image2.jpeg\"","\"C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image3.jpeg\"","\"C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image4.jpeg\"");
		for (int i=1;i<6;i++) {
			BusinessFunctions.clickUsingActions(roomDetails.btn_uploadRoomPhotos, "Upload Photos");
			Thread.sleep(3000);
			ImageUtils.uploadImage(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\Images\\image"+i+".jpeg","Image"+i);
			Thread.sleep(5000);
			VerifiyAndAssert.isElementDisplayed(roomDetails.blck_addAComment);
			//VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(roomDetails.blck_clickOnAnyPhoto), clickOnAnyRoomPhotoString);
		}
		
	     //verifying no of photos uploaded
		if (BusinessFunctions.countAllItemsInABlock(roomDetails.blck_roomPhotos,"img")>=4) {
			BusinessFunctions.clickUsingJS(roomDetails.bttn_readyToContinue, "Ready To Continue");
		}
		else {
			BusinessFunctions.failTest();
		}
		BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_yourFloorPlan);
		
		//verifying your floor plan block UI text
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_yourFloorPlanText), yourFloorPlanString);
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_aPhotoOfaLegibleText), aPhotoOfLegible);
		
		//uploading image for YOUR FLOOR PLAN
		for (int j=0;j<2;j++) {
			BusinessFunctions.clickUsingActions(roomDetails.btn_uploadFloorPhotos, "Upload Photos");
			Thread.sleep(2000);
			ImageUtils.uploadImage(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\Images\\image2.jpeg","Image2");
			Thread.sleep(3000);
			//BusinessFunctions.explctWaitTillElementVisibility(roomDetails.btn_saveAndcontinue);
		}
		//verifying no of photos uploaded
		if (BusinessFunctions.countAllItemsInABlock(roomDetails.blck_yourFloorPlan,"img")>=1) {
			BusinessFunctions.click(roomDetails.btn_saveAndcontinue, "Save & Continue");
		}
		else {
			BusinessFunctions.failTest();
		}
		
	}

}
