package designerPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DesignerHomePage {

	@FindBy(how=How.ID,using="header-board-builder")
	public WebElement lnk_createBoard;
	
	@FindBy(how=How.ID,using="header-boards")
	public WebElement lnk_yourBoards;
	
	@FindBy(how=How.LINK_TEXT,using="Your Projects")
	public WebElement lnk_yourProjects;
}
