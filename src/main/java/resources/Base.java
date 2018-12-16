package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import academy.AssertionTestCase;

//import academy.FaceBookPrintFriends;

//ctrl+shift+f --> format the code automatically in Eclipse

public class Base {

	public static WebDriver driver = null;
	public Properties prop;
	public String browserName;
	public String url1;
	public String url2;
	public String path_propertiesfile = "C:\\Users\\1018546\\Desktop\\Selenium Learning\\Workspace\\MavenProjectSample\\src\\main\\java\\resources\\dataset.properties";
	public String driverpath_exe;
	public int wait_time;

	public static Logger log;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(path_propertiesfile);

		// prop.load(fis);
		prop.load(fis);
		browserName = prop.getProperty("browser");
		url1 = prop.getProperty("url1");
		driverpath_exe = prop.getProperty("driverpath_exe");
		wait_time = Integer.parseInt(prop.getProperty("wait_time"));

		System.out.println(url1);

		url2 = prop.getProperty("url2");

		// System.out.println(browserName);

		if (driver == null) {

			if (browserName.equalsIgnoreCase("Chrome")) {

				System.setProperty("webdriver.chrome.driver", driverpath_exe + "\\chromedriver.exe");
				driver = new ChromeDriver();
				// System.out.println("Driver name "+driver);

			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", driverpath_exe + "\\geckodriver.exe");
				driver = new FirefoxDriver();
				// System.out.println("Driver name "+driver);

			} else {
				System.setProperty("webdriver.ie.driver", driverpath_exe + "\\IEDriverServer.exe");

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

	public void getScreenshot(String failedtestcasename) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// File dest=new File("C:\\Users\\ANUMANTHU\\Desktop\\Selenium
		// Learning\\ScreenShots\\screenshot.png");

		FileUtils.copyFile(src, new File("C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\ScreenShots\\"
				+ failedtestcasename + " screenshot.png"));

		// File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		// FileUtils.copyFile(src1, new File("path of image to be svaed"));

	}

}
