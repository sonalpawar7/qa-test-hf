package com.hf.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * This class is to override the Selenium WebEventListeners
 * Below are some sample implementation
 */
public class WebEventListeners extends AbstractWebDriverEventListener {
    Logger logger = Logger.getLogger(WebEventListeners.class);

    /**
     * This method will be called be opening any URL in the browser
     *
     * @param url    to navigate
     * @param driver instance
     */
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before Navigate to - " + url);
        logger.info("Before Navigate to - " + url);
    }

    /**
     * This method will be called before finding an element
     *
     * @param by
     * @param element element to check
     * @param driver  instance
     */
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Before Finding WebElement " );
    }

    /**
     * This method will be called before performing click action on any element
     *
     * @param element to be checked
     * @param driver  instance
     */
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("Before Clicking on WebElement ");
    }
}
