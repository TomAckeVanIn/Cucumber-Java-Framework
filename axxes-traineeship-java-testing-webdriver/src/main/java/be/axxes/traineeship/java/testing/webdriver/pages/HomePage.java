package be.axxes.traineeship.java.testing.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "CybotCookiebotDialogBody")
    private WebElement cookiePopup;

    @FindBy(id = "maincontent")
    private WebElement content;

    @FindBy(className = "page-header")
    private WebElement signInSection;


    public HomePage(final WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isHomePageDisplayed(){
        return isDisplayed(content);
    }

    public boolean isUserLoggedOn(){
        return isDisplayed(signInSection, By.className("customer-name"));
    }

    public void clickSignUpButton() {
        click(signInSection, By.className("authorization-link"));
    }

    public void clickCloseCookiePopup(){
        click(cookiePopup, By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
    }

}
