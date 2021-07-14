package com.competella.qaframework.parsers;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileParser {

    private static final Logger LOGGER = Logger.getLogger(FileParser.class);

    private FileParser() {}

    public static Properties parsePropertyFile(String filePath) {
        Properties propertyFile = new Properties();
        try {
            FileInputStream fs = new FileInputStream(filePath);
            propertyFile.load(fs);
            LOGGER.info("Property name : " + propertyFile);
        } catch (IOException ex) {
            LOGGER.error("Failed to read the property file. ", ex);
        }
        return propertyFile;
    }
}

