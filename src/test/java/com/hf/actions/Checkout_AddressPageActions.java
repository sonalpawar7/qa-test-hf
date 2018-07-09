package com.hf.actions;

import com.hf.repo.Checkout_AddressPageRepo;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Checkout_AddressPageActions extends Checkout_AddressPageRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(Checkout_AddressPageActions.class);

    public Checkout_AddressPageActions(WebDriver driver) {
        this.driver = driver;
//        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickProceedChekout(Checkout_ShippingPageActions checkout_shippingPageActions){
        click(proceedCheckout);
        waitUntilElementDisplayed(checkout_shippingPageActions.proceedCheckout);
    }
}
