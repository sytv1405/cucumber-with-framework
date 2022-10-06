package awesomeCucumber.domainObjects;

public class Product {

    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }
}
