package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefinitions.Hooks;


public class ToolsPage 
{
	public WebDriver driver;
	
	//Manage Duplicate -Elements	
	@FindBy(id="module_select_drp_dwn") public WebElement Module;//Select
	//By.partiallinkTest-Find Duplicate
	@FindBy(id="search_flds_email") public WebElement ManagedDuplicateEmail;//Checkbox
	//By.LinkTest-Search

	
	public ToolsPage() 
	{
		driver=Hooks.driver;
		PageFactory.initElements(driver, this);
	}

}
