package userPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import businessActions.InspirationImages;
import utilities.ExcelUtilities;

public class InspirationPage extends Base{

	//*********************Inspiration Page 1*****************************************//
	                       
	//Let’s see what style you’d like for your....Text
	@FindBy(how=How.XPATH,using="//div[contains(@ng-init,'unsortedRoomOptions')]/h1")
	public WebElement str_whatStyle;
	
	//Loading Your Inspiration...Text
	@FindBy(how=How.XPATH,using="//div[starts-with(@class,'pins-loader')]/div[3]")
	public WebElement str_loadingYourInspiration;
	
	//Select at least 3 photos that best reflect the look and feel you want.Text
	@FindBy(how=How.XPATH,using="//div/h4")
	public WebElement str_select3Photos;
	
	//Block where the photos are displayed
	@FindBy(how=How.XPATH,using="//div[starts-with(@class,'pins-wrap')]")
	public WebElement blck_photos;
	
	//Clicked Image pop-up block
	@FindBy(how=How.ID,using="shopItemCarousel")
	public WebElement blck_clickedImgPopup;
	
	//What do you like about this photo? Is there anything you dislike?Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'image-comment')]/div[1]")
	public WebElement str_likeAboutThisPhoto;
	
	//Is it the overall look and feel? Colors or patterns? A specific furniture item?Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'image-comment')]/div[contains(@class,'copy-regular')]")
	public WebElement str_overallLook;
	
	//Comment Text Box
	@FindBy(how=How.TAG_NAME,using="textarea")
	public WebElement txt_comment;
	
	//Comment button
	@FindBy(how=How.XPATH,using="//button[starts-with(@ng-show,'showButtonComment')]")
	public WebElement btn_comment;
	
	//CONTINUE button
	@FindBy(how=How.LINK_TEXT,using="CONTINUE")
	public WebElement btn_continue;
	
	//*********************Inspiration Page 2*****************************************//
	
	//You like a mostly .... look for this room!Text
	@FindBy(how=How.XPATH,using="//div/h1")
	public WebElement str_lookForThisRoom;
	
	//Refine this further for your designer by adding your own links or photos below.
	@FindBy(how=How.XPATH,using="//div/h4[contains(@class,'subhead')]")
	public WebElement str_refineThisFurther;
	
	//ADD LINKS Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'question-wrap')]/h5")
	public WebElement str_addLinks;
	
	/*Add links to the items you love or any Pinterest boards or Houzz pages you’ve been working on. Simply copy and paste the full links below (and make sure your Pinterest boards aren’t private!)
	Upload room photos or other design inspiration below and add comments. If you don’t have any saved, take a look at our Pinterest board for inspiration!*/ 
	@FindBy(how=How.XPATH,using="//div[contains(@class,'question-wrap')]/div[@class='hidden-xs']/p[1]")
	public WebElement str_pinterestBoards;
	
	//Add Links text box
	@FindBy(how=How.XPATH,using="//input[@ng-value='answer.text']")
	public WebElement txt_addLink;
	
	//+ Add a Link link
	@FindBy(how=How.XPATH,using="//button[contains(@ng-click,'addLink')]")
	public WebElement lnk_addALink;
	
	//ADD PHOTOS Text
	@FindBy(how=How.XPATH,using="//div[contains(@ng-init,'arrPhotos')]/div/h5")
	public WebElement str_addPhotos;
	
	//Comments on photos are required.
	@FindBy(how=How.XPATH,using="//div[contains(@class,'flex')]/p")
	public WebElement str_commentsAreRequired;
	
	//Upload Photo button
	@FindBy(how=How.XPATH,using="//div[contains(@class,'i-upload')]")
	public WebElement btn_uploadPhoto;
	
	//SAVE & CONTINUE button
	@FindBy(how=How.XPATH,using="//div[contains(@class,'d-btn pink')]")
	public WebElement btn_saveAndContinue;
	
	
	public static void inspirationSelectionDetails() {
		Reports.setMethodMessage("inspirationSelectionDetails method is called");
        ExcelUtilities.setExcel();
		
		String letSeeWhatStyle=ExcelUtilities.getCellData("UI", 1, 7);
		String selectAtleast3Photos=ExcelUtilities.getCellData("UI", 2, 7);
		String likeAboutThisPhoto=ExcelUtilities.getCellData("UI", 3, 7);
		String overallLook=ExcelUtilities.getCellData("UI", 4, 7);
		String lookForThisRoom=ExcelUtilities.getCellData("UI", 5, 7);
		String refineThisFurther=ExcelUtilities.getCellData("UI", 6, 7);
		String addLinksInCapital=ExcelUtilities.getCellData("UI", 7, 7);
		String addLinksToTheItems=ExcelUtilities.getCellData("UI", 8, 7);
		String page2UploadPhotos=ExcelUtilities.getCellData("UI", 9, 7);
		String addPhotosInCapital=ExcelUtilities.getCellData("UI", 10, 7);
		String commentOnPhotos=ExcelUtilities.getCellData("UI", 11, 7);
		
		ItemDetailsPage.userItemDetails();
		BusinessFunctions.waitForBrowsertoload();
		
        inspirationPage=PageFactory.initElements(driver,InspirationPage.class);
		
		BusinessFunctions.explctWaitTillElementInvisibility(inspirationPage.str_loadingYourInspiration, "Loading Your Inspiration Text");
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(inspirationPage.str_whatStyle), letSeeWhatStyle);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(inspirationPage.str_select3Photos), selectAtleast3Photos);
		
		//Validation that no image is broken
	   // InspirationImages.verifyBrokenInspirationImages(inspirationPage.blck_photos);
		Reports.setMethodMessage("Validated that no image is broken");
		
		List<WebElement> imgPopup=driver.findElements(By.id("shopItemCarousel"));
		
		List<WebElement> likeAboutThis=driver.findElements(By.xpath("//div[contains(@class,'image-comment')]/div[1]"));
		
		List<WebElement> overallLookEle=driver.findElements(By.xpath("//div[contains(@class,'image-comment')]/div[contains(@class,'copy-regular')]"));
		
		List<WebElement> textBoxes=driver.findElements(By.tagName("textarea"));
		
		List<WebElement> btnComment=driver.findElements(By.xpath("//button[starts-with(@ng-show,'showButtonComment')]"));
		
		//selecting images one-by-one
		for (int i=2;i<10;i++) {
			if (i%2==0) {
				InspirationImages.clickOnInspirationImageByIndex(inspirationPage.blck_photos, i);
				for (int j=i/2;j<i/2;j++) {
					BusinessFunctions.explctWaitTillElementVisibility(imgPopup.get(j));
					VerifiyAndAssert.verifyAttributeIsNotNull(inspirationPage.blck_clickedImgPopup, "style");
					VerifiyAndAssert.verifyText(likeAboutThis.get(j).getText(), likeAboutThisPhoto);
					VerifiyAndAssert.verifyText(overallLookEle.get(j).getText(), overallLook);
				}
				BusinessFunctions.setText(textBoxes.get(i), "This is very good image.I like it..");
				Reports.setMethodMessage("Image at index:"+i+" is clicked and This is very good image.I like it.. is entered");
				BusinessFunctions.explctWaitTillElementVisibility(btnComment.get(i));
				BusinessFunctions.clickUsingJS(btnComment.get(i), "Comment button");
				BusinessFunctions.explctWaitTillElementVisibility(inspirationPage.str_whatStyle);
			}
		}
		BusinessFunctions.clickUsingJS(inspirationPage.btn_continue, "Continue button");
		Reports.setMethodMessage("Continue button is clicked");
		
		BusinessFunctions.explctWaitTillElementVisibility(inspirationPage.str_refineThisFurther);
		//Validating Inspiration Page2 UI
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(inspirationPage.str_lookForThisRoom), lookForThisRoom);
		BusinessFunctions.explctWaitTillElementVisibility(inspirationPage.str_refineThisFurther);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(inspirationPage.str_refineThisFurther), refineThisFurther);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(inspirationPage.str_addLinks), addLinksInCapital);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(inspirationPage.str_pinterestBoards), addLinksToTheItems);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(inspirationPage.str_pinterestBoards), page2UploadPhotos);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(inspirationPage.str_addPhotos), addPhotosInCapital);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(inspirationPage.str_commentsAreRequired), commentOnPhotos);
		
		//Entering Link
		BusinessFunctions.setText(inspirationPage.txt_addLink, "www.facebook.com/shubhanshu");
		BusinessFunctions.clickUsingJS(inspirationPage.lnk_addALink, "+ Add a Link");
		List<WebElement> linkTextBoxes=driver.findElements(By.xpath("//input[@ng-value='answer.text']"));
		BusinessFunctions.setText(linkTextBoxes.get(1), "www.facebook.com/shubhanshu");
		Reports.setMethodMessage("www.facebook.com/shubhanshu is entered as link");
		
		//**********Below code is to upload image on Inspiration Page-2**********************//
		//Uploading Image
		/*BusinessFunctions.scrollWindowDown();
		for (int i=0;i<2;i++) {
			Thread.sleep(1000);
			BusinessFunctions.clickUsingActions(inspirationPage.btn_uploadPhoto, "Upload Photo");
			Thread.sleep(2000);
			ImageUtils.uploadImage(imagePath3, "Image3");
		}*/
		BusinessFunctions.clickUsingJS(inspirationPage.btn_saveAndContinue, "Save and Continue");
		Reports.setMethodMessage("Save and Continue is clicked");
	}
	
}
