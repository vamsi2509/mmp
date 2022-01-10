package facebooktestcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import facebookpages.LoginPageFB;
import library.BrowserFactory;
import library.XLUtility;

public class FBLoginTC2DDT {
	@Test(dataProvider = "logindata")
	public void loginDDT(String uname,String pass)throws InterruptedException {
		
		
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
	
	@DataProvider(name="logindata")
	public String[][] loginCredentials() throws IOException
	{
		String path=".\\TestData\\sample (1).xlsx";
		XLUtility utils=new XLUtility(path);
		int totalrows=utils.getRowCount("Sheet1");
		int totalcols=utils.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];
		for(int i=0;i<totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i][j]=utils.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;
		
	}

}
