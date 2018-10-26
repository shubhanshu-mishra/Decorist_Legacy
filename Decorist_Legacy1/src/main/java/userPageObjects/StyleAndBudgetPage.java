package userPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import utilities.ExcelUtilities;

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
	
	
	public static void styleAndBudgetDetails() {
		Reports.setMethodMessage("styleAndBudgetDetails method is called");
		ExcelUtilities.setExcel();
		String YouAreAlmostDone=ExcelUtilities.getCellData("UI", 1, 9);
		String OverallColorPreference=ExcelUtilities.getCellData("UI", 2, 9);
		String whatsYourBudget=ExcelUtilities.getCellData("UI", 3, 9);
		String thisHelpsDesigner=ExcelUtilities.getCellData("UI", 4, 9);
		/*String neutralPaletteImgSRC=ExcelUtilities.getCellData("ImagesSRC", 2, 1);
		String somePopsofColorImgSRC=ExcelUtilities.getCellData("ImagesSRC", 3, 1);*/
		String specificBudget=ExcelUtilities.getCellData("UI", 5, 9);
		String specificBudgetValue="10";
		/*String saveAndContinueBtn=ExcelUtilities.getCellData("UI", 6, 7);
		String lowBudget=ExcelUtilities.getCellData("UI", 7, 7);
		String mediumBudget=ExcelUtilities.getCellData("UI", 8, 7);
		String highBudget=ExcelUtilities.getCellData("UI", 9, 7);
		
		String boldColorImgSRC=ExcelUtilities.getCellData("ImagesSRC", 4, 1);
		String lowBudgetImgSRC=ExcelUtilities.getCellData("ImagesSRC", 5, 1);
		String mediumBudgetImgSRC=ExcelUtilities.getCellData("ImagesSRC", 6, 1);
		String highBudgetImgSRC=ExcelUtilities.getCellData("ImagesSRC", 7, 1);*/
		
		
		InspirationPage.inspirationSelectionDetails();
		
		styleBudgetPage=PageFactory.initElements(driver,StyleAndBudgetPage.class);
		
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.str_youAreAlmostDone),YouAreAlmostDone);
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.blck_overallPreference);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.str_overallPreference),OverallColorPreference);
		
		List<WebElement> images=driver.findElements(By.xpath("//img[@alt='Room with some colors']"));
		//Validating src for default image displayed
		VerifiyAndAssert.isElementDisplayed(images.get(1));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(images.get(1), "src"), somePopsofColorImgSRC);
		
		//clicking on radio buttons one-by-one and validating displayed images src
		BusinessFunctions.selectRadioButtonFromGroup(styleBudgetPage.blck_overallPreference, "//div/span[@class='radio-button']", "Neutral palette");
		Reports.setMethodMessage("Neutral palette radio button is selected");
		BusinessFunctions.waitForSecs(1000);
		VerifiyAndAssert.isElementDisplayed(images.get(0));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(styleBudgetPage.img_roomColor, "src"), neutralPaletteImgSRC);
		
		BusinessFunctions.selectRadioButtonFromGroup(styleBudgetPage.blck_overallPreference, "//div/span[@class='radio-button']", "Bold color throughout");
		Reports.setMethodMessage("Bold color throughout radio button is selected");
		BusinessFunctions.waitForSecs(1000);
		VerifiyAndAssert.isElementDisplayed(images.get(2));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(images.get(2), "src"), boldColorImgSRC);
		
		BusinessFunctions.clickUsingJS(styleBudgetPage.bttn_readyToContinue, "Ready To Continue");
		Reports.setMethodMessage("Ready To Continue is clicked");
		
		//*****************Budget Section****************************************//
		
		BusinessFunctions.explctWaitTillElementVisibility(styleBudgetPage.str_whatsYourBudget);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.str_whatsYourBudget), whatsYourBudget);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.str_thisHelpsDesigner), thisHelpsDesigner);
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.budgetImages(1));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(styleBudgetPage.budgetImages(1), "src"), mediumBudgetImgSRC);
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.budgetRangeTexts(1));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(StyleAndBudgetPage.budgetRangeTexts(1)).trim(), mediumBudget.trim());
		
		//Selecting Low budget radio buttons and validating image displayed
		Reports.setMethodMessage("Validating:Selecting Low budget radio buttons and validating image displayed");
		BusinessFunctions.clickUsingActions(styleBudgetPage.budgetRadioButtons(0), "Low Budget");
		Reports.setMethodMessage("Low Budget radio button is clicked");
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.budgetRangeTexts(0));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.budgetRangeTexts(0)), lowBudget);
		BusinessFunctions.waitForSecs(1000);
		//VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(styleBudgetPage.budgetImages(0), "src"), lowBudgetImgSRC);
		
		//Selecting High budget radio buttons and validating image displayed
		Reports.setMethodMessage("Validating:Selecting High budget radio buttons and validating image displayed");
		BusinessFunctions.clickUsingActions(styleBudgetPage.budgetRadioButtons(2), "High Budget");
		Reports.setMethodMessage("High Budget radio button is selected");
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.budgetRangeTexts(2));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.budgetRangeTexts(2)), highBudget);
		BusinessFunctions.waitForSecs(1000);
		//VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(styleBudgetPage.budgetImages(2), "src"), highBudgetImgSRC);
		
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.str_specificBudget);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.str_specificBudget), specificBudget);
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.str_dolarSign);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.str_dolarSign), "$");
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.txt_specificBudget);
		VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(styleBudgetPage.txt_specificBudget, "placeholder"), "0");
		BusinessFunctions.setText(styleBudgetPage.txt_specificBudget, specificBudgetValue);
		Reports.setMethodMessage("Entered:"+specificBudgetValue+" in specific budget text box");
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.btn_saveAndContinue), saveAndContinueBtn);
		BusinessFunctions.clickUsingJS(styleBudgetPage.btn_saveAndContinue, "Save & Continue button");
		Reports.setMethodMessage("Save & Continue button is clicked");
	}
	
}
