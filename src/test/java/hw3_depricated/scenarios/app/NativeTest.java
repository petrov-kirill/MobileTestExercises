package hw3_depricated.scenarios.app;

import hw3_depricated.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(groups = "native")
public class NativeTest extends Driver {

    protected NativeTest() throws IOException {
        super();
    }

    @Test(description = "Finding button 'Add contact' with different locators and clicking it")
    public void clickingButtonTest() throws Exception {
        driver().findElement(By.xpath("//android.widget.Button[@content-desc=\"Add Contact\"]")).click();

        assert driver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Contact Name\"]"))
                .getText().equals("Contact Name")
                : "Not equals";

        assert driver().findElement(By.id("com.example.android.contactmanager:id/contactNameEditText"))
                .isDisplayed()
                : "Not displayed";

        assert driver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Contact Phone\"]"))
                .getText().equals("Contact Phone")
                : "Not equals";

        assert driver().findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText"))
                .isDisplayed()
                : "Not displayed";
        System.out.println("End of test");
    }
}
