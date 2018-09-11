package BusinessRules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageobjects.AddRoomPage;
import pageobjects.HeaderObjects;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.PaymentInfoPage;
import pageobjects.SelectYourDesignPage;
import pageobjects.ShoppingCartPage;
import pageobjects.SignupPage;



public class Base {

	public static WebDriver driver;
	public static String snapshotFolder=System.getProperty("user.dir")+"/snapshotFolder";
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	//Pages
	public static HeaderObjects header;
	public static SignupPage signupPage;
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static AddRoomPage addRoomPage;
	public static SelectYourDesignPage selectYourDesign;
	public static ShoppingCartPage shoppingCartPage;
	public static PaymentInfoPage paymentInfoPage;
	
}
