package com.competella.qaframework.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MicrosoftLoginPage {
	private static final Logger LOGGER = Logger.getLogger(MicrosoftLoginPage.class);
	private WebDriver driver;

	public MicrosoftLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String password) {
		setPassword(password);
		clickSignInButton();
		clickStaySignInButton();
	}

	public void setPassword(String password) {
		By passwordTextBox = By.id("i0118");
		driver.findElement(passwordTextBox).sendKeys(password);
		LOGGER.info("Entered User Name: " + driver.findElement(passwordTextBox));
	}

	public void clickStaySignInButton() {
		By approveButton = By.id("idSIButton9");
		WebElement button1 = driver.findElement(approveButton);
		button1.click();
		LOGGER.info("Login button clicked.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			LOGGER.error("Interrupted while approving the login.", ex);
		}
		LOGGER.info("Clicked login button");
	}

	public void clickSignInButton() {
		By loginButton = By.id("idSIButton9");
		WebElement button1 = driver.findElement(loginButton);
		button1.click();
		LOGGER.info("Login button clicked ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			LOGGER.error("Interrupted while clicking the login button.", ex);
		}
		LOGGER.info("Clicked login button");
	}

	public String getErrorMessage() {
		WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'validation')]"));
		LOGGER.info(errorMessage.getText());
		return errorMessage.getText();
	}

	// TODO Should be changed later for login page element. Currently it is for MainPage and is not being used.
	public boolean isPageLoaded() {
		Boolean pageLoadingStatus = false;
		try {
			By leadClass = By.id("i0118"); 
			WebElement leadClasssElement = driver.findElement(leadClass);
			Boolean isleadClassElementDisplayed = leadClasssElement.isDisplayed(); 
			
			if(isleadClassElementDisplayed == true) {
        		pageLoadingStatus = true;
        		System.out.print("Microsoft Login Page is Loaded and title appeared: " + pageLoadingStatus+"\n");
        		return  pageLoadingStatus;
         }
			
			LOGGER.info(leadClasssElement.getText());
			return pageLoadingStatus;
		
		} catch (Exception ex) {
			LOGGER.error("Microsoft Page Element 'Password field' is not found ");
			return false;
		}
		
	}
}
