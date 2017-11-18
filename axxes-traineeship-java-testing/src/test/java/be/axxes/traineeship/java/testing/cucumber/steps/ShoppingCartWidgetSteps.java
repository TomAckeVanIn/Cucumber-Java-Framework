package be.axxes.traineeship.java.testing.cucumber.steps;

import be.axxes.traineeship.java.testing.AbstractSeleniumTest;
import be.axxes.traineeship.java.testing.webdriver.pages.CheckoutWidget;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartWidgetSteps extends AbstractSeleniumTest {

    @Before
    public void initialize() {
        initializePageObjects();
    }

    @Given("^the user is signed in (.*) (.*)$")
    public void theUserIsSignedIn(String Logon, String Password) throws Throwable {
        homePage().clickSignUpButton();
        assertThat(signInWidget().isSignUpWidgetDisplayed()).isTrue();

        signInWidget()
                .enterEmailAddressSignIn(Logon)
                .enterPasswordSignIn(Password)
                .clickSignIn();

        assertThat(accountPage().accountPageDisplayed()).isTrue();
        accountPage().returnToHomePage();
    }

    @When("^the user adds (.*) items size (.*) to the shopping cart (.*)$")
    public void theUserAddsItemsToCart(int Amount, String Size, String Item) throws Throwable {
        homePage().clickWomenCLothingButton();

        womenClothingPage().clothingPageDisplayed();
        womenClothingPage().selectItem(Item);

        assertThat(itemDetailPage().itemDetailPageDisplayed()).isTrue();
        itemDetailPage()
                .enterDesiredAmount(Amount)
                .selectDesiredSize(Size)
                .addItemToShoppingCart();

        assertThat(itemDetailPage().itemAddedToShoppingCart()).isTrue();
        itemDetailPage().proceedToCheckout();
    }

    @And("^finishes the checkout procedure (.*) (.*) (.*)$")
    public void finishesTheCheckoutProcedure(String Item, int Amount, String Size) throws Throwable {
        assertThat(checkoutWidget().checkoutWidgetSummaryDisplayed()).isTrue();
        assertThat(checkoutWidget().verifyOrderData(Item, Integer.toString(Amount), Size)).isTrue();
        checkoutWidget().proceedToNextStep();
        assertThat(checkoutWidget().checkoutWidgetAddressesDisplayed()).isTrue();
        checkoutWidget().proceedToNextStep();
        assertThat(checkoutWidget().checkoutWidgetCarrierDisplayed()).isTrue();

    }

    @And("^signs in and finishes the checkout procedure$")
    public void signsInAndFinishesTheCheckoutProcedure() throws Throwable {

    }

    @Then("^he has bought the item$")
    public void heHasBoughtTheItem() throws Throwable {

    }



}
