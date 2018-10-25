package designerPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import BusinessRules.Base;
import BusinessRules.Log;

public class YourBoardsPage extends Base{

	//YOUR BOARDS text
	@FindBy(how=How.ID,using="design-board")
	public WebElement str_yourBoards;
	
	//All available Board blocks
	public static WebElement getBoardBlock(int indx) {
		List<WebElement> blocks=driver.findElements(By.xpath("//div[contains(@id,'board_')]"));
		int blocksSize=blocks.size();
		if (blocksSize<1) {
			Log.info("No Block Available");
		}
		Log.info("Returning block having index:"+indx);
		return blocks.get(indx);
	}
}
