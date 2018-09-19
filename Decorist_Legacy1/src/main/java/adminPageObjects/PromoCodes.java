package adminPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PromoCodes {

	//Add Promocode Discount button
	@FindBy(how=How.XPATH,using="//*[@id=\"changelist\"]/div/div[1]/a")
	public WebElement btn_addPromocode;
	
	//Code text box
	@FindBy(how=How.ID,using="id_code")
	public WebElement txt_code;
	
	//Promo code information block
	@FindBy(how=How.ID,using="input_info_block")
	public WebElement blck_promocodeInfo;
	
	//code type dropdown
	@FindBy(how=How.ID,using="id_code_type")
	public WebElement drp_codeType;
	
	//Max Discount Amount Text box
	@FindBy(how=How.ID,using="id_amount")
	public WebElement txt_discountAmount;
	
	//Available Designer Profiles multiple[]select box
	@FindBy(how=How.ID,using="id_possible_products_from")
	public WebElement drp_availableDesignerProfile;
	
	//Arrow for add Designer Profile
	@FindBy(how=How.ID,using="id_possible_products_add_link")
	public WebElement lnk_addDesigner;
	
	//Chosen Designer Profile box/multiple[]select dropdown
	@FindBy(how=How.ID,using="id_possible_products_to")
	public WebElement drp_choosenDesignerProfile;
	
	//Uses Limit text box
	@FindBy(how=How.ID,using="id_uses_limit")
	public WebElement txt_usesLimit;
	
	//Expires on Date calendar icon
	@FindBy(how=How.CLASS_NAME,using="date-icon")
	public WebElement icon_date;
	
	//Date text box
	@FindBy(how=How.ID,using="id_expires_on_0")
	public WebElement txt_date;
	
	//Calendar complete block
	@FindBy(how=How.ID,using="calendarbox0")
	public WebElement block_calendar;
		
	//Expires on Time calendar icon
	@FindBy(how=How.CLASS_NAME,using="clock-icon")
	public WebElement icon_time;
	
	//Time text box
	@FindBy(how=How.ID,using="id_expires_on_1")
	public WebElement txt_time;
	
	//Time complete block
	@FindBy(how=How.ID,using="clockbox0")
	public WebElement block_time;
	
	//Description Text box
	@FindBy(how=How.ID,using="id_description")
	public WebElement txt_description;
	
	//Extra Arguments text box
	@FindBy(how=How.ID,using="id_extra_arguments")
	public WebElement txt_extraArguments;
	
	//Save button
	@FindBy(how=How.NAME,using="_save")
	public WebElement btn_save;
	
	//Alert message that promo code is successfully added
	@FindBy(how=How.XPATH,using="//*[@id=\"suit-center\"]/div[1]")
	public WebElement alert_codeSuccessfullyAdded;
}
