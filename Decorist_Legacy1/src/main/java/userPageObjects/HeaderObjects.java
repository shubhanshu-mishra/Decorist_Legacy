package userPageObjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HeaderObjects {
	
	//Header Block
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[1]/div")
	public WebElement block_header;

	//Login Link
	@FindBy(how=How.XPATH,using="//div[text()='Log In']")
	public WebElement lnk_login;
	
	//Design Services Element and its child links
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]")
	public WebElement ele_designServices;
	
	@FindBy(how=How.ID,using="header-how-it-works")
	public WebElement lnk_howItWorks;
	
	@FindBy(how=How.ID,using="header-office")
	public WebElement lnk_officeDesign;
	
	@FindBy(how=How.ID,using="header-start-a-project")
	public WebElement lnk_startaProject;
	
	//Design Services Block on mouse hover
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/div[1]")
	public WebElement block_designServices;
	
	//Our Designers Element and its child Links
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[1]/div/div[1]/div[2]/div[1]/div/div[3]/div[1]")
	public WebElement ele_ourDesigners;
	
	@FindBy(how=How.ID,using="header-designers-classic")
	public WebElement lnk_classicDesigners;
	
	@FindBy(how=How.ID,using="header-designers-elite")
	public WebElement lnk_eliteDesigners;
	
	@FindBy(how=How.ID,using="header-designers-celebrity")
	public WebElement lnk_celebrityDesigners;
	
	//Our Designers Block on mouse hover
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[1]/div/div[1]/div[2]/div[1]/div/div[3]/div[2]/div[1]")
	public WebElement block_ourDesigners;
	
	//Client Projects Element and its child links
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[1]/div/div[1]/div[2]/div[1]/div/div[4]/div[1]")
	public WebElement ele_clientProjects;
	
	@FindBy(how=How.ID,using="header-projects")
	public WebElement lnk_projectGallery;
	
	@FindBy(how=How.ID,using="header-reviews")
	public WebElement lnk_reviews;
	
	//Client Projects Block on mouse hover
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[1]/div/div[1]/div[2]/div[1]/div/div[4]/div[2]/div[1]")
	public WebElement block_clientProjects;
		
	//Design Bar Element and its Client Projects
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[1]/div/div[1]/div[2]/div[1]/div/div[5]/div[1]")
	public WebElement ele_designBar;
	
	@FindBy(how=How.ID,using="header-questions")
	public WebElement lnk_browseAllAdvice;
	
	@FindBy(how=How.ID,using="header-questions-help")
	public WebElement lnk_accessoryHelp;
	
	@FindBy(how=How.ID,using="header-questions-dilemma")
	public WebElement lnk_designDilemma;
	
	@FindBy(how=How.ID,using="header-questions-paint")
	public WebElement lnk_paintColor;
	
	@FindBy(how=How.ID,using="header-questions-items")
	public WebElement lnk_findingItems;
	
	@FindBy(how=How.ID,using="header-questions-art")
	public WebElement lnk_choosingArt;
	
	@FindBy(how=How.ID,using="header-ask")
	public WebElement lnk_askaFreeQuestion;
	
	//Design Bar Block on mouse hover
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[1]/div/div[1]/div[2]/div[1]/div/div[5]/div[2]/div[1]")
	public WebElement block_designBar;
	
	//Blog Element and its Child Links
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[1]/div/div[1]/div[2]/div[1]/div/div[6]/div[1]")
	public WebElement ele_blog;
	
	@FindBy(how=How.ID,using="header-blog")
	public WebElement lnk_mostRecent;
	
	@FindBy(how=How.ID,using="header-blog-featured")
	public WebElement lnk_featured;
	
	@FindBy(how=How.ID,using="header-blog-behind-design")
	public WebElement lnk_behindTheDesign;
	
	@FindBy(how=How.ID,using="header-blog-before-after")
	public WebElement lnk_beforeAndAfter;
	
	@FindBy(how=How.ID,using="header-blog-spotlight")
	public WebElement lnk_designerSpotlight;
	
	@FindBy(how=How.ID,using="header-blog-design-trends")
	public WebElement lnk_designTrends;
	
	//Blog Block on mouse hover
	@FindBy(how=How.XPATH,using="/html/body/div[5]/div[1]/div/div[1]/div[2]/div[1]/div/div[6]/div[2]/div[1]")
	public WebElement block_blog;
	
	//Start A Project Button
	@FindBy(how=How.LINK_TEXT,using="Start a Project")
	public WebElement bttn_startaProject;
	
	//Decorist Logo
	@FindBy(how=How.XPATH,using="//*[@id=\"header-logo-web\"]/img")
	public WebElement img_decoristLogo;
}
