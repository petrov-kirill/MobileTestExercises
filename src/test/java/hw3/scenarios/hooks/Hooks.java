package hw3.scenarios.hooks;

import hw3.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(groups = "native")
public class Hooks extends Driver{

    public Hooks() throws IOException {
        super();
    }

    @BeforeSuite(description = "Setting up driver to run tests", groups = {"native", "web"})
    public void setUp() throws Exception {
        prepareDriver();
    }

    @AfterSuite(description = "Shutting down driver", groups = {"native", "web"}, alwaysRun = true)
    public void tearDown() throws Exception {
        driver().closeApp();
    }
}
