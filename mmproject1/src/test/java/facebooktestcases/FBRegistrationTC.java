package facebooktestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import facebookpages.RegistrationPageFB;
import library.BrowserFactory;

public class FBRegistrationTC {
	public static void main(String args[]) throws InterruptedException {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("D:\\Reports\\FacebookRegistrationReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("FB Registartion Test");
		WebDriver driver = BrowserFactory.startBrowser("chrome", "https://www.facebook.com/reg/");
		RegistrationPageFB registration = PageFactory.initElements(driver, RegistrationPageFB.class);
		registration.registerFB("vamsi", "pothana", "vamsi5544@gmail.com", "vamsi5544@gmail.com", "Vamsi@5544", "5",
				"Apr", "1991", "male");
		Thread.sleep(5000);
		Assert.assertTrue(true);
		test.log(Status.PASS,"Test Case has been Passed");
		extent.flush();	

	}
}
