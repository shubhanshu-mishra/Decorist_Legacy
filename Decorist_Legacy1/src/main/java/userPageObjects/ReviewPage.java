package userPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import businessActions.AutoSuggestionsUtils;
import utilities.ExcelUtilities;

public class ReviewPage extends Base{

	//Your.... (Title in header)
	@FindBy(how=How.XPATH,using="//div[contains(@class,'bl-title')]")
	public WebElement str_yourRoomName;
	
	//Messages button
	@FindBy(how=How.XPATH,using="//div[contains(@class,'message-designer')]")
	public WebElement btn_messages;
	
	//Messages button text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'message-designer')]/div[2]")
	public WebElement str_messages;
		
	//section complete numeric (like 4/4)
	@FindBy(how=How.XPATH,using="//div[contains(@class,'complete-number')]")
	public WebElement str_sectionCompleteNumeric;
	
	//section complete text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'complete-text')]")
	public WebElement str_sectionCompleteText;
	
	//Your project details are ready to submit!Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'details-status')]/h4[2]")
	public WebElement str_projectDetailsSubmit;
	
	//Your project details are incomplete.Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'details-status')]/h4[1]")
	public WebElement str_projectDetailsIncomplete;
	
	//We’ve received your project details, Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'details-status')]/h4[3]")
	public WebElement str_receivedProjectDetails;
	
	//Your designer won’t be matched until your details are submitted. You can review your answers below to make any final edits.Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'details-status')]/p[2]")
	public WebElement str_designerWontBeMatched;
	
	//Your designer is waiting! Submit your project details and we’ll find your perfect designer match.Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'details-status')]/p[1]")
	public WebElement str_designerIsWaiting;
	
	//We’re reviewing them now! We’ll match you with a designer based on your style and design needs within one business day.Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'details-status')]/p[3]")
	public WebElement str_weAreReviewingThem;
	
	//Submit My Details button
	@FindBy(how=How.XPATH,using="//div[contains(@class,'details-submit')]/button")
	public WebElement btn_submitMyDetails;
	
	//Print button
	@FindBy(how=How.XPATH,using="//a[@class='d-btn black-inverse btn-md font-14 print-btn']")
	public WebElement btn_print;
	
	//Print text on Print button
	@FindBy(how=How.XPATH,using="//a[@print-element-id='pd-print-list']/span[2]")
	public WebElement str_print;
	
	//Your Designer Block
	@FindBy(how=How.XPATH,using="//div[contains(@class,'matched-designer')]")
	public static WebElement blck_yourDesigner;
	
	//Your Designer Block
	@FindBy(how=How.XPATH,using="//div[contains(@class,'matched-designer')]/h5[1]")
	public WebElement str_yourDesigner;
		
	//You’ll be matched by us!Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'matched-designer')]/h5[2]")
	public WebElement str_youWillBeMatched;
	
	//Have any designers in mind? Let us know and we’ll check their availability first.Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'matched-designer')]/p[1]")
	public WebElement str_haveDesignerInMind;
	
	//Designer Name Text box
	@FindBy(how=How.ID,using="designer-sugest-input_value")
	public WebElement txt_designerName;
	
	//Populated designers dropdown
	@FindBy(how=How.ID,using="designer-sugest-input_dropdown")
	public WebElement drp_designers;
	
	//Selected Designers block
	public static WebElement designerSelected(int designerNameBlockIndex) {
		WebElement block=blck_yourDesigner;
		List<WebElement> designerName=block.findElements(By.xpath("//div[starts-with(@id,'preffered-designer')]"));
		return designerName.get(designerNameBlockIndex);
	}
	
	//Browse .... Designers > Link
	@FindBy(how=How.XPATH,using="//a[contains(@ng-if,'!mainSurveyService.ready')]")
	public WebElement lnk_browseDesigners;
	
	//Room Details Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'project-sections')]/h5")
	public WebElement str_roomDetails;
	
	//Project Goals Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'item-white hidden-xs hidden-sm')]/h5")
	public WebElement str_projectGoals;
	
	//Let’s get some important details first.Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'item-white hidden-xs hidden-sm')]/p")
	public WebElement str_getImportantDetails;
	
	//Edit Buttons
	public static WebElement editButtons(int btnIndex) {
		List<WebElement> editBtns=driver.findElements(By.xpath("//a[contains(@class,'edit-item')]"));
		return editBtns.get(btnIndex);
	}
	
	//Open/Not Open to a new layout Text
	@FindBy(how=How.XPATH,using="//h5[contains(@ng-class,'new-furniture-layout')]")
	public WebElement str_newLayout;
	
	//Room Photos images
	public static WebElement roomPhotos(int imgIndex) {
		List<WebElement> roomImages=driver.findElements(By.xpath("//img[@ng-if='!isVideo(roomPhoto.media_url)']"));
		return roomImages.get(imgIndex);
	}
	
	//Floor Plan images
	public static WebElement floorPlanImages(int imgIndex) {
		List<WebElement> floorImages=driver.findElements(By.xpath("//img[@ng-if='!isVideo(floor.media_url)']"));
		return floorImages.get(imgIndex);
	}
	
	
	//Print functionality (Downloading pdf file and it will get save in Test Data.DownloadedFiles folder)
	public static void printProjectDetails() {
		BusinessFunctions.clickUsingSikuli(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\sikuliElements\\myprint.PNG", "Print button");
        BusinessFunctions.saveAndPrint("project1");
	}
	
	public static void currentAndDesiredUsesEditLinksTest() {
		BusinessFunctions.click(reviewPage.editButtons(1), "Current/Desired uses block Edit button");
  		BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_currentlyUseRoom);
  		VerifiyAndAssert.isElementDisplayed(roomDetails.blck_currentlyUseRoom);
  		BusinessFunctions.clickUsingJS(roomDetails.btn_saveAndcontinue, "Save and Continue button");
  		BusinessFunctions.explctWaitTillElementVisibility(reviewPage.str_projectDetailsSubmit);
	}
	
	public static void openNotOpenToNewLayoutTest() {
		Reports.setMethodMessage("openNotOpenToNewLayoutTest method is called");
		ExcelUtilities.setExcel();
		String notOpenToNewLayout=ExcelUtilities.getCellData("UI", 19, 11);
		String openToNewLayout=ExcelUtilities.getCellData("UI", 18, 11);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_newLayout), notOpenToNewLayout);
  		BusinessFunctions.click(reviewPage.editButtons(1), "Not open to new layout Edit button");
  		BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_newFurnitureText);
  		BusinessFunctions.clickUsingJS(roomDetails.btn_Yes, "Open to new furniture Yes button");
  		BusinessFunctions.clickUsingJS(roomDetails.btn_saveAndcontinue, "Save and Continue button");
  		BusinessFunctions.explctWaitTillElementVisibility(reviewPage.str_projectDetailsSubmit);
  		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_newLayout), openToNewLayout);
	}
	
	public static void validatingRoomImages() {
		for (int i=0;i<4;i++) {
  			String roomImageName=ExcelUtilities.getCellData("Images", i+1, 0);
  			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getAttributeText(reviewPage.roomPhotos(i), "src"), roomImageName);
  		}
	}
	
	public static void validatingFloorPlanImages() {
		String floorImageName=ExcelUtilities.getCellData("Images", 4, 0);
      	VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getAttributeText(reviewPage.floorPlanImages(0), "src"), floorImageName);
	}
	
	public static void validateProjectGoalsFunctionality() {
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_projectGoals), roomGoals);
  		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_getImportantDetails), getImpDetails);
  		BusinessFunctions.click(reviewPage.editButtons(0), "Project Goals Edit link");
		BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_letsGetSomeDetails);
		VerifiyAndAssert.isElementDisplayed(roomDetails.blck_letsGetSomeDetails);
		BusinessFunctions.clearTextField(roomDetails.txt_roomTextBox, "Overallgoal for this room");
		BusinessFunctions.setText(roomDetails.txt_roomTextBox, "Let’s get some important details first.");
		BusinessFunctions.clickUsingJS(roomDetails.btn_saveAndcontinue, "Save and Continue");
		BusinessFunctions.explctWaitTillElementVisibility(reviewPage.str_projectDetailsSubmit);
	}
	
	//Verifying that designer name entered in text box is shown in auto suggested values and then select designer name entered
	public static void designerNameTest() {
		Reports.setMethodMessage("designerNameTest is called");
		ExcelUtilities.setExcel();
		String celebrityDesignerName=ExcelUtilities.getCellData("Designers", 1, 2);
		BusinessFunctions.setText(reviewPage.txt_designerName, celebrityDesignerName);
	  	AutoSuggestionsUtils.verifyAutosuggestionStringsForReviewPage(reviewPage.drp_designers, celebrityDesignerName);
	  	AutoSuggestionsUtils.clickOnFirstAutosuggestedValue(reviewPage.drp_designers);
	  //verifying that block for selected designer name (in green color) is displayed
	  	VerifiyAndAssert.isElementDisplayed(reviewPage.designerSelected(0));
	  	VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(reviewPage.lnk_browseDesigners), celebrityDesignerName);
	}
	
	public static void yourDesignerBlockUItest() {
		Reports.setMethodMessage("yourDesignerBlockUItest method is called");
		ExcelUtilities.setExcel();
		String YourDesignerStr=ExcelUtilities.getCellData("UI", 13, 11);
		String YouWillBeMatched=ExcelUtilities.getCellData("UI", 14, 11);
		String HaveAnyDesignerInMind=ExcelUtilities.getCellData("UI", 15, 11);
		VerifiyAndAssert.isElementDisplayed(reviewPage.blck_yourDesigner);
      	VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_yourDesigner), YourDesignerStr);
      	VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_youWillBeMatched), YouWillBeMatched);
      	VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_haveDesignerInMind), HaveAnyDesignerInMind);
	}
	
	public static void reviewPageHeaderUItest() {
		ExcelUtilities.setExcel();
		String YourRoomName=ExcelUtilities.getCellData("UI", 1, 11);
		String SectionCompleteText=ExcelUtilities.getCellData("UI", 7, 11);
		String ProjectDetailsReady=ExcelUtilities.getCellData("UI", 3, 11);
		String SubmitMyDetailsBtn=ExcelUtilities.getCellData("UI", 8, 11);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(reviewPage.str_yourRoomName), YourRoomName);
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_sectionCompleteNumeric), SectionCompleteNumbers);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_sectionCompleteText), SectionCompleteText);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_projectDetailsSubmit), ProjectDetailsReady);
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_designerWontBeMatched), DesignerWontBeMatched);
		VerifiyAndAssert.isElementDisplayed(reviewPage.btn_submitMyDetails);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.btn_submitMyDetails), SubmitMyDetailsBtn);
		VerifiyAndAssert.isElementDisplayed(reviewPage.btn_messages);
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(reviewPage.str_messages), MessagesBtn);
	}
  	
}
