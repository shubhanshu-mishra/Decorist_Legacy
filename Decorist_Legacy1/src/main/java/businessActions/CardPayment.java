package businessActions;

import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import pageobjects.PaymentInfoPage;

public class CardPayment extends Base{

	public static void makingPaymentThroughCard(String nameOnCard,String cardNum,int monthIndex,int yearIndex,String cvv,String phoneNumber,String zip) {
		paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
		BusinessFunctions.setText(paymentInfoPage.txt_nameOnCard,nameOnCard);
		BusinessFunctions.setText(paymentInfoPage.txt_cardNumber, cardNum);
		BusinessFunctions.selectFromDropdownByIndex(paymentInfoPage.drop_month, monthIndex);
		BusinessFunctions.selectFromDropdownByIndex(paymentInfoPage.drop_year, yearIndex);
		BusinessFunctions.setText(paymentInfoPage.txt_cvv, cvv);
		BusinessFunctions.setText(paymentInfoPage.txt_phoneNumber, phoneNumber);
		BusinessFunctions.setText(paymentInfoPage.txt_zip, zip);
	}
}
