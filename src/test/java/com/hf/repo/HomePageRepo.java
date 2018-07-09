package com.hf.repo;

import com.hf.utils.SafeElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageRepo extends SafeElementActions {

    @FindBy(css = ".header_user_info")
    public WebElement signInBtn;
}
