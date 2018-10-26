package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import businessActions.CardPayment;
import businessActions.Login;
import businessActions.ShoppingCart;
import utilities.ExcelUtilities;

public class PaymentInfoPage extends Base{
	
	//Pay with card block
	@FindBy(how=How.XPATH,using="//div[@data-braintree-id='card']")
	public WebElement blck_payWithCard;
	
	@FindBy(how=How.ID,using="credit-card-number")
	public WebElement txt_cardNumber;
	
	@FindBy(how=How.ID,using="expiration")
	public WebElement txt_expirationDate;
	
	@FindBy(how=How.NAME,using="phone")
	public WebElement txt_phoneNumber;
	
	@FindBy(how=How.NAME,using="zip")
	public WebElement txt_zip;
	
	//Place Your Order button inside Order Summary block
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[2]/div/form/div[1]/div[2]/div[1]/div/input")
	public WebElement btn_placeYourOrder;
	
	//Place Your Order button below on the page
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[2]/div/form/div[3]/input")
	public WebElement btn_placeYourOrderBelow;
	
	//"Item Total" text inside Order Summary block
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[2]/div/form/div[1]/div[2]/div[1]/div/div[1]/div[1]")
	public WebElement str_itemTotalText;
	
	//"Item Total" value inside Order Summary block
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[2]/div/form/div[1]/div[2]/div[1]/div/div[1]/div[2]")
	public WebElement str_itemTotalValue;
	
	//"Order Total" text inside Order Summary block
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[2]/div/form/div[1]/div[2]/div[1]/div/div[2]/div")
	public WebElement str_orderTotalText;
	
	//"Order Total" value inside Order Summary block
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[2]/div/form/div[1]/div[2]/div[1]/div/div[2]/h3")
	public WebElement str_orderTotalValue;
	
	//promo code check box
	@FindBy(how=How.ID,using="promo_checkbox")
	public WebElement chk_promoCode;
	
	//promo code text field
	@FindBy(how=How.NAME,using="promo")
	public WebElement txt_promoCode;
	
	//promo code Apply button
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[2]/div/form/div[1]/div[1]/fieldset[1]/div/div[2]/div/div[2]/input")
	public WebElement btn_promoApply;
	
	//Promo code msg after it is applied
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[2]/div/form/div[1]/div[1]/fieldset[1]/div/div[2]/div[2]")
	public WebElement blck_promoAppliedMsg;
	
	//Gift Checkbox
	@FindBy(how=How.ID,using="gift_checkbox")
	public WebElement chk_gift;
	
	//Log In link
	@FindBy(how=How.LINK_TEXT,using="Log In")
	public WebElement lnk_login;
	
	//first name text field for non login
	@FindBy(how=How.XPATH,using="//input[contains(@ng-model,'userCredentials.firstName')]")
	public WebElement txt_fname;
	
	//last name text field for non login
	@FindBy(how=How.XPATH,using="//input[contains(@ng-model,'userCredentials.lastName')]")
	public WebElement txt_lname;
	
	//Email text field for non login
	@FindBy(how=How.XPATH,using="//input[contains(@ng-model,'userCredentials.email')]")
	public WebElement txt_email;
	
	//Password text field for non login
	@FindBy(how=How.XPATH,using="//input[contains(@ng-model,'userCredentials.password')]")
	public WebElement txt_password;
	
	//validating promo check box default state that should be un-checked
	public static void validatePromoChkBxState() {
		paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getAttributeText(paymentInfoPage.chk_promoCode, "class"), "ng-empty");
	}
	
	//validating gift check box default state that should be un-checked
	public static void validateGiftChkBxState() {
		paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getAttributeText(paymentInfoPage.chk_gift, "class"), "ng-empty");
	}
	
	public static void clickOnPlaceYourOrder() {
		paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
		BusinessFunctions.click(paymentInfoPage.btn_placeYourOrder,"Place Your Order");
	}
	
	public static void signupNonLoginCase() {
		paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
		BusinessFunctions.setText(paymentInfoPage.txt_fname, "pradeep");
		BusinessFunctions.setText(paymentInfoPage.txt_lname, "singh");
		BusinessFunctions.clearTextField(paymentInfoPage.txt_email, "Email field");
		BusinessFunctions.setText(paymentInfoPage.txt_email, "abcssww@gmail.com");
		BusinessFunctions.setText(paymentInfoPage.txt_password, "Password12");
		
	}
	
	public static void multipleRoomWithMultiplePackagesTest() {
		ExcelUtilities.setExcel();
		String thanksForOrdering=ExcelUtilities.getCellData("Messages", 2, 1);
		
		header=PageFactory.initElements(driver,HeaderObjects.class);
		Login.loginAsClient();
		BusinessFunctions.waitForSecs(2000);
		
		//Start A Project
		homePage=PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnStartAProjectBtn();
			
		//Selecting Room
		addRoomPage=PageFactory.initElements(driver,AddRoomPage.class);
		addRoomPage.addRoom(6, "Home Office");
		Reports.setMethodMessage("Home Office is selected");
		addRoomPage.addRoom(9, "Nursery");
		Reports.setMethodMessage("Nursery is selected");
		addRoomPage.clickOnNextBtnOnAddRoom();
		Reports.setMethodMessage("Next button is clicked");
	
		//selecting design package
		selectYourDesign=PageFactory.initElements(driver,SelectYourDesignPage.class);
		selectYourDesign.selectEliteDesignPackageForLogin();
		Reports.setMethodMessage("Elite design package is selected");
		BusinessFunctions.waitForSecs(2000);
			
		shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(shoppingCartPage.bttn_proceedToCheckout);
		BusinessFunctions.waitForSecs(1000);
			
		//Adding 1 more design packages by clicking on add product + button
		ShoppingCart.addProductButtonClick(1);
			
		//Adding 1 more room by clicking on "Add Another Room" link
		BusinessFunctions.clickUsingJS(shoppingCartPage.lnk_addAnotherRoom,"Add Another Room");
		BusinessFunctions.explctWaitTillElementVisibility(addRoomPage.bttn_next);
		addRoomPage.addRoom(11, "Other");
		Reports.setMethodMessage("Other is selected");
		addRoomPage.clickOnNextBtnOnAddRoom();
		Reports.setMethodMessage("Next button is clicked");
		BusinessFunctions.explctWaitTillElementVisibility(selectYourDesign.bttn_clasic);
		selectYourDesign.selectCelebrityDesignPackageForLogin();
		Reports.setMethodMessage("Celebrity design package is selected");
		BusinessFunctions.waitForSecs(1000);
		shoppingCartPage.clickOnProceedToCheckoutForLogin();
		Reports.setMethodMessage("Proceed to checkout button is clicked");
		BusinessFunctions.waitForSecs(2000);
			
		//Making payment
		paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
		CardPayment.makingValidPaymentThroughCard();
		Reports.setMethodMessage("Card payment done");
		//validating promo check box default state that should be un-checked
		paymentInfoPage.validatePromoChkBxState();
		//validating gift check box default state that should be un-checked
		paymentInfoPage.validateGiftChkBxState();
			
		ExcelUtilities.writeCellData("ShoppingCart", 1, 7, BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue));
			
		//Writing Order Total in excel
		ExcelUtilities.writeCellData("ShoppingCart", 1, 8, BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue));
			
			//Applying promo code
			/*BusinessFunctions.clickUsingJS(paymentInfoPage.chk_promoCode, "Promo code check box");
			
			//Applying promocode
			BusinessFunctions.setText(paymentInfoPage.txt_promoCode,"TestCode19");
			BusinessFunctions.clickUsingJS(paymentInfoPage.btn_promoApply, "Apply");
			BusinessFunctions.explctWaitTillElementVisibility(paymentInfoPage.blck_promoAppliedMsg);
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(paymentInfoPage.blck_promoAppliedMsg), "Your promo code was successfully applied!");*/
			
			//Writing Order Total in excel after promo code is applied
		ExcelUtilities.writeCellData("ShoppingCart", 1, 8, BusinessFunctions.getElementText(paymentInfoPage.str_orderTotalValue));
			
		paymentInfoPage.clickOnPlaceYourOrder();
		Reports.setMethodMessage("Place your order button is clicked");
		orderConfirmation=PageFactory.initElements(driver,OrderConfirmation.class);
		BusinessFunctions.explctWaitTillElementVisibility(orderConfirmation.str_thanksForOrdering);
		VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(orderConfirmation.str_thanksForOrdering), thanksForOrdering);
	}
	
}
