package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import academy.AssertionTestCase;

//import academy.FaceBookPrintFriends;

//ctrl+shift+f --> format the code automatically in Eclipse

public class Base {

	public static WebDriver driver = null;
	public Properties prop;
	public String browserName;
	public String url1;
	public String url2;
	public String path_propertiesfile = ".\\src\\main\\java\\resources\\config.properties";

	public int wait_time;

	public static Logger log;

   //public static Logger log= LogManager.getLogger(Class.class.getName());//Need to work on logs to customize the code

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(path_propertiesfile);

		// prop.load(fis);
		prop.load(fis);
		browserName = prop.getProperty("browser");

		//url1 = prop.getProperty("url1");
		url1 = prop.getProperty("url1");

		wait_time = Integer.parseInt(prop.getProperty("wait_time"));

		System.out.println(url1);

		url2 = prop.getProperty("url2");

		// System.out.println(browserName);

		if (driver == null) {

			if (browserName.equalsIgnoreCase("Chrome")) {
				
				//**************************First way*********************
				
				//1. To run in Headless mode define the ChromeOptions as shown below 
				ChromeOptions options=new ChromeOptions();
				//options.addArguments("--headless");
			//	options.addArguments("headless"); //we can define either way
				
			//	***********************Second way**************************************
				// Creating a new instance of the HTML unit driver
                
                //WebDriver driver1 = new HtmlUnitDriver();
				
				options.addArguments("--disable-notifications");
				
				
				String path=System.getProperty("user.dir");//it will get current project directoy/path

				System.setProperty("webdriver.chrome.driver", ".\\LibraryFolder\\Drivers\\chromedriver.exe");
				//driver = new ChromeDriver();
				//Headless mode
				driver = new ChromeDriver(options);
				// System.out.println("Driver name "+driver);

			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", ".\\LibraryFolder\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				// System.out.println("Driver name "+driver);

			} else {
				System.setProperty("webdriver.ie.driver", ".\\LibraryFolder\\Drivers\\IEDriverServer.exe");

				driver = new InternetExplorerDriver();

			}

		}

		driver.manage().timeouts().implicitlyWait(wait_time, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(wait_time, TimeUnit.SECONDS);

		return driver;

	}

	public void openurl(String url) {
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}

	public void quit() {
		System.out.println("Quittting the browser");
		driver.quit();
		driver = null;
	}

	public void close() {
		System.out.println("Closing the browser");
		driver.close();
		driver = null;
	}

	public void waitTime_Seconds(int t) throws InterruptedException {
		t = t + 1000;
		Thread.sleep(t);
	}

	public static Logger logging() {
		log = LogManager.getLogger(Class.class.getName());
		return log;

	}
	
	public static WebDriverWait explictWait(WebDriver driver,int w)
	{
		WebDriverWait d=new WebDriverWait(driver,w);
		
		
		return d;
	}

	
}
