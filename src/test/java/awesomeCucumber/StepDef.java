package awesomeCucumber;

import awesomeCucumber.domainObjects.BillingDetails;
import awesomeCucumber.domainObjects.Product;
import awesomeCucumber.factory.DriverFactory;
import awesomeCucumber.pages.CartPage;
import awesomeCucumber.pages.CheckoutPage;
import awesomeCucumber.pages.StorePage;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StepDef {
    private WebDriver driver;
    private BillingDetails billingDetails;

    @Given("I am in Store page")
    public void iAmInStorePage() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store");
    }

    @When("I add a {string} to cart")
    public void iAddAProductToCart(String productName) {
        new StorePage(driver).addToCart(productName);
    }

    @Then("{int} {string} is shown in my cart")
    public void isShownInMyCart(int numberOfProduct, String productName) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(productName, cartPage.getProductName());
        Assert.assertEquals(numberOfProduct, cartPage.getProductQuantity());
    }

    @Given("I am a guest customer")
    public void iAmAGuestCustomer() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store");
    }

    @And("I have a product in cart")
    public void iHaveAProductInCart() {
        new StorePage(driver).addToCart("Blue Shoes");
    }

    @And("I'm on Checkout page")
    public void iMOnCheckoutPage() {
        new CartPage(driver).checkout();
    }

    @When("I provide billing address")
    public void iProvideBillingAddress(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        new CheckoutPage(driver).placeOrder();
    }

    @Then("the order should be places successfully")
    public void theOrderShouldBePlacesSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", new CheckoutPage(driver).getNoticeTxt());
    }
}
