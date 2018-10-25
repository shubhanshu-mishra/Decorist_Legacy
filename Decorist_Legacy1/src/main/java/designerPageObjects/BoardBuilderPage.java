package designerPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import BusinessRules.Base;

public class BoardBuilderPage extends Base{

	//Item blocks in Finds and Categorization section
	@FindBy(how=How.XPATH,using="//div[@class='bg-item font-xs ng-scope']")
	public WebElement blck_items;
	
	//Images displayed in Finds and Categorization section
	public static WebElement getItemImage(int itemImgIndx) {
		List<WebElement> images=driver.findElements(By.xpath("//img[@draggable='true']"));
		return images.get(itemImgIndx);
	}
	
	//Finds and Categorization link
	@FindBy(how=How.LINK_TEXT,using="Finds and Categorization")
	public WebElement lnk_findsAndCategorization;
	
	//Design Board
	@FindBy(how=How.ID,using="design-board")
	public WebElement blck_designBoard;
}
