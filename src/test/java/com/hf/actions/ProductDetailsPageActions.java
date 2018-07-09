package com.hf.actions;

import com.hf.repo.ProductDetailsPageRepo;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPageActions extends ProductDetailsPageRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(ProductDetailsPageActions.class);

    public ProductDetailsPageActions(WebDriver driver) {
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public void checkoutProduct(Checkout_SummaryPageActions checkout_summaryPageActions) {
        click(addTocartBtn);
        staticWait();
        click(proceddCheckout);
        waitUntilElementDisplayed(checkout_summaryPageActions.proceedCheckout);
    }


}
