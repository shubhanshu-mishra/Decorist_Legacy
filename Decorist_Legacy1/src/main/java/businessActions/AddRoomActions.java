package businessActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BusinessRules.Base;
import BusinessRules.Log;

public class AddRoomActions extends Base{

	//To select/de-select toggle items
	public static void selectItemByName(WebElement Block,String itemName) {
		
		Log.info("selecting item by name");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		List<WebElement> items=Block.findElements(By.xpath("//div[starts-with(@ng-repeat,'item in')]"));
		for (int i=0;i<items.size();i++) {
			try {
				if (items.get(i).getText().equalsIgnoreCase(itemName)) {
					WebElement Element=items.get(i);
					executor.executeScript("arguments[0].click();", Element);
					Log.info("Pass:Clicked on:"+itemName);
				}
			}
			catch(Exception e) {
				Log.info("Fail:Could not clicked on:"+itemName);
				e.printStackTrace();
				Assert.fail();
			}
		}
	}
}
