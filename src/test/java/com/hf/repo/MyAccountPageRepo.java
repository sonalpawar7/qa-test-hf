package com.hf.repo;

import com.hf.utils.SafeElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageRepo extends SafeElementActions {

    @FindBy(css = ".my-account")
    public WebElement myaccountheader;

    @FindBy(css = ".account")
    public WebElement userName;

    @FindBy(css = ".info-account")
    public WebElement accountInfo;

    @FindBy(css = ".logout")
    public WebElement logoutLink;
}
