package BusinessRules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BusinessFunctions extends Base{

	
	public static String loadBrowser() {
		FileInputStream file;
		String Browser=null;
		try {
			file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\config.properties");
			Properties prop=new Properties();
			prop.load(file);
			Browser=prop.getProperty("Browser");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Browser;
	}
	
	public static String loadUrl() {
		FileInputStream file;
		String testUrl=null;
		try {
			file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\config.properties");
			Properties prop=new Properties();
			prop.load(file);
			testUrl=prop.getProperty("User_URL");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testUrl;
	}
	
	public static void setUrl(String url) {
		try {
			if(driver!=null) {
				driver.navigate().to(url);
			}
		}
		catch(Exception e) {
		}
	}
	
	public static void launchBrowser() {
		
		String testUrl=loadUrl();
		String browserName=loadBrowser();
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.navigate().to(testUrl);
		}
		else {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		setUrl(testUrl);
	}
	
	public static String getUniqueId() {
		String uniqueId="";
		try {
			UUID id=UUID.randomUUID();
			uniqueId=id.toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return uniqueId;
	}
	
	public static String takeSnapshot() {
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileName=snapshotFolder+getUniqueId()+".png";
	    try {
			FileUtils.copyFile(srcFile, new File (fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return fileName;
	}
	
	public static void explctWaitTillElementVisibility(WebElement Element) {
		Log.info("waiting for "+Element+"to display");
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}
	
	public static void implctWait() {
		driver.manage().timeouts().implicitlyWait(14,TimeUnit.SECONDS);
	}
	
	
	public static void setText(WebElement Element,String Text) {
		Log.info("Setting text");
		try {
			Element.sendKeys(Text);
			Log.info("Pass:"+Text+" is entered");
		}
		catch(Exception e) {
			Log.info("Fail:Unable so set text: "+Text);
			e.printStackTrace();
		}
	}
	
	public static void click(WebElement Element,String name) {
		Log.info("Clicking on"+name);
		try {
			Element.click();
			Log.info("Pass: "+name+" :is clicked");
		}
		catch(Exception e) {
			e.printStackTrace();
			Log.info("Fail:Could not Click on "+name);
			Assert.fail();
		}
	}
	
	
	public static void clickUsingJS(WebElement Element,String name) {
		Log.info("Clicking using JS on"+name);
		try {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", Element);
			Log.info("Pass: "+name+" :is clicked");
		}
		catch(Exception e) {
			e.printStackTrace();
			Log.info("Fail:Could not Click on "+name);
			Assert.fail();
		}
	}
	
	private static boolean checkBrowserReadyState(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return true;
		}else{
			return false;
		}

	}
	
	public static void waitForBrowsertoload() {		

		try{
			boolean isReady = checkBrowserReadyState();
			if(!isReady){
				for (int i = 0; i < 90; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
					}
					isReady = checkBrowserReadyState();
					if(isReady){						
						break;
					}
				}	
			}				

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public static void mouseHover(WebElement Element) {
		Actions action=new Actions(driver);
		action.moveToElement(Element).build().perform();
	}
	
	public static String getElementText(WebElement Element) {
		return Element.getText().trim();
		
	}
	
	public static String getAttributeText(WebElement Element,String attributeName) {
		String attributeValue=Element.getAttribute(attributeName).toString();
		return attributeValue;
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void selectFromDropdownByIndex(WebElement Element,int index) {
		try {
			Select sel=new Select(Element);
			sel.selectByIndex(index);
			Log.info("Element selected by index:"+index+ " is:"+sel.getFirstSelectedOption().getText());
		}
		catch(Exception e) {
			e.printStackTrace();
			Log.info("Could not select element from dropdown:"+Element);
		}
	}
	
	public static void selectDropdownByName(WebElement Element,String name) {
		Log.info("selectDropdownByName");
		try {
			Select sel=new Select(Element);
			sel.selectByVisibleText(name);
			Log.info("Selected value is:"+name);
		}
		catch(Exception e) {
			e.printStackTrace();
			Log.info("Could not select element from dropdown:"+name);
		}
	}
	
	public static int countAllItemsInABlock(WebElement Element,String tagName) {
		List<WebElement> items=Element.findElements(By.tagName(tagName));
		int itmCount=items.size();
		return itmCount;
	}
	
	public static String returnElementTextByArrayIndex(WebElement Element,String tagName,int arraylistIndex){
		List<WebElement> items=Element.findElements(By.tagName(tagName));
		String elementText=items.get(arraylistIndex).getText();
		return elementText;
	}
	
	
	
	

}
