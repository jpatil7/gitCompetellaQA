package com.competella.qaframework.selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxDriverManager extends DriverManagerInternal {
    public void createWebDriver() {
        FirefoxProfile profile = new FirefoxProfile();

        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", "c:\\downloads\\baba");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        //options.addArguments("--headless");
        driver = new FirefoxDriver(options);
            }
    
    public void createWebDriver1() {
        FirefoxProfile profile = setFirefoxProfile();
//
//        profile.setPreference("browser.download.folderList", 2);
//        profile.setPreference("browser.download.manager.showWhenStarting", false);
//        profile.setPreference("browser.download.dir", "c:\\downloads\\baba");
//        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
            }
    
    private FirefoxProfile setFirefoxProfile() {
    	FirefoxProfile profile = new FirefoxProfile();

        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", "c:\\downloads\\baba");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		return profile;
	}
    

    
    
}
