package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HelperClass {

	// See the Mukesh frame work videos

	public void getScreenshot(WebDriver driver, String failedtestcasename) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		//FileUtils.copyFile(src, new File(".\\LibraryFolder\\Failuretestcases_screenshots\\" + failedtestcasename
			//	+ "_screenshot_" + HelperClass.getCurrentDateTime() + ".png"));

		// File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		// FileUtils.copyFile(src1, new File("path of image to be svaed"));

	}

	public static String getCurrentDateTime() {
		Date date = new Date();

		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/YYYY_hh_mm_ss");

		return sfd.format(date);
		// System.out.println(sfd.format(date));

	}

}
