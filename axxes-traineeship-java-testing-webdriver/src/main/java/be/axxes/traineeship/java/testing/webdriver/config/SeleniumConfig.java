package be.axxes.traineeship.java.testing.webdriver.config;

import be.axxes.traineeship.java.testing.webdriver.WebDriverFactory;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

@Configuration
public class SeleniumConfig {

    @Profile("chrome")
    @Bean(destroyMethod = "quitWebDriver")
    public WebDriverFactory chromeWebDriver() {
        ChromeDriverManager.getInstance().setup();
        return new WebDriverFactory(() -> configure(new ChromeDriver()));
    }

    @Profile("firefox")
    @Bean(destroyMethod = "quitWebDriver")
    public WebDriverFactory firefoxWebDriver() {
        FirefoxDriverManager.getInstance().setup();
        return new WebDriverFactory(() -> configure(new FirefoxDriver()));
    }

    private static <T extends WebDriver> T configure(final T driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

}