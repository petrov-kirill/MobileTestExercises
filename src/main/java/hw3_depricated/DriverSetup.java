package hw3_depricated;

import enums.driver.PropsEnum;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static enums.driver.CapabilitiesEnum.*;
import static enums.driver.PropsEnum.APPIUM_LOCAL_HOST_URL;
import static enums.driver.PropsEnum.APPLICATION_NAME;

public class DriverSetup {

    public AndroidDriver driver;

    protected void prepareAndroidNative() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(EMLATOR_NAME.text, EMULATOR_NAME.text);
        capabilities.setCapability(PLATFORM_NAME.text, ANDROID.text);

        File appDir = new File(PropsEnum.APPLICATION_PATH.text);
        File app = new File(appDir, APPLICATION_NAME.text);

        capabilities.setCapability(APPLICATION.text, app.getAbsolutePath());

        driver = new AndroidDriver(new URL(APPIUM_LOCAL_HOST_URL.text), capabilities);
    }
}
