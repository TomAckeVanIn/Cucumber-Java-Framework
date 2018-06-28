package be.axxes.traineeship.java.testing;

import be.axxes.traineeship.java.testing.config.TestingConfig;
import be.axxes.traineeship.java.testing.cucumber.CucumberContext;
import be.axxes.traineeship.java.testing.webdriver.WebDriverFactory;
import be.axxes.traineeship.java.testing.webdriver.config.SeleniumConfig;
import be.axxes.traineeship.java.testing.webdriver.pages.AbstractPage;
import be.axxes.traineeship.java.testing.webdriver.pages.HomePage;
import be.axxes.traineeship.java.testing.webdriver.pages.SignInWidget;
//import com.gargoylesoftware.htmlunit.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ContextConfiguration
@SpringBootTest(classes = {TestingConfig.class, SeleniumConfig.class})
public abstract class AbstractSeleniumTest {

    @Autowired
    protected CucumberContext context;

    @Autowired
    private WebDriverFactory factory;

    private List<AbstractPage> pages;

    protected HomePage homePage() {
        return getPageObject(HomePage.class);
    }

    protected SignInWidget signInWidget() {
        return getPageObject(SignInWidget.class);
    }


    private <T extends AbstractPage> T getPageObject(Class<T> PageObjectClassType) {
        return (T) pages
                .stream()
                .filter(PageObjectClassType::isInstance)
                .findFirst()
                .get();
    }

    protected <T extends AbstractPage> void initializePageObjects() {
        if(pages == null) {
            pages = Collections.unmodifiableList(
                        Stream.of(
                                new HomePage(factory.getWebDriver()),
                                new SignInWidget(factory.getWebDriver()))
                        .collect(Collectors.toList()));
        }
    }
}
