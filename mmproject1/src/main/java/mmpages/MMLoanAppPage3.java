package mmpages;




import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;



import library.Fwait;

public class MMLoanAppPage3 {
	
	WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//div[@id='financial-status-form']//div[@class='font-weigh-400 text-black font-size-more-4 pb-1 pt-1 line-height-6']/h1")
	@CacheLookup
	WebElement welcomemsg;

		
	public MMLoanAppPage3(WebDriver driver) throws InterruptedException
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		Fwait.isLoaded(driver, welcomemsg);	
	}
	 
	
	//public void loanFormFill() throws InterruptedException
	public void loanFormFill(String emptype,String cemp,String ephone,String payperoid,String lpaydate,String npaydate,String paychamt,String takehome) throws InterruptedException
	{
		String actual_message=welcomemsg.getText();
		String expected_message="Looking good!";
		Assert.assertTrue(actual_message.equals(expected_message));
		System.out.println("Landed in a Perfect Page3");
		
		
		
		driver.findElement(By.xpath("(//button[@class='mm-select__value'])[1]")).click();
		
		Thread.sleep(3000);
		
		List<WebElement> emplist=driver.findElements(By.xpath("//div[@class='mm-dropdown__menu']/button"));
		
		for(WebElement el:emplist)
		{
			//if(el.getText().equalsIgnoreCase("Full Time Employed"))
			if(el.getText().equalsIgnoreCase(emptype))
			{
				el.click();
				break;
			}
		}
		
		//new Select(driver.findElement(By.xpath("(//span[@class='mm-select'])[1]//select"))).selectByValue("FT");
		//driver.findElement(By.xpath("(//span[@class='mm-select'])[1]//select/option[2]")).click();
		
		//@SuppressWarnings("deprecation")
		//WebDriverWait wait = new WebDriverWait(driver,120);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class='mm-input mm-gs-input']"))));
		
		Thread.sleep(5000);
		
		//Fwait.isLoaded(driver,driver.findElement(By.xpath("//input[@class='mm-input mm-gs-input']")));
		
		WebElement currentemployer=driver.findElement(By.xpath("//input[@class='mm-input mm-gs-input']"));
		//currentemployer.sendKeys("BMW");
		currentemployer.sendKeys(cemp);
		
		WebElement employerphonenum=driver.findElement(By.xpath("//input[@placeholder='XXX-XXX-XXXX']"));
		//employerphonenum.sendKeys("8987766767");
		employerphonenum.sendKeys(ephone);
		
		//new Select(driver.findElement(By.xpath("//div[@class='mm-form-field mm-form-field--has-value']//select"))).selectByVisibleText("Same day every month");
		
		driver.findElement(By.xpath("(//button[@class='mm-select__value'])[2]")).click();
		
		Thread.sleep(3000);
		
		List<WebElement> oftenpaidlist=driver.findElements(By.xpath("//div[@class='mm-dropdown__menu']/button"));
		
		for(WebElement opl:oftenpaidlist)
		{
			//if(opl.getText().equalsIgnoreCase("Same day every month"))
			if(opl.getText().equalsIgnoreCase(payperoid))
			{
				opl.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("(//input[@class='mm-input'])[2]")).sendKeys(lpaydate);
		
		driver.findElement(By.xpath("(//input[@class='mm-input'])[3]")).sendKeys(npaydate);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(paychamt);
		
		driver.findElement(By.xpath("(//input[@class='mm-input'])[5]")).sendKeys(takehome);
		
		driver.findElement(By.xpath("//button[@id='gs-accept']")).click();
		}
	}
