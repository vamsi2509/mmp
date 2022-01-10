package library;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SSUtility {
	public static String getScreenshot(WebDriver driver)
	{
	 
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	 
	File source=ts.getScreenshotAs(OutputType.FILE);
	
	//String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
	
	String path=System.getProperty("user.dir")+"/Screenshot/"+dateName+".png";
	
	File destination= new File(path);
	try {
		
	FileUtils.copyFile(source, destination);
	
	System.out.println("Screenshot taken");
	} 
	catch (IOException e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	}
	return path; 
	}
	}
