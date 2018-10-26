package userPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import businessActions.AutoSuggestionsUtils;
import businessActions.HandleToggleElement;
import utilities.ExcelUtilities;
import utilities.ImageUtils;

public class ItemDetailsPage extends Base{

	//Now, let’s talk furniture.Text
	@FindBy(how=How.XPATH,using="//div[@data-id='existing-furniture']/h1")
	public WebElement blck_talkFurniture;
	
	//Do you want to keep any of your existing furniture? Text
	@FindBy(how=How.XPATH,using="//div[@data-id='existing-furniture']//div/p")
	public WebElement blck_existingFurnitureText;
	
	//Yes Button
	@FindBy(how=How.XPATH,using="//button[contains(text(),'YES')]")
	public WebElement btn_Yes;
	
	//Items to keep dropdown
	@FindBy(how=How.XPATH,using="//div[@data-id='items-to-keep']")
	public WebElement blck_itemsToKeep;
	
	//List only the main items you’ll be keeping.Text
	@FindBy(how=How.XPATH,using="//div[@data-id='items-to-keep']/h1")
	public WebElement blck_itemsKeepingText;
	
	//Type item name text box
	@FindBy(how=How.ID,using="item-keep_value")
	public WebElement txt_itemName;
	
	//Item keep dropdown (auto suggestion ajax)
	@FindBy(how=How.ID,using="item-keep_dropdown")
	public WebElement drp_itemKeep;
	
	//upload photo block under items to keep block
	@FindBy(how=How.XPATH,using="//*[@id=\"labelDropzone\" and contains(@ng-click,'photo')]")
	public WebElement blck_uploadPhoto;
	
	//Upload a photo of your item Text
	@FindBy(how=How.XPATH,using="//*[@id=\"labelDropzone\"]/span[1]")
	public WebElement blck_uploadPhotoText;
	
	//Add a link block
	@FindBy(how=How.XPATH,using="//*[@id=\"labelDropzone\"]/div")
	public WebElement blck_addLink;
	
	//Add a link to your item Text
	@FindBy(how=How.ID,using="//div[@id='labelDropzone']/span[@text(),'Add a link to your item']")
	public WebElement blck_addLinkText;
	
	//Qty Text in block1
	@FindBy(how=How.XPATH,using="//p[(@text(),'Qty')]")
	public WebElement blck_Qty;
	
	//Qty text box
	@FindBy(how=How.XPATH,using="//div/input[contains(@ng-model,'qty')]")
	public WebElement txt_Qty;
	
	//Dimensions Text in block1
	@FindBy(how=How.XPATH,using="//div/p[@text(),'Dimensions']")
	public WebElement blck_dimensions;
	
	//Dimension Width text box
	@FindBy(how=How.XPATH,using="//div/input[contains(@ng-model,'width')]")
	public WebElement txt_dimensionsWidth;
	
	//Dimension Depth text box
	@FindBy(how=How.XPATH,using="//div/input[contains(@ng-model,'depth')]")
	public WebElement txt_dimensionsDepth;
	
	//Feet Dropdown and its Text in block1
	@FindBy(how=How.XPATH,using="//div/select[@text(),'Feet']")
	public WebElement blck_feet;
	
	//Feet Height text box
	@FindBy(how=How.XPATH,using="//div/input[@placeholder='Height']")
	public WebElement txt_feetHeight;

	//Retailer Text in block1
	@FindBy(how=How.XPATH,using="//div/p[@text(),'Retailer']")
	public WebElement blck_retailer;
	
	//Optional Text with Retailer box
	@FindBy(how=How.XPATH,using="//div/div/p[@text(),'Optional']")
	public WebElement blck_retailerOptional;
	
	//Retailer Text box
	@FindBy(how=How.XPATH,using="//div/input[contains(@ng-model,'retailer')]")
	public WebElement txt_retailer;
	
	//Add an item to keep button
	@FindBy(how=How.XPATH,using="//button[contains(@ng-click,'addKeepItem')]")
	public WebElement btn_addItemToKeep;
	
	//Link/Photo changer
	@FindBy(how=How.TAG_NAME,using="select")
	public WebElement drp_linkphoto;
	
	//No Button
	@FindBy(how=How.XPATH,using="//button[contains(text(),'NO')]")
	public WebElement btn_No;
	
	//Circle Button
	@FindBy(how=How.CLASS_NAME,using="ico-next-question")
	public WebElement btn_readyToContinue;
	
	//What items do you want to replace? Block
	@FindBy(how=How.XPATH,using="//div[@data-id='replace-item']")
	public WebElement blck_replaceItems;
	
	//What items do you want to replace? Text
	@FindBy(how=How.XPATH,using="//div[@data-id='replace-item']/div[1]")
	public WebElement str_replaceItems;
	
	//What items do you want to add?Block
	@FindBy(how=How.XPATH,using="//div[@data-id='add-item']")
	public WebElement blck_addItems;
	
	//What items do you want to add?Text
	@FindBy(how=How.XPATH,using="//div[@data-id='add-item']/div")
	public WebElement str_addItems;
	
	//Let your designer know if you have any detailed item needs. Text
	@FindBy(how=How.XPATH,using="//div[@data-id='add-item']/label/span[1]")
	public WebElement str_letYourDesignerKnow;
	
	//Let your designer know if you have any detailed item needs. Optional Text
	@FindBy(how=How.XPATH,using="//div[@data-id='add-item']/label/span[2]")
	public WebElement str_letYourDesignerKnowOptional;
	
	//Let your designer know if you have any detailed item needs.text box
	@FindBy(how=How.NAME,using="goalBody")
	public WebElement txt_letYourDesignerKnow;
	
	//Are you open to painting your room?Block
	@FindBy(how=How.XPATH,using="//div[@data-id='open-to-painting']")
	public WebElement blck_openToPainting;
	
	//Open to painting block YES button
	@FindBy(how=How.XPATH,using="//div[@data-id='open-to-painting']/button[contains(text(),'YES')]")
	public WebElement btn_openToPaintingYes;
	
	//Open to painting block NO button
	@FindBy(how=How.XPATH,using="//div[@data-id='open-to-painting']/button[contains(text(),'NO')]")
	public WebElement btn_openToPaintingNo;
	
	//Are you open to wallpaper?Text
	@FindBy(how=How.XPATH,using="//div[@data-id='open-to-wallpaper']/p")
	public WebElement str_openToWallpaper;
	
	//Are you open to wallpaper?Block YES button
	@FindBy(how=How.XPATH,using="//div[@data-id='open-to-wallpaper']/button[contains(text(),'YES')]")
	public WebElement btn_openToWallpaperYes;
	
	//Are you open to wallpaper?Block NO button
	@FindBy(how=How.XPATH,using="//div[@data-id='open-to-wallpaper']/button[contains(text(),'YES')]")
	public WebElement btn_openToWallpaperNo;
	
	//Are you open to drapes or window treatments? Block
	@FindBy(how=How.XPATH,using="//div[@data-id='open-to-window']")
	public WebElement blck_openToWindow;
	
	//Are you open to drapes or window treatments? Text
	@FindBy(how=How.XPATH,using="//div[@data-id='open-to-window']/p")
	public WebElement str_openToWindow;
	
	//Are you open to drapes or window treatments?Block YES button
	@FindBy(how=How.XPATH,using="//div[@data-id='open-to-window']/button[contains(text(),'YES')]")
	public WebElement btn_openToWindowYes;
	
	//Are you open to drapes or window treatments?Block NO button
	@FindBy(how=How.XPATH,using="//div[@data-id='open-to-window']/button[contains(text(),'NO')]")
	public WebElement btn_openToWindowNo;
	
	//Save & Continue button
	@FindBy(how=How.XPATH,using="//div[contains(text(),'SAVE & CONTINUE')]")
	public WebElement btn_saveAndcontinue;
	
    public static void userItemDetails(){
		Reports.setMethodMessage("userItemDetails method is called");
		ExcelUtilities.setExcel();
		String talkFurnitureStr=ExcelUtilities.getCellData("UI", 1, 5);
		String keepExistingFurnitureStr=ExcelUtilities.getCellData("UI", 2, 5);
		String listMainItemsStr=ExcelUtilities.getCellData("UI", 3, 5);
		/*String uploadPhoto=ExcelUtilities.getCellData("UI", 4, 5);
		String addLink=ExcelUtilities.getCellData("UI", 21, 1);*/
		String quantityStr=ExcelUtilities.getCellData("UI", 5, 5);
		String dimensionsStr=ExcelUtilities.getCellData("UI", 6, 5);
		String feetStr=ExcelUtilities.getCellData("UI", 7, 5);
		String retailerStr=ExcelUtilities.getCellData("UI", 8, 5);
		String optionalStr=ExcelUtilities.getCellData("UI", 9, 5);
		String replaceItems=ExcelUtilities.getCellData("UI", 10, 5);
		String itemsToAdd=ExcelUtilities.getCellData("UI", 11, 5);
		String letYourDesignerKnow=ExcelUtilities.getCellData("UI", 12, 5);
		String letYourDesignerKnowTextBox=ExcelUtilities.getCellData("UI", 13, 5);
		String openToPainting=ExcelUtilities.getCellData("UI", 14, 5);
		String openToWallpaper=ExcelUtilities.getCellData("UI", 15, 5);
		String openToWindow=ExcelUtilities.getCellData("UI", 16, 5);
		
		String imagePath3="C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image3.jpeg";
		
		RoomDetailsPage.roomDetailsTest();
		
		 Actions action=new Actions(driver);
		itemsDetailsPage=PageFactory.initElements(driver, ItemDetailsPage.class);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_talkFurniture), talkFurnitureStr);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_existingFurnitureText), keepExistingFurnitureStr);
		VerifiyAndAssert.isElementDisplayed(itemsDetailsPage.btn_Yes);
		VerifiyAndAssert.isElementDisplayed(itemsDetailsPage.btn_No);
		
		//If YES is pressed
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_Yes, "YES");
		Reports.setMethodMessage("YES button is clicked");
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_readyToContinue,"Ready To Continue");
		Reports.setMethodMessage("Ready To Continue");
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.blck_itemsToKeep);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_itemsKeepingText), listMainItemsStr);
		String[] itemName= {"table","bed","chair"};
		BusinessFunctions.setText(itemsDetailsPage.txt_itemName, itemName[0]);
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.drp_itemKeep);
		          //Calling verifyAutosuggestionStrings method
		AutoSuggestionsUtils.verifyAutosuggestionStrings(itemsDetailsPage.drp_itemKeep, itemName[0]);
		AutoSuggestionsUtils.clickOnFirstAutosuggestedValue(itemsDetailsPage.txt_itemName);
		Reports.setMethodMessage(itemsDetailsPage.txt_itemName+":is selected");
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.blck_uploadPhoto);
		
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_uploadPhotoText), uploadPhoto);
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.blck_addLinkText), addLink);
		for (int i=0;i<2;i++) {
			BusinessFunctions.clickUsingActions(itemsDetailsPage.blck_uploadPhotoText, "Upload Photo");
			Reports.setMethodMessage("Upload Photo is clicked");
			ImageUtils.uploadImage(imagePath3, "Image3");
			Reports.setMethodMessage("Image uploaded:Image3");
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
		Reports.setMethodMessage("1 is entered in Qty");
		BusinessFunctions.setText(itemsDetailsPage.txt_dimensionsWidth,"22");
		Reports.setMethodMessage("22 is entered in Width");
		BusinessFunctions.setText(itemsDetailsPage.txt_dimensionsDepth,"22");
		Reports.setMethodMessage("22 is entered in Depth");
		BusinessFunctions.setText(itemsDetailsPage.txt_feetHeight,"22");
		Reports.setMethodMessage("22 is entered in Height");
		BusinessFunctions.setText(itemsDetailsPage.txt_retailer,"Demo Retailer");
		Reports.setMethodMessage("Demo Retailer is entered in Optional");
		
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.btn_addItemToKeep);
		BusinessFunctions.click(itemsDetailsPage.btn_addItemToKeep, "Add Item To Keep");
		Reports.setMethodMessage("Add Item To Keep is clicked");
		
        //Keep2 Item
        
		Reports.setMethodMessage("===Keep Item 2=====");
        WebElement keep2Block=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div/div[2]/keep-list/div/div[2]/div[1]"));
        WebElement addItemKeep2TextBox=keep2Block.findElement(By.id("item-keep_value"));
        addItemKeep2TextBox.sendKeys(itemName[1]);
        BusinessFunctions.explctWaitTillElementVisibility(keep2Block.findElement(By.id("item-keep_dropdown")));
        //Calling verifyAutosuggestionStrings method
		AutoSuggestionsUtils.verifyAutosuggestionStrings(itemsDetailsPage.drp_itemKeep, itemName[1]);
		AutoSuggestionsUtils.clickOnFirstAutosuggestedValue(addItemKeep2TextBox);
		Reports.setMethodMessage(addItemKeep2TextBox+":is selected");
		//BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.blck_uploadPhoto);
		
        for (int j=0;j<2;j++) {
        	BusinessFunctions.scrollWindowDown();
        	BusinessFunctions.clickUsingJS(itemsDetailsPage.blck_addLink, "Add Link");
        	BusinessFunctions.clickUsingJS(itemsDetailsPage.blck_addLink, "Add Link");
        	WebElement addLinkTextBox=keep2Block.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div/div[2]/keep-list/div/div[2]/div[3]/label[2]/input"));
        	BusinessFunctions.explctWaitTillElementVisibility(addLinkTextBox);
        	BusinessFunctions.clearTextField(addLinkTextBox,"Add Link");
        	addLinkTextBox.sendKeys("https://www.facebook.com");
        	Reports.setMethodMessage("Add Link is clicked and:https://www.facebook.com is entered");
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
		Reports.setMethodMessage("Ready To Continue button is clicked");
		
		      //Items to replace toggle element
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.str_replaceItems);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.str_replaceItems), replaceItems);
		HandleToggleElement.selectItemByName(itemsDetailsPage.blck_replaceItems, "Desk");
		Reports.setMethodMessage("Desk is selected as toggle element");
		/*BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.btn_readyToContinue);
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_readyToContinue,"Ready To Continue button");*/
		Reports.setMethodMessage("Ready To Continue button is clicked");
		BusinessFunctions.waitForSecs(2000);
		
		     //Items to add
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.str_addItems);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.str_addItems), itemsToAdd);
		HandleToggleElement.selectItemByName(itemsDetailsPage.blck_addItems, "Table");
		Reports.setMethodMessage("Desk is selected as toggle element");
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.str_letYourDesignerKnow), letYourDesignerKnow);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.str_letYourDesignerKnowOptional), "Optional");
		VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(itemsDetailsPage.txt_letYourDesignerKnow, "placeholder"), letYourDesignerKnowTextBox);
		BusinessFunctions.setText(itemsDetailsPage.txt_letYourDesignerKnow, "Want to avoid materials that show pet dander? Allergic to feathers?");
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_readyToContinue,"Ready To Continue");
		Reports.setMethodMessage("Ready To Continue button is clicked");
		
		     //Open To Painting
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.blck_openToPainting);
		VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(itemsDetailsPage.blck_openToPainting, "question"), openToPainting);
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_openToPaintingNo, "Open To Painting No button");
		Reports.setMethodMessage("Open To Painting No button is clicked");
		/*BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.btn_readyToContinue);
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_readyToContinue,"Ready To Continue");*/
		BusinessFunctions.waitForSecs(2000);
		     //Open to wallpaper
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.str_openToWallpaper);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.str_openToWallpaper), openToWallpaper);
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_openToWallpaperNo,"Open to wallpaper NO button");
		Reports.setMethodMessage("Open to wallpaper NO button is clicked");
		/*BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.btn_readyToContinue);
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_readyToContinue,"Ready To Continue");*/
		BusinessFunctions.waitForSecs(2000);
		     //Open to Window Treatment
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.str_openToWindow);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(itemsDetailsPage.str_openToWindow), openToWindow);
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_openToWindowNo,"Open to window NO button");
		Reports.setMethodMessage("Open to window treatment NO button is clicked");
		BusinessFunctions.explctWaitTillElementVisibility(itemsDetailsPage.btn_saveAndcontinue);
		
		BusinessFunctions.clickUsingJS(itemsDetailsPage.btn_saveAndcontinue, "Save & Continue button");
		Reports.setMethodMessage("Save & Continue button is clicked");
		
		inspirationPage=PageFactory.initElements(driver,InspirationPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(inspirationPage.str_whatStyle);
		
	}
}
