package businessActions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BusinessRules.Base;
import BusinessRules.Log;

public class RadioButtonsUtils extends Base{

	
	//Style And Budget Page Radio Buttons
	public static void verifyDefaultRadioButtonSelected(WebElement block,String locatorXpath) {
		Log.info("Verifying Bydefault selected radio button");
		List<WebElement> radioButtons=block.findElements(By.xpath(locatorXpath));
		radioButtons.get(1);
			System.out.println(driver.findElement(By.id("pref-colors1")).getAttribute("class"));
		
	}
	
	//Designers page Classic,Elite and Celebrity buttons/links
	/*This method will verify that if button/link is selected/activated*/
	public static void verifyIfLinkSelected(WebElement Element,String linkName,String attribute,String text) {
		try {
			Element.getAttribute(attribute).contains(text);
			Log.info("Pass:"+linkName+" is selected");
		}
		catch(Exception e) {
			Log.info("Fail:"+linkName+" is not selected");
			e.printStackTrace();
			Assert.fail();
		}

	}
	
}
