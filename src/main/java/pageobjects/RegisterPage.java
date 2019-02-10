package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Below all 3 are same using id,how,using combination and xpath
	
	
	@FindBy(how=How.ID,using="user_name")
	public WebElement fullname;
	

	
/*
	@FindBy(id="user_name")
	public WebElement fullname2;
	
	@FindBy(xpath="//input[@id='user_name']")
	public WebElement fullname1;
	
	*/
	//input[@name='user[email]']
	
	@FindBy(name="user[email]")
	public WebElement emailid;
	
	@FindBy(id="user_password")
	public WebElement password;
	
	@FindBy(how=How.NAME,using="user[password_confirmation]")
	public WebElement confirmpassword;
	
	
	@FindBy(xpath="//input[@id='user_agreed_to_terms']")
	public WebElement termsconditions;
	
	
	@FindBy(xpath="//input[@value='Sign Up']")
	public WebElement signUp;
	
	

	//input[@id='user_agreed_to_terms']

	//user[password_confirmation]
}
