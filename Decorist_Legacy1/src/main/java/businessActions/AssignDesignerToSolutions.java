package businessActions;

import org.openqa.selenium.support.PageFactory;



import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import BusinessRules.VerifiyAndAssert;
import adminPageObjects.AdminHomePage;
import utilities.ExcelUtilities;

public class AssignDesignerToSolutions extends Base{

	/*This method will assign designer to all the solutions of client whose ID is in method argument.Designer
	will be assigned to the solutions that don't have "designer assigned" value in "Solution status" column.*/
	public static void assignDesignerToSolutions(String userName) {
		Log.info("AssignDesignerToSolutions method is called");
		Log.info("Searching for the projects client with email id:"+userName);
		ExcelUtilities.setExcel();
		
		String designerName=ExcelUtilities.getCellData("Designers", 1, 1);
		String attentionStr=ExcelUtilities.getCellData("UI", 1, 15);
		String toAssignDesignerStr=ExcelUtilities.getCellData("UI", 2, 15);
		String toUnAssignDesignerStr=ExcelUtilities.getCellData("UI", 3, 15);
		String successfulAssignDesigner=ExcelUtilities.getCellData("UI", 4, 15);
		
		adminHomePage=PageFactory.initElements(driver, AdminHomePage.class);
		//AdminLoginTest.loginAsAdmin();
		BusinessFunctions.clickUsingJS(adminHomePage.lnk_solutions, "Mini Makeover Solutions Link");
		//String userName=LoginTest.email;
		int uuidCnt=BusinessFunctions.getElementsCountUsingXpath("//th[@class='field-item_name']/a/p[2]");
		for (int i=0;i<uuidCnt;i++) {
			if (adminHomePage.getClientDetails(i).contains(userName)&&(!adminHomePage.getSolutionStatusValue(i).equals("designer assigned"))) {
				System.out.println(adminHomePage.getClientDetails(i));
				BusinessFunctions.click(adminHomePage.getActionCheckBox(i), "Action Check Box at index:"+i);
				BusinessFunctions.selectDropdownByName(adminHomePage.drp_designer, "Assign / Un-assign a DESIGNER");
				BusinessFunctions.click(adminHomePage.btn_go, "GO button");
				BusinessFunctions.explctWaitTillElementVisibility(adminHomePage.str_attention);
				VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(adminHomePage.str_attention), attentionStr);
				VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(adminHomePage.str_toAssignDesigner), toAssignDesignerStr);
				VerifiyAndAssert.verifyText(BusinessFunctions.getElementText(adminHomePage.str_toUnAssignDesigner), toUnAssignDesignerStr);
				BusinessFunctions.selectDropdownByName(adminHomePage.drp_assignDesigner, designerName);
				BusinessFunctions.click(adminHomePage.btn_assignDesignerToSolution, "Assign Designer To Solution button");
				BusinessFunctions.explctWaitTillElementVisibility(adminHomePage.str_successfullyAssignDesigner);
				Log.info("Pass:"+designerName+" is assigned for project with UUID "+adminHomePage.getUUIDvalue(i));
				VerifiyAndAssert.verifyChildStringInParentString(BusinessFunctions.getElementText(adminHomePage.str_successfullyAssignDesigner), successfulAssignDesigner);
			}
		}
		
	}
}
