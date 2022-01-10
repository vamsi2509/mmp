package browserInitaiation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeInitiation {
	WebDriver driver;

	@BeforeTest
	public void startUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}

	@Test
	public void InvokingChrome() throws IOException {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("D:\\Reports\\ChromeInitaiationReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("MyFirstTest");

		int no_of_links = driver.findElements(By.tagName("a")).size();
		System.out.println("No of Links in the Google Home Page is:" + no_of_links);
		Assert.assertTrue(true);
		test.pass("Test Case is Passed",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\1003060\\Downloads\\sample.png").build());;
		extent.flush();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
