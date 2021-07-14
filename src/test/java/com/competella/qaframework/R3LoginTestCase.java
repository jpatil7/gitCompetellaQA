package com.competella.qaframework;

import com.competella.qaframework.entities.Credentials;
import com.competella.qaframework.pages.R3LoginPage;
import com.competella.qaframework.pages.R3MainPage;
import com.competella.qaframework.pages.MicrosoftLoginPage;
import com.competella.qaframework.pages.R3ContactCenterPage;
import com.competella.qaframework.selenium.DriverManagerFactory;
import com.competella.qaframework.selenium.DriverManagerInternal;
import com.competella.qaframework.selenium.DriverType;
import com.competella.qaframework.utility.CredentialReader;
import com.competella.qaframework.utility.SnapshotUtil;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class R3LoginTestCase {

    private static final Logger LOGGER = Logger.getLogger(R3LoginTestCase.class);
    private DriverManagerInternal driverManager;
    private WebDriver driver;
    private Credentials credentials;
    private WebDriverWait wait;
   
    
    @BeforeTest
    public void setUp() {
    	System.setProperty("webdriver.gecko.driver","C:\\Work\\Softwares\\geckodriver\\geckodriver-v0.29.0-win64\\geckodriver.exe");
    	driverManager = DriverManagerFactory.getDriverManager(DriverType.firefox);
        driver = driverManager.getWebDriver();
        if (null == driver) {
        	LOGGER.error("Driver Manager having null value");
        	throw new NullPointerException ("Drvier Manager having null value");
        }
        driver = driverManager.getWebDriver();
        //credentials = Credentials.getInstance();
        credentials = CredentialReader.readCredentials();
        driver.get(credentials.getAccessURL());
    }

    
    
    @AfterTest
    public void tearDown() {
        driverManager.quitWebDriver();
    }

    
    @Test
    public void loginTest() throws InterruptedException {
    	R3LoginPage loginPage = new R3LoginPage(driver);
    	Thread.sleep(10000);
    	AssertJUnit.assertTrue("R3-Login page is not loaded", loginPage.isPageLoaded());
    	loginPage.login(credentials.getUserName(), credentials.getPassword());
    	Thread.sleep(1000);
        SnapshotUtil.takeSnapShot(driver, credentials.getScreenshotPath());
       
        MicrosoftLoginPage microsoftLoginPage = new MicrosoftLoginPage(driver);
        Thread.sleep(10000);
        AssertJUnit.assertTrue("Microsoft page is not loaded", microsoftLoginPage.isPageLoaded());
        microsoftLoginPage.login(credentials.getPassword());
        wait = new WebDriverWait(driver, 20);
        Thread.sleep(10000);
        R3MainPage r3mainPage = new R3MainPage(driver);
        Thread.sleep(10000);
        AssertJUnit.assertTrue("Main page is not loaded", r3mainPage.isPageLoaded());
        LOGGER.info("Login Successful");
        String Cs = "Contact Center";
        r3mainPage.openPage(Cs);
        Thread.sleep(10000);
        R3ContactCenterPage r3ContactCenterPage = new R3ContactCenterPage (driver);
        AssertJUnit.assertTrue("Contact center page is not loaded", r3ContactCenterPage.isContactCenterPageLoaded());
        SnapshotUtil.takeSnapShot(driver, credentials.getScreenshotPath());
    }
}
