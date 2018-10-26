package com.decoristLegacy.userTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Constants;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import businessActions.HandleToggleElement;
import userPageObjects.OrderConfirmation;
import userPageObjects.RoomDetailsPage;
import utilities.ExcelUtilities;
import utilities.ImageUtils;

public class Room_Details_Test extends RunnerTest{
	
	@Test
	public static void projectDetailsTest() throws InterruptedException {
		Reports.setTestName("Room_Details_Test");
		Log.startTestCase("Room_Details_Test");
		RoomDetailsPage.roomDetailsTest();
		Log.endTestCase("Room_Details_Test");
	}

}
