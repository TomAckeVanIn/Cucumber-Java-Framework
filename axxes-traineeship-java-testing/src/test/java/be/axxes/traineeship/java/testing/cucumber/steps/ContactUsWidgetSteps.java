package be.axxes.traineeship.java.testing.cucumber.steps;

import be.axxes.traineeship.java.testing.AbstractSeleniumTest;
import be.axxes.traineeship.java.testing.cucumber.CucumberContext;
import be.axxes.traineeship.java.testing.cucumber.Keys;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactUsWidgetSteps extends AbstractSeleniumTest {

    @Before
    public void initialize() {
        initializePageObjects();
    }


    @Given("^the user is on the contact us page$")
    public void theUserIsOnTheContactPage() throws Throwable {
        homePage().clickContactUsButton();
        assertThat(contactUsWidget().isContactWidgetDisplayed()).isTrue();
    }

    @When("^the user selects a subject heading$")
    public void theUserSelectsSubjectHeading() throws Throwable {
        contactUsWidget().selectHeading(CucumberContext.getValue(Keys.CONTACT_HEADING));
    }

    @And("^the user fills out the email address$")
    public void theUserFillsOutEmail() throws Throwable {
        contactUsWidget().enterEmailAddress(CucumberContext.getValue(Keys.CONTACT_ADDRESS));
    }

    @And("^the user fills out the order reference$")
    public void theUserFillsOutReference() throws Throwable {
        contactUsWidget().enterReference(CucumberContext.getValue(Keys.CONTACT_REFERENCE));
    }

    @And("^the user fills out the contact message$")
    public void theUserFillsOutTheContactMessage() throws Throwable {
        contactUsWidget().enterMessage(CucumberContext.getValue(Keys.CONTACT_MESSAGE));
    }

    @And("^the send button is clicked$")
    public void theSendButtonIsClicked() throws Throwable {
        contactUsWidget().submitContactForm();
    }

    @Then("^the message is successfully sent$")
    public void theMessageIsSuccessfullySent() throws Throwable {
        assertThat(contactUsWidget().isSuccessMessageDisplayed()).isTrue();
    }
}
