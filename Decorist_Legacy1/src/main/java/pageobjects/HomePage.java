package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div/div[1]/svg")
	public WebElement icon_msg;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"navbar-links\"]/div[1]/span")
	public WebElement lnk_nameLogin;
	
	@FindBy(how=How.ID,using="header-logout")
	public WebElement lnk_logout;
}
