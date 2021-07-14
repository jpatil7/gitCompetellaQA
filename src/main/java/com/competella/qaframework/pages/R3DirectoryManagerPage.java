package com.competella.qaframework.pages;
import org.testng.Assert;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class R3DirectoryManagerPage {
    private static final Logger LOGGER = Logger.getLogger(R3DirectoryManagerPage.class);
    private WebDriver driver;

    public R3DirectoryManagerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String pageName) {
        if (pageName.contains("Stat"))
            clickOnStatLink(pageName);
        else if (pageName.contains("queue"))
            clickOnQueueHandling(pageName);
    }

    public void clickOnStatLink(String pageName) {
        driver.findElement(By.linkText("Statistics & Logs")).click();
        LOGGER.info("Found Statistics Link");
    }

    public void clickOnQueueHandling(String pageName) {
        driver.findElement(By.linkText("Queue handling")).click();
        LOGGER.info("Found Queue handling");
    }

    public boolean isPageLoaded1() {
        try {
            
        	driver.findElements(By.className("mat-card-title")).get(2).isDisplayed();
        	driver.findElement(By.className("mat-card-title")).isDisplayed();
        	System.out.print("Return of Page Loaded: " + driver.findElement(By.className("mat-card-title")).getText());
        } catch (Exception ex) {
            LOGGER.error("Lead Class not found");
            return false;
        }
        List<WebElement> pageElement =driver.findElements(By.className("mat-card-title"));
        System.out.print("Return of Page Loaded: " + pageElement.get(2).isDisplayed());
        return pageElement.get(2).isDisplayed();
    }
    
    public boolean isPageLoaded() {
        try {
        	 List<WebElement> pageElement =driver.findElements(By.className("mat-card-title"));
        	 Boolean pageElementStatus = pageElement.get(2).isDisplayed(); 
        	 System.out.print("R3 Main Page Is Loaded: " + pageElementStatus+"\n");
        	 return pageElementStatus;
        } catch (Exception ex) {
            LOGGER.error("Lead Class not found");
            return false;
        }
    }
    
    public boolean isContactCenterPageLoaded() {
      
        	boolean state;
            driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.ng-star-inserted")));
        	if(driver.findElements(By.xpath("//button[contains(@id,'mat-button-toggle')]")).size() == 6)
        	{
        		System.out.println("Page is loaded");
        		state = true;
        	}
        	else
        	{
        		Assert.fail("Page is not loaded");
        		state = false;
        	};
        	driver.switchTo().defaultContent();
			return state;
        	
        	
        }
}
