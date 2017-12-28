package be.axxes.traineeship.java.testing.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AbstractPage {

    private final WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void click(final WebElement parent, final By by) {
        WebElement input = waitFor(parent, by);
        waitFor(visibilityOf(input));
        input.click();
    }

    protected boolean isDisplayed(final WebElement parent, final By by) {
        return isDisplayed(waitFor(parent, by));
    }

    protected boolean isDisplayed(final WebElement element) {
        try {
            return waitFor(element).isDisplayed();
        } catch(NoSuchElementException | TimeoutException exception) {
            return false;
        }
    }

    protected boolean isSelected(final WebElement parent, By by){
        return waitFor(parent, by).isSelected();
    }

    protected void typeInto(final WebElement parent, final By by, final String value) {
        waitFor(waitFor(parent, by)).sendKeys(value);
    }

    protected void selectFromDropdown(final WebElement parent, final By by, final String value){
        Select select = new Select(waitFor(parent, by));
        select.selectByVisibleText(value);
    }

    protected String getAttributeValue (final WebElement parent, final By by, String Attribute){
        return waitFor(parent,by).getAttribute(Attribute);
    }

    protected List<WebElement> findElements (final WebElement parent, final By by){
        return waitFor(parent, by).findElements(by);
    }

    protected void clearContent(final WebElement parent, final By by){
        waitFor(parent, by).clear();
    }

    private WebElement waitFor(final WebElement parent, final By by) {
        return by == null ? waitFor(parent) : waitFor(parent).findElement(by);
    }

    private WebElement waitFor(final WebElement webElement) {
        return waitFor(visibilityOf(webElement));
    }

    private <T> T waitFor(final ExpectedCondition<T> condition) {
        return getWebDriverWait().until(condition);
    }

    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, 10);
    }
}
