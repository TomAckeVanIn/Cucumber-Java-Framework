package be.axxes.traineeship.java.testing.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ItemDetailPage extends AbstractPage {

    @FindBy(id = "product")
    private WebElement parent;

    @FindBy(id = "header")
    private WebElement popup;

    public ItemDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean itemDetailPageDisplayed() {
        return isDisplayed(parent);
    }

    public boolean itemAddedToShoppingCart() {
        return isDisplayed(popup, By.className("icon-ok"));
    }

    public ItemDetailPage enterDesiredAmount(int Amount) {
        for (int i = 1; i < Amount; i++) {
            click(parent, By.className("product_quantity_up"));
        }
        return this;
    }

    public ItemDetailPage selectDesiredSize(String Size) {
        selectFromDropdown(parent, By.id("group_1"), Size);
        return this;
    }

    public void addItemToShoppingCart() {
        click(parent, By.cssSelector("button[name='Submit']"));
    }

    public void proceedToCheckout(){
        click(popup, By.cssSelector("a[title='Proceed to checkout'"));
    }

}
