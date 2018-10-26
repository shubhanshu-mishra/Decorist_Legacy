package com.decoristLegacy.userTestcases;
import java.lang.reflect.Array;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.decoristLegacy.userTestcases.RunnerTest;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import businessActions.AutoSuggestionsUtils;
import businessActions.HandleToggleElement;
import userPageObjects.InspirationPage;
import userPageObjects.ItemDetailsPage;
import userPageObjects.RoomDetailsPage;
import utilities.ExcelUtilities;
import utilities.ImageUtils;

public class Item_Details_Test extends RunnerTest{

	@Test
	public void itemDetailsTest() {
		Reports.setTestName("Item_Details_Test");
		Log.startTestCase("Item_Details_Test");
		ItemDetailsPage.userItemDetails();
		Log.endTestCase("Item_Details_Test");
	}
}
