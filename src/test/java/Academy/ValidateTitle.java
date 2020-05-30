package Academy;

import java.io.IOException;
import org.junit.*;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;


public class ValidateTitle extends Base{
	
	WebDriver driver = null;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		
		System.out.println("Before Test");
		

		driver = initializeDriver();
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));

	}
	
	@Test
	public void validateTitle() throws IOException
	{
		
				
		LandingPage lp = new LandingPage(driver);
		
		String t = lp.getTitle().getText();
		
		
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES123");
		
	}	
	
	@AfterTest
	public void closeBrowsers()
	{
		System.out.println("After Test");
		driver.close();
		
	}

}
