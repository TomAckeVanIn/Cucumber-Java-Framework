package be.axxes.traineeship.java.testing.cucumber.hooks;

import be.axxes.traineeship.java.testing.cucumber.CucumberContext;
import be.axxes.traineeship.java.testing.webdriver.WebDriverFactory;
import cucumber.api.java.After;
import org.springframework.beans.factory.annotation.Autowired;

public class AfterScenarioHook {

    @Autowired
    private WebDriverFactory webDriverFactory;

    @Autowired
    private CucumberContext cucumberContext;

    @After
    public void resetWebDriver() {
       webDriverFactory.quitWebDriver();
       cucumberContext.clear();
    }
}
