package StepDefinitions;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/resources/Features", glue="StepDefinitions")

public class Runner extends AbstractTestNGCucumberTests
{
	public static final Logger log = Logger.getLogger(Runner.class);
	public static final String LOG_FILE= "log4j.properties";
	
	@BeforeClass	
	public void setUpClass() throws FileNotFoundException, IOException
	{		
		Properties logProperties = new Properties();
		log.info("started");
		logProperties.load(new FileInputStream(System.getProperty("user.dir")+"\\log4j.properties"));
		PropertyConfigurator.configure(logProperties);
        log.info("Logging initialized.");    
        System.out.println("Test Started");
	}
	
	 @AfterClass
	 public void tearDownClass() throws Exception 
	 {
	       System.out.println("Test End");
	       
	 }
	
	
	
	
}
