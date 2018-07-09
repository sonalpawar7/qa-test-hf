package com.hf.repo;

import com.hf.utils.SafeElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPageRepo extends SafeElementActions {

    @FindBy(id = "id_gender1")
    public WebElement mrBtn;

    @FindBy(id = "id_gender2")
    public WebElement mrsBtn;

    @FindBy(id = "customer_firstname")
    public WebElement personalFN;

    @FindBy(id = "customer_lastname")
    public WebElement personalLN;

    @FindBy(id = "passwd")
    public WebElement passwordFld;

    @FindBy(id = "days")
    public WebElement daysDD;

    @FindBy(id = "months")
    public WebElement monthsDD;

    @FindBy(id = "years")
    public WebElement yearsDD;

    @FindBy(id = "company")
    public WebElement companyFld;

    @FindBy(id = "address1")
    public WebElement address1fld;

    @FindBy(id = "address2")
    public WebElement address2fld;

    @FindBy(id = "city")
    public WebElement cityfld;

    @FindBy(id = "id_state")
    public WebElement stateDD;

    @FindBy(id = "postcode")
    public WebElement postalCode;

    @FindBy(id = "other")
    public WebElement moreInfoFld;

    @FindBy(id = "phone")
    public WebElement homePhoneFld;

    @FindBy(id = "phone_mobile")
    public WebElement mobileNoFld;

    @FindBy(id = "alias")
    public WebElement aliasFld;

    @FindBy(id = "submitAccount")
    public WebElement submitBtn;
}
