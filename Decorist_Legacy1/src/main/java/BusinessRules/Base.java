package BusinessRules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import adminPageObjects.AdminDesignSolutionsPage;
import adminPageObjects.AdminHomePage;
import adminPageObjects.PromoCodes;
import designerPageObjects.BoardBuilderPage;
import designerPageObjects.DesignerHomePage;
import designerPageObjects.YourBoardsPage;
import designerPageObjects.YourProjectsPage;
import userPageObjects.AddRoomPage;
import userPageObjects.HeaderObjects;
import userPageObjects.HomePage;
import userPageObjects.InspirationPage;
import userPageObjects.ItemDetailsPage;
import userPageObjects.LandingPage;
import userPageObjects.LoginPage;
import userPageObjects.OrderConfirmation;
import userPageObjects.OurDesignersPage;
import userPageObjects.PaymentInfoPage;
import userPageObjects.ReviewPage;
import userPageObjects.RoomDetailsPage;
import userPageObjects.SelectYourDesignPage;
import userPageObjects.ShoppingCartPage;
import userPageObjects.SignupPage;
import userPageObjects.StyleAndBudgetPage;
import userPageObjects.StyleQuizPage;



public class Base {

	public static WebDriver driver;
	public static String snapshotFolder=System.getProperty("user.dir")+"/snapshotFolder";
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	//User Pages
	public static HeaderObjects header;
	public static LandingPage landingPage;
	public static SignupPage signupPage;
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static AddRoomPage addRoomPage;
	public static SelectYourDesignPage selectYourDesign;
	public static ShoppingCartPage shoppingCartPage;
	public static PaymentInfoPage paymentInfoPage;
	public static OrderConfirmation orderConfirmation;
	public static RoomDetailsPage roomDetails;
	public static ItemDetailsPage itemsDetailsPage;
	public static InspirationPage inspirationPage;
	public static StyleAndBudgetPage styleBudgetPage;
	public static ReviewPage reviewPage;
	public static OurDesignersPage ourDesignersPage;
	public static StyleQuizPage styleQuizPage;
	
	//Admin pages
	public static AdminHomePage adminHomePage;
	public static PromoCodes promoCodes;
	public static AdminDesignSolutionsPage adminDesignSolPage;
	
	//Designers pages
	public static DesignerHomePage designerHomePage;
	public static BoardBuilderPage boardBuilderPage;
	public static YourBoardsPage yourBoardsPage;
	public static YourProjectsPage yourProjectsPage;
	
}
