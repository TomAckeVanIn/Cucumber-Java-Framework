package be.axxes.traineeship.java.testing.cucumber.steps;

import be.axxes.traineeship.java.testing.AbstractSeleniumTest;
import be.axxes.traineeship.java.testing.cucumber.CucumberContext;
import be.axxes.traineeship.java.testing.cucumber.Keys;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAccountWidgetSteps extends AbstractSeleniumTest {

    @Before
    public void initialize() {
        initializePageObjects();
    }


    @And("^navigates to the create account page$")
    public void navigatesToTheCreateAccountPage() throws Throwable {
        signInWidget()
                .enterEmailAddress(CucumberContext.getValue(Keys.ACCOUNT_EMAIL))
                .goToAccountCreation();
        assertThat(createAccountWidget().isCreateAccountWidgetDisplayed()).isTrue();

    }

    @When("^the user enters all required personal information fields:$")
    public void theUserEntersAllRequiredPersonalInformationFields(List<String> accountCreationInfo) throws Throwable {
        createAccountWidget().enterPersonalInformation(accountCreationInfo);
    }

    @And("^the user enters all required address information fields (.*)$")
    public void theUserEntersAllRequiredAddressInformationFields() throws Throwable {

    }

    @And("^clicks on the register button$")
    public void clicksOnTheRegisterButton() throws Throwable {
        createAccountWidget().submitAccountCreationForm();
    }

    @Then("^the new account is created$")
    public void theNewAccountIsCreated() throws Throwable {
        assertThat(accountPage().accountPageDisplayed()).isTrue();
    }

}
