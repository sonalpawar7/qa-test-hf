package com.hf.repo;


import com.hf.utils.SafeElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPageRepo extends SafeElementActions {

    @FindBy(tagName = "h1")
    public WebElement title;

    @FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
    public WebElement laststep;

    @FindBy(xpath = "//*[@class='cheque-indent']/strong")
    public WebElement orderConfirmationTitle;
}
