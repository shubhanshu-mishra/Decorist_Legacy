package userPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignupPage {

	
	@FindBy(how=How.ID,using="signup_form")
	public WebElement form_signup;
	
	@FindBy(how=How.ID,using="name")
	public WebElement txt_fname;
	
	@FindBy(how=How.ID,using="lastName")
	public WebElement txt_lname;
	
	@FindBy(how=How.ID,using="email")
	public WebElement txt_email;
	
	@FindBy(how=How.ID,using="password")
	public WebElement txt_password;
	
	@FindBy(how=How.ID,using="email-btn")
	public WebElement btn_signup;
	
	
}
