package awesomeCucumber.pages;

import awesomeCucumber.domainObjects.BillingDetails;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    @FindBy(id = "billing_first_name") private WebElement firstNameFld;
    @FindBy(id = "billing_last_name") private WebElement lastNameFld;
    @FindBy(id = "billing_country") private WebElement countryDropdown;
    @FindBy(id = "billing_address_1") private WebElement streetAddress1Fld;
    @FindBy(id = "billing_city") private WebElement cityFld;
    @FindBy(id = "billing_state") private WebElement stateDropdown;
    @FindBy(id = "billing_postcode") private WebElement zipCodeFld;
    @FindBy(id = "billing_email") private WebElement emailFld;
    @FindBy(id = "place_order") private WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-notice") private WebElement noticeTxt;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String billingFirstName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(firstNameFld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckoutPage enterLastName(String billingLastName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(lastNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckoutPage selectCountry(String billingCountry) {
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(billingCountry);
        return this;
    }

    public CheckoutPage enterFirstLineStreet(String billingAddress) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(streetAddress1Fld));
        e.clear();
        e.sendKeys(billingAddress);
        return this;
    }

    public CheckoutPage enterCity(String billingCity) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(cityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckoutPage selectBillingState(String billingState) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(stateDropdown)));
        select.selectByVisibleText(billingState);
        return this;
    }

    public CheckoutPage enterZipCode(String billingZipcode) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(zipCodeFld));
        e.clear();
        e.sendKeys(billingZipcode);
        return this;
    }

    public CheckoutPage enterEmail(String billingEmail) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(emailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage setBillingDetails(BillingDetails billingDetails) {
        // builder pattern
        return enterFirstName(billingDetails.getFirstName()).
                enterLastName(billingDetails.getLastName()).
                selectCountry(billingDetails.getCountry()).
                enterFirstLineStreet(billingDetails.getStreet()).
                enterCity(billingDetails.getCity()).
                selectBillingState(billingDetails.getState()).
                enterZipCode(billingDetails.getZip()).
                enterEmail(billingDetails.getEmail());
    }

    public CheckoutPage placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }

    public String getNoticeTxt() {
        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
    }

}
