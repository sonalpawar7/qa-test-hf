package com.hf.repo;

import com.hf.utils.SafeElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomensActionsRepo extends SafeElementActions {

    @FindBy(linkText = "Women")
    public WebElement womenTab;

    public WebElement dresslink(String dressName) {
        return getDriver().findElement(By.xpath("//a[@title='" + dressName + "']/ancestor::li"));
    }
}
