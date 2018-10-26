package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.Constants;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import businessActions.HandleToggleElement;
import utilities.ExcelUtilities;
import utilities.ImageUtils;

public class RoomDetailsPage extends Base{

	//xpath of Let’s get some important details first.
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div/div/div[1]/div/div/h1")
	public WebElement blck_letsGetSomeDetails;
	
	//xpath of What are your overall goals for this room?
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div/div/div[1]/div/div/text-question/div/div[1]")
	public WebElement blck_overallGoals;
	
	//xpath of Keep it brief! You’ll be able to provide more details throughout the rest of this form.
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div/div/div[1]/div/div/text-question/div/div[2]/div[1]")
	public WebElement blck_keepItBrief;
	
	//name of text box
	@FindBy(how=How.NAME,using="goalBody")
	public WebElement txt_roomTextBox;
	
	//Circle Button
	@FindBy(how=How.CLASS_NAME,using="ico-next-question")
	public WebElement bttn_readyToContinue;
	
	//Currently use room block
	@FindBy(how=How.XPATH,using="//div[starts-with(@data-id,'currently-use-room')]")
	public WebElement blck_currentlyUseRoom;
	
	//String How do you currently use your *******?
	@FindBy(how=How.XPATH,using="//div[starts-with(@data-id,'currently-use-room')]/div[contains(text(),'How do you')]")
	public WebElement blck_currentlyUseRoomText;
	
	//Want use room block
	@FindBy(how=How.XPATH,using="//div[starts-with(@data-id,'want-use-room')]")
	public WebElement blck_wantUseRoom;
	
	//String How do you want to use your *******?
	@FindBy(how=How.XPATH,using="//div[starts-with(@data-id,'want-use-room')]/div[contains(text(),'How do you')]")
	public WebElement blck_wantUseRoomText;
	
	//New Furniture Layout block
	@FindBy(how=How.XPATH,using="//div[@data-id='new-furniture-layout']")
	public WebElement blck_newFurniture;
	
	//Are you open to a new furniture layout? Text
	@FindBy(how=How.XPATH,using="//div[@data-id='new-furniture-layout']//div/p")
	public WebElement blck_newFurnitureText;
	
	//Furniture Layout block button Yes
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div/div/div[1]/div/div/div[3]/div[1]/button[1]")
	public WebElement btn_Yes;
	
	//Furniture Layout block button No
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div/div/div[1]/div/div/div[3]/div[1]/button[2]")
	public WebElement btn_No;
	
	//Your Room Photos block
	@FindBy(how=How.XPATH,using="//div[@data-id='room-photos']")
	public WebElement blck_roomPhotos;
	
	//Your Room Photos Text
	@FindBy(how=How.XPATH,using="//div[@data-id='room-photos']/h2")
	public WebElement blck_roomPhotosText;
	
	//upload atleast 4 room photos text
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div/div/div[1]/div/div/div[4]/div[1]")
	public WebElement blck_4roomPhotosText;
	
	//upload room photos icon
	@FindBy(how=How.XPATH,using="//*[@id=\"defaultDropzone\"]/div")
	public WebElement btn_uploadRoomPhotos;
	
	//Click to upload or drag and drop directly from a website Text
	@FindBy(how=How.XPATH,using="//div[@id='defaultDropzone']/p")
	public WebElement blck_uploadPhotosOrDragDrop;
	
	//Add a comment block
	@FindBy(how=How.XPATH,using="//p[@class='proxima-semibold']")
	public WebElement blck_addAComment;
	
	//Click on any photo to add a comment Text
	@FindBy(how=How.XPATH,using="//p[@class='font-14']")
	public WebElement blck_clickOnAnyPhoto;
	
	//Your Floor Plan block
	@FindBy(how=How.XPATH,using="//div[@data-id='floor-plan']")
	public WebElement blck_yourFloorPlan;
	
	//Your Floor Plan Text
	@FindBy(how=How.XPATH,using="//div[@data-id='floor-plan']/h2")
	public WebElement blck_yourFloorPlanText;
	
	//A photo of a legible sketch works great like in this example. Or, a digital floor plan if you have it.Text
	@FindBy(how=How.XPATH,using="//div[@data-id='floor-plan']/div[starts-with(@class,'q-upload-desc')]")
	public WebElement blck_aPhotoOfaLegibleText;
	
	//upload floor plan photos icon
	@FindBy(how=How.XPATH,using="//*[@id=\"floorDropzone\"]/div")
	public WebElement btn_uploadFloorPhotos;
	
	//Save & Continue button
	@FindBy(how=How.XPATH,using="//div[contains(text(),'SAVE & CONTINUE')]")
	public WebElement btn_saveAndcontinue;
	
	public static void roomDetailsTest() {
		Reports.setMethodMessage("roomDetailsTest is called");
		ExcelUtilities.setExcel();
		String letsGetSomeDetails=ExcelUtilities.getCellData("UI", 1, 3);
		String overallGoals=ExcelUtilities.getCellData("UI", 2, 3);
		String keepItBrief=ExcelUtilities.getCellData("UI", 3, 3);
		String didYouMove=ExcelUtilities.getCellData("UI", 4, 3);
		String currentlyUseRoomString=ExcelUtilities.getCellData("UI", 5, 3);
		String itemNameToggle1=ExcelUtilities.getCellData("ShoppingCart", 1, 10);
		String itemNameToggle2=ExcelUtilities.getCellData("ShoppingCart", 3, 10);
		String wantUseRoomString=ExcelUtilities.getCellData("UI", 6, 3);
		String newFurnitureLayoutString=ExcelUtilities.getCellData("UI", 7, 3);
		String roomPhotosString=ExcelUtilities.getCellData("UI", 8, 3);	
		String fourRoomPhotosString=ExcelUtilities.getCellData("UI", 9, 3);
		//String uploadPhotosString=ExcelUtilities.getCellData("UI", 10, 1);
		//String clickOnAnyRoomPhotoString=ExcelUtilities.getCellData("UI", 11, 1);
		String yourFloorPlanString=ExcelUtilities.getCellData("UI", 10, 3);
		String aPhotoOfLegible=ExcelUtilities.getCellData("UI", 11, 3);
		
		PaymentInfoPage.multipleRoomWithMultiplePackagesTest();
		orderConfirmation=PageFactory.initElements(driver, OrderConfirmation.class);
		orderConfirmation.clickOnImReadyLetsGo();
		BusinessFunctions.waitForSecs(3000);
		
		
		
		//Room Details Page
		roomDetails=PageFactory.initElements(driver,RoomDetailsPage.class);
		          //verifying UI elements on Room Details page
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_letsGetSomeDetails), letsGetSomeDetails);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_overallGoals), overallGoals);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_keepItBrief), keepItBrief);
		VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(roomDetails.txt_roomTextBox, "placeholder"), didYouMove);
		
		BusinessFunctions.setText(roomDetails.txt_roomTextBox, letsGetSomeDetails);
		Reports.setMethodMessage("Setting text in room text box:"+letsGetSomeDetails);
		BusinessFunctions.waitForSecs(2000);
		BusinessFunctions.click(roomDetails.bttn_readyToContinue, "Ready To Continue");
		Reports.setMethodMessage("Ready To Continue button is clicked");
		BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_currentlyUseRoom);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(roomDetails.blck_currentlyUseRoomText), currentlyUseRoomString);
		         //Selecting toggle item
		HandleToggleElement.selectItemByName(roomDetails.blck_currentlyUseRoom, itemNameToggle1);
		BusinessFunctions.waitForSecs(2000);
		BusinessFunctions.clickUsingJS(roomDetails.bttn_readyToContinue, "Ready To Continue");
		BusinessFunctions.waitForSecs(1000);
		BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_wantUseRoom);
		         //Selecting toggle item
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(roomDetails.blck_wantUseRoomText), wantUseRoomString);
		HandleToggleElement.selectItemByName(roomDetails.blck_wantUseRoom, itemNameToggle2);
		Reports.setMethodMessage("Selecting toggle element as:"+itemNameToggle2);
		BusinessFunctions.waitForSecs(2000);
		BusinessFunctions.clickUsingJS(roomDetails.bttn_readyToContinue, "Ready To Continue");
		Reports.setMethodMessage("Ready To Continue button is clicked");
		BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_newFurniture);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_newFurnitureText), newFurnitureLayoutString);
		BusinessFunctions.clickUsingJS(roomDetails.btn_No, "Furniture Layout No");
		Reports.setMethodMessage("Furniture Layout No button is clicked");
		BusinessFunctions.waitForSecs(2000);
		BusinessFunctions.clickUsingJS(roomDetails.bttn_readyToContinue, "Ready To Continue");
		Reports.setMethodMessage("Ready To Continue button is clicked");
		BusinessFunctions.explctWaitTillElementVisibility(roomDetails.blck_roomPhotos);
		          //Validating Your Room Photos block UI
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_roomPhotosText), roomPhotosString);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_4roomPhotosText), fourRoomPhotosString);
		
		/*VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(roomDetails.blck_uploadPhotosOrDragDrop), uploadPhotosString);*/
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(roomDetails.blck_uploadPhotosOrDragDrop),uploadPhotosString);
		
		
		
		//uploading four images for YOUR ROOM PHOTOS
		
		for (int i=1;i<5;i++) {
			BusinessFunctions.clickUsingSikuli(Constants.uploadPhotos, "Upload Photos");
			Reports.setMethodMessage("clicked on Upload Photos for YOUR ROOM PHOTOS functionality");
			//BusinessFunctions.clickUsingActions(roomDetails.btn_uploadRoomPhotos, "Upload Photos");
			BusinessFunctions.waitForSecs(3000);
			ImageUtils.uploadImage(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\Images\\image"+i+".jpeg","Image"+i);
			Reports.setMethodMessage("Uploaded image with name:"+"Image"+i);
			BusinessFunctions.waitForSecs(5000);
			VerifiyAndAssert.isElementDisplayed(roomDetails.blck_addAComment);
			//VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(roomDetails.blck_clickOnAnyPhoto), clickOnAnyRoomPhotoString);
		}
		
	     //verifying no of photos uploaded
		if (BusinessFunctions.countAllItemsInABlock(roomDetails.blck_roomPhotos,"img")>=4) {
			Reports.setMethodMessage("Validating if no of photos are greater than or equals to 4");
			BusinessFunctions.clickUsingJS(roomDetails.bttn_readyToContinue, "Ready To Continue");
			Reports.setMethodMessage("Ready To Continue button is clicked");
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
			Reports.setMethodMessage("clicked on Upload Photos for YOUR FLOOR PLAN functionality");
			BusinessFunctions.waitForSecs(2000);
			ImageUtils.uploadImage(Constants.floorPlanPic,"Floor Plan Pic");
			Reports.setMethodMessage("Uploaded image:"+Constants.floorPlanPic);
			BusinessFunctions.waitForSecs(3000);
			//BusinessFunctions.explctWaitTillElementVisibility(roomDetails.btn_saveAndcontinue);
		}
		//verifying no of photos uploaded
		if (BusinessFunctions.countAllItemsInABlock(roomDetails.blck_yourFloorPlan,"img")>=1) {
			Reports.setMethodMessage("validating that no of photos are greater than or equals to 1 for YOUR FLOOR PLAN");
			BusinessFunctions.click(roomDetails.btn_saveAndcontinue, "Save & Continue");
			Reports.setMethodMessage("Ready To Continue button is clicked");
		}
		else {
			BusinessFunctions.failTest();
		}
	}
}


