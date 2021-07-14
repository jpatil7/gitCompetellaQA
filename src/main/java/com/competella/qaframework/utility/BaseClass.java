package com.competella.qaframework.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.competella.qaframework.entities.Credentials;
import com.competella.qaframework.selenium.DriverManagerFactory;
import com.competella.qaframework.selenium.DriverManagerInternal;
import com.competella.qaframework.selenium.DriverType;

public class BaseClass {

	// private static final Logger LOGGER = Logger.getLogger(R3LoginTestCase.class);
	private DriverManagerInternal driverManager;
	private WebDriver driver;
	private Credentials credentials;
	private WebDriverWait wait;

	public void initializeDriver() throws IOException {
		
		Properties Prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Work\\Automation\\R3\\R3\\src\\main\\java\\data.properties");
		Prop.load(fs);
		String browserName= Prop.getProperty("Browser");
		
		
		if(browserName == "Chrome") {
			
		}
		else if(browserName == "IE") {
			
		}
		else if(browserName == "Firefox") {
	
}
				
		System.setProperty("webdriver.gecko.driver",
				"C:\\Work\\Softwares\\geckodriver\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driverManager = DriverManagerFactory.getDriverManager(DriverType.firefox);
		driver = driverManager.getWebDriver();
		if (null == driver) {
			
			throw new NullPointerException("Drvier Manager having null value");
		}
		driver = driverManager.getWebDriver();
		// credentials = Credentials.getInstance();
		credentials = CredentialReader.readCredentials();
		driver.get(credentials.getAccessURL());
	}
}