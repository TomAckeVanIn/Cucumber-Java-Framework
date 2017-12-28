package be.axxes.traineeship.java.testing;

import be.axxes.traineeship.java.testing.config.TestingConfig;
import be.axxes.traineeship.java.testing.cucumber.CucumberContext;
import be.axxes.traineeship.java.testing.webdriver.WebDriverFactory;
import be.axxes.traineeship.java.testing.webdriver.config.SeleniumConfig;
import be.axxes.traineeship.java.testing.webdriver.pages.AbstractPage;
import be.axxes.traineeship.java.testing.webdriver.pages.AccountPage;
import be.axxes.traineeship.java.testing.webdriver.pages.CheckoutWidget;
import be.axxes.traineeship.java.testing.webdriver.pages.ContactUsWidget;
import be.axxes.traineeship.java.testing.webdriver.pages.CreateAccountWidget;
import be.axxes.traineeship.java.testing.webdriver.pages.HomePage;
import be.axxes.traineeship.java.testing.webdriver.pages.ItemDetailPage;
import be.axxes.traineeship.java.testing.webdriver.pages.SignInWidget;
import be.axxes.traineeship.java.testing.webdriver.pages.WomenClothingPage;
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

    protected ContactUsWidget contactUsWidget() {
        return getPageObject(ContactUsWidget.class);
    }

    protected SignInWidget signInWidget() {
        return getPageObject(SignInWidget.class);
    }

    protected CreateAccountWidget createAccountWidget() {
        return getPageObject(CreateAccountWidget.class);
    }

    protected AccountPage accountPage() {
        return getPageObject(AccountPage.class);
    }

    protected CheckoutWidget checkoutWidget() {
        return getPageObject(CheckoutWidget.class);
    }

    protected WomenClothingPage womenClothingPage() {
        return getPageObject(WomenClothingPage.class);
    }

    protected ItemDetailPage itemDetailPage() {
        return getPageObject(ItemDetailPage.class);
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
                                new ContactUsWidget(factory.getWebDriver()),
                                new SignInWidget(factory.getWebDriver()),
                                new CreateAccountWidget(factory.getWebDriver()),
                                new AccountPage(factory.getWebDriver()),
                                new CheckoutWidget(factory.getWebDriver()),
                                new WomenClothingPage(factory.getWebDriver()),
                                new ItemDetailPage(factory.getWebDriver()))
                        .collect(Collectors.toList()));
        }
    }
}
