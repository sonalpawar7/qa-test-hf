package com.hf.actions;

import com.hf.repo.Checkout_PaymentPageRepo;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Checkout_PaymentPageActions extends Checkout_PaymentPageRepo {
    WebDriver driver;
    Logger logger = Logger.getLogger(Checkout_PaymentPageActions.class);

    public Checkout_PaymentPageActions(WebDriver driver) {
        this.driver = driver;
//        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectpayByWire(OrderConfirmationPageActions orderConfirmationPageActions){
        click(paybywire);
        click(confirmationOrderBtn);
        waitUntilElementDisplayed(orderConfirmationPageActions.title);
    }
}
