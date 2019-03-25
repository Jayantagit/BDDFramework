package StepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks 
{
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	@Before
	public void OpenBrowser()
	{
		
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\chromedriver.exe");
		 driver=new ChromeDriver();
		 System.out.println("Chrome Driver Luanched");   
		
	}
	
	
	@After
	public void TakeScreenshotPostTests(Scenario scenario)
	{
		if(scenario.isFailed()) 
		{
			try 
			{
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} 
			catch (WebDriverException somePlatformsDontSupportScreenshots) 
			{
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			} 
			
		}
		driver.close();
		
	}

}
