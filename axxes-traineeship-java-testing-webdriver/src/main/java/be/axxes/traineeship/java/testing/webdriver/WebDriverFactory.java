package be.axxes.traineeship.java.testing.webdriver;

import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

public final class WebDriverFactory {

    private WebDriver webDriver;
    private Supplier<WebDriver> supplier;

    public WebDriverFactory(final Supplier<WebDriver> factory) {
        supplier = factory;
    }

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = supplier.get();
        }
        return webDriver;
    }

    public void quitWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

}
