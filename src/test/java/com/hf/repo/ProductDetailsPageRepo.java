package com.hf.repo;

import com.hf.utils.SafeElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPageRepo extends SafeElementActions {

    @FindBy(name = "Submit")
    public WebElement addTocartBtn;

    @FindBy(css = "a[title='Proceed to checkout'] span")
    public WebElement proceddCheckout;

}
