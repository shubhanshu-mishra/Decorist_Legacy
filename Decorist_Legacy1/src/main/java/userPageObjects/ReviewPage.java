package userPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import BusinessRules.Base;

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
}
