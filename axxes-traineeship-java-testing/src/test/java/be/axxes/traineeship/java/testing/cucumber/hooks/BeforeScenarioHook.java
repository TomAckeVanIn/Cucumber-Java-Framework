package be.axxes.traineeship.java.testing.cucumber.hooks;

import be.axxes.traineeship.java.testing.cucumber.CucumberContext;
import be.axxes.traineeship.java.testing.cucumber.Keys;
import be.axxes.traineeship.java.testing.webdriver.WebDriverFactory;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeforeScenarioHook {

    @Value("${app.url}")
    private String appUrl;

    @Value("#{'${app.data}'.split(',')}")
    private List<String> data;

    @Autowired
    private WebDriverFactory factory;

    @Before
    public void setDataKeys() {
        ArrayList<Keys> keyList = new ArrayList<>(Arrays.asList(Keys.values()));

        for (int i =0; i < data.size(); i++){
            CucumberContext.putValue(keyList.get(i), data.get(i));
        }
    }

    @Before
    public void goToHomePage() {
        factory.getWebDriver().get(appUrl);
    }


}
