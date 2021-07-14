package com.competella.qaframework.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class R3MainPage {
    private static final Logger LOGGER = Logger.getLogger(R3MainPage.class);
    private WebDriver driver;

    public R3MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String pageName) {
        if (pageName.contains("Contact Center"))
         	clickOnStatLink(pageName);
        else if (pageName.contains("queue"))
            clickOnQueueHandling(pageName);
    }

    public void clickOnStatLink(String pageName) {
    	String s = "//div/mat-card-title[contains(text(),"+pageName+"]";
    	System.out.println(pageName);
        driver.findElement(By.xpath("//div/mat-card-title[contains(text(),'"+pageName+"')]")).click();
        LOGGER.info("Contact Center Link");
    }

    public void clickOnQueueHandling(String pageName) {
        driver.findElement(By.linkText("Queue handling")).click();
        LOGGER.info("Found Queue handling");
    }

    public boolean isPageLoaded1() {
        try {
            
        	driver.findElements(By.className("mat-card-title")).get(2).isDisplayed();
        	//driver.findElements(By.className("mat-card-title")).get(2).
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
        	 System.out.print("Text on Contact center mat card:  " + pageElement.get(2).getText());
        	 System.out.print("R3 Main Page Is Loaded: " + pageElementStatus+"\n");
        	 return pageElementStatus;
        } catch (Exception ex) {
            LOGGER.error("Lead Class not found");
            return false;
        }
    }
}
