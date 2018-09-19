package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddRoomPage {

	//Next button
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div/div/div[3]/div[2]/a/div")
	public WebElement bttn_next;
}
