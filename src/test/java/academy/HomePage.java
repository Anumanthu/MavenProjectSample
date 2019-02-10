package academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.*;
import resources.Base;
import utils.TestUtil;

public class HomePage extends Base {

	public static String sheetName = "FIRSTXCELNAME2";
	TestUtil testUtil;

	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	// private static Logger log =Base.logging();

	@BeforeMethod
	public void openUrl() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver initialized");

		driver.get(url1);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath(
				"//div[@style='position: absolute; top: 0px; left: 0px; bottom: 0px; right: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;']"))
				.click();

		log.info("Opened url successfully");

	}

	@Test(dataProvider = "getData1")
	public void initialize(String username, String password) throws IOException, Exception {

		LandingPage l = new LandingPage(driver);

		Thread.sleep(5000);

		l.getLogin().click();

		Thread.sleep(5000);

		LoginPage lp = new LoginPage(driver);

		/*
		 * lp.getEmail().sendKeys("anumanthunitt@gmail.com");
		 * lp.getPassword().sendKeys("xxxxxxxxxxxxxxx"); lp.getLogin().click();
		 */

		lp.email1.sendKeys(username);
		log.info("Entered usename  " + username + " Successfully");
		lp.passowrd1.sendKeys(password);
		log.info("Entered usename  " + password + " Successfully");
		lp.login1.click();

		log.info("Clicked login button Successfully");

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();

		log.info("driver closed after test completed");

		driver = null;
	}

	@DataProvider(name = "getData1")
	public Object[][] getData() throws IOException {

		testUtil = new TestUtil();

		// Object[][] data = TestUtil.getTestData(sheetName);

		Object[][] data = new Object[3][2];

		data[0][0] = "Anumanthu@gmail.com";
		data[0][1] = "XXXXXXXXX";

		data[1][0] = "Divya@gmail.com";
		data[1][1] = "YYYYYY";

		data[2][0] = "Nandini@gmail.com";
		data[2][1] = "ZZZZZ";

		return data;

	}

}
