package com.decoristLegacy.adminTestcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.client.ClientProtocolException;
import org.eclipse.jetty.client.HttpResponse;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.decoristLegacy.userTestcases.RunnerTest;

import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.Reports;
import BusinessRules.VerifiyAndAssert;
import adminPageObjects.AdminHomePage;
import businessActions.Login;
import junit.framework.Assert;
import userPageObjects.HeaderObjects;
import userPageObjects.HomePage;
import userPageObjects.LandingPage;
import userPageObjects.LoginPage;
import utilities.ExcelUtilities;

public class AdminLoginTest extends RunnerTest{

	@Test
	public static void loginAsAdmin() {
		Log.startTestCase("Login as Admin with valid credential test");
		Login.loginAsAdmin();
		Log.endTestCase("Pass:AdminLoginTest");

	}
}
