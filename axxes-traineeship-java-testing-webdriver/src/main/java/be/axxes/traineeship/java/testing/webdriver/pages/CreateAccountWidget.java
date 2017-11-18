package be.axxes.traineeship.java.testing.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CreateAccountWidget extends AbstractPage {

    @FindBy(id = "account-creation_form")
    private WebElement parent;

    private String[][][] AccountInfoElements = new String[][][]{{
            {"customer_firstname","customer_lastname","passwd","address1","city","id_state","postcode","id_country","phone_mobile","alias"},
            {"input","input","input","input","input","dropdown","input","dropdown","input","input"},
            {"id","id","id","id","id","id","id","id","id","id"}
    }};

    public CreateAccountWidget(WebDriver driver) {
        super(driver);
    }

    public boolean isCreateAccountWidgetDisplayed(){
        return isDisplayed(parent);
    }

    public boolean enterPersonalInformation(List<String> AccountInfo) {

        for (int i = 0; i < AccountInfo.size(); i++) {
            if (AccountInfoElements[0][1][i] == "input") {
                if (AccountInfoElements[0][2][i] == "id") {
                    typeInto(parent, By.id(AccountInfoElements[0][0][i]), AccountInfo.get(i));
                } else if (AccountInfoElements[0][2][i] == "class") {
                    typeInto(parent, By.className(AccountInfoElements[0][0][i]), AccountInfo.get(i));
                }
            }
            if (AccountInfoElements[0][1][i] == "dropdown") {
                if (AccountInfoElements[0][2][i] == "id") {
                    selectFromDropdown(parent, By.id(AccountInfoElements[0][0][i]), AccountInfo.get(i));
                } else if (AccountInfoElements[0][2][i] == "class") {
                    selectFromDropdown(parent, By.className(AccountInfoElements[0][0][i]), AccountInfo.get(i));
                }
            }
        }
        return true;
    }

    public void submitAccountCreationForm(){

        click(parent, By.id("submitAccount"));
    }


}
