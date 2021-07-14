package com.competella.qaframework.utility;

import com.competella.qaframework.entities.CredentialsOld;
import com.competella.qaframework.entities.Credentials;
import com.competella.qaframework.parsers.FileParser;

import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialReader {

	private static final Logger LOGGER = Logger.getLogger(CredentialReader.class);
	//private static final String FILE_PATH = "C:\\Users\\talhas\\Desktop\\Data\\Office\\Automations\\Eclipes\\qaframework\\src\\resources\\credentials.txt";
	private static final String FILE_PATH = "src/resources/credentials.txt";

	public static Credentials readCredentials() {
		//Properties credentialsData = FileParser.parsePropertyFile(FILE_PATH);
    	//LOGGER.debug("Properties size : " + testCasesData.size());
    
        //CredentialsOld credentialsOld = new CredentialsOld();
        Credentials credentials = Credentials.getInstance();
        Properties properties = FileParser.parsePropertyFile(FILE_PATH);
        
        try {
            System.out.println("User name property is "+ properties.getProperty("username"));
            credentials.setUserName(properties.getProperty("username"));
            credentials.setPassword(properties.getProperty("password"));
            credentials.setQueueName(properties.getProperty("queueName"));
            credentials.setQueueDisplayName(properties.getProperty("queuedisplayname"));
            credentials.setQueueSipAddress(properties.getProperty("queueaipaddress"));
            credentials.setScheduleName(properties.getProperty("scheduleName"));
            credentials.setScheduleDisplayName(properties.getProperty("scheduleDisplayName"));
            credentials.setAccessURL(properties.getProperty("accessURL"));
            credentials.setScreenshotPath(properties.getProperty("screenshotPath"));
            credentials.setAccessGOURL(properties.getProperty("accessGOURL"));
            
            LOGGER.info("access url is"+properties.getProperty("accessURL")); 
             
            
        } catch (Exception ex) {
            LOGGER.error("Failed to read the credentials. ", ex);
        }
        return credentials;
    }
	
	
	public static CredentialsOld readCredentials1() {
		Properties properties = FileParser.parsePropertyFile(FILE_PATH);
 
        CredentialsOld credentials = new CredentialsOld();

        try {

            System.out.println("User name property is "+ properties.getProperty("username"));
            credentials.setUserName(properties.getProperty("username"));
            credentials.setPassword(properties.getProperty("password"));
            credentials.setQueueName(properties.getProperty("queueName"));
            credentials.setQueueDisplayName(properties.getProperty("queuedisplayname"));
            credentials.setQueueSipAddress(properties.getProperty("queueaipaddress"));
            credentials.setScheduleName(properties.getProperty("scheduleName"));
            credentials.setScheduleDisplayName(properties.getProperty("scheduleDisplayName"));
            credentials.setAccessURL(properties.getProperty("accessURL"));
            LOGGER.info("access url is"+properties.getProperty("accessURL")); 
            
        } catch (Exception ex) {
            LOGGER.error("Failed to read the credentials. ", ex);
        }
        return credentials;
    }
	
	
	
	
	
	
	
}
