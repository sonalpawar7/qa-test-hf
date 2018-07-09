package com.hf.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SafeElementActions extends BrowserInitializer {

    Logger logger = Logger.getLogger(SafeElementActions.class);
    //private WebDriver driver;

    /**
     * If the element is a text entry element(input or textarea), this will clear the value.
     *
     * @param element to be clear
     */
    public void clear(WebElement element) {
        element.clear();
        logger.info("Text in the element -  " + element + " - is removed");
    }

    /**
     * Click this element
     *
     * @param element to be clicked
     */
    public void click(WebElement element) {
        try {
            element.click();
            logger.info("Clicked on element - " + element);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the value of the given attribute of the element.
     *
     * @param element   to be performed
     * @param attribute of the element
     * @return string if the attribute found else return null
     */
    public String getAttribute(WebElement element, String attribute) {
        waitUntilElementDisplayed(element);
        return element.getAttribute(attribute);
    }

    /**
     * Get the css property of the element
     *
     * @param element     to be performed
     * @param cssProperty the css property name of the element
     * @return The current, computed value of the property.
     */
    public String getCssvalue(WebElement element, String cssProperty) {
        waitUntilElementDisplayed(element);
        return element.getCssValue(cssProperty);
    }

    /**
     * Get the visible (i.e. not hidden by CSS) innerText of this element, including sub-elements,
     * without any leading or trailing whitespace.
     *
     * @param element to be found
     * @return The innerText of this element.
     */
    public String getText(WebElement element) {
        return element.getText();
    }

    /**
     * Get the tag name of this element.
     *
     * @param element to be found
     * @return The tag name of this element.
     */
    public String getTagName(WebElement element) {
        try {
            return element.getTagName();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Is this element displayed or not?
     *
     * @param element to be found
     * @return Whether or not the element is displayed
     */
    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Is the element currently enabled or not?
     *
     * @param element to be found
     * @return True if the element is enabled, false otherwise.
     */
    public boolean isEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Determine whether or not this element is selected or not
     * This operation only applies to input elements such as checkboxes, options in a select and radio buttons.
     *
     * @param element to be found
     * @return True if the element is currently selected or checked, false otherwise
     */
    public boolean isSelected(WebElement element) {
        waitUntilElementDisplayed(element);
        try {
            return element.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method to simulate typing into an element, which may set its value.
     *
     * @param element to be found
     * @param text    to send to the element
     */
    public void fillText(WebElement element, String text) {
        waitUntilElementDisplayed(element);
        try {
            element.sendKeys(text);
        } catch (IllegalArgumentException e) {
            logger.info("Please check the text you have passed: " + text);
        }
    }

    /**
     * This method will perform both clear and fill text
     *
     * @param element to be found
     * @param text    to send to the element
     */
    public void clearAndFillText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (IllegalArgumentException e) {
            logger.info("Please check the text you have passed: " + text);
        }
    }

    /**
     * If the current element is a form, or an element within a form,
     * then this will be submitted to the remote server.
     *
     * @param element to be found
     */
    public void submit(WebElement element) {
        try 
        {
            element.submit();
        } catch (NoSuchElementException e) {
            logger.info("element: " + element + " - is not found in the current page");
        }
    }

    /**
     * waits until the element is found
     *
     * @param element to be found
     * @return True if elements is found
     */
    public boolean waitUntilElementDisplayed(WebElement element) {
        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            logger.info("Element - " + element + " is not found after 20 seconds wait");
            return false;
        }
    }

    /**
     * waits until the element is found
     *
     * @param element to be found
     * @return True if elemenet is found
     */
    public boolean waitUntilElementDisplayed(WebElement element, int timeout) {
        try {
            new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            logger.info("Element - " + element + " is not found after 20 seconds wait");
            return false;
        }
    }

    /**
     * waits until the element is invisible
     *
     * @param element to be found
     * @return True if element is not found
     */
    public boolean waitUntilElementInvisiblie(WebElement element, int timeout) {
        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (NoSuchElementException e) {
            logger.info("Element - " + element + " is still displayed after 20 seconds wait");
            return false;
        }
    }

    /**
     * Select the drop-down by index no
     *
     * @param selectElement to perform action
     * @param index         to be selected
     */
    public void selectDropDownByIndex(WebElement selectElement, int index) {
        Select dropdown = new Select(selectElement);
        dropdown.selectByIndex(index);
    }

    /**
     * Select drop-down by display text
     *
     * @param selectElement to perform action
     * @param dropDownText  to select
     */
    public void selectDropDownByVisibleText(WebElement selectElement, String dropDownText) {
        Select dropdown = new Select(selectElement);
        dropdown.selectByVisibleText(dropDownText);
    }

    /**
     * Selects drop-down by visible text
     *
     * @param selectElement to perform action
     * @param dropDownText  css value
     */
    public void selectDropDownByValue(WebElement selectElement, String dropDownText) {
        Select dropdown = new Select(selectElement);
        dropdown.selectByValue(dropDownText);
    }

    public void staticWait() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
