package businessActions;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BusinessRules.Base;
import BusinessRules.Log;

public class InspirationImages extends Base{

	 public static void clickOnInspirationImageByIndex(WebElement block,int index) {
	  	List<WebElement> images=block.findElements(By.className("room-image"));
	  	Actions action=new Actions(driver);
	  	try {
	  		System.out.println(images.get(index).getAttribute("src"));
	  		action.moveToElement(images.get(index)).click().perform();
	  	}
	  	catch(Exception e) {
	  		e.printStackTrace();
	  	}
	  		
	  	}
	 
	 public static void verifyBrokenInspirationImages(WebElement block) {
	  	  Log.info("Verifying Broken Images");
	  	  int invalidImageCount=0;
	  	  List<WebElement> images=block.findElements(By.className("room-image"));
	  	  Log.info("Total images count:"+images.size());
	  	  HttpClient client = HttpClientBuilder.create().build();
	  	  for (int i=0;i<images.size();i++) {
				if (!images.get(i).getAttribute("src").contains("ico-close")) {
					HttpGet request = new HttpGet(images.get(i).getAttribute("src"));
		  			org.apache.http.HttpResponse response;
					try {
						response = client.execute(request);
						if (response.getStatusLine().getStatusCode()!=200) {
			  				invalidImageCount++;
			  				Log.info("*****************************************");
			  				Log.info("Fail:Broken image is: "+images.get(i).getAttribute("alt"));
			  			    Log.info("*****************************************");
			  			}
					} catch (ClientProtocolException e ) {
						// TODO Auto-generated catch block
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
					}
				}
				
	  	  }
	  	      Log.info("*****************************************");
			  Log.info("Broken image count:"+invalidImageCount);
			  Log.info("*****************************************");
				
	    }
}
