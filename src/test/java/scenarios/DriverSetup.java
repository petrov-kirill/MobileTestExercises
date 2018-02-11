package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {
    protected AndroidDriver driver;
//    private static final String APPLICATION_PATH =
//            "C:\\Users\\Kirill_Petrov\\IdeaProjects\\mobile_testing_project\\src\\main\\resources\\";

    private static final String APPLICATION_PATH =
            "src\\main\\resources\\";

    protected void prepareNative() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
//        capabilities.setCapability("deviceName", "18b15cd77d94");
        capabilities.setCapability("platformName", "Android");
        File appLocation = new File(APPLICATION_PATH);
        File app = new File(appLocation, "ContactManager.apk");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    protected void prepareAndroidWeb() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("browserName", "Chrome");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
