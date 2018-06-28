package be.axxes.traineeship.java.testing.cucumber.hooks;

import be.axxes.traineeship.java.testing.cucumber.CucumberContext;
import be.axxes.traineeship.java.testing.cucumber.Keys;
import be.axxes.traineeship.java.testing.webdriver.Objects.Account;
import be.axxes.traineeship.java.testing.webdriver.WebDriverFactory;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeforeScenarioHook {

    @Value("${app.data.url}")
    private String appUrl;

    @Value("#{'${app.data.account}'.split(',')}")
    private List<String> accountData;

    @Autowired
    private WebDriverFactory webDriverFactory;

    private static Account account;

    @Before
    public void setDataObjects() {
        account = new Account(accountData.get(0),accountData.get(1), accountData.get(2));
    }

    @Before
    public void goToHomePage() {
        webDriverFactory.getWebDriver().get(appUrl);
    }
}
