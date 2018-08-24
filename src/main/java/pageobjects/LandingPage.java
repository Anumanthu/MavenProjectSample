package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//By signin=By.cssSelector("a[href*='sign_in']");
	
	
	@FindBy(css="a[href*='sign_in']")
	public WebElement signin;
	
	
	//@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']/li/a")
	@FindBy(css=".nav.navbar-nav.navbar-right>li>a")
	public WebElement navigationBar;
	
	@FindBy(xpath="//div[@class='text-center']/h2")
	public WebElement getTitle;
	
	@FindBy(xpath="//span[contains(text(),'Register')]")
	public WebElement register;
	
	
	//span[contains(text(),'Register')]
	
	public WebElement getLogin()
	{
		return signin;
	}
	
	
	
}
