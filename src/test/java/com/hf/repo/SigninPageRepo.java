package com.hf.repo;

import com.hf.utils.SafeElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPageRepo extends SafeElementActions {

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "passwd")
    public WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    public WebElement submitBtn;

    @FindBy(id = "email_create")
    public WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    public WebElement createBtn;

}
