package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartPage {

	//Proceed to checkout button
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[2]/div/div[2]/div/div[2]/div[2]")
	public WebElement bttn_proceedToCheckout;
	
	//Cart Wrapper Block
	@FindBy(how=How.CLASS_NAME,using="cart-wrapper")
	public WebElement block_cartWrapper;
	
	//Add Another Room link
	@FindBy(how=How.LINK_TEXT,using="Add Another Room")
	public WebElement lnk_addAnotherRoom;
	
	//Order Summary 
}
