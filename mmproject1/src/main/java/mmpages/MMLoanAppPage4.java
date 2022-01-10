package mmpages;






import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;



import library.Fwait;

public class MMLoanAppPage4 {
	
	WebDriver driver;
	@FindBy(how=How.XPATH,using="//h1[@class='mb-2 mm-picra__cta__header']")
	@CacheLookup
	WebElement welcomemsg;
	
	@FindBy(how=How.XPATH,using="//input[@class='mm-checkbox__input']")
	@CacheLookup
	WebElement checkbox;
	
	@FindBy(how=How.XPATH,using="//button[@id='gs-accept']")
	@CacheLookup
	WebElement agreebtn;
	
	
	public MMLoanAppPage4(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		Fwait.isLoaded(driver,welcomemsg);
	}
	
	public void loanFormFill() throws InterruptedException
	{
		String actual_message=welcomemsg.getText();
		String expected_message="We need your approval";
		Assert.assertTrue(actual_message.equals(expected_message));
		System.out.println("Landed in a Perfect Page4");
		
		
		Actions actions = new Actions(driver);
		actions.moveToElement(checkbox).click().build().perform();
		
		
		agreebtn.click();
		
	}
}
