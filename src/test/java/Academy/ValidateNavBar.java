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


public class ValidateNavBar extends Base{
	
	@BeforeTest
	public void initialize() throws IOException
	{
		
		System.out.println("Before Test");
		

		driver = initializeDriver();
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
	
	}
	
	@Test
	public void validateNavBar() throws IOException
	{
		
				
		LandingPage lp = new LandingPage(driver);
		
		
		
		
		Assert.assertTrue(lp.getnavbar().isDisplayed());
		
	}	
	
	@AfterTest
	public void closeBrowsers()
	{
		System.out.println("After Test");
		driver.close();
		
	}

}
