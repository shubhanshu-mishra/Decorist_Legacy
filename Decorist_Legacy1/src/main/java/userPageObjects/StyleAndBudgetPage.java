package userPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import BusinessRules.Base;
import BusinessRules.Log;

public class StyleAndBudgetPage extends Base{

	@FindBy(how=How.XPATH,using="//div/h1[contains(@class,'preference-header')]")
	public WebElement str_youAreAlmostDone;
	
	//overall color preference block
	@FindBy(how=How.XPATH,using="//div[contains(@class,'overall-box')]")
	public WebElement blck_overallPreference;
	
	//What’s your overall color preference? Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'overall-box')]/h2")
	public WebElement str_overallPreference;
	
	//Radio Buttons in overall color preference? block
	@FindBy(how=How.XPATH,using="//span[@class='radio-button']")
	public WebElement radio_overallPreference;
	
	//Image Room Colour
	@FindBy(how=How.XPATH,using="//img[@alt='Room with some colors']")
	public WebElement img_roomColor;
	
	//Circle Button
	@FindBy(how=How.CLASS_NAME,using="ico-next-question")
	public WebElement bttn_readyToContinue;
	
	//What’s your budget for furniture, accessories, paint, etc?Text
	@FindBy(how=How.XPATH,using="//div[@data-id='budget']/div/h2")
	public WebElement str_whatsYourBudget;
	
	//This helps your designer recommend the best items curated just for you. This budget will not include tax, shipping, or installation costs.Text
	@FindBy(how=How.XPATH,using="//div[@data-id='budget']/div/p")
	public WebElement str_thisHelpsDesigner;
	
	//3 Images for Budget (Low,Medium and High)
	public static WebElement budgetImages(int imgIndex) {
		Log.info("Working on Budget Images");
		List<WebElement> budgetImgs=driver.findElements(By.xpath("//img[@ng-repeat='answer in budgetAnswers']"));
		Log.info("Budget Images count:"+budgetImgs.size());
		Log.info("selected Image at index:"+imgIndex);
		return budgetImgs.get(imgIndex);
	}
	
	//What’s your budget for furniture, accessories, paint, etc? radio boxes
	public static WebElement budgetRadioButtons(int rdBtnIndex) {
		Log.info("Working on Budget Radio Button");
		List<WebElement> radioButton=driver.findElements(By.xpath("//div[@ng-repeat='answer in budgetAnswers']/span"));
		Log.info("Budget radio button count:"+radioButton.size());
		Log.info("selected radio button at index:"+rdBtnIndex);
		return radioButton.get(rdBtnIndex);
	}
	
	//Low,Medium and High Budget Text with $Amount
	public static WebElement budgetRangeTexts(int budgetRangeIndex) {
		Log.info("Working on Budget Range Texts");
		List<WebElement> budgetRangeTxts=driver.findElements(By.xpath("//div[@ng-repeat='answer in budgetAnswers']/div[contains(@class,'radio-desc')]"));
		Log.info("Budget Range Texts count:"+budgetRangeTxts.size());
		Log.info("selected radio button at index:"+budgetRangeIndex);
		return budgetRangeTxts.get(budgetRangeIndex);
	}
	
	//Do you have a specific budget in mind?Text
	@FindBy(how=How.XPATH,using="//h2[contains(@class,'budget-desc')]")
	public WebElement str_specificBudget;
	
	//$ sign
	@FindBy(how=How.XPATH,using="//span[contains(@class,'dolar-sign')]")
	public WebElement str_dolarSign;
	
	//Specific Budget text box
	@FindBy(how=How.XPATH,using="//input[contains(@class,'budget-input')]")
	public WebElement txt_specificBudget;
	
	//Save & Continue button
	@FindBy(how=How.XPATH,using="//div[contains(@class,'d-btn')]")
	public WebElement btn_saveAndContinue;
	
}
