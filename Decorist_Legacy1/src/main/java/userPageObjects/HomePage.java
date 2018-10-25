package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;

public class HomePage extends Base{
	
	@FindBy(how=How.XPATH,using="//*[@id=\"navbar-links\"]/div[1]/span")
	public WebElement lnk_nameLogin;
	
	@FindBy(how=How.ID,using="header-logout")
	public WebElement lnk_logout;
	
	//Hi [username] block on hovering mouse
	@FindBy(how=How.XPATH,using="//*[@id=\"navbar-links\"]/div[1]/span")
	public WebElement blck_nameLogin;
	
	
	public static void clickOnStartAProjectBtn() {
		homePage=PageFactory.initElements(driver, HomePage.class);
		BusinessFunctions.click(header.bttn_startaProject,"Start A Project button on header");
	}
}
