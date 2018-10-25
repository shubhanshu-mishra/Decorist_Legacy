package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;

public class OrderConfirmation extends Base{

	//Thanks for ordering a design product string
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div/div[2]/div[1]/div/div[1]")
	public WebElement str_thanksForOrdering;
	
	//I’M READY, LET’S GO button
	@FindBy(how=How.XPATH,using="//div[contains(text(),'I’M READY, LET’S GO')]")
	public WebElement btn_iamReadyLetsGo;
	
	//Pick a room to start with block
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div/div[3]/div/div")
	public WebElement blck_pickRoomToStartWith;
	
	public static void clickOnImReadyLetsGo() {
		orderConfirmation=PageFactory.initElements(driver, OrderConfirmation.class);
		BusinessFunctions.click(orderConfirmation.btn_iamReadyLetsGo, "I am Ready Lets Go");
		BusinessFunctions.explctWaitTillElementVisibility(orderConfirmation.blck_pickRoomToStartWith);
	}
}
