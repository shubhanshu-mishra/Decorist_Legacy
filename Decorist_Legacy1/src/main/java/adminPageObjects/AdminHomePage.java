package adminPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminHomePage {

	@FindBy(how=How.ID,using="user-tools")
	public WebElement block_headerElements;
	
	@FindBy(how=How.LINK_TEXT,using="Promo Codes")
	public WebElement lnk_promoCodes;
}
