package facebooktestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import facebookpages.LoginPageFB;
import library.BrowserFactory;

public class FBLoginTC {

	public static void main(String[] args) throws InterruptedException {
		
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("D:\\Reports\\FacebookLoginReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("FB Login Test");
		WebDriver driver=BrowserFactory.startBrowser("chrome","https://www.facebook.com/login.php/");
		LoginPageFB login=PageFactory.initElements(driver, LoginPageFB.class);
		login.LoginToFB("vamsi","vamsi");
		Thread.sleep(5000);
		String actual_url="https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100";
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(actual_url.equalsIgnoreCase(driver.getCurrentUrl()));
		test.log(Status.PASS,"Test Case has been Passed");
		extent.flush();

	}

}
