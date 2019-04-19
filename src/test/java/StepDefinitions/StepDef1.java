package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Pages.LeadPage;
import Pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDef1 
{
	public WebDriver driver= null;
	LeadPage lead=new LeadPage();
	LoginPage login=new LoginPage(); 
	
	public StepDef1() 
	{ 		
		driver = Hooks.driver;		
	} 
	
	@Given("^Already Logged in to ConvergeHub site$")	
	public void already_Logged_in_to_ConvergeHub_site() throws Throwable 
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
   	  
	}

	@When("^I navigate to Lead List and enter the Name \"([^\"]*)\" for Quick Search$")
	public void i_navigate_to_Lead_List_and_enter_the_Name_for_Quick_Search(String searchText) throws Throwable 
	{
		
		driver.get("https://stage01"+".convergehub.com/leads");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lead.BasicSearchTxt.clear();
		lead.BasicSearchTxt.sendKeys(searchText);
		
	}

	@Then("^Search result will appear$")	
	public void search_result_will_appear() throws Throwable 
	{
		
		lead.Gobtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	   
		//*****************************Validate the Search Result**********************************
	    try
	    {
	        List<WebElement> Leads_num=driver.findElements(By.xpath("//input[@class='list_checkbox']"));	          
	        if(Leads_num.size()>0)
	        {
	        	System.out.println("Basic Search return result  :"+Leads_num.size());  
	        }
	        else
	        {
	        	System.out.println("No records found for the selected search criteras for Quick search");  
	        }
	       	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("No Record found for the Search");  
	    	e.printStackTrace();	    	
	    }
}

}
