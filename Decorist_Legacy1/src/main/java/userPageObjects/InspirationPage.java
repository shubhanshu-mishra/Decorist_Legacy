package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InspirationPage {

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
	@FindBy(how=How.XPATH,using="//div/h4[1]")
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
	
}
