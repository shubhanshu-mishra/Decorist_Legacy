package businessActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.VerifiyAndAssert;
import userPageObjects.PaymentInfoPage;
import utilities.ExcelUtilities;

public class CardPayment extends Base{
	
	
	

	public static void makingValidPaymentThroughCard() {
		ExcelUtilities.setExcel();
		String cardNum=ExcelUtilities.getCellData("CardDetails",1,0);
		String expiryDate=ExcelUtilities.getCellData("CardDetails",1,1);
		String phone=ExcelUtilities.getCellData("CardDetails",1,2);
		String zip=ExcelUtilities.getCellData("CardDetails",1,3);
		paymentInfoPage=PageFactory.initElements(driver,PaymentInfoPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(paymentInfoPage.blck_payWithCard);
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		System.out.println("Frame Size:"+frames.size());
		
			driver.switchTo().frame("braintree-hosted-field-number");
			try {
				BusinessFunctions.setText(paymentInfoPage.txt_cardNumber, cardNum);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("braintree-hosted-field-expirationDate");
				BusinessFunctions.setText(paymentInfoPage.txt_expirationDate, expiryDate);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		driver.switchTo().defaultContent();
		BusinessFunctions.setText(paymentInfoPage.txt_phoneNumber, phone);
		BusinessFunctions.setText(paymentInfoPage.txt_zip, zip);
	}
	
	
}
