package homework3.scenario.webtest;

import homework3.Driver;
import homework3.webpages.IanaHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTests extends Driver {

    private IanaHomePage homePage;

    protected WebTests() throws Exception {
        super();
    }

    @Test(description = "Basic test just opens website")
    public void webTest() throws Exception {
        driver().get(SUT);
        Assert.assertTrue(driver().getTitle().equals("Internet Assigned Numbers Authority"));
        System.out.println("Site opening done");
    }

    @Test
    public void openWebSiteTest() throws Exception {
        homePage.openWebSite(SUT);
        homePage.checkPageTitle();
        homePage.checkDomainBlockText();
        homePage.checkNumbersBlockText();
        homePage.checkProtocolsBlockText();
        homePage.checkTextUnderLogo();
    }
}
