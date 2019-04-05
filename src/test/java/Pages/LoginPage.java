package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefinitions.Hooks;

public class LoginPage 
{
	public WebDriver driver;
	
	@FindBy(id="username") public WebElement username;
	@FindBy(id="password") public WebElement password;
	@FindBy(id="loginb")   public WebElement login;
	
	public LoginPage() 
	{
		driver=Hooks.driver;
		PageFactory.initElements(driver, this);
		
	}
}
