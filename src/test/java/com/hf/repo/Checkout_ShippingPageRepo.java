package com.hf.repo;

import com.hf.utils.SafeElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout_ShippingPageRepo extends SafeElementActions {

    @FindBy(id = "uniform-cgv")
    public WebElement termsandCondtions;

    @FindBy(name = "processCarrier")
    public WebElement proceedCheckout;

}
