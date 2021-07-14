package com.competella.qaframework.selenium;

public class DriverManagerFactory {

    public static DriverManagerInternal getDriverManager(DriverType type) {
        DriverManagerInternal driverManager = null;

        switch (type) {
            case firefox:
                driverManager = new FirefoxDriverManager();
                break;
            case chrome:
               // driverManager = new chromeDriverManager();
                break;
        }
        return driverManager;
    }
}
