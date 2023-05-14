package com.qa.hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private ConfigReader configReader;
	private DriverFactory driverfactory;
	private WebDriver driver;
	Properties prop;
	//check whether we need to create object of DriverFactory
	
	@Before(order=0)
	public void getproperty() {
		 configReader = new ConfigReader() ;
		 prop = configReader.init_prop();
	}
	
	@Before(order=1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver= driverfactory.init_driver(browserName);
		
	}

//	@After(order=0)
//	public void quitbrowser() {
//		driver.quit();//this will throw null pointer exception if we didn't 
//		//store the driverfactory.init_driver(browserName) to driver in line no 30
//	}
	
	@After(order=1)
	public void teardown(Scenario scenario) {
		if(scenario.isFailed()) {
			String ScreenshotName =scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", ScreenshotName);
		}
		
	}
	
		
	

}
