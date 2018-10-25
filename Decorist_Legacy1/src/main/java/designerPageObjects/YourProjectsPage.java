package designerPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import BusinessRules.Base;
import BusinessRules.Log;

public class YourProjectsPage extends Base{

	//By concepts delivered to client TEXT
	@FindBy(how=How.XPATH,using="//span[@class='search-filters']/h3")
	public WebElement str_byConceptsDelivered;
	
	//All UUIDs
	public static WebElement getUUID(int uuidIndx) {
		List<WebElement> uuIds=driver.findElements(By.xpath("//th[@class='field-item_name']/a/p[2]"));
		return uuIds.get(uuidIndx);
	}
	
	//Text below Concepts (Send concept,Concept weren't sent,None,Waiting for concept)
	public static String getDataForConcepts(int blockIndx) {
		List<WebElement> blocks=driver.findElements(By.xpath("//div[@class='buttons_block']/span[@disabled='disabled']"));
		//WebElement myEle=blocks.get(blockIndx).findElement(By.xpath("//div[@class='buttons_block']/span[2]"));
		return blocks.get(blockIndx).getText();
	}
	
	//ADD DESIGN EDITION button
	@FindBy(how=How.ID,using="add_another_edition")
	public WebElement btn_addDesignEdition;
		
	//Save Solution button
	@FindBy(how=How.ID,using="save_solution_btn")
	public WebElement btn_saveSolution;
		
	//Design Edition Radio buttons
	public static WebElement getDesignEditionRadiobutton(int indx) {
		List<WebElement> radioBttns=driver.findElements(By.xpath("//div[contains(@class,'type_checkbox_div')]/span"));
		String myXpath="//div[contains(@class,'type_checkbox_div')]/span["+(indx+1)+"]";
		String rdBttnName=driver.findElement(By.xpath(myXpath)).getText();
		Log.info(rdBttnName+" is returned");
		return radioBttns.get(indx);
	}
		
	//Add board to this edition button
	@FindBy(how=How.LINK_TEXT,using="Add board to this edition")
	public WebElement btn_addBoardToEdition;
		
	//Board order number text fields
	public static WebElement getBoardOredrNumTxtField(int indx) {
		List<WebElement> boardOrdsTxts=driver.findElements(By.xpath("//input[@class='js_board_order_number_input']"));
		return boardOrdsTxts.get(indx);
	}
		
	//Board (type to search by name): text fields
	public static WebElement getBoardNameTxtField(int indx) {
		List<WebElement> boardNameTxts=driver.findElements(By.xpath("//input[@placeholder='search by board name']"));
		return boardNameTxts.get(indx);
	}
		
	//Auto-suggestion values from Board (type to search by name) dropdown
	public static WebElement getValueFromBoardName(int designEditionIndxDisplayed,int indx) {
		String myXpath="//ul[contains(@id,'ui-id-"+designEditionIndxDisplayed+"')]/li/a";
		List<WebElement> boardNameTxts=driver.findElements(By.xpath(myXpath));
		Log.info("Returning"+boardNameTxts.get(indx).getText());
		return boardNameTxts.get(indx);
	}
		
	//current board image
	@FindBy(how=How.ID,using="current_board_image")
	public WebElement img_currentBoard;
}
