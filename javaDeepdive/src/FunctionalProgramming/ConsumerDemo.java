package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class ConsumerDemo {

    public static void main (String[] args) {
        ArrayList<ProductInterface> productsList = new ArrayList<>(Arrays.asList(
                new DefaultProduct(1, "Product 1", "ProductCategory 1", 99.99),
                new DefaultProduct(2, "Product 2", "ProductCategory 2", 50.99),
                new DefaultProduct(3, "Product 3", "ProductCategory 3", 30.99)
        ));

        increasePriceForProductCollection(productsList, 10);
        for (ProductInterface product : productsList) {
            System.out.println(product);
        }
    }

    public static void increasePriceForProductCollection(ArrayList<? extends ProductInterface> productCollection, double priceIncrease) {
        productCollection.iterator().forEachRemaining(
                product -> product.setPrice(product.getPrice() + priceIncrease)
        );
    }
}
