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
import userPageObjects.InspirationPage;
import userPageObjects.StyleAndBudgetPage;
import utilities.ExcelUtilities;

public class Style_And_Budget_Test extends RunnerTest{

	@Test
	public static void styleAndBudgetTest() {
		
		Reports.setTestName("Style_And_Budget_Test");
		Log.startTestCase("Style_And_Budget_Test");
		StyleAndBudgetPage.styleAndBudgetDetails();
		Log.endTestCase("Style_And_Budget_Test");
	}
}
