package businessActions;

import java.util.Random;

import BusinessRules.Base;
import BusinessRules.Log;
import utilities.ExcelUtilities;

public class AddPromoCode extends Base{

	public static String generatePromocodeName() {
		Log.info("Generating promo code name");
		int num=(int) (Math.random()*100);
		String codeName="AutomationPromo"+num;
		Log.info("promo code name: "+codeName);
		return codeName;
	}
	
	public static void writePromocodeInExcel() {
		Log.info("writing promocode name in excel");
		ExcelUtilities.setExcel();
		for (int i=1;i<6;i++) {
			String codeName=generatePromocodeName();
			ExcelUtilities.writeCellData("PromoCodes", i, 0, codeName);
			Log.info(codeName+" written in cell ("+i+","+"0 )");
		}
	}
	
	public static int generateRandomNum(int min,int max) {
		Log.info("Generating random number");
		 Random random = new Random();
	     int num=random.nextInt((max - min) + 1) + min;
		 Log.info("Random Num:"+num);
		 return num;
		
	}
	
	
}
