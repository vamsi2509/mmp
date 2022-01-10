package mmtestcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import library.BaseClass;
import library.SSUtility;
import library.XLUtility;
import mmpages.MMHomePage;
import mmpages.MMLoanAppPage1;
import mmpages.MMLoanAppPage2;
import mmpages.MMLoanAppPage3;
import mmpages.MMLoanAppPage4;


public class LoanApply2 extends BaseClass {
	
	
	MMHomePage mmh;
	MMLoanAppPage1 mmlp1;
	MMLoanAppPage2 mmlp2;
	MMLoanAppPage3 mmlp3;
	MMLoanAppPage4 mmlp4;
	
	@Test(dataProvider = "DummyData")
	public void lApply(String fname,String lname,String date,String SSN, String mobileno,String email, String add) throws InterruptedException, IOException
	//public void lApply() throws InterruptedException
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/MMSampleReport"+dateName+".html");
		// htmlReporter = new ExtentHtmlReporter("./Reports/MMSampleReport2.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest logger1 = extent.createTest("MM Home Page and Page 1 Report");
		
		logger1.log(Status.INFO, "Home Page Started");
		mmh=new MMHomePage(driver);
		mmh.applyloan();
		
		logger1.log(Status.INFO,"Page 1 Started");
		mmlp1=new MMLoanAppPage1(driver);
		mmlp1.loanFormFill(fname,lname,date,SSN,mobileno,email,add);
		//mmlp1.loanFormFill();
		logger1.log(Status.INFO,"Data has been Entered Successfully");
		String path=SSUtility.getScreenshot(driver);
		logger1.addScreenCaptureFromPath(path);
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
		mmlp3.loanFormFill();
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
	
	}


