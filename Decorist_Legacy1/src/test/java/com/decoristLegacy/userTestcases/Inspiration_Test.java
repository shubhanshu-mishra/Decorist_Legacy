package com.decoristLegacy.userTestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.VerifiyAndAssert;
import businessActions.InspirationImages;
import userPageObjects.InspirationPage;
import utilities.ExcelUtilities;
import utilities.ImageUtils;

public class Inspiration_Test extends RunnerTest{

	
	@Test
	public static void inspirationTest() throws InterruptedException {
		
		ExcelUtilities.setExcel();
		
		String letSeeWhatStyle=ExcelUtilities.getCellData("UI", 1, 5);
		String selectAtleast3Photos=ExcelUtilities.getCellData("UI", 2, 5);
		String likeAboutThisPhoto=ExcelUtilities.getCellData("UI", 3, 5);
		String overallLook=ExcelUtilities.getCellData("UI", 4, 5);
		String lookForThisRoom=ExcelUtilities.getCellData("UI", 5, 5);
		String refineThisFurther=ExcelUtilities.getCellData("UI", 6, 5);
		String addLinksInCapital=ExcelUtilities.getCellData("UI", 7, 5);
		String addLinksToTheItems=ExcelUtilities.getCellData("UI", 8, 5);
		String page2UploadPhotos=ExcelUtilities.getCellData("UI", 9, 5);
		String addPhotosInCapital=ExcelUtilities.getCellData("UI", 10, 5);
		String commentOnPhotos=ExcelUtilities.getCellData("UI", 11, 5);
		
		Item_Details_Test.itemDetailsTest();
		BusinessFunctions.waitForBrowsertoload();
		
        inspirationPage=PageFactory.initElements(driver,InspirationPage.class);
		
		BusinessFunctions.explctWaitTillElementInvisibility(inspirationPage.str_loadingYourInspiration, "Loading Your Inspiration Text");
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(inspirationPage.str_whatStyle), letSeeWhatStyle);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(inspirationPage.str_select3Photos), selectAtleast3Photos);
		
		//Validation that no image is broken
	    InspirationImages.verifyBrokenInspirationImages(inspirationPage.blck_photos);
		
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
				BusinessFunctions.explctWaitTillElementVisibility(btnComment.get(i));
				BusinessFunctions.clickUsingJS(btnComment.get(i), "Comment button");
				BusinessFunctions.explctWaitTillElementVisibility(inspirationPage.str_whatStyle);
			}
		}
		BusinessFunctions.clickUsingJS(inspirationPage.btn_continue, "Continue button");
		
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
		
		//Uploading Image
		/*BusinessFunctions.scrollWindowDown();
		for (int i=0;i<2;i++) {
			Thread.sleep(1000);
			BusinessFunctions.clickUsingActions(inspirationPage.btn_uploadPhoto, "Upload Photo");
			Thread.sleep(2000);
			ImageUtils.uploadImage(imagePath3, "Image3");
		}*/
		BusinessFunctions.clickUsingJS(inspirationPage.btn_saveAndContinue, "Save and Continue");
	}
}
