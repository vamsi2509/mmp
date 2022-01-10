package mmtestcases;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import library.SSUtility;
import library.XLUtility;
import mmpages.MMHomePage;
import mmpages.MMLoanAppPage1;
import mmpages.MMLoanAppPage2;
import mmpages.MMLoanAppPage3;
import mmpages.MMLoanAppPage4;
import mmpages.MMLoanAppPage5;
import mmpages.MMLoanAppPage6;

public class LoanApplyMM 
	{
	
	WebDriver driver;
	MMHomePage mmh;
	MMLoanAppPage1 mmlp1;
	MMLoanAppPage2 mmlp2;
	MMLoanAppPage3 mmlp3;
	MMLoanAppPage4 mmlp4;
	MMLoanAppPage5 mmlp5;
	MMLoanAppPage6 mmlp6;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2); 
		ChromeOptions options = new ChromeOptions();               
		options.setExperimentalOption("prefs", prefs);
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://qac.moneymart.ca/home");
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/MMSampleReport"+dateName+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("MM Sample Report");
	}
	
	
	
	@Test(dataProvider = "DummyData")
	public void lApply(String fname,String lname,String date,String SSN, String mobileno,String email, String add,String emptype,String cemp,String ephone,String payperoid,String lpaydate,String npaydate,String paychamt,String takehome,String secq,String seca,String cpwd,String cfpwd) throws InterruptedException, IOException
	//public void lApply() throws InterruptedException
	{
		
		
		logger.log(Status.INFO, "Home Page Started");
		mmh=new MMHomePage(driver);
		mmh.applyloan();
		
		logger.log(Status.INFO,"Page 1 Started");
		mmlp1=new MMLoanAppPage1(driver);
		mmlp1.loanFormFill(fname,lname,date,SSN,mobileno,email,add);
		//mmlp1.loanFormFill();
		logger.log(Status.INFO,"Data has been Entered Successfully");
		String path=SSUtility.getScreenshot(driver);
		logger.addScreenCaptureFromPath(path);
		extent.flush();
		
		
		ExtentTest logger2=extent.createTest("MM Page 2 Report");
		logger2.log(Status.INFO,"Page 2 Started");
		mmlp2=new MMLoanAppPage2(driver);
		mmlp2.loanFormFill();
		String path2=SSUtility.getScreenshot(driver);
		logger2.addScreenCaptureFromPath(path2);
		extent.flush();
		
		ExtentTest logger3=extent.createTest("MM Page 3 Report");
		logger3.log(Status.INFO,"Page 3 Started");
		mmlp3=new MMLoanAppPage3(driver);
		mmlp3.loanFormFill(emptype,cemp,ephone,payperoid,lpaydate,npaydate,paychamt,takehome);
		String path3=SSUtility.getScreenshot(driver);
		logger3.addScreenCaptureFromPath(path3);
		extent.flush();
		
		ExtentTest logger4=extent.createTest("MM Page 4 Report");
		logger4.log(Status.INFO,"Page 4 Started");
		mmlp4=new MMLoanAppPage4(driver);
		mmlp4.loanFormFill();
		String path4=SSUtility.getScreenshot(driver);
		logger4.addScreenCaptureFromPath(path4);
		extent.flush();
		
		/*
		ExtentTest logger5=extent.createTest("MM Page 5 Report");
		logger5.log(Status.INFO,"Page 5 Started");
		mmlp5=new MMLoanAppPage5(driver);
		mmlp5.loanFormFill(secq,seca,cpwd,cfpwd);
		String path5=SSUtility.getScreenshot(driver);
		logger5.addScreenCaptureFromPath(path5);
		extent.flush();
		*/
		
		ExtentTest logger6=extent.createTest("MM Page 6 Report");
		logger6.log(Status.INFO,"Page 6 Started");
		mmlp6=new MMLoanAppPage6(driver);
		mmlp6.loanFormFill(cpwd);
		String path6=SSUtility.getScreenshot(driver);
		logger6.addScreenCaptureFromPath(path6);
		extent.flush();
	}
	
	@DataProvider(name="DummyData")
	public String[][] logindata() throws IOException
	{
		String path="./TestData/test.xlsx";
		
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
	

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	/*
	@AfterTest
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path=SSUtility.getScreenshot(driver);
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		}
		
		driver.quit();
	
	}
	*/
	
	
	

}
