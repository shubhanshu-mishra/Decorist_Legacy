package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentInfoPage {
	
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
}
