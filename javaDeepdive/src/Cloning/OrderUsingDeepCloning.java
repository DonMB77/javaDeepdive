package Cloning;

import java.util.ArrayList;
import java.util.List;

public class OrderUsingDeepCloning implements Cloneable {
    private String creditCardNumber;
    private List<Product> products;
    private int customId;

    public OrderUsingDeepCloning() {

    }

    public OrderUsingDeepCloning(String creditCardNumber, List<Product> products, int customId) {
        this.creditCardNumber = creditCardNumber;
        this.products = products;
        this.customId = customId;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getCustomId() {
        return customId;
    }

    public void setCustomId(int customId) {
        this.customId = customId;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // first the object gets cloned like with shallow cloning
        OrderUsingDeepCloning clonedOrder = (OrderUsingDeepCloning) super.clone();

        // deep cloning of mutable fields
        List<Product> productListCopy = new ArrayList<>(this.products);
        clonedOrder.setProducts(productListCopy);

        return clonedOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "creditCardNumber='" + creditCardNumber + '\'' +
                ", products=" + products +
                ", customId=" + customId +
                '}';
    }
}
