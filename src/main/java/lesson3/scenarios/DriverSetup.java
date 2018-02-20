package lesson3.scenarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DriverSetup extends Props {
    private AppiumDriver appiumDriver;
    private DesiredCapabilities capabilities;
    private WebDriverWait driverWait;

    private String aut;
    private String sut;
    private String testPlatform;
    private String driver;
    private String browserName;

    public DriverSetup() throws IOException {
//        aut = getProp("aut");
        String tSut = getProp("sut");
        sut = tSut == null ? null : "http://" + tSut;
        sut = getProp("sut");
        testPlatform = getProp("platform");
        driver = getProp("driver");
    }


    public AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public String getSut() {
        return sut;
    }

    /**
     * Setting up capabilities
     *
     * @throws Exception
     */
    public void prepareDriver() throws Exception {
        preparePlatform();
        prepareType();
        driverWait = new WebDriverWait(appiumDriver, 10);
    }

    private void prepareType() throws Exception {
        if (aut != null && sut == null) {
            File application = new File(aut);
            capabilities.setCapability(MobileCapabilityType.APP, application);
        } else if (sut != null && aut == null) {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unknown type of app");
        }

        appiumDriver = new AppiumDriver(new URL(driver), capabilities);
    }

    private void preparePlatform() throws Exception {
        capabilities = new DesiredCapabilities();
        switch (testPlatform) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                browserName = "Chrome";
                break;
            case "iOS":
                browserName = "Safari";
                // ...?
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, testPlatform);
    }
}
