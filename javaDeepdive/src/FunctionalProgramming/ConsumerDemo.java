package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

        HashMap<Integer, ProductInterface> idProductMap = new HashMap<>();
        idProductMap.put(1, new DefaultProduct(1, "TestProduct1", "ProductCategory 1", 50.99));
        idProductMap.put(2, new DefaultProduct(2, "TestProduct2", "ProductCategory 1", 60.99));
        idProductMap.put(3, new DefaultProduct(3, "TestProduct3", "ProductCategory 1", 70.99));

        System.out.println("BiConsumer:");
        increasePriceForProductMap(idProductMap, 10);
        for (ProductInterface product : idProductMap.values()) {
            System.out.println(product);
        }
    }

    public static void increasePriceForProductCollection(ArrayList<? extends ProductInterface> productCollection, double priceIncrease) {
        productCollection.iterator().forEachRemaining(
                product -> product.setPrice(product.getPrice() + priceIncrease)
        );
    }
    public static void increasePriceForProductMap(HashMap<Integer, ? extends ProductInterface> idProductMap, double priceToIncrease) {
        idProductMap.forEach((id, product) -> product.setPrice(product.getPrice() + priceToIncrease));
    }
}
