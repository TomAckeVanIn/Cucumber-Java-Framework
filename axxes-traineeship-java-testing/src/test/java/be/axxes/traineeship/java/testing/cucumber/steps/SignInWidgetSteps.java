package be.axxes.traineeship.java.testing.cucumber.steps;

import be.axxes.traineeship.java.testing.AbstractSeleniumTest;
import cucumber.api.PendingException;
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

    @When("^the user navigates to the logon page$")
    public void theUserNavigatesToTheLogonPage() throws Throwable {

    }

    @And("^the user logs on using his credentials (.*)(.*)$")
    public void theUserLogsOnUsingHisCredentialsTesterAxxesTest(int arg0) throws Throwable {

    }

    @Then("^the user should be logged on successfully$")
    public void theUserIsSuccessfullyLoggedIn() throws Throwable {

    }

}
