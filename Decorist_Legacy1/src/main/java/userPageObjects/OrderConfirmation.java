package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderConfirmation {

	//Thanks for ordering a design product string
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div/div[2]/div[1]/div/div[1]")
	public WebElement str_thanksForOrdering;
}
