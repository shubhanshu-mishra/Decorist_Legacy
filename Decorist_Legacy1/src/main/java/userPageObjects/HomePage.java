package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	@FindBy(how=How.XPATH,using="//*[@id=\"navbar-links\"]/div[1]/span")
	public WebElement lnk_nameLogin;
	
	@FindBy(how=How.ID,using="header-logout")
	public WebElement lnk_logout;
}
