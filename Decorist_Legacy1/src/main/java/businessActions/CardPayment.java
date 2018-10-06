package businessActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import userPageObjects.PaymentInfoPage;

public class CardPayment extends Base{

	public static void makingPaymentThroughCard(String cardNum,String mmyy,String phoneNumber,String zip) {
		paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(paymentInfoPage.blck_payWithCard);
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		System.out.println("Frame Size:"+frames.size());
		
			driver.switchTo().frame("braintree-hosted-field-number");
			try {
				BusinessFunctions.setText(paymentInfoPage.txt_cardNumber, cardNum);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("braintree-hosted-field-expirationDate");
				BusinessFunctions.setText(paymentInfoPage.txt_expirationDate, mmyy);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		driver.switchTo().defaultContent();
		BusinessFunctions.setText(paymentInfoPage.txt_phoneNumber, phoneNumber);
		BusinessFunctions.setText(paymentInfoPage.txt_zip, zip);
	}
}
