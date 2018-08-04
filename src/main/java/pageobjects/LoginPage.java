package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	
	
public WebDriver driver;
	
	
	By email=By.cssSelector("input[id='user_email']");
	
	By password=By.cssSelector("input[type='password']");
	
	By login=By.xpath("//input[@type='submit']");
	
	//input[@type='submit']
	
	@FindBy(css="input[id='user_email']")
	public WebElement email1;
	
	@FindBy(css="input[type='password']")
	public WebElement passowrd1;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement login1;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);

	}
	
	//PageFactory.initElements(driver, this);

	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}

	
	

}
