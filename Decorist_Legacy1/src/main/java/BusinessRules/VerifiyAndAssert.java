package BusinessRules;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class VerifiyAndAssert extends Base{

	public static void isElementDisplayed(WebElement Element) {
		Log.info("Verifying Is Element Displayed");
		try {
			
			if (Element.isDisplayed()) {
				Log.info("Pass: Element is displayed");
				
			}
		}
		catch(NoSuchElementException ignored) {
			Log.info("Fail:"+"Element:"+Element+" is not displayed");
			Assert.fail();
		}
		
	}
	
	public static void verifyText(String ActText,String ExpText) {
		Log.info("Verifying Text");
		if (ActText.equals(ExpText)) {
			Log.info("Pass: Act Text:"+ActText+" Exp Text: "+ExpText);
		}
		else {
			Log.info("Fail: Act Text:"+ActText+" Exp Text: "+ExpText);
			Reports.setMethodMessage("Text is not same:Act Text is:"+ActText+"& Exp Text is: "+ExpText);
			Assert.fail();
		}
	}
	
	public static boolean verifyIsElementEnable(WebElement Element) {
		try {
			if (Element.getAttribute("disabled")==null) {
				return true;
			}
		}
		catch(ElementNotFoundException e) {
			e.printStackTrace();
			Assert.fail();
		}
		return false;
		
	}
	
	public static void verifyURL(String expUrl) {
		Assert.assertEquals(driver.getCurrentUrl(), expUrl);
		Log.info("Pass:Verified Act and Exp URLs: Act URL:"+driver.getCurrentUrl()+" Exp URL:"+expUrl);
	}
	
	public static void verifyChildStringInParentString(String parentString,String childString) {
		Log.info("verifying whether child text is present in parent text");
		if (parentString.contains(childString)) {
			Log.info("Pass:child :"+childString+"Parent: "+parentString);
		}
		else {
			Log.info("Fail: child:"+childString+" parent: "+parentString);
		}
	}
	
	

}