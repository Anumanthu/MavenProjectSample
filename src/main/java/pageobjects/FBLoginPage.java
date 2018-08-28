package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPage {
	
	public WebDriver driver;

	public FBLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="email")
	public WebElement userid;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(how=How.XPATH,using="//input[@type='submit']")
	public WebElement submit;
	
	
}
