package com.hf.actions;

import com.hf.repo.CreateAccountPageRepo;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;

public class CreateAccountPageActions extends CreateAccountPageRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(CreateAccountPageActions.class);

    public CreateAccountPageActions(WebDriver driver) {
        this.driver = driver;
        
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Creates account with all require fields
     *
     * @param myAccountPageActions
     * @param gender               to select
     * @param fName                of the user
     * @param lName                of the user
     * @param pwd                  for the account
     * @param company              user work for
     * @param address1             address line
     * @param address2             address line2
     * @param city                 city
     * @param state                of the user
     * @param zipCode              postcode
     * @param moreInfo             if any
     * @param homePhone            of the user
     * @param mobileNo             of the user
     * @param alias                if any
     */
    public boolean createAccount(MyAccountPageActions myAccountPageActions, String gender, String fName, String lName, String pwd, String company, String address1, String address2, String city,
                                 String state, String zipCode, String moreInfo, String homePhone, String mobileNo, String alias) 
    {

        if (gender.equalsIgnoreCase("Male"))
            click(mrBtn);
        if (gender.equalsIgnoreCase("Female"))
            click(mrsBtn);

        clearAndFillText(personalFN, fName);
        clearAndFillText(personalLN, lName);
        clearAndFillText(passwordFld, pwd);
        selectDOB();
        clearAndFillText(companyFld, company);
        clearAndFillText(address1fld, address1);
        clearAndFillText(address2fld, address2);
        clearAndFillText(cityfld, city);
        selectDropDownByVisibleText(stateDD, state);
        clearAndFillText(postalCode, zipCode);
        clearAndFillText(moreInfoFld, moreInfo);
        clearAndFillText(homePhoneFld, homePhone);
        clearAndFillText(mobileNoFld, mobileNo);
        clearAndFillText(aliasFld, alias);
        click(submitBtn);
        return waitUntilElementDisplayed(myAccountPageActions.myaccountheader, 60);
    }

    /**
     * Select DOB for new user
     * Same Date 20 years back
     */
    public void selectDOB() 
    {
        Calendar c = Calendar.getInstance();
        String date = String.valueOf(c.get(Calendar.DATE));
        String month = String.valueOf(c.get(Calendar.MONTH));
        String year = String.valueOf(c.get(Calendar.YEAR) - 20);

        selectDropDownByValue(daysDD, date);
        selectDropDownByValue(monthsDD, month);
        selectDropDownByValue(yearsDD, year);
    }


}
