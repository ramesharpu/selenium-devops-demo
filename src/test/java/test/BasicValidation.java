package test;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicValidation {

	public static WebDriver driver;

	@BeforeTest
	public void beforeTest() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options);

		driver.get("https://www.facebook.com");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void titleValiadation() {
		String expectedResult = "Facebook – log in or sign up";
		String actualResult = driver.getTitle();

		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);

		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title,");
	}

	@Test
	public void welcomeMessageValiadation() {
		String expectedResult = "Facebook helps you connect and share with the people in your life.";

		WebElement elem = driver.findElement(By.xpath("//h2[@class='_8eso']"));
		String actualResult = elem.getText();

		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);

		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title,");
	}
}
