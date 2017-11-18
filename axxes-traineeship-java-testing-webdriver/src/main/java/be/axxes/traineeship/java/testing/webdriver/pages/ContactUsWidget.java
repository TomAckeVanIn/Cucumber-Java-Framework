package be.axxes.traineeship.java.testing.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactUsWidget extends AbstractPage {

    @FindBy(className = "contact")
    private WebElement parent;

    public ContactUsWidget(WebDriver driver) {
        super(driver);
    }

    public boolean isContactWidgetDisplayed() {
        return isDisplayed(parent);
    }

    public void selectHeading(String Heading)
    {
        selectFromDropdown(parent,By.id("id_contact"),Heading);
    }

    public void enterEmailAddress(String Email) {
        typeInto(parent, By.id("email"),Email);
    }

    public void enterReference(String Reference) {
        typeInto(parent, By.id("id_order"),Reference);
    }

    public void enterMessage(String Message) {
        typeInto(parent, By.id("message"),Message);
    }

    public void submitContactForm()
    {
        click(parent,By.id("submitMessage"));
    }

    public boolean isSuccessMessageDisplayed()
    {
        return isDisplayed(parent, By.className("alert-success"));
    }
}
