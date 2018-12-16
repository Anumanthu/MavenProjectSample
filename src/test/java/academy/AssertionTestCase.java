package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import resources.Base;


public class AssertionTestCase extends Base
{

private static Logger log=LogManager.getLogger(AssertionTestCase.class.getName());
	
	
	
	//log=LogManager.getLogger(AssertionTestCase.class.getName());
	

	@BeforeMethod
	public void openUrl() throws IOException
	{
		//log=logging();
		driver =initializeDriver();
		 log.info("Driver initialized");
		 driver.get(url1);
		 log.info("Opened url successfully");
	 
	}
	
	@Test
	public void basePageNavigation() throws IOException, Exception
	{
		 LandingPage l=new LandingPage(driver);
		 Thread.sleep(10000);	
		 //System.out.println(l.getTitle.getText());
	     Assert.assertEquals(l.getTitle.getText(),"FEATURED COURSES");
	     
	     //Assert.assertTrue(false);
	     
	  
	     
	     log.info("Verified FEATURED COURSES SUCCESSFULLY");
		
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
        
        log.info("driver closed after test completed");
        
        driver=null;
        
        
	}

	
	
}
