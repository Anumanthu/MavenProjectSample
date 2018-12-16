package academy;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.FBHomePage;
import pageobjects.FBLoginPage;
import resources.Base;

public class FaceBookPrintFriends extends Base {

	public static Logger log = LogManager.getLogger(FaceBookPrintFriends.class.getName());

	// public static Logger
	// log=LogManager.getLogger(FaceBookPrintFriends.driver.getClass());

	@BeforeMethod
	public void openUrl1() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver initialized");
		driver.get(url2);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		// driver.findElement(By.xpath("//div[@style='position: absolute; top: 0px;
		// left: 0px; bottom: 0px; right: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px
		// inset;']")).click();

		log.info("Opened url successfully");

	}

	@Parameters({ "userid", "password" })
	@Test()
	public void login(String userid1, String password1) throws InterruptedException {
		FBLoginPage fbl = new FBLoginPage(driver);
		FBHomePage fbh = new FBHomePage(driver);

		fbl.userid.sendKeys(userid1);
		fbl.password.sendKeys(password1);
		log.info("Entered login credentials");
		fbl.submit.click();
		log.info("Clicked on submit button");
		Thread.sleep(5000);

		/*
		 * driver.switchTo().alert(); driver.switchTo().alert().accept();
		 */

		WebDriverWait d = new WebDriverWait(driver, 20);

		d.until(ExpectedConditions.elementToBeClickable(fbh.home));

		driver.manage().window().maximize();

	}

	@Test(enabled = false)
	public void anotherMehtod() throws IOException, InterruptedException {
		login("userid", "password");
		Registration r = new Registration();
		r.register("fullname", "emailid", "password");
	}

	@Test(enabled = false)
	public void anotherMehtod1() throws IOException, InterruptedException {
		login("userid", "password");
		Registration r = new Registration();
		r.register("fullname", "emailid", "password");
	}

	@Parameters({ "userid", "password" })
	@Test
	public void printFriendsList(String userid1, String password1) throws InterruptedException {

		login(userid1, password1);

		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='Profile']")).click();
		log.info("Clicked on Profile link");
		driver.findElement(By.xpath("//a[@data-tab-key='friends']")).click();
		log.info("Clicked on Friends link");

		while (true) {
			int bs = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']")).size();

			int y = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']")).get(bs - 1).getLocation().y;

			// JavascriptExecutor js=(JavascriptExecutor)driver;

			// js.executeScript("scroll(0,"+y+")");

			// We have method scroll(horizontal(x-coordinate), vertical(y-coordinate)) i.e.
			// scroll(0,400)

			// ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+y+")");

			// ((JavascriptExecutor)driver).executeScript("window.scroll(0,"+y+")");

			// we can scroll bar without using window.

			((JavascriptExecutor) driver).executeScript("scroll(0," + y + ")");

			log.info("dragging friends list scroll bar");

			Thread.sleep(5000);

			int as = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']")).size();

			if (as == bs)
				break;
		}

		int count = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']")).size();

		log.info("Got the total friends count");

		System.out.println("Total number of friends  ---->" + count);
		log.info("Total number of friends  " + count);

		List<WebElement> lst = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']"));

		Iterator<WebElement> it = lst.iterator();
		log.info("Iterating the friends");

		while (it.hasNext()) {
			System.out.println(it.next().getText());
			// ((JavascriptExecutor)driver).executeScript("scroll(0,100000)");

		}

		log.info("Printed all the friends");
	}

	@AfterMethod
	public void tearDown() {
		close();
		driver = null;
		log.info("driver closed after test method");
	}

}
