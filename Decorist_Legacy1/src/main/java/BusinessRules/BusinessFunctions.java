package BusinessRules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
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
	
	public static void explctWaitTillElementInvisibility(WebElement Element,String name) {
		Log.info("waiting for "+name+"to become invisible");
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.invisibilityOf(Element));
		Log.info("Pass:"+name+" is invisible");
	}
	
	public static void implctWait() {
		driver.manage().timeouts().implicitlyWait(14,TimeUnit.SECONDS);
	}
	
	public static void clearTextField(WebElement Element,String name) {
		Log.info("clearing text field");
		try {
			Element.clear();
			Log.info("Pass: Text Field "+name+" has been cleared");
		}
		catch(Exception e) {
			Log.info("Fail:Could not clear "+name+" text field");
			e.printStackTrace();
		}
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
	
	public static void setTextUsingActions(WebElement Element,String Text) {
		Log.info("Setting text using Actions");
		try {
			WebElement element=Element;
			Actions action=new Actions(driver);
			action.moveToElement(element).sendKeys(Text).perform();
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
	
	public static void clickUsingActions(WebElement Element,String name) {
		Log.info("Clicking using Actions on"+name);
		try {
			WebElement element=Element;
			Actions action=new Actions(driver);
			action.moveToElement(element).click().perform();
			Log.info("Pass: "+name+" :is clicked");
		}
		catch(Exception e) {
			e.printStackTrace();
			Log.info("Fail:Could not Click on "+name);
			Assert.fail();
		}
	}
	
	public static void clickUsingSikuli(String screenshotPath,String elementName) {
		Log.info("Clicking using sikuli");
		Screen s=new Screen();
		Pattern reqElement = new Pattern(screenshotPath);
	    try {
			s.click(reqElement);
			Log.info("Pass:Clicked on: "+elementName);
		} catch (FindFailed e) {
			Log.info("Fail:Could not click on: "+elementName);
			e.printStackTrace();
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
	
	public static void failTest() {
		Log.info("Intentionally failed test");
		Assert.fail();
	}
	
	public static void scrollWindowDown() {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
	}
	
	public static void scrollWindowToBottom() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void switchToWindow(int windowIndex) {
		Log.info("Handling multiple tabs");
		ArrayList windows=new ArrayList(driver.getWindowHandles());
		Log.info("Tabs size:"+windows.size());
		driver.switchTo().window((String)windows.get(windowIndex));
	}
	
	public static boolean isElementDisplayed(WebElement Element,String name) {
		boolean state = true;
		try {
			Log.info("Is Element Displayed: "+name);
			state=Element.isDisplayed();
			Log.info(name+" displayed is:"+state);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static int getWindowsSize() {
		Log.info("Getting windows size");
		ArrayList windows=new ArrayList(driver.getWindowHandles());
		Log.info("Tabs size:"+windows.size());
		return windows.size();
	}
	
	public static void switchToParentWindow() {
		Log.info("switchToParentWindow");
		try {
			ArrayList windows=new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String)windows.get(0));
			Log.info("Pass:switched to window 0");
		}
		catch(Exception e) {
			Log.info("Fail:could not switch to window 0");
			e.printStackTrace();
		}
	}
	
	public static void closeSpecificWindow(int windowIndex) {
		Log.info("Close specific window");
		try {
			ArrayList windows=new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String)windows.get(windowIndex)).close();
			Log.info("Pass:window at index:"+windowIndex+" is closed");
		}
		catch(Exception e) {
			Log.info("Fail:window at index:"+windowIndex+" is not closed");
			e.printStackTrace();
		}
	}
	
	public static void selectRadioButtonFromGroup(WebElement block,String xpath,String rdButtonName) {
		Log.info("Selecting Radio ButtonFrom Group");
		try {
			List<WebElement> radioButtons=block.findElements(By.xpath(xpath));
			Log.info("Total radio buttons count:"+radioButtons.size());
			if (rdButtonName.equals("Neutral palette")) {
			radioButtons.get(0).click();
			}
			else if(rdButtonName.equals("Bold color throughout")) {
				radioButtons.get(2).click();
			}
			Log.info("Pass:Radio Button at index:"+rdButtonName+"is selected");
		}
		catch(Exception e) {
			Log.info("Fail:Could not select on radio button at index:"+rdButtonName);
			e.printStackTrace();
		}
		
	}
	
	public static void saveAndPrint(String fileName) {
		Log.info("Save and Print method is called");
        String pathToSaveFile=Constants.downloadedFilesPath;
		File file=new File(pathToSaveFile+"\\"+fileName+".pdf");
		if (file.exists()) {
			file.delete();
		}
		StringSelection selection = new StringSelection(pathToSaveFile+"\\"+fileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
			try {
				Robot robot=new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
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
		        Log.info("Pass:"+fileName+"Downloaded");
			} catch (AWTException e) {
				e.printStackTrace();
				Log.info("Fail:"+fileName+"could not be downloaded");
			}
	}
	
	public static void navigateToURL(String URL) {
		Log.info("Navigating to url:"+URL);
		try {
			driver.navigate().to(URL);
			Log.info("Pass:Navigated to:"+URL);
		}
		catch(Exception e) {
			Log.info("Fail:Could not navigate to:"+URL);
			e.printStackTrace();
		}
	}
	
	public static String getCurrentURL() {
		Log.info("Getting current url");
		String currentUrl="";
		try {
			currentUrl=driver.getCurrentUrl();
			Log.info("current url:"+currentUrl);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return currentUrl;
	}
	
	public static String splitAndReturnString(String str,String splitPattern,int returnIndex) {
		Log.info("Returning sub string by splitting it");
		String myString=str;
		String[] values=str.split(splitPattern);
		Log.info("returned splitted string is:"+values[returnIndex]);
		return values[returnIndex];
	}
	
	public static void launchChromeIncognito(String url) {
		Log.info("Launching chrome incognito and navigating to url");
		try {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("incognito");
			driver=new ChromeDriver(opt);
			Log.info("Pass:Chrome Incognito Launched");
			driver.get(url);
			driver.manage().window().maximize();
			Log.info("Pass:Navigated to:"+url);
		}
		catch(Exception e) {
			Log.info("Fail:Fail in launching and navigating using incognito");
			e.printStackTrace();
		}
	}
	
	public static int getElementsCountUsingXpath(String eleXpath) {
		List<WebElement> myElmnts=driver.findElements(By.xpath(eleXpath));
		return myElmnts.size();
	}
	
	public static void refreshPage() {
		Log.info("Refreshing page");
		try {
			driver.navigate().refresh();
			Log.info("Pass:Refreshed page");
		}
		catch(Exception e) {
			Log.info("Fail:Refresh page");
			e.printStackTrace();
		}
	}
	
	public static void waitForSecs(long secs) {
		try {
			Log.info("waiting for:"+secs+" seconds");
			Thread.sleep(secs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void switchToFrame(String frameID) {
		Log.info("switching to frame");
		try {
			driver.switchTo().frame(frameID);
			Log.info("Pass:switched into frame with ID"+frameID);
		}
		catch(Exception e) {
			Log.info("Fail:Could not switched into frame with ID"+frameID);
			e.printStackTrace();
		}
	}
	
	
	

}
