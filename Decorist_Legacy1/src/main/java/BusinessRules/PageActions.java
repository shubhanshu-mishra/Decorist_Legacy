package BusinessRules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageActions extends Base{

	public static int countAllItemsInABlock(WebElement Element,String tagName) {
		List<WebElement> items=Element.findElements(By.tagName(tagName));
		int itmCount=items.size();
		return itmCount;
	}
}
