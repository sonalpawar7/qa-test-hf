package com.hf.actions;

import com.hf.repo.SigninPageRepo;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SigninPageActions extends SigninPageRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(SigninPageActions.class);

    public SigninPageActions(WebDriver driver) {
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Will open a createa ccount page with email provided
     *
     * @param createAccountPageActions
     * @param email                    of the user to create an account
     * @return
     */
    public boolean registerEmail(CreateAccountPageActions createAccountPageActions, String email) {
        clearAndFillText(emailCreate, email);
        click(createBtn);
        return waitUntilElementDisplayed(createAccountPageActions.mrBtn);
    }

    /**
     * login as reguser
     *
     * @param myAccountPageActions
     * @param email                of the reg user
     * @param pwd                  of the user
     * @return
     */
    public boolean loginAsRegUser(MyAccountPageActions myAccountPageActions, String email, String pwd) {
        clearAndFillText(emailField, email);
        clearAndFillText(passwordField, pwd);
        click(submitBtn);
        return waitUntilElementDisplayed(myAccountPageActions.logoutLink);
    }


}
