package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.*;
import resources.Base;



public class HomePage extends Base{
	
private static Logger log=LogManager.getLogger(HomePage.class.getName());

	@BeforeMethod
	public void openUrl() throws IOException
	{
		driver =initializeDriver();
		 log.info("Driver initialized");
		 driver.get(url);
		 log.info("Opened url successfully");
		 
	}
	
	
	@Test(dataProvider="getData1")
	public void initialize(String username,String password) throws IOException, Exception
	{
		 
		 LandingPage l=new LandingPage(driver);
		 
		 Thread.sleep(5000);
		 
		 l.getLogin().click();
		 
		 Thread.sleep(5000);
		 
		 LoginPage lp=new LoginPage(driver);
		
		 /*
		 lp.getEmail().sendKeys("anumanthunitt@gmail.com");
		 lp.getPassword().sendKeys("xxxxxxxxxxxxxxx");
		 lp.getLogin().click();  */
		 
		 lp.email1.sendKeys(username);
		 log.info("Entered usename  "+username+" Successfully");
		 lp.passowrd1.sendKeys(password);
		 log.info("Entered usename  "+password+" Successfully");
		 lp.login1.click();
		 
		 log.info("Clicked login button Successfully");
		 
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		 driver.close();
	        
	        log.info("driver closed after test completed");
	        
	        driver=null;
	}

	@DataProvider(name="getData1")
	public Object[][] getData()
	{
		
		Object[][] data=new Object[3][2];
		
		data[0][0]="Anumanthu@gmail.com";
		data[0][1]="XXXXXXXXX";
		
		data[1][0]="Divya@gmail.com";
		data[1][1]="YYYYYY";
		
		data[2][0]="Nandini@gmail.com";
		data[2][1]="ZZZZZ";
		
		return data;
		
	}
	
}
