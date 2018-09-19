package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentInfoPage {

	@FindBy(how=How.NAME,using="nameOnCard")
	public WebElement txt_nameOnCard;
	
	@FindBy(how=How.NAME,using="cardNumber")
	public WebElement txt_cardNumber;
	
	@FindBy(how=How.NAME,using="cardMonth")
	public WebElement drop_month;
	
	@FindBy(how=How.NAME,using="cardYear")
	public WebElement drop_year;
	
	@FindBy(how=How.NAME,using="cardCVV")
	public WebElement txt_cvv;
	
	//cvv user text
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[5]/div[2]/div/form/div[1]/div[1]/div[4]/fieldset/div[3]/div[2]/div/div")
	public WebElement str_cvv;
	
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
	
	//Gift Checkbox
	@FindBy(how=How.ID,using="gift_checkbox")
	public WebElement chk_gift;
}
