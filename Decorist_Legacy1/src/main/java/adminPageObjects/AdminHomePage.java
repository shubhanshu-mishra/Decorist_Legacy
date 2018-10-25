package adminPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import BusinessRules.Base;
import BusinessRules.Log;

public class AdminHomePage extends Base{

	//Login As link
	@FindBy(how=How.LINK_TEXT,using="Login As")
	public WebElement lnk_loginAs;
		
	@FindBy(how=How.ID,using="user-tools")
	public WebElement block_headerElements;
	
	@FindBy(how=How.LINK_TEXT,using="Promo Codes")
	public WebElement lnk_promoCodes;
	
	//Hi [username] text
	@FindBy(how=How.XPATH,using="//*[@id=\"navbar-links\"]/div[1]/span")
	public WebElement str_username;
	
	@FindBy(how=How.LINK_TEXT,using="Mini Makeover Solutions")
	public WebElement lnk_solutions;
	
	//All action checkboxes
	public static WebElement getActionCheckBox(int chkBxIndx) {
		Log.info("Getting Action Check Boxes");
		List<WebElement> chkBxs=driver.findElements(By.name("_selected_action"));
		Log.info("Action checkboxes size:"+chkBxs.size());
		Log.info("Using check box at index:"+chkBxIndx);
		return chkBxs.get(chkBxIndx);
	}
	
	//Order IDs (Numeric values)
	public static String getOrderIDvalue(int IDIndx) {
		Log.info("Getting Order ID Value");
		List<WebElement> orderIds=driver.findElements(By.className("field-order_number"));
		Log.info("Order IDs size:"+orderIds.size());
		Log.info("Using Order ID at index:"+IDIndx);
		return orderIds.get(IDIndx).getText();
	}
	
	//Solution Keys(value)
	public static String getSolutionKeyValue(int solKeyIndx) {
		Log.info("Getting Solution Key Value");
		List<WebElement> solKeys=driver.findElements(By.className("field-key_"));
		Log.info("Solution Keys size:"+solKeys.size());
		Log.info("Using Solution Key at index:"+solKeyIndx);
		return solKeys.get(solKeyIndx).getText();
	}
	
	//All UUIDs value
	public static String getUUIDvalue(int uuidIndx) {
		List<WebElement> uuIds=driver.findElements(By.xpath("//th[@class='field-item_name']/a/p[2]"));
		return uuIds.get(uuidIndx).getText();
	}
	
	//Solution status values in string
	public static String getSolutionStatusValue(int solStatusIndx) {
		List<WebElement> solStatus=driver.findElements(By.xpath("//span[@class='solution_status']"));
		return solStatus.get(solStatusIndx).getText();
	}
	
	//Client (client data in string)
	public static String getClientDetails(int clientIndx) {
		List<WebElement> clientDetails=driver.findElements(By.xpath("//td[@class='field-client_']"));
		return clientDetails.get(clientIndx).getText();
	}
	
	//Assign Designer dropdown
	@FindBy(how=How.NAME,using="action")
	public WebElement drp_designer;
	
	//GO button
	@FindBy(how=How.NAME,using="index")
	public WebElement btn_go;
	
	//!Attention! text
	@FindBy(how=How.XPATH,using="//div[@class='search-container']/h4[1]")
	public WebElement str_attention;
	
	//To Assign a designer to solutions select a designer from list.text
	@FindBy(how=How.XPATH,using="//div[@class='search-container']/h4[2]")
	public WebElement str_toAssignDesigner;
	
	//To Un-assign designer from solutions don't select any designer.text
	@FindBy(how=How.XPATH,using="//div[@class='search-container']/h4[3]")
	public WebElement str_toUnAssignDesigner;
	
	//Designer dropdown on assign designer page
	@FindBy(how=How.ID,using="id_designer")
	public WebElement drp_assignDesigner;
	
	//Assign designer to solution button
	@FindBy(how=How.NAME,using="apply")
	public WebElement btn_assignDesignerToSolution;
	
	//Successfully assigned designer [name] to [count] orders.text
	@FindBy(how=How.XPATH,using="//div[@class='alert alert-info']")
	public WebElement str_successfullyAssignDesigner;
	
	//Log out button
	@FindBy(how=How.LINK_TEXT,using="Log out")
	public WebElement btn_logOut;
}
