package be.axxes.traineeship.java.testing.cucumber.steps;

import be.axxes.traineeship.java.testing.AbstractSeleniumTest;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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

    @When("^the user selects a subject heading (.*)$")
    public void theUserSelectsSubjectHeading(String Heading) throws Throwable {
        contactUsWidget().selectHeading(Heading);
    }

    @And("^the user fills out the email address (.*)$")
    public void theUserFillsOutEmail(String Email) throws Throwable {
        contactUsWidget().enterEmailAddress(Email);
    }

    @And("^the user fills out the order reference (.*)$")
    public void theUserFillsOutReference(String Reference) throws Throwable {
        contactUsWidget().enterReference(Reference);
    }

    @And("^the user fills out the contact message (.*)$")
    public void theUserFillsOutTheContactMessage(String Message) throws Throwable {
        contactUsWidget().enterMessage(Message);
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
