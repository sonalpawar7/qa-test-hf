package com.hf.actions;

import com.hf.repo.WomensActionsRepo;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WomensActionsPage extends WomensActionsRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(WomensActionsPage.class);

    public WomensActionsPage(WebDriver driver) {
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToWomensSection() {
        click(womenTab);
    }

    public void openproductByName(ProductDetailsPageActions productDetailsPageActions, String name) {
        click(dresslink(name));
        click(dresslink(name));
        waitUntilElementDisplayed(productDetailsPageActions.addTocartBtn);
    }
}
