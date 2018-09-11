package BusinessRules;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class VerificationsActions extends Base{

	public void verifyUrl(String Url) {
		//Reports.setMethodMessage("Verifying URL");
		if(driver.getCurrentUrl().equals(Url)) {
			//Reports.setMethodMessage("Pass: URL Verified");
		}else {
			//Reports.setMethodMessage("Fail: URL not matched");
		}
	}
	
	public void verifyElementPresentOnPage(WebElement Element) {
		//Reports.setMethodMessage("Verify Element Present On Page");
		try {
			if(Element.isDisplayed()) {
				//Reports.setMethodMessage("Pass: Verified Element Presence");
			}
		}
		catch(NoSuchElementException ignored) {
			//Reports.setMethodMessage("Fail: Element is not Present On Page");
			Assert.assertFalse(false);
		}
	}
	
	
}
