package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefinitions.Hooks;

public class LeadPage 
{
		public WebDriver driver;
		//Basic Search
		@FindBy(id="Searchtxt") public WebElement BasicSearchTxt;
		@FindBy(xpath="//div[@class='listing-top']/ul/li[2]/a[contains(text(),'Go')]") public WebElement Gobtn;
		
				
		public LeadPage() 
		{
			driver=Hooks.driver;
			PageFactory.initElements(driver, this);
			
		}

	
	

}
