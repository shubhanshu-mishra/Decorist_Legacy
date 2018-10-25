package userPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import BusinessRules.Base;

public class OurDesignersPage extends Base{
	
	//MEET OUR DESIGNERS text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'title-text')]/h1")
	public WebElement str_meetOurDesigners;
	
	//Our interior designers are hand-selected across three experience levels ranging from talented newcomers to notable names in the industry.text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'title-text')]/p")
	public WebElement str_ourDesignersAre;

	@FindBy(how=How.LINK_TEXT,using="CLASSIC")
	public WebElement lnk_classic;
	
	@FindBy(how=How.LINK_TEXT,using="ELITE")
	public WebElement lnk_elite;
	
	@FindBy(how=How.LINK_TEXT,using="CELEBRITY")
	public WebElement lnk_celebrity;
	
	//$[amount] per room text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'price')]")
	public WebElement str_amountPerRoom;
	
	//Our best value. Instagram-worthy style that doesn't equal high price.text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'desc-title')]/span[contains(@ng-if,'classic')]")
	public WebElement str_aboutClassic;
	
	//Seasoned talent with 5+ years of successful design projects.TEXT
	@FindBy(how=How.XPATH,using="//div[contains(@class,'desc-title')]/span[contains(@ng-if,'elite')]")
	public WebElement str_aboutElite;
	
	//High-profile designers you’ve eyed on social media and in top magazines. Text
	@FindBy(how=How.XPATH,using="//div[contains(@class,'desc-title')]/span[contains(@ng-if,'celebrity')]")
	public WebElement str_aboutCelebrity;
	
	//GREAT FOR: text
	@FindBy(how=How.XPATH,using="//div[@class='col-md-9']/div[2]")
	public WebElement str_greatFor;
	
	//Design that adapts to your lifestyle TEXT
	@FindBy(how=How.XPATH,using="//div[@class='col-md-9']/div[3]")
	public WebElement str_designThatAdapts;
	
    //Tapping a designer’s signature look TEXT
	@FindBy(how=How.XPATH,using="//div[@class='col-md-9']/div[3]")
	public WebElement str_tappingDesgner;
	
	//Making an investment in your space with celebrity style TEXT
	@FindBy(how=How.XPATH,using="//div[@class='col-md-9']/div[3]")
	public WebElement str_makingInvestment;
	
	//Two initial design concepts to review, final room design and floor plan, online shopping list, complimentary purchasing service, direct messaging with your designer TEXT
	@FindBy(how=How.XPATH,using="//div[@class='col-md-9']/div[5]")
	public WebElement str_initialDesignConcepts;
	
	/*Two initial moodboards to review, one design concept and accessory board, final room design and floor plan, online shopping list, complimentary purchasing service 
	PLUS! Personal project manager, direct messaging with project manager, 30 minute call with project manager*/
	@FindBy(how=How.XPATH,using="//div[@class='col-md-9']/div[5]")
	public WebElement str_twoMoodboards;
	
	//INCLUDES: text
	@FindBy(how=How.XPATH,using="//div[@class='col-md-9']/div[4]")
	public WebElement str_includes;
	
	//SEEN IN logos (for Web) for celebrity
	@FindBy(how=How.XPATH,using="//img[@src='/static/img/celebrity-logos.jpg']")
	public WebElement img_seenInLogo;
	
	//All designer names
	public static String getDesignerName(int nameIndex) {
		List<WebElement> designerNames=driver.findElements(By.xpath("//div[@class='text-wrap text-center']/a[contains(@href,'/order/add-rooms/product:22/designer:')]"));
		return designerNames.get(nameIndex).getText();
	}
	
	
}
