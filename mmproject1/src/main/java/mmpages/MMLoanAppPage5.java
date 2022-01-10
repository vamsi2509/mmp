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

public class MMLoanAppPage5 {
	
	WebDriver driver;
	@FindBy(how=How.XPATH,using="//h2[text()='Sign up to Money Mart']")
	@CacheLookup
	WebElement welcomemsg;
	
	@FindBy(how=How.XPATH,using="//input[@class='mm-input']")
	@CacheLookup
	WebElement secquesans;
	
	@FindBy(how=How.XPATH,using="//input[@name='newPassword']")
	@CacheLookup
	WebElement chsepwd;
	
	
	@FindBy(how=How.XPATH,using="//input[@name='confirmPassword']")
	@CacheLookup
	WebElement cnfmpwd;
	
	@FindBy(how=How.XPATH,using="//button[@class='mm-btn mm-btn--lg mm-btn--primary']")
	@CacheLookup
	WebElement createbtn;
	
	
	public MMLoanAppPage5(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		Fwait.isLoaded(driver,welcomemsg);
	}
	
	public void loanFormFill(String secq,String seca,String cpwd,String cfpwd) throws InterruptedException
	{
		String actual_message=welcomemsg.getText();
		String expected_message="Sign up to Money Mart";
		Assert.assertTrue(actual_message.equals(expected_message));
		System.out.println("Landed in a Perfect Page5");
		
		
		driver.findElement(By.xpath("//button[@class='mm-select__value']")).click();
		Thread.sleep(3000);
		
		List<WebElement> secques=driver.findElements(By.xpath("//div[@class='mm-dropdown__menu']/button"));
		
		for(WebElement sq:secques)
		{
			//if(sq.getText().equalsIgnoreCase("What was the name of your elementary/primary school?"))
			if(sq.getText().equalsIgnoreCase(secq))
			{
				sq.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		
		secquesans.sendKeys(seca);
		
		chsepwd.sendKeys(cpwd);
		cnfmpwd.sendKeys(cfpwd);
		createbtn.click();
		
		
		
		
	}
}
