package academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import junit.framework.Assert;
import pageobjects.LandingPage;
import pageobjects.RegisterPage;
import resources.Base;
import utils.TestUtil;

public class Registration extends Base {

	public static String sheetName = "FIRSTXCELNAME3";
	TestUtil testUtil;

	@BeforeMethod
	public void openUrl() throws IOException {
		driver = initializeDriver();
		// log.info("Driver initialized");
		driver.get(url1);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath(
				"//div[@style='position: absolute; top: 0px; left: 0px; bottom: 0px; right: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;']"))
				.click();

		// log.info("Opened url successfully");

	}

	@Test(dataProvider = "getdata")
	public void register(String fullname, String emailid, String password) throws IOException {
		LandingPage lp = new LandingPage(driver);

		lp.register.click();

		RegisterPage rg = new RegisterPage(driver);

		rg.fullname.sendKeys(fullname);
		rg.emailid.sendKeys(emailid);
		rg.password.sendKeys(password);
		rg.confirmpassword.sendKeys(password);

		rg.termsconditions.click();
		rg.signUp.click();

	}

	@Test
	public <HardAssert> void assertEqulasverify() {
		String actual = "Actaul";
		String expected = "Expected";

		SoftAssert sft = new SoftAssert();

		Assert.assertEquals(actual, expected);

		Assert.assertTrue(true);
		Assert.assertFalse(false);

	}

	@DataProvider(name = "getdata")
	public Object[][] getData() throws IOException {
		testUtil = new TestUtil();

		Object[][] data = TestUtil.getTestData(sheetName);

		/*
		 * Object[][] ob=new Object[1][3];
		 * 
		 * ob[0][0]="Anumanthu"; ob[0][1]="nandinikindinti@gmail.com";
		 * ob[0][2]="Divya@143";
		 * 
		 */

		return data;

	}

}
