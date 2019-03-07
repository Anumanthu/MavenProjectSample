package academy;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GitClass {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities ch = new DesiredCapabilities();

		ch.acceptInsecureCerts();
		ch.setBrowserName("chrome");
		ch.setPlatform(Platform.WINDOWS);

		// If we want to run tests on nodes using Selenium Grid

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), ch);

		driver.get("https://www.google.com/");

	}

	public void gitmethod1() {
		System.out.println("This is my gitmethod4");
	}

	public void gitmethod4() {
		System.out.println("This is my gitmethod4");
	}

}

class GitClass2 {

	public static void main(String[] args) {

	}

	public void gitmethod1() {
		System.out.println("This is my gitmethod Git Class 2");

		System.out.println("This is my gitmethod Git Class 3");
		System.out.println("This is my gitmethod Git Class 4");
	}

	public void gitmethod2() {
		System.out.println("This is my gitmethod2 Git Class 2");
	}

	public void gitmethod3() {
		System.out.println("This is my gitmethod3 Git Class 2");
	}

	public void gitmethod4() {
		System.out.println("This is my gitmethod4 Git Class 2");
	}

	public void gitmethod7() {
		System.out.println("This is my gitmethod4 Git Class 7");
	}



	public void gitmethod10() {
		System.out.println("This is my gitmethod4 Git Class 2");
	}

}
