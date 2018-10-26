package com.decoristLegacy.userTestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import businessActions.InspirationImages;
import userPageObjects.InspirationPage;
import userPageObjects.ItemDetailsPage;
import utilities.ExcelUtilities;
import utilities.ImageUtils;

public class Inspiration_Test extends RunnerTest{

	
	@Test
	public static void inspirationTest(){
		Reports.setTestName("Inspiration_Test");
		Log.startTestCase("Inspiration_Test");
		InspirationPage.inspirationSelectionDetails();
	}
}
