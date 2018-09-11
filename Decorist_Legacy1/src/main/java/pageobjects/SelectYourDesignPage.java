package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SelectYourDesignPage {

	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[1]/div[2]/div[2]/div[1]/button")
	public WebElement bttn_clasic;
	
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[1]/div[2]/div[2]/div[2]/button")
	public WebElement bttn_elite;
	
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[1]/div[2]/div[2]/div[3]/button")
	public WebElement bttn_celebrity;
}
