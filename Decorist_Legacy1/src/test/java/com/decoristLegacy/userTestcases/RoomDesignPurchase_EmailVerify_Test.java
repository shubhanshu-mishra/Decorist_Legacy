package com.decoristLegacy.userTestcases;

import org.testng.annotations.Test;

import BusinessRules.Constants;
import BusinessRules.Log;
import BusinessRules.Reports;
import userPageObjects.PaymentInfoPage;
import utilities.EmailUtils;
import utilities.ExcelUtilities;

public class RoomDesignPurchase_EmailVerify_Test extends RunnerTest{

	@Test
	public static void verifyEmailForDesignPurchase() {
		Reports.setTestName("RoomDesignPurchase_EmailVerify_Test");
		Log.startTestCase("RoomDesignPurchase_EmailVerify_Test");
		String hostName=ExcelUtilities.getCellData("Email", 1, 0);
		String username=ExcelUtilities.getCellData("Email", 1, 1);
		String from=ExcelUtilities.getCellData("Email", 1, 3);
		String subjectForDesignPackagePurchase=ExcelUtilities.getCellData("Email", 1, 4);
		PaymentInfoPage.multipleRoomWithMultiplePackagesTest();
		EmailUtils.verifyReceivedEmail(hostName, username, Constants.password, from, subjectForDesignPackagePurchase);
		Reports.setMethodMessage("Pass:Email Received with subject:"+subjectForDesignPackagePurchase);
	}
}
