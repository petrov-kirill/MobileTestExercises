package homework3;

import enums.driver.CapabilitiesEnum;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

import static enums.driver.CapabilitiesEnum.*;
import static enums.driver.CommonEnum.UNCLEAR_TYPE_OF_APP;
import static enums.driver.CommonEnum.UNKNOWN_PLATFORM_MESSAGE;

public class Driver extends SetupProps {

    private static AppiumDriver singleDriver;
    protected DesiredCapabilities desiredCapabilities;

    private static String AUT; // (mobile) app under testing
    protected static String SUT; // site under testing
    private static String TEST_PLATFORM;
    private static String DRIVER;
    private static String DEVICE_NAME;
    private String browser;

    public Driver() throws Exception {

        AUT = getProp(APPLICATION_UNDER_TEST.text);
        String t_sut = getProp(SITE_UNDER_TEST.text);
        SUT = t_sut == null ? null : "http://" + t_sut;
        TEST_PLATFORM = getProp(PLATFORM.text);
        DRIVER = getProp(CapabilitiesEnum.DRIVER.text);
        DEVICE_NAME = getProp(CapabilitiesEnum.DEVICE_NAME.text);
    }

    protected void prepareDriver() throws Exception {
        preparePlatform();
        prepareType();
    }

    private void preparePlatform() throws Exception {
        desiredCapabilities = new DesiredCapabilities();
        switch (TEST_PLATFORM) {
            case "Android":
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                browser = CHROME.text;
                break;
            case "iOS":
                browser = SAFARI.text;
                break;
            default:
                throw new Exception(UNKNOWN_PLATFORM_MESSAGE.text);
        }
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);
    }

    private void prepareType() throws Exception {
        if (AUT != null && SUT == null) {
            // Native
            File app = new File(AUT);
            desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            // Web
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
        } else {
            throw new Exception(UNCLEAR_TYPE_OF_APP.text);
        }

        // Init driver for local Appium server with capabilities have been set
        if (singleDriver == null) {
            singleDriver = new AppiumDriver(new URL(DRIVER), desiredCapabilities);
        }
    }

    protected AppiumDriver driver() throws Exception {
        if (singleDriver == null) prepareDriver();
        return singleDriver;
    }
}
