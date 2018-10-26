package BusinessRules;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports extends Base{
	
	public static void setReport() {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/DecoristExtentReport_2.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS","Windows10");
		extent.setSystemInfo("Host Name","IDCQA");
		extent.setSystemInfo("Environment","IDC QA");
		extent.setSystemInfo("User Name","Shubhanshu Mishra");
		
		htmlReporter.config().setDocumentTitle("Testing Report");
		htmlReporter.config().setReportName("Decorist Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public static void getResult(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"Test case failed due to below issue",ExtentColor.RED));
			test.fail(result.getThrowable());
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile,new File("C:\\Users\\test\\git\\repository\\Decorist_Legacy1\\FailedScreenshots"+result.getName()+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		else if (result.getStatus()==ITestResult.SUCCESS){
			test.log(Status.PASS,MarkupHelper.createLabel(result.getName()+"Test case passed",ExtentColor.GREEN));
		}
		else{
			test.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"Test case skipped",ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}
	}
	
	public static void flush() {
		extent.flush();
	}
	
	public static void setTestName(String name) {
		test=extent.createTest(name);
	}
	
	public static void setMethodMessage(String Message) {
		test.log(Status.INFO,Message);
	}
}
