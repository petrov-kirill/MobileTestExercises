package hw3_depricated.webpages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IanaHomePage {

    private AppiumDriver driver;

    @FindBy(css = "#intro p")
    private WebElement textUnderLogo;

    @FindBy(css = "#home-panel-domains")
    private WebElement domainsBlock;

    @FindBy(css = "home-panel-numbers")
    private WebElement numbersBlock;

    @FindBy(css = "home-panel-protocols")
    private WebElement protocolsBlock;

    public IanaHomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void openWebSite(String url) {
        driver.get(url);
    }

    public void checkPageTitle() {
        assertEquals("Internet Assigned Numbers Authority", driver.getTitle());
    }

    public void checkTextUnderLogo() {
        assertTrue(textUnderLogo.isDisplayed());
    }

    public void checkDomainBlockText() {
        assertTrue(domainsBlock.isDisplayed());
    }

    public void checkNumbersBlockText() {
        assertTrue(numbersBlock.isDisplayed());
    }

    public void checkProtocolsBlockText() {
        assertTrue(protocolsBlock.isDisplayed());
    }
}
