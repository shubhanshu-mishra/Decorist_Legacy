package com.decoristLegacy.userTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import businessActions.AutoSuggestionsUtils;
import userPageObjects.ReviewPage;
import userPageObjects.RoomDetailsPage;
import userPageObjects.StyleAndBudgetPage;
import utilities.ExcelUtilities;

public class ReviewTest extends RunnerTest{

	@Test
	public static void reviewProjectDetailsTest() {
		Reports.setTestName("ReviewTest");
		Log.startTestCase("ReviewTest");
//		ExcelUtilities.setExcel();
		
		//String MessagesBtn=ExcelUtilities.getCellData("UI", 2, 9);
		//String SectionCompleteNumbers=ExcelUtilities.getCellData("UI", 3, 9);
		
//		String DesignerWontBeMatched=ExcelUtilities.getCellData("UI", 5, 11);
//		String projectGoals=ExcelUtilities.getCellData("UI", 10, 11);
		
		//String roomGoals=ExcelUtilities.getCellData("UI", 10, 11);
		/*String getImpDetails=ExcelUtilities.getCellData("UI", 11, 11);
		String getImpDetailsFirst=ExcelUtilities.getCellData("UI", 1, 3);*/
		
		
		StyleAndBudgetPage.styleAndBudgetDetails();

		/*reviewPage=PageFactory.initElements(driver, ReviewPage.class);
		roomDetails=PageFactory.initElements(driver,RoomDetailsPage.class);*/
		
		//UI Validations
		ReviewPage.reviewPageHeaderUItest();
		
		
        
      //Verifying that designer name entered in text box is shown in auto suggested values and then select designer name entered
		ReviewPage.designerNameTest();
        
      //Your Designer Block
		ReviewPage.yourDesignerBlockUItest();
      	
      //Validating Current uses and Desired uses edit link
  		ReviewPage.currentAndDesiredUsesEditLinksTest();
      	
      //Not open/open to new layout
  		ReviewPage.openNotOpenToNewLayoutTest();
  		
      //verifying room images
  		ReviewPage.validatingRoomImages();
      		
      //Validating Project Goals UI and Functionality
  	    ReviewPage.validateProjectGoalsFunctionality();
      		
      //Verifying Floor Plan images
        ReviewPage.validatingFloorPlanImages();
        
      //Print functionality (Downloading pdf file and it will get save in Test Data.DownloadedFiles folder)
        ReviewPage.printProjectDetails();
      	
      	BusinessFunctions.clickUsingJS(reviewPage.btn_submitMyDetails, "Submit My Details button");
      	Reports.setMethodMessage("Submit My Details button is clicked");
	}
}
