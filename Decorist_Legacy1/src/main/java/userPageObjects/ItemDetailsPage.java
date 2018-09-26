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
	@FindBy(how=How.XPATH,using="//*[@id=\\/span")
	public WebElement blck_uploadPhotoText;
	
	//Add a link block
	@FindBy(how=How.ID,using="//*[@id=\"labelDropzone\" and contains(@ng-click,'link')]")
	public WebElement blck_addLink;
	
	//Add a link to your item Text
	@FindBy(how=How.ID,using="//*[@id=\"labelDropzone\" and contains(@ng-click,'link')]/span")
	public WebElement blck_addLinkText;
	
	//No Button
	@FindBy(how=How.XPATH,using="//button[contains(text(),'NO')]")
	public WebElement btn_No;
	
	//Circle Button
	@FindBy(how=How.CLASS_NAME,using="ico-next-question")
	public WebElement btn_readyToContinue;
}
