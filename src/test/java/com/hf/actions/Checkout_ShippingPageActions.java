package com.hf.actions;

import com.hf.repo.Checkout_ShippingPageRepo;
import com.hf.repo.Checkout_ShippingPageRepo;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Checkout_ShippingPageActions extends Checkout_ShippingPageRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(Checkout_ShippingPageActions.class);

    public Checkout_ShippingPageActions(WebDriver driver) {
        this.driver = driver;
//        setDriver(driver);
        PageFactory.initElements(driver, this);
    }


    public void clickProceedCheckout(Checkout_PaymentPageActions checkout_paymentPageActions){
        click(termsandCondtions);
        click(proceedCheckout);
        waitUntilElementDisplayed(checkout_paymentPageActions.paybywire);
    }
}
