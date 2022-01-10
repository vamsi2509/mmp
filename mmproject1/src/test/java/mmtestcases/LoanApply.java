package mmtestcases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mmpages.MMHomePage;
import mmpages.MMLoanAppPage1;
import mmpages.MMLoanAppPage2;
import mmpages.MMLoanAppPage3;
import mmpages.MMLoanAppPage3_2;


public class LoanApply {
	WebDriver driver;

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
	}
	
	@Test
	public void lApply() throws InterruptedException
	{	
		@SuppressWarnings("deprecation")
		WebDriverWait wait=new WebDriverWait(driver,120);
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='button__container']//div[@class='button-block toggleLoanApplyNow']//a")));
		if(element1.isDisplayed())
		{
			MMHomePage mmh=PageFactory.initElements(driver, MMHomePage.class);
			mmh.applyloan();
			WebElement element2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='app-wrapper__container']//div[@class='col col-12 col-l-8 getstarted']/h1")));
			if(element2.isDisplayed())
			{
				MMLoanAppPage1 mmlp1=PageFactory.initElements(driver, MMLoanAppPage1.class);
				mmlp1.loanFormFill();
				WebElement element3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='app-wrapper__container']//div[@class='containerflinks']/div/h1")));
				if(element3.isDisplayed())
				{
					MMLoanAppPage2 mmlp2=PageFactory.initElements(driver, MMLoanAppPage2.class);
					mmlp2.loanFormFill(); 
					WebElement element4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='financial-status-form']//div[@class='font-weigh-400 text-black font-size-more-4 pb-1 pt-1 line-height-6']/h1")));
					if(element4.isDisplayed())
					{
						MMLoanAppPage3 mmlp3=PageFactory.initElements(driver, MMLoanAppPage3.class);
						mmlp3.loanFormFill();
						@SuppressWarnings("deprecation")
						WebDriverWait wait1= new WebDriverWait(driver, 180);
						WebElement element5=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row']//input[@class='mm-input mm-gs-input']")));
						if(element5.isDisplayed())
						{
							MMLoanAppPage3_2 mmlp3_1=PageFactory.initElements(driver, MMLoanAppPage3_2.class);
							mmlp3_1.LoanFormFill1();
						}
						
						
						}
				}
			}
		}
		else
		{
			System.out.println("TimeOut");
		}
	}
	}


