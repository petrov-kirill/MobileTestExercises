package hw3.scenarios.web;

import hw3.Driver;
import hw3.webpages.IanaHomePage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class WebTest extends Driver {

    private IanaHomePage homePage;

    protected WebTest() throws IOException {
        super();
    }

    @BeforeClass
    public void setup() throws Exception {
        homePage = PageFactory.initElements(driver(), IanaHomePage.class);
    }

    @Test
    public void openWebSiteTest() throws Exception {
        homePage.openWebSite(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        homePage.checkPageTitle();
        homePage.checkDomainBlockText();
        homePage.checkNumbersBlockText();
        homePage.checkProtocolsBlockText();
        homePage.checkTextUnderLogo();
    }
}
