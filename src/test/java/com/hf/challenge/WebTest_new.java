package com.hf.challenge;

import com.hf.utils.FileUtils;
import com.hf.utils.JavaUtils;
import com.hf.utils.PageInitilizer;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebTest_new extends PageInitilizer {
    WebDriver driver;
    String filePath = projectPath + "/src/main/resources/testData.Properties";
    FileUtils fileUtils;
    JavaUtils javaUtils;
    String email;

    @BeforeClass
    public void init() throws Exception {
        fileUtils = new FileUtils(filePath);
        javaUtils = new JavaUtils();
        email = javaUtils.createRandomEmail();
        initDriver();
        driver = getDriver();
        initilizePages(driver);
    }

    @BeforeMethod
    public void openBrowser() {
        driver.get("http://automationpractice.com/index.php");
    }

    @Test(priority = 0)
    public void signInTest() {
        homePageActions.clickSignInBtn(signinPageActions);
        signinPageActions.registerEmail(createAccountPageActions, email);
        boolean myacc = createAccountPageActions.createAccount(myAccountPageActions, fileUtils.getValue("gender"), fileUtils.getValue("fName"), fileUtils.getValue("lName"), fileUtils.getValue("password"), fileUtils.getValue("company"), fileUtils.getValue("address1")
                , fileUtils.getValue("address2"), fileUtils.getValue("city"), fileUtils.getValue("state"), fileUtils.getValue("postcode"), fileUtils.getValue("addInfo"), fileUtils.getValue("homePhone")
                , fileUtils.getValue("mobileNo"), fileUtils.getValue("aliasAddres"));

        Assert.assertTrue(myacc, "myaccount page is displayed");

        boolean username = myAccountPageActions.validateUserName(fileUtils.getValue("lName"), fileUtils.getValue("fName"));
        Assert.assertTrue(username, "Verify username is displayed correctly ");
        Assert.assertTrue(myAccountPageActions.validateMyAccountInfo(), "Verify My Account info text");
        Assert.assertTrue(myAccountPageActions.isDisplayed(myAccountPageActions.logoutLink), "Verify logout link");
        Assert.assertTrue(driver.getCurrentUrl().contains(fileUtils.getValue("myaccountURL")), "verify current url");
    }

    @Test(priority = 1)
    public void loginTest() {
        homePageActions.clickSignInBtn(signinPageActions);
        boolean loginSuccess = signinPageActions.loginAsRegUser(myAccountPageActions, fileUtils.getValue("existingEmail"), fileUtils.getValue("password"));
        Assert.assertTrue(loginSuccess, "Login is successful");

        boolean username = myAccountPageActions.validateUserName(fileUtils.getValue("existinguserLName"), fileUtils.getValue("existinguserFName"));
        Assert.assertTrue(username, "Verify username is displayed correctly ");
        Assert.assertTrue(myAccountPageActions.isDisplayed(myAccountPageActions.logoutLink), "Verify logout link");
        Assert.assertTrue(myAccountPageActions.validateMyAccountInfo(), "Verify My Account info text");
        Assert.assertTrue(driver.getCurrentUrl().contains(fileUtils.getValue("myaccountURL")), "verify current url");
    }

    @Test(priority = 2)
    public void checkout() {
        homePageActions.clickSignInBtn(signinPageActions);
        signinPageActions.loginAsRegUser(myAccountPageActions, fileUtils.getValue("existingEmail"), fileUtils.getValue("password"));
        womensActionsPage.navigateToWomensSection();
        womensActionsPage.openproductByName(productDetailsPageActions, fileUtils.getValue("dressName"));
        productDetailsPageActions.checkoutProduct(checkoutSummaryPageActions);
        checkoutSummaryPageActions.clickProceedCheckout(checkoutAddressPageActions);
        checkoutAddressPageActions.clickProceedChekout(checkoutShippingPageActions);
        checkoutShippingPageActions.clickProceedCheckout(checkoutPaymentPageActions);
        checkoutPaymentPageActions.selectpayByWire(orderConfirmationPageActions);

        Assert.assertTrue(orderConfirmationPageActions.validateOrderConfirmationHeader(), "Validate Order Confirmation Header");
        Assert.assertTrue(orderConfirmationPageActions.verifyCurrentStepIsLate(), "Validate Current Step is last step");
        Assert.assertTrue(orderConfirmationPageActions.orderConfirmationTitle(), "Validate Order Confirmation Title");
        Assert.assertTrue(driver.getCurrentUrl().contains(fileUtils.getValue("orderconfirmationurl")), "verify current url");

    }

    @AfterMethod
    public void clearcahe() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}
