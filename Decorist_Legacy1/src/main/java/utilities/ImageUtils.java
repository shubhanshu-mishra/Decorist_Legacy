package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BusinessRules.Base;
import BusinessRules.Log;

public class ImageUtils extends Base{

	public static int ImagesCount() {
		List<WebElement> images=driver.findElements(By.className("room-img"));
		int imgsCount=images.size();
		Log.info("Total Image Count is: "+imgsCount);
		return imgsCount;
	}
	
	public static int countBrokenImages(String cssProperty,String propertyVal) {
		int brokenImgCnt=0;
		List<WebElement> images=driver.findElements(By.className("room-img"));
		int imgsCount=images.size();
		for (int i=0;i<imgsCount;i++) {
			if (!images.get(i).getCssValue(cssProperty).equals(propertyVal)) {
				brokenImgCnt++;
				Log.info("Broken image name is: "+images.get(i).getAttribute("aria-label"));
			}
		}
		Log.info("Count of Broken Images: "+brokenImgCnt);
		return brokenImgCnt;
	}
	
	public static void clickOnImageByIndex(int index,String name) {
		try {
			List<WebElement> images=driver.findElements(By.className("room-img"));
			images.get(index).click();
			Log.info("Pass: Clicked on image at index:"+index+" and name: "+name);
		}
		catch(Exception e) {
			Log.info("Fail: Could not clicked on image at index:"+index+" and name:"+name);
			e.printStackTrace();
		}
		
	}
	
	public static void clickOnImageByIndexUsingActions(int Index,String name) {
		try {
			List<WebElement> images=driver.findElements(By.className("room-img"));
			Actions action=new Actions(driver);
			action.moveToElement(images.get(Index)).click().perform();
			Log.info("Pass: Clicked on image present at index: "+Index+" and name: "+name);
		}
		catch(Exception e) {
			e.printStackTrace();
			Log.info("Fail: Could not click on image at index: "+Index+" and name: "+name);
		}
	}
}
