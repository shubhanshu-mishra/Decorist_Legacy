package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RoomDetailsPage {

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
	
	//upload photo icon
	@FindBy(how=How.XPATH,using="//*[@id=\"defaultDropzone\"]/div")
	public WebElement btn_uploadPhotos;
	
	//Click to upload or drag and drop directly from a website Text
	@FindBy(how=How.XPATH,using="//div[@id='defaultDropzone']/p")
	public WebElement blck_uploadPhotosOrDragDrop;
	
}


