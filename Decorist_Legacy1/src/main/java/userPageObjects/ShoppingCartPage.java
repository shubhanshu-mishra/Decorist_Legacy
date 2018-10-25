package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.VerifiyAndAssert;
import businessActions.ShoppingCart;
import utilities.ExcelUtilities;

public class ShoppingCartPage extends Base{

	//Proceed to checkout button
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[2]/div/div[2]/div/div[2]/div[2]")
	public WebElement bttn_proceedToCheckout;
	
	//Cart Wrapper Block
	@FindBy(how=How.CLASS_NAME,using="cart-wrapper")
	public WebElement block_cartWrapper;
	
	//Add Another Room link
	@FindBy(how=How.LINK_TEXT,using="Add Another Room")
	public WebElement lnk_addAnotherRoom;
	
	public static void clickOnProceedToCheckoutForLogin() {
		shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
		ExcelUtilities.setExcel();
		String paymentInfoPageUrl=ExcelUtilities.getCellData("URL",5,1);
		ShoppingCart.writeCartDetails("ShoppingCart");
		BusinessFunctions.clickUsingJS(shoppingCartPage.bttn_proceedToCheckout, "Proceed To Checkout Button");
		BusinessFunctions.waitForSecs(2000);
		VerifiyAndAssert.verifyURL(paymentInfoPageUrl);
	}
	
	public static void clickOnProceedToCheckoutForNonLogin() {
		shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
		ExcelUtilities.setExcel();
		String paymentInfoPageUrl=ExcelUtilities.getCellData("URL",9,1);
		ShoppingCart.writeCartDetails("ShoppingCart");
		BusinessFunctions.clickUsingJS(shoppingCartPage.bttn_proceedToCheckout, "Proceed To Checkout Button");
		BusinessFunctions.waitForSecs(2000);
		VerifiyAndAssert.verifyURL(paymentInfoPageUrl);
	}
	
	
	
}
