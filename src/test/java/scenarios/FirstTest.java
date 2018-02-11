package scenarios;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class FirstTest extends DriverSetup {

    @BeforeClass(description = "preparing android native")
    public void setup() throws MalformedURLException {
        prepareNative();
//        prepareAndroidWeb();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @Test
    public void SimpleEmulatorAppTest() {
//        String appPackageName = "com.example.android.contactmanager:id/";
//        By addBtn = By.id(appPackageName + "addContactButton");
        By addBtn = By.xpath("//android.widget.Button[@content-desc=\"Add Contact\"]");
//        By addBtn = By.className("android.widget.Button");
        driver.findElement(addBtn).click();
        System.out.println("Simple test is over");
    }

    @Test
    public void SimpleWebEmulatorTest() {
        driver.get("http://iana.org");
        System.out.println("web test finished");
    }
}
