package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPage {

	//popup
	@FindBy(how=How.CLASS_NAME,using="fancy-cover")
	public WebElement ele_popup;
	
	//No thanks link on popup
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[3]/div/div/div[2]/div[1]/div[4]")
	public WebElement lnk_noThanks;
}
