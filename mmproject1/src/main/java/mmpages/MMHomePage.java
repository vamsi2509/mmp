package mmpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class MMHomePage {
	
	WebDriver driver;
	
	/*@FindBy(how=How.XPATH,using="//h3[starts-with(text(),'Let')]")
	@CacheLookup
	WebElement welcomemsg;
	
	@FindBy(how=How.XPATH,using="//input[@id='currency-field']")
	@CacheLookup
	WebElement inpuamt;
	
	@FindBy(how=How.XPATH,using="//input[@id='selectTerm_calculator']")
	@CacheLookup
	WebElement termCalDD;*/
	
	
	@FindBy(how=How.XPATH,using="//div[@class='button__container']//div[@class='button-block toggleLoanApplyNow']//a")
	@CacheLookup
	WebElement applynow;
	


	public MMHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void applyloan()
	{
		
		/*String actual_msg=welcomemsg.getText();
		Fwait.isLoaded(driver, welcomemsg);
		Assert.assertTrue(actual_msg.equalsIgnoreCase("Let’s get you started"));
		System.out.println("Perfectly Landed in Home Page");
		
		inpuamt.clear();
		inpuamt.sendKeys("$3000");
		new Select(termCalDD).selectByVisibleText("12 Months");
		*/
		applynow.click();
	}

}
