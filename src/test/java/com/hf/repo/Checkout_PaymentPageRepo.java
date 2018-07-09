package com.hf.repo;

import com.hf.utils.SafeElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout_PaymentPageRepo extends SafeElementActions {

    @FindBy(css = ".bankwire")
    public static WebElement paybywire;

    @FindBy(xpath="//*[@id='cart_navigation']/button")
    public WebElement confirmationOrderBtn;
}
