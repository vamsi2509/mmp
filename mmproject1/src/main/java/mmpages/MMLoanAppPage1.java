package mmpages;





import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import org.testng.Assert;



import library.Fwait;

public class MMLoanAppPage1 {
	
	WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//div[@class='app-wrapper__container']//div[@class='col col-12 col-l-8 getstarted']/h1")
	@CacheLookup
	WebElement welcomemsg;
	
	@FindBy(how=How.XPATH,using="//input[@name='firstName']")
	@CacheLookup
	WebElement firstname;
	
	@FindBy(how=How.XPATH,using="//input[@name='lastName']")
	@CacheLookup
	WebElement lastname;
	
	@FindBy(how=How.XPATH,using="//input[@name='dob']")
	@CacheLookup
	WebElement dob;
	
	@FindBy(how=How.XPATH,using="//input[@name='sin']")
	@CacheLookup
	WebElement sin;
	
	@FindBy(how=How.XPATH,using="//input[@name='phone']")
	@CacheLookup
	WebElement phonenum;
	
	@FindBy(how=How.XPATH,using="//input[@name='email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(how=How.XPATH,using="//input[@name='address']")
	@CacheLookup
	WebElement address;
	
	@FindBy(how=How.XPATH,using="//button[normalize-space()='Yes']")
	@CacheLookup
	WebElement rentbtnyes;
	
	@FindBy(how=How.XPATH,using="//button[text()='No']")
	@CacheLookup
	WebElement rentbtnno;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='$0']")
	@CacheLookup
	WebElement rentshare;
	
	@FindBy(how=How.XPATH,using="//button[@id='gs-accept']")
	@CacheLookup
	WebElement nextbtn;

	
	public MMLoanAppPage1(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		Fwait.isLoaded(driver, welcomemsg);
	}
	
	
	public void loanFormFill(String fname,String lname,String date,String SSN, String mobileno,String mail, String add) throws InterruptedException
	//public void loanFormFill() throws InterruptedException
	{
		String actual_message=welcomemsg.getText();
		String expected_message="Welcome!";
		Assert.assertTrue(actual_message.equals(expected_message));
		System.out.println("Landed in a Perfect Page1");
		
		firstname.sendKeys(fname);
		//firstname.sendKeys("Kelvin");
		lastname.sendKeys(lname);
		//lastname.sendKeys("peter");
		dob.sendKeys(date);
		//dob.sendKeys("1989/04/17");
		sin.sendKeys(SSN);
		//sin.sendKeys("945 820 843");
		phonenum.sendKeys(mobileno);
		//phonenum.sendKeys("6135550197");
		email.sendKeys(mail);
		//email.sendKeys("hazidautreye-2979@yopmail.com");
		address.sendKeys(add);
		//address.sendKeys("C-80 Du");
		Thread.sleep(8000);
		
		address.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		address.sendKeys(Keys.ENTER);
	
		
		Thread.sleep(5000);
		rentbtnyes.click();
		
	

		Thread.sleep(5000);
		rentshare.sendKeys("1000");
		nextbtn.click();
	}
}
