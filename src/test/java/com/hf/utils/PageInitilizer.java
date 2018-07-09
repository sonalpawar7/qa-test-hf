package com.hf.utils;

import com.hf.actions.*;
import org.openqa.selenium.WebDriver;

public class PageInitilizer extends BrowserInitializer {

    public WomensActionsPage womensActionsPage;
    public SigninPageActions signinPageActions;
    public OrderConfirmationPageActions orderConfirmationPageActions;
    public HomePageActions homePageActions;
    public MyAccountPageActions myAccountPageActions;
    public CreateAccountPageActions createAccountPageActions;
    public Checkout_SummaryPageActions checkoutSummaryPageActions;
    public ProductDetailsPageActions productDetailsPageActions;
    public Checkout_ShippingPageActions checkoutShippingPageActions;
    public Checkout_PaymentPageActions checkoutPaymentPageActions;
    public Checkout_AddressPageActions checkoutAddressPageActions;

    public void initilizePages(WebDriver driver) {
        womensActionsPage = new WomensActionsPage(driver);
        signinPageActions = new SigninPageActions(driver);
        orderConfirmationPageActions = new OrderConfirmationPageActions(driver);
        homePageActions = new HomePageActions(driver);
        createAccountPageActions = new CreateAccountPageActions(driver);
        checkoutSummaryPageActions = new Checkout_SummaryPageActions(driver);
        productDetailsPageActions = new ProductDetailsPageActions(driver);
        checkoutShippingPageActions = new Checkout_ShippingPageActions(driver);
        checkoutPaymentPageActions = new Checkout_PaymentPageActions(driver);
        checkoutAddressPageActions = new Checkout_AddressPageActions(driver);
        myAccountPageActions = new MyAccountPageActions(driver);
    }
}
