package com.decoristLegacy.userTestcases;
import java.lang.reflect.Array;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.decoristLegacy.userTestcases.Project_Details_Test;
import com.decoristLegacy.userTestcases.RunnerTest;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import businessActions.AutoSuggestionsUtils;
import businessActions.HandleToggleElement;
import userPageObjects.InspirationPage;
import userPageObjects.ItemDetailsPage;
import utilities.ExcelUtilities;
import utilities.ImageUtils;

public class Item_Details_Test extends RunnerTest{

	@Test
	public static void itemDetailsTest() throws InterruptedException {
		
		ExcelUtilities.setExcel();
		String talkFurnitureStr=ExcelUtilities.getCellData("UI", 17, 1);
		String keepExistingFurnitureStr=ExcelUtilities.getCellData("UI", 18, 1);
		String listMainItemsStr=ExcelUtilities.getCellData("UI", 19, 1);
		String uploadPhoto=ExcelUtilities.getCellData("UI", 20, 1);
		String addLink=ExcelUtilities.getCellData("UI", 21, 1);
		String quantityStr=ExcelUtilities.getCellData("UI", 22, 1);
		String dimensionsStr=ExcelUtilities.getCellData("UI", 23, 1);
		String feetStr=ExcelUtilities.getCellData("UI", 24, 1);
		String retailerStr=ExcelUtilities.getCellData("UI", 25, 1);
		String optionalStr=ExcelUtilities.getCellData("UI", 26, 1);
		String replaceItems=ExcelUtilities.getCellData("UI", 27, 1);
		String itemsToAdd=ExcelUtilities.getCellData("UI", 28, 1);
		String letYourDesignerKnow=ExcelUtilities.getCellData("UI", 29, 1);
		String letYourDesignerKnowTextBox=ExcelUtilities.getCellData("UI", 30, 1);
		String openToPainting=ExcelUtilities.getCellData("UI", 31, 1);
		String openToWallpaper=ExcelUtilities.getCellData("UI", 32, 1);
		String openToWindow=ExcelUtilities.getCellData("UI", 33, 1);
		
		String imagePath3="C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image3.jpeg";
		
		Project_Details_Test.projectDetailsTest();
		
		 Actions action=new Actions(driver);
		itemsDetailsPage=PageFactory.initElements(driver, ItemDetailsPage.class);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_talkFurniture), talkFurnitureStr);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_existingFurnitureText), keepExistingFurnitureStr);
		VerifiyAndAssert.isElementDisplayed(itemsDetailsPage.btn_Yes);
		VerifiyAndAssert.isElementDisplayed(itemsDetailsPage.btn_No);
		
		//If YES is pressed
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_Yes, "YES");
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_readyToContinue,"Ready To Continue");
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.blck_itemsToKeep);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_itemsKeepingText), listMainItemsStr);
		String[] itemName= {"table","bed","chair"};
		BusinessFunctions.setText(itemsDetailsPage.txt_itemName, itemName[0]);
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.drp_itemKeep);
		          //Calling verifyAutosuggestionStrings method
		AutoSuggestionsUtils.verifyAutosuggestionStrings(itemsDetailsPage.drp_itemKeep, itemName[0]);
		AutoSuggestionsUtils.clickOnFirstAutosuggestedValue(itemsDetailsPage.txt_itemName);
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.blck_uploadPhoto);
		
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_uploadPhotoText), uploadPhoto);
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_addLinkText), addLink);
		for (int i=0;i<2;i++) {
			BusinessFunctions.clickUsingActions(itemsDetailsPage.blck_uploadPhotoText, "Upload Photo");
			ImageUtils.uploadImage(imagePath3, "Image3");
		}
		/*BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.blck_Qty);
		        //Verifying UI Elements
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_Qty), quantityStr);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_dimensions), dimensionsStr);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_feet), feetStr);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_retailer), retailerStr);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_retailerOptional), optionalStr);*/
		
		BusinessFunctions.clearTextField(itemsDetailsPage.txt_Qty, "Qty");
		BusinessFunctions.setText(itemsDetailsPage.txt_Qty,"1");
		BusinessFunctions.setText(itemsDetailsPage.txt_dimensionsWidth,"22");
		BusinessFunctions.setText(itemsDetailsPage.txt_dimensionsDepth,"22");
		BusinessFunctions.setText(itemsDetailsPage.txt_feetHeight,"22");
		BusinessFunctions.setText(itemsDetailsPage.txt_retailer,"Demo Retailer");
		
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.btn_addItemToKeep);
		BusinessFunctions.click(itemsDetailsPage.btn_addItemToKeep, "Add Item To Keep");
		
        //Keep2 Item
        
        WebElement keep2Block=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div/div[2]/keep-list/div/div[2]/div[1]"));
        WebElement addItemKeep2TextBox=keep2Block.findElement(By.id("item-keep_value"));
        addItemKeep2TextBox.sendKeys(itemName[1]);
        BusinessFunctions.explctWaitTillElementVisibility(keep2Block.findElement(By.id("item-keep_dropdown")));
        //Calling verifyAutosuggestionStrings method
		AutoSuggestionsUtils.verifyAutosuggestionStrings(itemsDetailsPage.drp_itemKeep, itemName[1]);
		AutoSuggestionsUtils.clickOnFirstAutosuggestedValue(addItemKeep2TextBox);
		//BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.blck_uploadPhoto);
		
        for (int j=0;j<2;j++) {
        	BusinessFunctions.scrollWindowDown();
        	BusinessFunctions.clickUsingJS(itemsDetailsPage.blck_addLink, "Add Link");
        	BusinessFunctions.clickUsingJS(itemsDetailsPage.blck_addLink, "Add Link");
        	WebElement addLinkTextBox=keep2Block.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div/div[2]/keep-list/div/div[2]/div[3]/label[2]/input"));
        	BusinessFunctions.explctWaitTillElementVisibility(addLinkTextBox);
        	BusinessFunctions.clearTextField(addLinkTextBox,"Add Link");
        	addLinkTextBox.sendKeys("https://www.facebook.com");
        }
        
       // BusinessFunctions.click(itemsDetailsPage.btn_addItemToKeep, "Add Item To Keep");
		
		//Keep3 Item
        /*WebElement keep3Block=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div/div[2]/keep-list/div/div[3]/div[1]"));
        WebElement addItemKeep3TextBox=keep3Block.findElement(By.id("item-keep_value"));
        addItemKeep3TextBox.sendKeys("ABCD");
        BusinessFunctions.explctWaitTillElementVisibility(keep3Block.findElement(By.id("item-keep_dropdown")));
        action.moveToElement(addItemKeep3TextBox).sendKeys(Keys.ENTER).build().perform();
		//BusinessFunctions.clickUsingActions(itemsDetailsPage.blck_addLinkText, "Add Link");	
		Thread.sleep(2000);
        BusinessFunctions.selectDropdownByName(itemsDetailsPage.drp_linkphoto, "Photo");
        
        for (int k=0;k<=1;k++) {
        	driver.findElement(By.xpath("//div[starts-with(@id,'default_')]")).click();
        	ImageUtils.uploadImage(imagePath3, "Image3");
        	Thread.sleep(3000);
        }
        
        BusinessFunctions.clearTextField(itemsDetailsPage.txt_Qty, "Qty");
		BusinessFunctions.setText(itemsDetailsPage.txt_Qty,"1");
		BusinessFunctions.setText(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div/div[2]/keep-list/div/div[3]/div[4]/div[3]/div[2]/div[2]/input[1]")),"22");
		BusinessFunctions.setText(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div/div[2]/keep-list/div/div[3]/div[4]/div[3]/div[2]/div[2]/input[2]")),"22");
		BusinessFunctions.setText(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div/div[2]/keep-list/div/div[3]/div[4]/div[3]/div[2]/div[2]/input[3]")),"22");
		//BusinessFunctions.setText(itemsDetailsPage.txt_retailer,"Demo Retailer");
*/		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.btn_readyToContinue);
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_readyToContinue,"Ready To Continue");
		
		      //Items to replace toggle element
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.str_replaceItems);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.str_replaceItems), replaceItems);
		HandleToggleElement.selectItemByName(itemsDetailsPage.blck_replaceItems, "Desk");
		/*BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.btn_readyToContinue);
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_readyToContinue,"Ready To Continue button");*/
		Thread.sleep(2000);
		
		     //Items to add
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.str_addItems);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.str_addItems), itemsToAdd);
		HandleToggleElement.selectItemByName(itemsDetailsPage.blck_addItems, "Table");
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.str_letYourDesignerKnow), letYourDesignerKnow);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.str_letYourDesignerKnowOptional), "Optional");
		VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(itemsDetailsPage.txt_letYourDesignerKnow, "placeholder"), letYourDesignerKnowTextBox);
		BusinessFunctions.setText(itemsDetailsPage.txt_letYourDesignerKnow, "Want to avoid materials that show pet dander? Allergic to feathers?");
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_readyToContinue,"Ready To Continue");
		
		     //Open To Painting
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.blck_openToPainting);
		VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(itemsDetailsPage.blck_openToPainting, "question"), openToPainting);
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_openToPaintingNo, "Open To Painting No button");
		/*BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.btn_readyToContinue);
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_readyToContinue,"Ready To Continue");*/
		Thread.sleep(2000);
		     //Open to wallpaper
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.str_openToWallpaper);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.str_openToWallpaper), openToWallpaper);
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_openToWallpaperNo,"Open to wallpaper NO button");
		/*BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.btn_readyToContinue);
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_readyToContinue,"Ready To Continue");*/
		Thread.sleep(2000);
		     //Open to Window Treatment
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.str_openToWindow);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.str_openToWindow), openToWindow);
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_openToWindowNo,"Open to window NO button");
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.btn_saveAndcontinue);
		
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_saveAndcontinue, "Save & Continue button");
		
		inspirationPage=PageFactory.initElements(driver,InspirationPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(inspirationPage.str_whatStyle);
		
	}
}
