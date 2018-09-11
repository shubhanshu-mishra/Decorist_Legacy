package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	@FindBy(how=How.ID,using="email")
	public WebElement txt_email;
	
	@FindBy(how=How.ID,using="password")
	public WebElement txt_password;
	
	@FindBy(how=How.ID,using="email-btn")
	public WebElement btn_login;
	
	@FindBy(how=How.LINK_TEXT,using="Sign Up")
	public WebElement lnk_signup;
	
	@FindBy(how=How.ID,using="signup_form")
	public WebElement form_signup;
	
	@FindBy(how=How.ID,using="error-window")
	public WebElement block_err;
	
	//Button to close login/signup form
	@FindBy(how=How.XPATH,using="//*[@id=\"account-content\"]/div[1]/button")
	public WebElement btn_closeForm;
	
	//Error message for password with blank credentials
	@FindBy(how=How.ID,using="error-password")
	public WebElement block_errBlnkCred;
	
	//Error message for invalid email
	@FindBy(how=How.ID,using="error-email")
	public WebElement block_errEmail;
	
	//Error message with valid email and invalid password
	@FindBy(how=How.ID,using="error-combination")
	public WebElement block_errPass;
}
