package mmpages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;



import library.Fwait;

public class MMLoanAppPage2 {
	
	WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//div[@class='app-wrapper__container']//div[@class='containerflinks']/div/h1")
	@CacheLookup
	WebElement welcomemsg;
	
	@FindBy(how=How.XPATH,using="//div[@class='box-content']//div[@class='box-text']//p[text()='Express']")
	@CacheLookup
	WebElement expressway;
	
	@FindBy(how=How.XPATH,using="//div[@class='box-content']//div[@class='box-text']//p[text()='Standard']")
	@CacheLookup
	WebElement standardway;
	
	@FindBy(how=How.XPATH,using="//button[@id='gs-exit']")
	@CacheLookup
	WebElement back_btn;
	
	@FindBy(how=How.XPATH,using="//button[@id='gs-accept']")
	@CacheLookup
	WebElement next_btn;
	
	
	
	public MMLoanAppPage2(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		Fwait.isLoaded(driver,welcomemsg);
	}
	public void loanFormFill() throws InterruptedException
	{
		String actual_message=welcomemsg.getText();
		String expected_message="2 ways to apply";
		Assert.assertTrue(actual_message.equals(expected_message));
		System.out.println("Landed in a Perfect Page2");
		
		Thread.sleep(2000);
		standardway.click();
		
		Thread.sleep(2000);
		next_btn.click();
		
	}
}
