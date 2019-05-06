package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Pages.LoginPage;
import Pages.ToolsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ToolsStepDef 
{
	public WebDriver driver= null;
	ToolsPage tools=new ToolsPage();
	LoginPage login=new LoginPage(); 
	
	
	public ToolsStepDef()
	{
		driver=Hooks.driver;
		
	}
	
	@Given("^User navigate to the MergeDuplicate Page$")
	public void user_navigate_to_the_MergeDuplicate_Page() 
	{      
	    driver.get("https://stage01.convergehub.com/");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     
    	login.username.clear();
   	    login.username.sendKeys("coretest@mailinator.com");
   		login.password.sendKeys("1");
   	    login.login.click();
   	    System.out.println("Successfully Logged");   	    
   	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	   
	  	   //Navigate to the Manage Duplicate Page	    
			driver.get("https://stage01"+".convergehub.com/manageduplicates/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	}

	@When("^user select the module \"([^\"]*)\" and click the FindDuplicate Link$")
	public void user_select_the_module_and_click_the_FindDuplicate_Link(String moduleName) 
	{
	   
		new Select(tools.Module).selectByVisibleText(moduleName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Click the Find Duplicate Link-Partial Link as Test as Link name changes with Module
		driver.findElement(By.partialLinkText("Find Duplicate")).click();
		
	}

	@When("^Click the Email Checkbox and Search Button$")
	public void click_the_Email_Checkbox_and_Search_Button() 
	{			
		//Click the Email Checkbox & Search Button
		tools.ManagedDuplicateEmail.click();
		driver.findElement(By.partialLinkText("Search")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	}

	@Then("^Check for the Search Result$")
	public void check_for_the_Search_Result() 
	{
	    // Write code here that turns the phrase above into concrete actions
		   
	    //*****************************Validate the Search Result***********************************************************
	    try
	    {
	        List<WebElement> srch_cnt=driver.findElements(By.name("selected_record"));
	          
	        if(srch_cnt.size()>0)
	        {
	        	System.out.println("Basic Search return result  :"+srch_cnt.size());  
	        }
	        else
	        {
	        	System.out.println("No records found for the selected search criteras");  
	        }
	       	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("No Record found for the Search");  
	    	e.printStackTrace();
	    	
	    }
	    	       
	}
	
}
