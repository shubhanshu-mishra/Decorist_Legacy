package com.decoristLegacy.userTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import userPageObjects.LandingPage;
import utilities.ExcelUtilities;
import utilities.ImageUtils;

public class LandingPageUITest extends RunnerTest{

	
	@Test
	public static void landingPageUITest() {
		Log.startTestCase("LandingPageUITest");
		
		ExcelUtilities.setExcel();
		String frontImgExpSrc=ExcelUtilities.getCellData("ImagesSRC", 1, 1);
		String easiestWayToDesignStr=ExcelUtilities.getCellData("UI", 1, 3);
		String aboutDecoristStr=ExcelUtilities.getCellData("UI", 3, 3);
		
		landingPage=PageFactory.initElements(driver,LandingPage.class);
		
		
		//Verifying for broken images on the page
		VerifiyAndAssert.verifyBrokenImages();
		
		//verifying front image
		VerifiyAndAssert.validateAnImage(landingPage.img_landingPage, frontImgExpSrc, "550");
		
		
		//verifying front image texts and elements
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(landingPage.str_easiestWayToDesign), easiestWayToDesignStr);
		VerifiyAndAssert.isElementDisplayed(landingPage.lnk_getStarted);
		VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(landingPage.str_decoristOnline), aboutDecoristStr);
		
		Log.endTestCase("LandingPageUITest");
	}
}
