package facebookpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageFB {

	WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//input[@name='email']")
	@CacheLookup()
	WebElement username;
	
	@FindBy(how=How.XPATH,using="//input[@name='pass']")
	@CacheLookup()
	WebElement password;
	
	@FindBy(how=How.XPATH,using="//button[@name='login']")
	@CacheLookup()
	WebElement login_btn;
	
	public LoginPageFB(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void LoginToFB(String uname, String Pass)
	{
		username.sendKeys(uname);
		password.sendKeys(Pass);
		login_btn.click();
	}
}
