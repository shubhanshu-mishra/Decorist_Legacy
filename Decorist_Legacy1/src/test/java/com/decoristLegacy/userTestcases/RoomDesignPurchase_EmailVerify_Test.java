package com.decoristLegacy.userTestcases;

import org.testng.annotations.Test;

import BusinessRules.Constants;
import BusinessRules.Log;
import utilities.EmailUtils;
import utilities.ExcelUtilities;

public class RoomDesignPurchase_EmailVerify_Test extends RunnerTest{

	@Test
	public static void verifyEmailForDesignPurchase() {
		Log.startTestCase("RoomDesignPurchase_EmailVerify_Test");
		String hostName=ExcelUtilities.getCellData("Email", 1, 0);
		String username=ExcelUtilities.getCellData("Email", 1, 1);
		String from=ExcelUtilities.getCellData("Email", 1, 3);
		String subjectForDesignPackagePurchase=ExcelUtilities.getCellData("Email", 1, 4);
		MultipleRooms_MultiplePackages_Test.multipleRoomsWithMultiplePackages();
		EmailUtils.verifyReceivedEmail(hostName, username, Constants.password, from, subjectForDesignPackagePurchase);
	}
}
