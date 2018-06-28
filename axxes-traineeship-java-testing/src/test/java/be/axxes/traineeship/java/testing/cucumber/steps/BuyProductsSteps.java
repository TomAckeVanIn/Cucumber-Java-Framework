package be.axxes.traineeship.java.testing.cucumber.steps;

import be.axxes.traineeship.java.testing.AbstractSeleniumTest;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyProductsSteps extends AbstractSeleniumTest {

    @Before
    public void initialize() {
        initializePageObjects();
    }

    @Given("^the user navigates to the overview of (.*)$")
    public void theUserIsOnTheSignUpPageAndHasAnAccount(String product) throws Throwable {

    }

    @When("^the user adds the product to the cart$")
    public void theUserAddsTheProductToTheCart() {

    }

    @Then("^the selected product should be added to the cart$")
    public void theSelectedProductWasAddedToTheCart() {

    }
}



