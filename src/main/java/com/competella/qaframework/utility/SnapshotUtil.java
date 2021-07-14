package com.competella.qaframework.utility;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;

public class SnapshotUtil {

    private SnapshotUtil() {}
    private static final Logger LOGGER = Logger.getLogger(SnapshotUtil.class);
    public static void takeSnapShot(WebDriver webdriver, String detinationPath) {

        //Convert web driver object to TakeScreenshot
        TakesScreenshot screenshot = ((TakesScreenshot) webdriver);

        //Call getScreenshotAs method to create image file
        File capturedFile = screenshot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        String fileName = detinationPath + System.currentTimeMillis() + ".png";
        File destinationFile = new File(detinationPath,fileName);
        try {
			//Copy file at destination
			FileUtils.copyFile(capturedFile, destinationFile);
			System.out.println("Screenshot added " + capturedFile +"at destination " + destinationFile+"\n");
		} catch(Exception ex) {
        	LOGGER.error("Error while taking snapshot. ", ex);
        	throw new IllegalStateException("Error while taking snapshot");
		}
    }
}




