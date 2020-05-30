package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	 public WebDriver driver;
	 public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	
	{
		Logger Log = LogManager.getLogger(Base.class.getName());
		
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\perei\\eclipse-workspace\\E2EProject\\src\\main\\java\\Resources\\configuration.properties");
		
		prop.load(fis);
		
		Log.info("Initiated");
		
		//String Browser = prop.getProperty("Browser");
		
		String Browser =System.getProperty("browser");
		
		if(Browser.equals("Chrome"))
		{
			
			System.out.println("Chrome Browser Seleceted");
			
			System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
			Log.info("Chrome Driver Selected");
			
		}
				
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String  takeScreenshot(String MethodName, WebDriver driver) throws IOException
	
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports\\"+MethodName+".png";
		
		FileUtils.copyFile(source,new File(destination));
		return destination;
		
		
		
	}

}
