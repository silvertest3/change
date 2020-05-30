package Academy;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;

public class HomePageChecks extends Base{
	
	Logger Log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		
		System.out.println("Before Test");
		

		driver = initializeDriver();
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		
		Log.info("Driver Initialized in Test ");
		
		
	}
	
	@Test(dataProvider = "getData")
	public void validateHomePage(String username, String password) throws IOException
	{
		
		
		LandingPage lp = new LandingPage(driver);
		
		lp.getLogin().click();
		
		LoginPage login = new LoginPage(driver);
		
		login.getusername().sendKeys(username);
		login.getpassword().sendKeys(password);
		
		Log.info("Test Iteration for Login ");
		
	}
	
	@DataProvider
	public Object[][] getData()
	
	{
		Object[][] data = new Object [1][2];
		
		data[0][0] = "Username1@user.com";
		data[0][1] = "Password1";
		
	
		
		return data;
	}
	
	@AfterTest
	public void closeBrowsers()
	{
		System.out.println("After Test");
		driver.close();
		
	}

}
