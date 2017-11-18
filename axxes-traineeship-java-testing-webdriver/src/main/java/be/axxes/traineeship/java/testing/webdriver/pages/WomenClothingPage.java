package be.axxes.traineeship.java.testing.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WomenClothingPage extends AbstractPage {

    @FindBy(id = "columns")
    private WebElement parent;

    public WomenClothingPage(WebDriver driver) {
        super(driver);
    }

    public boolean clothingPageDisplayed(){
        return isDisplayed(parent);
    }

    public void selectItem(String Item){
        click(parent, By.cssSelector("a[class='product-name'][title='" + Item + "']"));
    }






}
