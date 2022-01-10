package facebookpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPageFB {
	WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//input[@name='firstname']")
	@CacheLookup()
	WebElement firstname;
	
	@FindBy(how=How.XPATH,using="//input[@name='lastname']")
	@CacheLookup()
	WebElement surname;
	
	@FindBy(how=How.XPATH,using="//input[@name='reg_email__']")
	@CacheLookup()
	WebElement pemail;
	
	@FindBy(how=How.XPATH,using="//input[@name='reg_email_confirmation__']")
	@CacheLookup()
	WebElement re_email;
	
	@FindBy(how=How.XPATH,using="//input[@name='reg_passwd__']")
	@CacheLookup()
	WebElement pass;
	
	@FindBy(how=How.XPATH,using="//select[@name='birthday_day']")
	@CacheLookup()
	WebElement day_dropdown;
	
	@FindBy(how=How.XPATH,using="//select[@name='birthday_month']")
	@CacheLookup()
	WebElement month_dropdown;
	
	@FindBy(how=How.XPATH,using="//select[@name='birthday_year']")
	@CacheLookup()
	WebElement year_dropdown;
	
	@FindBy(how=How.XPATH,using="//input[@type='radio'][@value='2']")
	@CacheLookup()
	WebElement male_radio;
	
	@FindBy(how=How.XPATH,using="//input[@type='radio'][@value='1']")
	@CacheLookup()
	WebElement female_raio;
	
	@FindBy(how=How.XPATH,using="//input[@type='radio'][@value='-1']")
	@CacheLookup()
	WebElement others_radio;
	
	@FindBy(how=How.XPATH,using="//button[@name='websubmit']")
	@CacheLookup()
	WebElement signUp_btn;
	
	
	public void registerFB(String fname, String sname, String email, String re_en_email, String pwd,String day, String month, String year,String gender)
	{
		firstname.sendKeys(fname);
		surname.sendKeys(sname);
		pemail.sendKeys(email);
		re_email.sendKeys(re_en_email);
		pass.sendKeys(pwd);
		day_dropdown.sendKeys(day);
		month_dropdown.sendKeys(month);
		year_dropdown.sendKeys(year);
		if(gender.equals("male"))
			male_radio.click();
		else if(gender.equals("female"))
		    female_raio.click();
		else if(gender.equals("others"))
			others_radio.click();
		signUp_btn.click();
		
		
	}
}
