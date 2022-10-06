package awesomeCucumber.customeType;

import awesomeCucumber.domainObjects.BillingDetails;
import awesomeCucumber.domainObjects.Product;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {

    @DataTableType
    public BillingDetails billingDetailsEntry(Map<String, String> entry) {
        return new BillingDetails(entry.get("firstName"),
                entry.get("lastName"),
                entry.get("country"),
                entry.get("street"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zip"),
                entry.get("email"));
    }

    @DataTableType
    public Product product(String productName) {
        return new Product(productName);
    }
}