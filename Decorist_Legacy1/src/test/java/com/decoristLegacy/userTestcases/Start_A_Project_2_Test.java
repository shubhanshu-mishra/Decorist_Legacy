package com.decoristLegacy.userTestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.decoristLegacy.adminTestcases.AddPromocodeTest;
import com.decoristLegacy.adminTestcases.AdminLoginTest;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import businessActions.AddPromoCode;
import businessActions.AddRoomActions;
import businessActions.CardPayment;
import businessActions.ShoppingCart;
import userPageObjects.AddRoomPage;
import userPageObjects.HeaderObjects;
import userPageObjects.OrderConfirmation;
import userPageObjects.PaymentInfoPage;
import userPageObjects.RoomDetailsPage;
import userPageObjects.SelectYourDesignPage;
import userPageObjects.ShoppingCartPage;
import utilities.ExcelUtilities;
import utilities.ImageUtils;

public class Start_A_Project_2_Test extends RunnerTest{

	/*Validate start a project functionality with valid data.
	Room count:3 (initially 2 and later 1 more added)
	design package name and quantity:Elite,3
	Promo applied:Yes
	Is gift:No
	Payment status:successful*/
	
	@Test
	public void start_a_project2_test() throws InterruptedException{
		Log.startTestCase("Start_A_Project_Test");
		
		
		
		String letsGetSomeDetails=ExcelUtilities.getCellData("UI", 1, 1);
		String overallGoals=ExcelUtilities.getCellData("UI", 2, 1);
		String keepItBrief=ExcelUtilities.getCellData("UI", 3, 1);
		String didYouMove=ExcelUtilities.getCellData("UI", 4, 1);
		String currentlyUseRoomString=ExcelUtilities.getCellData("UI", 5, 1);
		String itemNameToggle1=ExcelUtilities.getCellData("Start_A_Project_2_Test", 3, 10);
		String itemNameToggle2=ExcelUtilities.getCellData("Start_A_Project_2_Test", 1, 10);
		String wantUseRoomString=ExcelUtilities.getCellData("UI", 6, 1);
		String newFurnitureLayoutString=ExcelUtilities.getCellData("UI", 7, 1);
		String roomPhotosString=ExcelUtilities.getCellData("UI", 8, 1);	
		String fourRoomPhotosString=ExcelUtilities.getCellData("UI", 9, 1);
		String uploadPhotosString=ExcelUtilities.getCellData("UI", 10, 1);
		String clickOnAnyPhotoString=ExcelUtilities.getCellData("UI", 11, 1);
		String yourFloorPlanString=ExcelUtilities.getCellData("UI", 12, 1);
		
		String imagePath1="C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image1.jpeg";
		String imagePath2="C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image2.jpeg";
		String imagePath3="C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image3.jpeg";
		String imagePath4="C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\src\\main\\java\\TestData\\Images\\image4.jpeg";
		
		
			BusinessFunctions.click(orderConfirmation.btn_iamReadyLetsGo, "I am Ready Lets Go");
			BusinessFunctions.explctWaitTillElementVisibility(orderConfirmation.blck_pickRoomToStartWith);
			
			/*String linkText=ExcelUtilities.getCellData("Start_A_Project_2_Test", 1, 1);
			int linkCount=BusinessFunctions.countAllItemsInABlock(orderConfirmation.blck_pickRoomToStartWith, "a");
			List<WebElement> links=orderConfirmation.blck_pickRoomToStartWith.findElements(By.tagName("a"));*/
			
			
			
			
			
	    
	}
}
