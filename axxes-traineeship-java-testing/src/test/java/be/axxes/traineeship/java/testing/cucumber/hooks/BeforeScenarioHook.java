package be.axxes.traineeship.java.testing.cucumber.hooks;

import be.axxes.traineeship.java.testing.cucumber.CucumberContext;
import be.axxes.traineeship.java.testing.cucumber.Keys;
import be.axxes.traineeship.java.testing.webdriver.WebDriverFactory;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class BeforeScenarioHook {

    @Value("${app.url}")
    private String appUrl;

    @Value("${app.data}")
    private String accountEmail;

    @Autowired
    private WebDriverFactory webDriverFactory;

    @Before
    public void goToHomePage() {
        webDriverFactory.getWebDriver().get(appUrl);
    }

    @Before
    public void setDataKeys() {
        CucumberContext.putValue(Keys.Account_Email, accountEmail);
    }
}
