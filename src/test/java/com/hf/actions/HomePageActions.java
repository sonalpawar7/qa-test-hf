package com.hf.actions;

import com.hf.repo.HomePageRepo;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageActions extends HomePageRepo {
    WebDriver driver;
    Logger logger = Logger.getLogger(HomePageActions.class);

    public HomePageActions(WebDriver driver) {
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * clicks on sing in displated
     *
     * @param signinPageActions
     * @return true if sign in page is displayed
     */
    public boolean clickSignInBtn(SigninPageActions signinPageActions) {
        click(signInBtn);
        return waitUntilElementDisplayed(signinPageActions.passwordField);
    }
}
