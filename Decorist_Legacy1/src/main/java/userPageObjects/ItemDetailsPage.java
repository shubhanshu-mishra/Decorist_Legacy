package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ItemDetailsPage {

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
}
