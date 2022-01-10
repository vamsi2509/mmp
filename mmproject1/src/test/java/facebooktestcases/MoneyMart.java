package facebooktestcases;


import java.util.HashMap;

import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class MoneyMart {
	
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);              
		ChromeOptions options = new ChromeOptions();               
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://qac.moneymart.ca/home");
	}
	
	@Test
	public void loanCreation() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='body__content--info']//span[text()='Apply Now']")).click();
		Thread.sleep(3000);
		String e_message=driver.findElement(By.xpath("//div[@class='row']//h1[text()='Welcome!']")).getText();
		String a_messge="Welcome!";
		Assert.assertTrue(a_messge.equals(e_message));
		System.out.println("We were landed in a Perfect Page");
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("vamsi");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("krishna");
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("1991/04/03");
		driver.findElement(By.xpath("//input[@name='sin']")).sendKeys("128 065 760");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9898989898");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("civaucillumou-5056@yopmail.com");
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("A-2882 Lake Shore Blvd W, ETOBICOKE ON M8V 1J2, CANADA");
		
		driver.findElement(By.xpath("//button[@class='mm-btn mm-btn--lg mm-btn--secondary bt-sec selected']")).click();
		driver.findElement(By.xpath("//input[@placeholder='$0']")).sendKeys("$1000");
		driver.findElement(By.xpath("//button[@id='gs-accept']")).click();
		
	}
	/*
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	*/
	

}
