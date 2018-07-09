package com.hf.utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserInitializer {
    public static String projectPath = System.getProperty("user.dir");
    public static String osType = System.getProperty("os.name").toLowerCase();

    public WebDriver driver;
    Logger logger = Logger.getLogger(BrowserInitializer.class);
    EventFiringWebDriver firingWebDriver;
    WebEventListeners webListeners;

    /**
     * Sets the driver
     *
     * @param driver
     */
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * get the driver instance
     *
     * @return driver instance
     */
    public WebDriver getDriver() {
        return driver;
    }

    public void setUpEventDriver() {
        firingWebDriver = new EventFiringWebDriver(driver);
        webListeners = new WebEventListeners();
        firingWebDriver.register(webListeners);
        driver = firingWebDriver;
    }

    /**
     * sets the page load timeout for driver
     *
     * @param driver instance
     */
    public void setTimeouts(WebDriver driver) {
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    public void initDriver() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String browser = Config.getBrowserType();
        String execType = Config.getExecType();

        if (execType.equalsIgnoreCase("local")) {
            switch (browser.toUpperCase()) {
                case "FIREFOX":
                    if (osType.contains("window"))
                        System.setProperty("webdriver.gecko.driver", projectPath + "/" + "bin/geckodriver.exe");
                    if (osType.contains("mac"))
                        System.setProperty("webdriver.gecko.driver", projectPath + "/" + "bin/geckodriver");
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setAcceptUntrustedCertificates(true);
                    profile.setAssumeUntrustedCertificateIssuer(true);
                    profile.setPreference("security.enable_java", true);
                    profile.setPreference("plugin.state.java", 2);
                    capabilities.setCapability(FirefoxDriver.PROFILE, profile);
                    driver = new FirefoxDriver(capabilities);
                    break;
                case "CHROME":
                    if (osType.contains("window"))
                        System.setProperty("webdriver.chrome.driver", projectPath + "/" + "bin/chromedriver.exe");
                    if (osType.contains("mac"))
                        System.setProperty("webdriver.chrome.driver", projectPath + "/" + "bin/chromedriver");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("disable-geolocation");
                    driver = new ChromeDriver(options);
                    break;
                case "HEADLESS":
                    if (osType.contains("window"))
                        System.setProperty("webdriver.chrome.driver", projectPath + "/" + "bin/chromedriver.exe");
                    if (osType.contains("mac"))
                        System.setProperty("webdriver.chrome.driver", projectPath + "/" + "bin/chromedriver");
                    options = new ChromeOptions();
                    options.addArguments("headless");
                    driver = new ChromeDriver(options);
                    break;

                case "IE":
                    System.setProperty("webdriver.ie.driver", projectPath + "/" + "bin/IEDriverServer.exe");
                    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    driver = new InternetExplorerDriver(capabilities);
                    driver.manage().window().maximize();
                    break;
            }
            

        } else if (execType.equalsIgnoreCase("grid")) {
            logger.info("Initilizing driver on grid machine");
            String huburl = Config.getHubUrl();

            capabilities.setBrowserName(browser);
            driver = new RemoteWebDriver((new URL("http://" + huburl + ":4444/wd/hub")), capabilities);
        } else if (execType.equalsIgnoreCase("sauce")) {
            //Saucelab access
        } else if (execType.equalsIgnoreCase("browserstack")) {
            //browser stack access
        }
        setDriver(driver);
        setUpEventDriver();
        setTimeouts(driver);
    }

    /**
     * taking screenshot
     * @param methodName name for screenshot
     */
    public void takeScreenShot(String methodName) {
        //get the driver
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name
        try {
            FileUtils.copyFile(scrFile, new File(projectPath + "/screenshots " + methodName + ".png"));
            System.out.println("***Placed screen shot in " + projectPath + "/screenshots " + " ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
