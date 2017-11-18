package be.axxes.traineeship.java.testing.cucumber.steps;

import be.axxes.traineeship.java.testing.AbstractSeleniumTest;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class SignInWidgetSteps extends AbstractSeleniumTest {

    @Before
    public void initialize() {
        initializePageObjects();
    }

    @Given("^the user is on the sign up page$")
    public void theUserIsOnTheSignUpPageAndHasAnAccount() throws Throwable {
        homePage().clickSignUpButton();
        assertThat(signInWidget().isSignUpWidgetDisplayed()).isTrue();
    }

    @When("^I enter a valid email address (.*)$")
    public void iEnterAValidEmailAddress(String Email) throws Throwable {
        signInWidget().enterEmailAddressSignIn(Email);
    }

    @And("^I enter a valid password (.*)$")
    public void iEnterAValidPassword(String Password) throws Throwable {
        signInWidget().enterPasswordSignIn(Password);
    }

    @And("^I click the submit button$")
    public void iClickTheSubmitButton() throws Throwable {
        signInWidget().clickSignIn();
    }

    @Then("^I am signed in to the application$")
    public void iAmSignedInToTheApplication() throws Throwable {
        assertThat(accountPage().accountPageDisplayed()).isTrue();
    }
}
