package be.axxes.traineeship.java.testing.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignInWidget extends AbstractPage {

    @FindBy(className = "login-container")
    private WebElement signIn;

    public SignInWidget(WebDriver driver) {
        super(driver);
    }

    public boolean isSignUpWidgetDisplayed(){
        return isDisplayed(signIn);
    }

    public void fillOutCredentials(String login, String password){
        typeInto(signIn, By.id("email"), login);
        typeInto(signIn, By.id("pass"), password);
    }

    public void clickSignIn(){
        click(signIn, By.id("send2"));
    }
}


