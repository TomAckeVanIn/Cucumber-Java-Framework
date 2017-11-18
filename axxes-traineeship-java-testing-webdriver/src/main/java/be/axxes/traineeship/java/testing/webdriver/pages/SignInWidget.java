package be.axxes.traineeship.java.testing.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignInWidget extends AbstractPage {

    @FindBy(id = "authentication")
    private WebElement parent;

    public SignInWidget(WebDriver driver) {
        super(driver);
    }

    public boolean isSignUpWidgetDisplayed(){
        return isDisplayed(parent);
    }

    public SignInWidget enterEmailAddress(String EmailCreate){
        typeInto(parent, By.id("email_create"), EmailCreate);
        return this;
    }

    public void goToAccountCreation(){
        click(parent, By.id("SubmitCreate"));
    }

    public SignInWidget enterEmailAddressSignIn(String EmailSignIn){
        typeInto(parent, By.id("email"), EmailSignIn);
        return this;
    }

    public SignInWidget enterPasswordSignIn(String PasswordSignIn){
        typeInto(parent, By.id("passwd"), PasswordSignIn);
        return this;
    }

    public void clickSignIn(){
        click(parent, By.id("SubmitLogin"));
    }
}


