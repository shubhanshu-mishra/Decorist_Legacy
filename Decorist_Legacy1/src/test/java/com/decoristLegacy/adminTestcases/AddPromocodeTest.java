package com.decoristLegacy.adminTestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.decoristLegacy.userTestcases.RunnerTest;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import adminPageObjects.AdminHomePage;
import adminPageObjects.PromoCodes;
import businessActions.AddPromoCode;
import utilities.ExcelUtilities;

public class AddPromocodeTest extends RunnerTest{

	@Test
	public static void addUniquePromoCodeTest(){
		Log.startTestCase("AddPromocodeTest");
		
		//Method to write promocode names in excel
		AddPromoCode.writePromocodeInExcel();
		
		ExcelUtilities.setExcel();
		String promocodePageUrl=ExcelUtilities.getCellData("URL", 6, 1);
		String addPromocodeDiscountPageUrl=ExcelUtilities.getCellData("URL", 7, 1);
		
		//Login as Admin
		AdminLoginTest.loginAsAdmin();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		adminHomePage=PageFactory.initElements(driver,AdminHomePage.class);
		BusinessFunctions.clickUsingJS(adminHomePage.lnk_promoCodes,"Promo Codes");
		
		promoCodes=PageFactory.initElements(driver,PromoCodes.class);
		BusinessFunctions.explctWaitTillElementVisibility(promoCodes.btn_addPromocode);
		VerifiyAndAssert.verifyURL(promocodePageUrl);
		
		for (int i=1;i<6;i++) {
			int randomRow=AddPromoCode.generateRandomNum(1,5);
			String promoCodeName=ExcelUtilities.getCellData("PromoCodes", randomRow,0);
			String codeType=ExcelUtilities.getCellData("PromoCodes", randomRow, 1);
			String maxDiscountAmount=ExcelUtilities.getCellData("PromoCodes", randomRow, 3);
			String usesLimit=ExcelUtilities.getCellData("PromoCodes",randomRow, 4);
			String date=ExcelUtilities.getCellData("PromoCodes", AddPromoCode.generateRandomNum(1,4), 5);
			String time=ExcelUtilities.getCellData("PromoCodes", randomRow, 6);
			String description=ExcelUtilities.getCellData("PromoCodes", randomRow, 7);
			String extraArgument=ExcelUtilities.getCellData("PromoCodes", randomRow, 8);
			BusinessFunctions.clickUsingJS(promoCodes.btn_addPromocode, "Add Promocode Discount button");
			BusinessFunctions.explctWaitTillElementVisibility(promoCodes.btn_save);
			VerifiyAndAssert.verifyURL(addPromocodeDiscountPageUrl);
			//Promo Code Details
			BusinessFunctions.setText(promoCodes.txt_code,promoCodeName);
			BusinessFunctions.click(promoCodes.txt_discountAmount,"Max Discount Amount Txt Box");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(promoCodes.blck_promocodeInfo),"is unique");
			BusinessFunctions.selectDropdownByName(promoCodes.drp_codeType,codeType);
			BusinessFunctions.setText(promoCodes.txt_discountAmount, maxDiscountAmount);
			//Available designer profile selection
			BusinessFunctions.selectFromDropdownByIndex(promoCodes.drp_availableDesignerProfile, 0);
			BusinessFunctions.selectFromDropdownByIndex(promoCodes.drp_availableDesignerProfile, 1);
			BusinessFunctions.selectFromDropdownByIndex(promoCodes.drp_availableDesignerProfile, 2);
			
			BusinessFunctions.clickUsingJS(promoCodes.lnk_addDesigner,"Add Designer");
			BusinessFunctions.setText(promoCodes.txt_usesLimit,usesLimit);
			BusinessFunctions.setText(promoCodes.txt_date, date);
			BusinessFunctions.setText(promoCodes.txt_time, time);
			BusinessFunctions.setText(promoCodes.txt_description,description);
			if (codeType.equals("")) {
				BusinessFunctions.setText(promoCodes.txt_extraArguments,"2");
			}else {
				BusinessFunctions.setText(promoCodes.txt_extraArguments,extraArgument);
			}
			BusinessFunctions.clickUsingJS(promoCodes.btn_save,"SAVE");
			BusinessFunctions.explctWaitTillElementVisibility(promoCodes.btn_addPromocode);
			VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(promoCodes.alert_codeSuccessfullyAdded), "was added successfully.");
			VerifiyAndAssert.verifyURL(promocodePageUrl);
		}
		Log.endTestCase("AddPromocodeTest");
	}
}
