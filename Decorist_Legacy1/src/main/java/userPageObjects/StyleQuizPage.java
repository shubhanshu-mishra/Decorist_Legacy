package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.VerifiyAndAssert;
import utilities.ExcelUtilities;

public class StyleQuizPage extends Base{

	//IFrame
	@FindBy(how=How.ID,using="typeform-full")
	public WebElement frame_styleQuiz;
	
	//Which style of sofa do you like best?* text
	@FindBy(how=How.XPATH,using="//*[@id=\"rctsiQNLov9d\"]/div/div[2]/span")
	public WebElement str_styleOfSofa;
	
	//sofa-A
	@FindBy(how=How.ID,using="oERbdGCTU5Ye")
	public WebElement blck_sofaA;
	
	//Great choice! Do you prefer a formal or more relaxed living room?* text
	@FindBy(how=How.XPATH,using="//*[@id=\"JFWvLnTuHP0B\"]/div/div[2]/span")
	public WebElement str_livingRoom;
	
	//living room-A
	@FindBy(how=How.ID,using="Yjvdnj3zD0B5")
	public WebElement blck_livingRoomA;
	
	//Which bedroom would you rather relax in?*
	@FindBy(how=How.XPATH,using="//*[@id=\"qf847Al8fOpp\"]/div/div[2]/span")
	public WebElement str_bedRoom;
	
	//Bedroom-A
	@FindBy(how=How.ID,using="lqpJNEasulzJ")
	public WebElement blck_bedRoomA;
	
	//We are loving your style! Next, how do you feel about color?* text
	@FindBy(how=How.XPATH,using="//*[@id=\"AcuDXOdbs85L\"]/div/div[2]/span")
	public WebElement str_aboutColor;
	
	//Bedroom-A
	@FindBy(how=How.ID,using="DiRRXmUziWJ1")
	public WebElement blck_colorA;
	
	//How do you feel about patterns?* text
	@FindBy(how=How.XPATH,using="//*[@id=\"wVJvHcsi4669\"]/div/div[2]/span")
	public WebElement str_aboutPattern;
	
	//Pattern-A
	@FindBy(how=How.ID,using="YpSvJsPxQq2H")
	public WebElement blck_patternA;
	
	//Enter your email to get your style result!* text
	@FindBy(how=How.XPATH,using="//*[@id=\"NvIg97ZB1QYy\"]/div/div[2]/span")
	public WebElement str_enterEmail;
	
	//Enter Email text box
	@FindBy(how=How.XPATH,using="//*[@id=\"NvIg97ZB1QYy\"]/div/div[3]/div/div[1]/div[1]/div/input")
	public WebElement txt_enterEmail;
	
	//OK button
	@FindBy(how=How.XPATH,using="//*[@id=\"NvIg97ZB1QYy\"]/div/div[3]/div/div[4]/div[1]/div")
	public WebElement btn_okEnterEmail;
	
	//Submit button
	@FindBy(how=How.XPATH,using="//*[@id=\"unfixed-footer\"]/div[3]/div[1]/div[1]")
	public WebElement btn_submit;
	
	//Get My Style Results » link
	@FindBy(how=How.LINK_TEXT,using="Get My Style Results »")
	public WebElement btn_getMyStyle;
	
	//Continue To Room Selection button
	@FindBy(how=How.XPATH,using="//a[@href='/order/add-rooms/']")
	public WebElement btn_continueToRoomSelection;
	
	public static void styleQuizTest() {
		ExcelUtilities.setExcel();
		String continueToRoomSelectionUrl=ExcelUtilities.getCellData("URL", 7, 1);
		BusinessFunctions.waitForSecs(2000);
		styleQuizPage=PageFactory.initElements(driver, StyleQuizPage.class);
		BusinessFunctions.switchToFrame("typeform-full");
		//driver.switchTo().frame("typeform-full");
		BusinessFunctions.explctWaitTillElementVisibility(styleQuizPage.str_styleOfSofa);
		BusinessFunctions.clickUsingActions(styleQuizPage.blck_sofaA, "Sofa-A");
		BusinessFunctions.waitForSecs(1000);
		BusinessFunctions.explctWaitTillElementVisibility(styleQuizPage.str_livingRoom);
		BusinessFunctions.clickUsingActions(styleQuizPage.blck_livingRoomA, "LivingRoom-A");
		BusinessFunctions.waitForSecs(1000);
		BusinessFunctions.explctWaitTillElementVisibility(styleQuizPage.str_bedRoom);
		BusinessFunctions.clickUsingActions(styleQuizPage.blck_bedRoomA, "BedRoom-A");
		BusinessFunctions.waitForSecs(1000);
		BusinessFunctions.explctWaitTillElementVisibility(styleQuizPage.str_aboutColor);
		BusinessFunctions.clickUsingActions(styleQuizPage.blck_colorA, "Color-A");
		BusinessFunctions.waitForSecs(1000);
		BusinessFunctions.explctWaitTillElementVisibility(styleQuizPage.str_aboutPattern);
		BusinessFunctions.clickUsingActions(styleQuizPage.blck_patternA, "Pattern-A");
		BusinessFunctions.waitForSecs(1000);
		BusinessFunctions.explctWaitTillElementVisibility(styleQuizPage.str_enterEmail);
		BusinessFunctions.setText(styleQuizPage.txt_enterEmail, "abc@gmail.com");
		BusinessFunctions.clickUsingActions(styleQuizPage.btn_okEnterEmail, "OK");
		BusinessFunctions.waitForSecs(1000);
		BusinessFunctions.clickUsingActions(styleQuizPage.btn_submit, "Submit");
		BusinessFunctions.explctWaitTillElementVisibility(styleQuizPage.btn_getMyStyle);
		BusinessFunctions.clickUsingActions(styleQuizPage.btn_getMyStyle, "Get My Style Results");
		BusinessFunctions.explctWaitTillElementVisibility(styleQuizPage.btn_continueToRoomSelection);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getCurrentURL(), continueToRoomSelectionUrl);
		BusinessFunctions.clickUsingActions(styleQuizPage.btn_continueToRoomSelection, "Continue To Room Selection");
	}
}
