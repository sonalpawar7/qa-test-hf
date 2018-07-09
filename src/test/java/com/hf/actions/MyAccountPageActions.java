package com.hf.actions;

import com.hf.repo.MyAccountPageRepo;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageActions extends MyAccountPageRepo {


    WebDriver driver;
    Logger logger = Logger.getLogger(MyAccountPageActions.class);
    
    

    public MyAccountPageActions(WebDriver driver) {
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * verify username in account header
     *
     * @param fn of the user
     * @param ln of the user
     * @return
     */
    public boolean validateUserName(String fn, String ln) {
        String text = ln + " " + fn;
        return getText(userName).equalsIgnoreCase(text);
    }

    /**
     * verifies validate my account link
     *
     * @return
     */
    public boolean validateMyAccountInfo() {
        String s = "Welcome to your account.";
        return getText(accountInfo).contains(s);
    }
}
