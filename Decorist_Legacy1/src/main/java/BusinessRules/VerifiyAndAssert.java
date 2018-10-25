package BusinessRules;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.openqa.selenium.By;
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
	
	public static void verifyIfLinkIsNotDisplayed(String linkName) {
		Log.info("Verifying if "+linkName+" is not displayed");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		Log.info("Links size:"+links.size());
		for (int i=0;i<links.size();i++) {
			if (!links.get(i).getText().equalsIgnoreCase(linkName)) {
				Log.info("Pass:"+linkName+" not found");
			}
			else {
				Log.info("Fail:"+linkName+" found");
				Assert.fail();
			}
				
			
		}
	}
	
	public static void verifyText(String ActText,String ExpText) {
		Log.info("Verifying Text");
		if (ActText.equals(ExpText)) {
			Log.info("Pass: Act Text:"+ActText+" Exp Text: "+ExpText);
		}
		else {
			Log.info("Fail: Act Text: "+ActText+" Exp Text: "+ExpText);
			//Reports.setMethodMessage("Text is not same:Act Text is:"+ActText+"& Exp Text is: "+ExpText);
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
	
	public static boolean isPopupDisplayed(WebElement Element) {
		Log.info("Verifying Is Popup Displayed");
		if (Element.isDisplayed()) {
			Log.info("Popup is displayed");
			return true;
		}else {
			Log.info("Popup is not displayed");
			return false;
		}
				
	}
	
	public static void verifyBrokenImages() {
  	  Log.info("Verifying Broken Images");
  	  int invalidImageCount=0;
  	  List<WebElement> images=driver.findElements(By.tagName("img"));
  	  Log.info("Total images count:"+images.size());
  	  HttpClient client = HttpClientBuilder.create().build();
  	  for (int i=0;i<images.size();i++) {
			if (images.get(i)!=null) {
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
	
	public static void validateAnImage(WebElement Element,String expSRC,String expHeight) {
		Log.info("Validating Image");
		String actSRC=Element.getAttribute("src");
		String actHeight=Element.getAttribute("height");
		if (actSRC.equals(expSRC)) {
			Log.info("Pass:expSRC:"+expSRC+" and ActSRC:"+actSRC);
		}
		else {
			System.out.println("**************************");
			Log.info("Fail:expSRC:"+expSRC+" and ActSRC:"+actSRC);
			System.out.println("**************************");
		}
		
		if (expHeight.equals(actHeight)) {
			Log.info("Pass:expHeight:"+expHeight+" and actHeight:"+actHeight);
		}
		else {
			System.out.println("**************************");
			Log.info("Fail:expHeight:"+expHeight+" and actHeight:"+actHeight);
			System.out.println("**************************");
		}
	}
	
	public static void verifyAttributeIsNotNull(WebElement Element,String Attribute) {
		Log.info("Verifying That Attribute Is Not Null");
		try {
			String value=Element.getAttribute(Attribute);
			if (value!=null) {
				Log.info("Pass:Attribute is not null");
			}else {
				Log.info("Fail:Attribute is null");
				Assert.fail();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void verifyStringsRegex(String regexString,String actString) {
		Log.info("Verifying 2 strings using regex");
		boolean found=Pattern.matches(regexString,actString);
		if (found==true) {
			Log.info("Pass:Both Strings are same");
		}else {
			Log.info("Fail:Both Strings are not same");
			Assert.fail();
		}
	}
	
	public static void verifyUrlResponseCodeIs200(String Url) {
		Log.info("Verifying Response code of url:"+Url);
		org.apache.http.impl.client.DefaultHttpClient httpclient=new org.apache.http.impl.client.DefaultHttpClient();
		org.apache.http.client.methods.HttpGet httpGet=new org.apache.http.client.methods.HttpGet(Url);
		try {
			org.apache.http.HttpResponse response=httpclient.execute(httpGet);
			int resCode=response.getStatusLine().getStatusCode();
			Log.info("response code is:"+resCode);
			org.testng.Assert.assertEquals(resCode, 200);
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void verifyStringsShouldNotSame(String str1,String str2) {
		Log.info("verifying that two strings are not same");
		try {
			str1.equals(str2);
			Log.info("Pass:"+str1+" and "+str2+" are not same");
		}
		catch(Exception e) {
			Log.info("Fail:"+str1+" and "+str2+" are same");
			e.printStackTrace();
		}
	}
	
	
	
	

}