package library;



import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
	{
	
	protected WebDriver driver;
	
	//ExtentReports extent;
	//ExtentTest logger;
	
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
		//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/MMSampleReport"+dateName+".html");
		//extent = new ExtentReports();
		//extent.attachReporter(htmlReporter);
		//logger = extent.createTest("MM Sample Report");
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
		extent.flush();
		driver.quit();
	
	}
	*/
	
	

}
