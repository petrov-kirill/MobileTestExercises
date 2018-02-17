package lesson3;

import lesson3.scenarios.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PropsDriverTests {

    private DriverSetup ds;

    @BeforeClass
    public void setUp() throws Exception {
        ds = new DriverSetup();
        ds.prepareDriver();
    }

    @Ignore
    @Test
    public void webTest() {
        ds.getAppiumDriver().get(ds.getSut());
        ds.getDriverWait().until(ExpectedConditions.urlToBe(ds.getSut() + "/"));
        System.out.println("Site opened!");
    }

    @Test
    public void nativeAppTest() {
        String packageName = "com.example.android.contactmanager:id/";
        By btn = By.id(packageName + "addContactButton");
        WebElement element = ds.getAppiumDriver().findElement(btn);
        element.click();
        assertTrue(!element.isDisplayed());
    }
}
