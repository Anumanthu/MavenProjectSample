package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {
	

	public static WebDriver driver;
	public Properties prop;
	public String browserName;
	public String url;
	public String url1;
	
	public WebDriver initializeDriver() throws IOException
	{

	prop= new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\Workspace\\MavenProjectSample\\src\\main\\java\\resources\\dataset.properties");

	prop.load(fis);
	browserName=prop.getProperty("browser");
	url=prop.getProperty("url");
	
	
	System.out.println(url);
	
//	url1=prop.getProperty("facebookurl1");
	
	//System.out.println(browserName);

	 
		
		
		
		
	if(browserName.equals("Chrome"))
	{
		
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("Driver name    "+driver);

		
	}
	else if (browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\geckodriver.exe");
		driver=new FirefoxDriver();
		System.out.println("Driver name    "+driver);
		
	}
	else
	{
		System.setProperty
		("webdriver.ie.driver","C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\IEDriverServer.exe");
		
		driver=new InternetExplorerDriver();

	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;


	}
	
	public void getScreenshot(String failedtestcasename) throws IOException
	{
		
	        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        
	        //File dest=new File("C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\ScreenShots\\screenshot.png");
	        
	      FileUtils.copyFile(src,new File("C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\ScreenShots\\"+failedtestcasename+" screenshot.png"));
	      
	     // FileUtils.copyFile(src, new File(""));
	      
	     // File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	}
	

}
