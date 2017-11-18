package be.axxes.traineeship.java.testing.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class AccountPage extends AbstractPage {

    @FindBy(id = "my-account")
    private WebElement parent;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean accountPageDisplayed(){
        return isDisplayed(parent, By.className("info-account"));
    }

    public void returnToHomePage(){
        click(parent, By.className("home"));
    }


}
