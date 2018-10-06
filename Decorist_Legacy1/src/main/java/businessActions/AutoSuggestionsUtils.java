package businessActions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BusinessRules.Base;
import BusinessRules.Log;

public class AutoSuggestionsUtils extends Base{

	//This method will verify that whatever user entered in text box must be contained in the auto suggestion strings
	public static void verifyAutosuggestionStrings(WebElement Element,String compVal) {
		Log.info("Verifying entered text in auto suggetion Strings");
		try {
			//making first character of compVal as capital
			String cap="";
			char[] b=compVal.toCharArray();
			if (Character.isLowerCase(b[0])) {
				cap=compVal.substring(0,1).toUpperCase()+compVal.substring(1);
			}else {
				cap=compVal;
			}
			
			List<WebElement> myEle=Element.findElements(By.xpath("//div[starts-with(@class,'angucomplete-title')]"));
			for (int i=0;i<myEle.size();i++) {
				if (myEle.get(i).getText().contains(cap)) {
					Log.info("Pass:Entered Text "+cap+" Auto sugg val:"+myEle.get(i).getText());
				}
				else {
					Log.info("Fail:Entered Text "+cap+" Auto sugg val:"+myEle.get(i).getText());
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			Log.info("Some system error");
		}
	}


	public static void clickOnFirstAutosuggestedValue(WebElement Element) {
		Log.info("selecting an auto suggested value at index 1");
		try {
			Actions action=new Actions(driver);
			action.moveToElement(Element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			Log.info("Pass: value at index 1 selected");	
		}
		catch(Exception e) {
			Log.info("Fail: could not select value at index 1");
			e.printStackTrace();
		}
	}
	
	public static void clickOnSecondAutosuggestedValue(WebElement Element) {
		Log.info("selecting an auto suggested value at index 2");
		try {
			Actions action=new Actions(driver);
			action.moveToElement(Element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			Log.info("Pass: value at index 2 selected");	
		}
		catch(Exception e) {
			Log.info("Fail: could not select value at index 2");
			e.printStackTrace();
		}
	}

}

