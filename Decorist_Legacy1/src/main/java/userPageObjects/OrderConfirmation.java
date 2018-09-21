package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderConfirmation {

	//Thanks for ordering a design product string
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div/div[2]/div[1]/div/div[1]")
	public WebElement str_thanksForOrdering;
	
	//I’M READY, LET’S GO button
	@FindBy(how=How.XPATH,using="//div[contains(text(),'I’M READY, LET’S GO')]")
	public WebElement btn_iamReadyLetsGo;
	
	//Pick a room to start with block
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div/div[3]/div/div")
	public WebElement blck_pickRoomToStartWith;
}
