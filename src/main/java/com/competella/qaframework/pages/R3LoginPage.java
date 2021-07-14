package com.competella.qaframework.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.paulhammant.ngwebdriver.*;


public class R3LoginPage {
    private static final Logger LOGGER = Logger.getLogger(R3LoginPage.class);
    private WebDriver driver;
    private WebDriverWait wait;
    
    public R3LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String password) {
        this.setLogin(userName);
        this.clickLogin();
    }

    public void setLogin1(String userName) {
		//By userNameTextBox = By.id("UserName");
		//By userNameTextBox = By.className("mat-form-field-infix");
    	wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(By.className("mat-input-element")));
    	//By userNameTextBox = By.xpath("/html/body/competella-security/div/competella-security-login/div/form/mat-card/mat-card-content/mat-form-field/div/div[1]/div/input");
    	By userNameTextBox = By.className("mat-input-element");
    	driver.findElement(userNameTextBox).sendKeys(userName);
		System.out.println("Entered User Name "+ userName);
		try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            LOGGER.error("Interrupted during login. ", ex);
        }
    }
    
    
    public void setLogin(String userName) {
		//By userNameTextBox = By.id("UserName");
		//By userNameTextBox = By.className("mat-form-field-infix");
    	//	<!--scope>test</scope>
    	wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(By.className("mat-input-element")));
    	//By userNameTextBox = By.xpath("/html/body/competella-security/div/competella-security-login/div/form/mat-card/mat-card-content/mat-form-field/div/div[1]/div/input");
    	//By userNameTextBox = By.className("mat-input-element");
    	//NgWebDriver userNameTextBox1;
    	By userNameTextBox=ByAngularModel.className("mat-input-element");
    	driver.findElement(userNameTextBox).sendKeys(userName);
		System.out.println("Entered User Name "+ userName);
		try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            LOGGER.error("Interrupted during login. ", ex);
        }
    }
    

    public void clickLogin() {
    	By loginButton = By.className("mat-button-wrapper");
        List<WebElement> loginButton1= driver.findElements(loginButton);
        System.out.println("Login button found and will be clicked" + loginButton );
        loginButton1.get(0).click();
        System.out.println("Login button clicked ");
//        try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
        LOGGER.info("Clicked login button");
    }

    public String getErrorMessage() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'validation')]"));
        LOGGER.info(errorMessage.getText());
        return errorMessage.getText();
    }
    

	public boolean isPageLoaded() {
		By loginFeildAreaClass = By.className("mat-card-title");
		LOGGER.info("Title of the page is: " + driver.getTitle() + "\n");

		List<WebElement> loginFeildAreaList = driver.findElements(loginFeildAreaClass);

		if (loginFeildAreaList == null || loginFeildAreaList.isEmpty()) {
			final String errorMessage = "Couldn't find any element";
			LOGGER.error(errorMessage);
			throw new NoSuchElementException(errorMessage);
		}

		boolean loginFeildAreaStatus = loginFeildAreaList.get(0).isDisplayed();
		// if element is not displayed
		String pageTitle = "Competella Security";
		boolean pageTitleStatus = pageTitle.matches(driver.getTitle());
		// if there is no title not

		if (loginFeildAreaStatus && pageTitleStatus) {
			LOGGER.info("R3-Login Page is Loaded and title appeared");
			return true;
		}

		return false;
	}
    
    
 }
