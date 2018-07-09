package com.hf.actions;

import com.hf.repo.Checkout_SummaryPageRepo;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Checkout_SummaryPageActions extends Checkout_SummaryPageRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(Checkout_SummaryPageActions.class);

    public Checkout_SummaryPageActions(WebDriver driver) {
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickProceedCheckout(Checkout_AddressPageActions checkout_addressPageActions) {
        click(proceedCheckout);
        waitUntilElementDisplayed(checkout_addressPageActions.proceedCheckout);
    }
}
