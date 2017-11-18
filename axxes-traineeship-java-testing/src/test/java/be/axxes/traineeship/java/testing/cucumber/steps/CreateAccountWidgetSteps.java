package be.axxes.traineeship.java.testing.cucumber.steps;

import be.axxes.traineeship.java.testing.AbstractSeleniumTest;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAccountWidgetSteps extends AbstractSeleniumTest {

    @Before
    public void initialize() {
        initializePageObjects();
    }

    @And("^navigates to the create account page (.*)$")
    public void navigatesToTheCreateAccountPage(String Email) throws Throwable {
        signInWidget()
                .enterEmailAddress(Email)
                .goToAccountCreation();
        assertThat(createAccountWidget().isCreateAccountWidgetDisplayed()).isTrue();
    }

    @When("^the user enters an email address (.*)$")
    public void theUserEntersAnEmailAddress(String Email1) throws Throwable {
        signInWidget().enterEmailAddress(Email1);
    }

    @And("^clicks on the create account button$")
    public void clicksOnTheCreateAccountButton() throws Throwable {
        signInWidget().goToAccountCreation();
    }

    @Then("^the create account widget is opened$")
    public void theCreateAccountWidgetIsOpened() throws Throwable {
        assertThat(createAccountWidget().isCreateAccountWidgetDisplayed()).isTrue();
    }

    @When("^the user enters all required personal information fields:$")
    public void theUserEntersAllRequiredPersonalInformationFields(List<String> AccountCreationInfo) throws Throwable {
        createAccountWidget().enterPersonalInformation(AccountCreationInfo);
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
