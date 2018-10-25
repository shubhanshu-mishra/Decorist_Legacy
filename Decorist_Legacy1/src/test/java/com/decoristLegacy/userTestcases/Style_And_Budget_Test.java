package com.decoristLegacy.userTestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.VerifiyAndAssert;
import userPageObjects.StyleAndBudgetPage;
import utilities.ExcelUtilities;

public class Style_And_Budget_Test extends RunnerTest{

	@Test
	public static void styleAndBudgetTest() {
		
		ExcelUtilities.setExcel();
		String YouAreAlmostDone=ExcelUtilities.getCellData("UI", 1, 9);
		String OverallColorPreference=ExcelUtilities.getCellData("UI", 2, 7);
		String whatsYourBudget=ExcelUtilities.getCellData("UI", 3, 7);
		String thisHelpsDesigner=ExcelUtilities.getCellData("UI", 4, 7);
		/*String neutralPaletteImgSRC=ExcelUtilities.getCellData("ImagesSRC", 2, 1);
		String somePopsofColorImgSRC=ExcelUtilities.getCellData("ImagesSRC", 3, 1);*/
		String specificBudget=ExcelUtilities.getCellData("UI", 5, 7);
		String specificBudgetValue="10";
		/*String saveAndContinueBtn=ExcelUtilities.getCellData("UI", 6, 7);
		String lowBudget=ExcelUtilities.getCellData("UI", 7, 7);
		String mediumBudget=ExcelUtilities.getCellData("UI", 8, 7);
		String highBudget=ExcelUtilities.getCellData("UI", 9, 7);
		
		String boldColorImgSRC=ExcelUtilities.getCellData("ImagesSRC", 4, 1);
		String lowBudgetImgSRC=ExcelUtilities.getCellData("ImagesSRC", 5, 1);
		String mediumBudgetImgSRC=ExcelUtilities.getCellData("ImagesSRC", 6, 1);
		String highBudgetImgSRC=ExcelUtilities.getCellData("ImagesSRC", 7, 1);*/
		
		
		try {
			Inspiration_Test.inspirationTest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		styleBudgetPage=PageFactory.initElements(driver,StyleAndBudgetPage.class);
		
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.str_youAreAlmostDone),YouAreAlmostDone);
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.blck_overallPreference);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.str_overallPreference),OverallColorPreference);
		
		List<WebElement> images=driver.findElements(By.xpath("//img[@alt='Room with some colors']"));
		//Validating src for default image displayed
		VerifiyAndAssert.isElementDisplayed(images.get(1));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(images.get(1), "src"), somePopsofColorImgSRC);
		
		//clicking on radio buttons one-by-one and validating displayed images src
		BusinessFunctions.selectRadioButtonFromGroup(styleBudgetPage.blck_overallPreference, "//div/span[@class='radio-button']", "Neutral palette");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();}
		VerifiyAndAssert.isElementDisplayed(images.get(0));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(styleBudgetPage.img_roomColor, "src"), neutralPaletteImgSRC);
		
		BusinessFunctions.selectRadioButtonFromGroup(styleBudgetPage.blck_overallPreference, "//div/span[@class='radio-button']", "Bold color throughout");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();}
		VerifiyAndAssert.isElementDisplayed(images.get(2));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(images.get(2), "src"), boldColorImgSRC);
		
		BusinessFunctions.clickUsingJS(styleBudgetPage.bttn_readyToContinue, "Ready To Continue");
		
		//*****************Budget Section****************************************//
		
		BusinessFunctions.explctWaitTillElementVisibility(styleBudgetPage.str_whatsYourBudget);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.str_whatsYourBudget), whatsYourBudget);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.str_thisHelpsDesigner), thisHelpsDesigner);
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.budgetImages(1));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(styleBudgetPage.budgetImages(1), "src"), mediumBudgetImgSRC);
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.budgetRangeTexts(1));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(StyleAndBudgetPage.budgetRangeTexts(1)).trim(), mediumBudget.trim());
		
		//Selecting Low budget radio buttons and validating image displayed
		BusinessFunctions.clickUsingActions(styleBudgetPage.budgetRadioButtons(0), "Low Budget");
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.budgetRangeTexts(0));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.budgetRangeTexts(0)), lowBudget);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(styleBudgetPage.budgetImages(0), "src"), lowBudgetImgSRC);
		
		//Selecting High budget radio buttons and validating image displayed
		BusinessFunctions.clickUsingActions(styleBudgetPage.budgetRadioButtons(2), "High Budget");
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.budgetRangeTexts(2));
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.budgetRangeTexts(2)), highBudget);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(styleBudgetPage.budgetImages(2), "src"), highBudgetImgSRC);
		
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.str_specificBudget);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.str_specificBudget), specificBudget);
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.str_dolarSign);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.str_dolarSign), "$");
		VerifiyAndAssert.isElementDisplayed(styleBudgetPage.txt_specificBudget);
		VerifiyAndAssert.verifyText(BusinessFunctions.getAttributeText(styleBudgetPage.txt_specificBudget, "placeholder"), "0");
		BusinessFunctions.setText(styleBudgetPage.txt_specificBudget, specificBudgetValue);
		//VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(styleBudgetPage.btn_saveAndContinue), saveAndContinueBtn);
		BusinessFunctions.clickUsingJS(styleBudgetPage.btn_saveAndContinue, "Save & Continue button");
		
		
	}
}
