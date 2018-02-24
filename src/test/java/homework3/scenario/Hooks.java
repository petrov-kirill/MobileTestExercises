package homework3.scenario;

import homework3.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test(groups = {"web", "native"})
public class Hooks extends Driver {

    Hooks() throws Exception {
        super();
    }

    @BeforeSuite(description = "Init driver to run tests", groups = {"web", "native"})
    public void setUp() throws Exception {
        prepareDriver();
        System.out.println("Driver prepared");
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}
