package com.hf.repo;

import com.hf.utils.SafeElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout_SummaryPageRepo extends SafeElementActions {

    @FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
    public WebElement proceedCheckout;
}
