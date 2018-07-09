package com.hf.utils;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Config {

    public static final String EXEC_TYPE = "env.executionType";
    public static final String BROWSER_TYPE = "browser.type";
    public static final String ENV_PROFILE = "environment.profile";
    public static final String HUB_URL = "hub.url";

    private static String configFile = "config.properties";

    private static Configuration configuration;

    /**
     * This method will load the content of the file
     *
     * @param fileName to load
     * @return
     */
    public static String loadAndGetResourceLocation(String fileName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(fileName).toString();
    }

    public static String getBrowserType() {
        try {
            configuration = new PropertiesConfiguration(loadAndGetResourceLocation(configFile));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
         return configuration.getString(BROWSER_TYPE);
    }

    public static String getExecType() {
        try {
            configuration = new PropertiesConfiguration(loadAndGetResourceLocation(configFile));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(EXEC_TYPE);
    }

    public static String getEnvType() {
        try {
            configuration = new PropertiesConfiguration(loadAndGetResourceLocation(configFile));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(ENV_PROFILE);
    }

    public static String getHubUrl(){
        try {
            configuration = new PropertiesConfiguration((loadAndGetResourceLocation(configFile)));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return configuration.getString(HUB_URL);
    }
}
