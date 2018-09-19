package businessActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BusinessRules.Base;
import BusinessRules.Log;
import utilities.ExcelUtilities;

public class ShoppingCart extends Base{

	public static int countNumOfProjects() {
		String element=driver.findElement(By.xpath("/html/body/div[5]/div[5]/div[2]/div/div[1]/div/div[1]/div[1]/span[2]")).getText();
		String[] eleArray=element.split(" ");
		int projectsCnt=Integer.parseInt(eleArray[0]);
		return projectsCnt;
	}
	
	//Method to write "Design Package","Price","Quantity" and "Sub Total" on Excel.
	public synchronized static void writeCartDetails(String sheetName) {
		ExcelUtilities.setExcel();
		int projectCnt=ShoppingCart.countNumOfProjects();
		String projCnt=String.valueOf(projectCnt);
		ExcelUtilities.writeCellData(sheetName, 1, 0,projCnt );
		for (int i=0;i<projectCnt;i++) {
			try {
				WebElement cartBlock=driver.findElement(By.xpath("/html/body/div[5]/div[5]/div[2]/div/div[1]/div/div[3]/div["+(i+1)+"]"));
				//Room Type
				String roomType=cartBlock.findElement(By.xpath("/html/body/div[5]/div[5]/div[2]/div/div[1]/div/div[3]/div["+(i+1)+"]/div[1]/div/div/div")).getText();
				ExcelUtilities.writeCellData(sheetName, i+1, 1, roomType);
				//Design Package
				String designPackageName=cartBlock.findElement(By.xpath("/html/body/div[5]/div[5]/div[2]/div/div[1]/div/div[3]/div["+(i+1)+"]/div[2]/div[2]")).getText();		
				ExcelUtilities.writeCellData(sheetName, i+1, 2, designPackageName);
				//Price
				String price=driver.findElement(By.xpath("/html/body/div[5]/div[5]/div[2]/div/div[1]/div/div[3]/div["+(i+1)+"]/div[3]/div/span[1]")).getText();
				ExcelUtilities.writeCellData(sheetName, i+1, 3, price);
				//Quantity
				String quantity=driver.findElement(By.xpath("/html/body/div[5]/div[5]/div[2]/div/div[1]/div/div[3]/div["+(i+1)+"]/div[4]/div[2]/input")).getAttribute("value");
				ExcelUtilities.writeCellData(sheetName, i+1, 4, quantity);
				//Sub Total
				String subTotal=driver.findElement(By.xpath("/html/body/div[5]/div[5]/div[2]/div/div[1]/div/div[3]/div[1]/div[5]/span")).getText();
				ExcelUtilities.writeCellData( sheetName, i+1, 5, subTotal);
				//Total
				String total=driver.findElement(By.xpath("/html/body/div[5]/div[5]/div[2]/div/div[2]/div/div[2]/div[1]/h3")).getText();
				ExcelUtilities.writeCellData(sheetName, i+1, 6, total);
			}
			catch(Exception ignored) {
				
			}
			
	     }
	}
	
	public static int countAddProductButtons() {
		Log.info("Counting add product buttons");
		List<WebElement> buttons=driver.findElements(By.className("add-button"));
		int buttonCount=buttons.size()-1;
		Log.info("Add Product Button Count:"+buttonCount);
		return buttonCount;
	}
	
	public static int countMinusProductButtons() {
		Log.info("Counting Minus product buttons");
		List<WebElement> buttons=driver.findElements(By.className("minus-button"));
		int buttonCount=buttons.size();
		Log.info("Minus Product Button Count:"+buttonCount);
		return buttonCount;
	}
	
	
	//In below method,cart add product button will start with index 1 instead of 0.
	public static void addProductButtonClick(int buttonIndex) {
		Log.info("Method:clicking on add product button based on index");
		List<WebElement> buttons=driver.findElements(By.className("add-button"));
			if (buttons.get(buttonIndex-1).getAttribute("ng-click").equals("addProduct(item,$event,$index);")) {
				buttons.get(buttonIndex-1).click();
				Log.info("Pass:clicked on button at index:"+(buttonIndex-1));
			}
			else {
				Log.info("Button at index:"+(buttonIndex-1)+"is not add product to cart button");
			}
	}
	
	public static void minusProductButtonClick(int buttonIndex) {
		Log.info("Method:clicking on minus product button based on index");
		List<WebElement> buttons=driver.findElements(By.className("minus-button"));
		System.out.println(buttons.size());
		if (buttons.size()>0) {
			try {
				buttons.get(buttonIndex).click();
				Log.info("Pass:clicked on button at index:"+buttonIndex);
			}
			catch(Exception e) {
				e.printStackTrace();
				Log.info("Button at index:"+buttonIndex+"is not minus product to cart button");
			}
		}
		else {
			Log.info("There is no minus button on the page");
		}
	}
}
