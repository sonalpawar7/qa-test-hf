package com.hf.repo;

import com.hf.utils.SafeElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout_AddressPageRepo extends SafeElementActions {
    @FindBy(name = "processAddress")
    public WebElement proceedCheckout;
}
