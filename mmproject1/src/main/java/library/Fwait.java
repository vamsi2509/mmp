package library;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class Fwait
{
	public static void isLoaded(WebDriver driver,final WebElement element) throws Error {
	    new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(180))
	            .pollingEvery(Duration.ofSeconds(20))
	            .ignoring(NoSuchElementException.class)
	            .ignoring(StaleElementReferenceException.class)
	            .until(new Function<WebDriver, Boolean>() {
	               
	            		public Boolean apply(WebDriver webDriver) {
	                  
	                    return element != null && element.isDisplayed();
	                }
	            });
	}

}
