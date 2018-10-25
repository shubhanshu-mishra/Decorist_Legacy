package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessRules.Base;
import BusinessRules.BusinessFunctions;

public class LandingPage extends Base{

	//popup
	@FindBy(how=How.CLASS_NAME,using="fancy-cover")
	public WebElement ele_popup;
	
	//No thanks link on popup
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[3]/div/div/div[2]/div[1]/div[4]")
	public WebElement lnk_noThanks;
	
	//Landing page image
	@FindBy(how=How.XPATH,using="//img[@alt='Professional Online Interior Design']")
	public WebElement img_landingPage;
	
	//The easiest way to design a beautiful home.Text
	@FindBy(how=How.XPATH,using="//div/h1")
	public WebElement str_easiestWayToDesign;
	
	//Professional online interior design for your home, always for a low flat fee.Text
	@FindBy(how=How.XPATH,using="//div/p")
	public WebElement str_professionalOnline;
	
	//Start A Project button on front image
	@FindBy(how=How.ID,using="home-redesign-test-hero-start-a-project")
	public WebElement lnk_startAProject;
	
	//Get Started button on front image
	@FindBy(how=How.ID,using="home-redesign-test-hero-get-started")
	public WebElement lnk_getStarted;
	
	/*Decorist is an online interior design service that matches you with a friendly designer 
	to work with you to pull your room together in your style and budget.Text*/
	@FindBy(how=How.XPATH,using="//div[@class='benefits-hero-info']/h3")
	public WebElement str_decoristOnline;
	
	public static void clickGetStartedButton() {
		BusinessFunctions.click(landingPage.lnk_getStarted, "Get Started");
	}
	
}
