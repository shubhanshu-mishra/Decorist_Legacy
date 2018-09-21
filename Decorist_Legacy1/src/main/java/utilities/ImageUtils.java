package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
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
	
      public static void uploadImage(String filePath,String imageName) {
		
    	 Log.info("Uploading Image");
		 StringSelection selection = new StringSelection(filePath);
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		 System.out.println("imageLocation:" +selection);
	      try {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        Log.info("Pass:"+imageName+"uploaded");
		} catch (AWTException e) {
			e.printStackTrace();
			Log.info("Fail:"+imageName+"could not be uploaded");
		}
		
	 }
      
      
}
