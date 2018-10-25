package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.VerifiyAndAssert;
import utilities.ExcelUtilities;

public class SelectYourDesignPage extends Base{

	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[1]/div[2]/div[2]/div[1]/button")
	public WebElement bttn_clasic;
	
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[1]/div[2]/div[2]/div[2]/button")
	public WebElement bttn_elite;
	
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[1]/div[2]/div[2]/div[3]/button")
	public WebElement bttn_celebrity;
	
	public static void selectCelebrityDesignPackageForLogin() {
		selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
		shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
		ExcelUtilities.setExcel();
		String designPackagePageUrl=ExcelUtilities.getCellData("URL",3,1);
		//String designPackagePageUrlNonLogin=ExcelUtilities.getCellData("URL",8,1);
		BusinessFunctions.explctWaitTillElementVisibility(selectYourDesign.bttn_elite);
		VerifiyAndAssert.verifyURL(designPackagePageUrl);
		BusinessFunctions.clickUsingJS(selectYourDesign.bttn_celebrity, "Celebrity Button");	
		BusinessFunctions.waitForSecs(1000);
		BusinessFunctions.explctWaitTillElementVisibility(shoppingCartPage.bttn_proceedToCheckout);
	}
	
	public static void selectClassicDesignPackageForLogin() {
		selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
		shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
		ExcelUtilities.setExcel();
		String designPackagePageUrl=ExcelUtilities.getCellData("URL",3,1);
		BusinessFunctions.explctWaitTillElementVisibility(selectYourDesign.bttn_elite);
		VerifiyAndAssert.verifyURL(designPackagePageUrl);
		BusinessFunctions.clickUsingJS(selectYourDesign.bttn_clasic, "Classic Button");	
		BusinessFunctions.waitForSecs(1000);
		BusinessFunctions.explctWaitTillElementVisibility(shoppingCartPage.bttn_proceedToCheckout);
	}
	
	public static void selectEliteDesignPackageForLogin() {
		selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
		shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
		ExcelUtilities.setExcel();
		String designPackagePageUrl=ExcelUtilities.getCellData("URL",3,1);
		BusinessFunctions.explctWaitTillElementVisibility(selectYourDesign.bttn_elite);
		VerifiyAndAssert.verifyURL(designPackagePageUrl);
		BusinessFunctions.clickUsingJS(selectYourDesign.bttn_elite, "Elite Button");	
		BusinessFunctions.waitForSecs(1000);
		BusinessFunctions.explctWaitTillElementVisibility(shoppingCartPage.bttn_proceedToCheckout);
	}
	
	public static void selectCelebrityDesignPackageForNonLogin() {
		selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
		shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
		ExcelUtilities.setExcel();
		String designPackagePageUrlNonLogin=ExcelUtilities.getCellData("URL",8,1);
		BusinessFunctions.explctWaitTillElementVisibility(selectYourDesign.bttn_elite);
		VerifiyAndAssert.verifyURL(designPackagePageUrlNonLogin);
		BusinessFunctions.clickUsingJS(selectYourDesign.bttn_celebrity, "Celebrity Button");	
		BusinessFunctions.waitForSecs(1000);
		BusinessFunctions.explctWaitTillElementVisibility(shoppingCartPage.bttn_proceedToCheckout);
	}
	
	public static void selectEliteDesignPackageForNonLogin() {
		selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
		shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
		ExcelUtilities.setExcel();
		String designPackagePageUrlNonLogin=ExcelUtilities.getCellData("URL",8,1);
		BusinessFunctions.explctWaitTillElementVisibility(selectYourDesign.bttn_elite);
		VerifiyAndAssert.verifyURL(designPackagePageUrlNonLogin);
		BusinessFunctions.clickUsingJS(selectYourDesign.bttn_elite, "Elite Button");	
		BusinessFunctions.waitForSecs(1000);
		BusinessFunctions.explctWaitTillElementVisibility(shoppingCartPage.bttn_proceedToCheckout);
	}
	
	public static void selectClassicDesignPackageForNonLogin() {
		selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
		shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
		ExcelUtilities.setExcel();
		String designPackagePageUrl=ExcelUtilities.getCellData("URL",8,1);
		BusinessFunctions.explctWaitTillElementVisibility(selectYourDesign.bttn_elite);
		VerifiyAndAssert.verifyURL(designPackagePageUrl);
		BusinessFunctions.clickUsingJS(selectYourDesign.bttn_clasic, "Classic Button");	
		BusinessFunctions.waitForSecs(1000);
		BusinessFunctions.explctWaitTillElementVisibility(shoppingCartPage.bttn_proceedToCheckout);
	}
}
