package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import utilities.ImageUtils;

public class AddRoomPage extends Base{

	//Next button
	@FindBy(how=How.XPATH,using="//a[contains(@class,'next-btn')]")
	public WebElement bttn_next;
	
	//Which rooms can we help you design? text
	@FindBy(how=How.XPATH,using="//h1[contains(@class,'headline text-center')]")
	public WebElement str_whichRooms;
	
	public static void addRoom(int index,String roomName) {
		addRoomPage=PageFactory.initElements(driver,AddRoomPage.class);
      if(ImageUtils.countBrokenImages("font-size", "14px")==0) {
		ImageUtils.clickOnImageByIndexUsingActions(index, roomName);
		BusinessFunctions.waitForSecs(2000);	
		Log.info("Next button is enabled");
	   }
    }
	
	public static void clickOnNextBtnOnAddRoom() {
   	 addRoomPage=PageFactory.initElements(driver,AddRoomPage.class);
   	 BusinessFunctions.click(addRoomPage.bttn_next,"Next bttn on add room page");

    }
}
