package pageobjects;

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
	
	@FindBy(how=How.NAME,using="phone")
	public WebElement txt_phoneNumber;
	
	@FindBy(how=How.NAME,using="zip")
	public WebElement txt_zip;
}
