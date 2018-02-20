package hw3;

import enums.driver.CapabilitiesEnum;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static enums.driver.CapabilitiesEnum.*;
import static enums.driver.CapabilitiesEnum.APP_ACTIVITY;
import static enums.driver.CommonEnum.UNCLEAR_TYPE_OF_APP;
import static enums.driver.CommonEnum.UNKNOWN_PLATFORM_MESSAGE;
import static enums.driver.CommonEnum.URL_HTTP_PREFIX;

public class Driver extends TestProperties {

    private static AppiumDriver driver = null;
    private static WebDriverWait wait;
    protected DesiredCapabilities capabilities;

    protected static String AUT;
    protected static String SUT;
    protected static String TEST_PLATFORM;
    protected static String DRIVER;
    protected static String DEVICE_NAME;
    protected static String PACKAGE;
    protected static String ACTIVITY;
    private String browserName;

    protected Driver() throws IOException {
        AUT = getProp(APPLICATION_UNDER_TEST.text);
        String t_sut = getProp(SITE_UNDER_TEST.text);
        SUT = t_sut == null ? null : URL_HTTP_PREFIX.text + t_sut;
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        DEVICE_NAME = getProp(CapabilitiesEnum.DEVICE_NAME.text);
        PACKAGE = getProp(APP_PACKAGE.text);
        ACTIVITY = getProp(APP_ACTIVITY.text);
    }

    protected void prepareDriver() throws Exception {
        preparePlatform();
        prepareType();
    }

    protected AppiumDriver driver() throws Exception {
        if (driver == null) prepareDriver();
        return driver;
    }

    protected WebDriverWait driverWait() throws Exception {
        return wait;
    }

    private void preparePlatform() throws Exception {
        capabilities = new DesiredCapabilities();

        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                browserName = CHROME.text;
                break;
            case "iOS":
                browserName = SAFARI.text;
                break;
            default:
                throw new Exception(UNKNOWN_PLATFORM_MESSAGE.text);
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);
        capabilities.setCapability(APP_PACKAGE.text, PACKAGE);
        capabilities.setCapability(APP_ACTIVITY.text, ACTIVITY);
    }

    private void prepareType() throws Exception {
        if (AUT != null && SUT == null) {
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception(UNCLEAR_TYPE_OF_APP.text);
        }
        if (driver == null) {
            driver = new AppiumDriver(new URL(DRIVER), capabilities);
        }
        if (wait == null) {
            wait = new WebDriverWait(driver, 10);
        }
    }
}
