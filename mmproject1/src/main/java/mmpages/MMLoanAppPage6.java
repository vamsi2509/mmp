package mmpages;







import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;



import library.Fwait;

public class MMLoanAppPage6 {
	
	WebDriver driver;
	@FindBy(how=How.XPATH,using="//h2[text()='Sign in to Money Mart']")
	@CacheLookup
	WebElement welcomemsg;
	
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	@CacheLookup
	WebElement pwd;
	
	
	@FindBy(how=How.XPATH,using="//button[@class='mm-btn mm-btn--lg mm-btn--block mb-2']")
	@CacheLookup
	WebElement signinbtn;
	
	
	public MMLoanAppPage6(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		Fwait.isLoaded(driver,welcomemsg);
	}
	
	public void loanFormFill(String cpwd) throws InterruptedException
	{
		String actual_message=welcomemsg.getText();
		String expected_message="Sign in to Money Mart";
		Assert.assertTrue(actual_message.equals(expected_message));
		System.out.println("Landed in a Perfect Page5");
		
		pwd.sendKeys(cpwd);
		signinbtn.click();
		
		
	}
}
