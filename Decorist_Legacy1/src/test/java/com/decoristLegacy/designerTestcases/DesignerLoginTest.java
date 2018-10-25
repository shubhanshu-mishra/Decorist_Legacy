package com.decoristLegacy.designerTestcases;

import org.testng.annotations.Test;

import com.decoristLegacy.userTestcases.RunnerTest;

import BusinessRules.Log;
import businessActions.Login;

public class DesignerLoginTest extends RunnerTest{

	@Test
	public static void designerLogin() {
		Log.startTestCase("DesignerLoginTest");
		Login.loginAsDesigner();
		Log.endTestCase("Pass:DesignerLoginTest");
	}
}
