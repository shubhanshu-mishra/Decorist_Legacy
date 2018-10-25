package businessActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;
import BusinessRules.Log;
import designerPageObjects.YourProjectsPage;

public class AddDesignEditionToSolution extends Base{

	/*This method is to add any type of (Concept,Final,Floor plan,3D rendering) design edition to a solution*/
	
	public static void addDesignSolution(String status,String editionTypeRadioName,int editionTypeRadioIndx,int boardNameTextFieldIndx,int designEditionIndex,int AddBoardToEditionIndex) {
		Log.info("method working for:"+editionTypeRadioName+" design");
		yourProjectsPage=PageFactory.initElements(driver, YourProjectsPage.class);
		BusinessFunctions.explctWaitTillElementVisibility(yourProjectsPage.str_byConceptsDelivered);
		int uuidCnt=BusinessFunctions.getElementsCountUsingXpath("//th[@class='field-item_name']/a/p[2]");
		System.out.println("uuidCnt is:"+uuidCnt);
		for (int i=0;i<uuidCnt;i++) {
			List<WebElement> blocks=driver.findElements(By.xpath("//td[@class='field-solution_actions']"));
			if (blocks.get(i).getText().contains(status)) {
				Log.info("Project picked with UUID:"+yourProjectsPage.getUUID(i).getText());
				BusinessFunctions.click(yourProjectsPage.getUUID(i), "UUID link (in string form)");
				BusinessFunctions.switchToWindow(1);
				BusinessFunctions.scrollWindowToBottom();
				BusinessFunctions.clickUsingJS(yourProjectsPage.btn_addDesignEdition, "Add Design Edition");
				BusinessFunctions.clickUsingJS(yourProjectsPage.getDesignEditionRadiobutton(editionTypeRadioIndx), "Design edition radio buttons at index:"+editionTypeRadioIndx);
				BusinessFunctions.clickUsingJS(yourProjectsPage.btn_addBoardToEdition, "Add board to this edition button");
				BusinessFunctions.setText(yourProjectsPage.getBoardNameTxtField(boardNameTextFieldIndx), "mno");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				BusinessFunctions.explctWaitTillElementVisibility(yourProjectsPage.getValueFromBoardName(designEditionIndex, AddBoardToEditionIndex));
				BusinessFunctions.click(yourProjectsPage.getValueFromBoardName(designEditionIndex, AddBoardToEditionIndex), "Autopopulated value from board name dropdown");
				BusinessFunctions.explctWaitTillElementVisibility(yourProjectsPage.img_currentBoard);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				BusinessFunctions.clickUsingJS(yourProjectsPage.btn_saveSolution, "Save Solution");
				BusinessFunctions.closeBrowser();
				BusinessFunctions.switchToParentWindow();
				BusinessFunctions.refreshPage();
			}
	
		}
	}
}
