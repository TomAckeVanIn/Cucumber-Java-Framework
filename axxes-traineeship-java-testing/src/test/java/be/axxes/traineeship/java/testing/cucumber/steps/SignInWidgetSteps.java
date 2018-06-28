package be.axxes.traineeship.java.testing.cucumber.steps;

import be.axxes.traineeship.java.testing.AbstractSeleniumTest;
import be.axxes.traineeship.java.testing.webdriver.Objects.Account;
import be.axxes.traineeship.java.testing.webdriver.pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.assertj.core.api.Assertions.assertThat;

public class SignInWidgetSteps extends AbstractSeleniumTest {

    @Before
    public void initialize() {
        initializePageObjects();
    }

    @When("^the user navigates to the logon page$")
    public void theUserNavigatesToTheLogonPage() throws Throwable {
        Assert.assertTrue(homePage().isHomePageDisplayed());
        homePage().clickCloseCookiePopup();
        homePage().clickSignUpButton();
    }

    @And("^the user logs on using his credentials$")
    public void theUserLogsOnUsingHisCredentials() throws Throwable {
        Assert.assertTrue(signInWidget().isSignUpWidgetDisplayed());
        signInWidget().fillOutCredentials(Account.getAccountLogin(), Account.getAccountPassword());
        signInWidget().clickSignIn();
    }

    @Then("^the user should be logged on successfully$")
    public void theUserIsSuccessfullyLoggedIn() throws Throwable {
        Assert.assertTrue(homePage().isUserLoggedOn());
    }

}
