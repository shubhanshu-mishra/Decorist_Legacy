package com.decoristLegacy.userTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.VerifiyAndAssert;
import userPageObjects.ReviewPage;
import userPageObjects.RoomDetailsPage;
import utilities.ExcelUtilities;

public class ReviewTest extends RunnerTest{

	@Test
	public static void reviewPrintTest() {
		
		ExcelUtilities.setExcel();
		String YourRoomName=ExcelUtilities.getCellData("UI", 1, 11);
		String MessagesBtn=ExcelUtilities.getCellData("UI", 2, 9);
		String SectionCompleteNumbers=ExcelUtilities.getCellData("UI", 3, 9);
		String SectionCompleteText=ExcelUtilities.getCellData("UI", 4, 9);
		String ProjectDetailsReady=ExcelUtilities.getCellData("UI", 5, 9);
		String DesignerWontBeMatched=ExcelUtilities.getCellData("UI", 8, 9);
		String SubmitMyDetailsBtn=ExcelUtilities.getCellData("UI", 12, 9);
		String YourDesignerStr=ExcelUtilities.getCellData("UI", 13, 9);
		String YouWillBeMatched=ExcelUtilities.getCellData("UI", 14, 9);
		String HaveAnyDesignerInMind=ExcelUtilities.getCellData("UI", 15, 9);
		String projectGoals=ExcelUtilities.getCellData("UI", 10, 11);
		
		String roomGoals=ExcelUtilities.getCellData("UI", 10, 11);
		String getImpDetails=ExcelUtilities.getCellData("UI", 11, 11);
		String getImpDetailsFirst=ExcelUtilities.getCellData("UI", 1, 3);
		String notOpenToNewLayout=ExcelUtilities.getCellData("UI", 19, 11);
		String openToNewLayout=ExcelUtilities.getCellData("UI", 18, 11);
		Style_And_Budget_Test.styleAndBudgetTest();

		reviewPage=PageFactory.initElements(driver, ReviewPage.class);
		roomDetails=PageFactory.initElements(driver,RoomDetailsPage.class);
		
		//UI Validations
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(reviewPage.str_yourRoomName), YourRoomName);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_sectionCompleteNumeric), SectionCompleteNumbers);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_sectionCompleteText), SectionCompleteText);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_projectDetailsSubmit), ProjectDetailsReady);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_designerWontBeMatched), DesignerWontBeMatched);
		VerifiyAndAssert.isElementDisplayed(reviewPage.btn_submitMyDetails);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.btn_submitMyDetails), SubmitMyDetailsBtn);
		VerifiyAndAssert.isElementDisplayed(reviewPage.btn_messages);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_messages), MessagesBtn);
		
		//Print functionality (Downloading pdf file and it will get save in Test Data.DownloadedFiles folder)
		BusinessFunctions.clickUsingSikuli(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\sikuliElements\\myprint.PNG", "Print button");
        BusinessFunctions.saveAndPrint("project1");
        
      //Your Designer Block
      	VerifiyAndAssert.isElementDisplayed(reviewPage.blck_yourDesigner);
      	VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_yourDesigner), YourDesignerStr);
      	VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_youWillBeMatched), YouWillBeMatched);
      	VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_haveDesignerInMind), HaveAnyDesignerInMind);
      	
      //Validating Current uses and Desired uses edit link
  		BusinessFunctions.click(reviewPage.editButtons(1), "Current/Desired uses block Edit button");
  		BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_currentlyUseRoom);
  		VerifiyAndAssert.isElementDisplayed(roomDetails.blck_currentlyUseRoom);
  		BusinessFunctions.clickUsingJS(roomDetails.btn_saveAndcontinue, "Save and Continue button");
  		BusinessFunctions.explctWaitTillElementVisibility(reviewPage.str_projectDetailsSubmit);
      	
      //Not open/open to new layout
  		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_newLayout), notOpenToNewLayout);
  		BusinessFunctions.click(reviewPage.editButtons(1), "Not open to new layout Edit button");
  		BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_newFurnitureText);
  		BusinessFunctions.clickUsingJS(roomDetails.btn_Yes, "Open to new furniture Yes button");
  		BusinessFunctions.clickUsingJS(roomDetails.btn_saveAndcontinue, "Save and Continue button");
  		BusinessFunctions.explctWaitTillElementVisibility(reviewPage.str_projectDetailsSubmit);
  		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_newLayout), openToNewLayout);
  		
      //verifying room images
      		for (int i=0;i<4;i++) {
      			String roomImageName=ExcelUtilities.getCellData("Images", i+1, 0);
      			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getAttributeText(reviewPage.roomPhotos(i), "src"), roomImageName);
      		}
      		
      	//Validating Project Goals UI and Functionality
      		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_projectGoals), roomGoals);
      		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_getImportantDetails), getImpDetails);
      		BusinessFunctions.click(reviewPage.editButtons(0), "Project Goals Edit link");
    		BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_letsGetSomeDetails);
    		VerifiyAndAssert.isElementDisplayed(roomDetails.blck_letsGetSomeDetails);
    		BusinessFunctions.clearTextField(roomDetails.txt_roomTextBox, "Overallgoal for this room");
    		BusinessFunctions.setText(roomDetails.txt_roomTextBox, "Let’s get some important details first.");
    		BusinessFunctions.clickUsingJS(roomDetails.btn_saveAndcontinue, "Save and Continue");
    		BusinessFunctions.explctWaitTillElementVisibility(reviewPage.str_projectDetailsSubmit);
      		
      	//Verifying Floor Plan images
      	String floorImageName=ExcelUtilities.getCellData("Images", 4, 0);
      	VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getAttributeText(reviewPage.floorPlanImages(0), "src"), floorImageName);
	}
}
