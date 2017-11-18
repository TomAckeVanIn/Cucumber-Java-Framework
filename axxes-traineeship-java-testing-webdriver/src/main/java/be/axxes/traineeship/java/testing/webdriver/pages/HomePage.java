package be.axxes.traineeship.java.testing.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "header")
    private WebElement parent;

    public HomePage(final WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage clickContactUsButton() {
        click(parent, By.id("contact-link"));
        return this;
    }

    public HomePage clickSignUpButton() {
        click(parent, By.className("login"));
        return this;
    }

    public HomePage clickWomenCLothingButton() {
        click(parent, By.cssSelector("a[title='Women']"));
        return this;
    }
}
