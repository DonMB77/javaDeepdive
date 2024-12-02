package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Predicates {

    public static void main (String[] args) {
        ArrayList<ProductInterface> productList = new ArrayList<>(Arrays.asList(
                new DefaultProduct(1, "TestProduct1", "Category 1", 50.99),
                new DefaultProduct(2, "TestProduct2", "Category 2", 120.99),
                new DefaultProduct(3, "TestProduct3", "Category 3", 100.99)
                ));

        removeProductsIfPriceExceeds(productList, 100);

        for (ProductInterface product : productList) {
            System.out.println(product);
        }

        System.out.println("Predicate.and(): ");
        ArrayList<ProductInterface> productList2 = new ArrayList<>(Arrays.asList(
                new DefaultProduct(1, "TestProduct1", "Category 1", 50.99),
                new DefaultProduct(2, "TestProduct2", "Category 2", 120.99),
                new DefaultProduct(3, "TestProduct3", "Category 3", 100.99)
        ));

        removeProductsIfPriceExceedsAndCategoryIsEqualTo(productList2, 100, "Category 1");
        for (ProductInterface product: productList2) {
            System.out.println(product);
        }
    }

    public static void removeProductsIfPriceExceeds (ArrayList<? extends ProductInterface> products, double price) {
        products.removeIf(product -> product.getPrice() > price);
    }

    public static void removeProductsIfPriceExceedsAndCategoryIsEqualTo (ArrayList<? extends ProductInterface> products, double price, String categoryName) {
        Predicate<ProductInterface> booleanIsPriceMoreThanPredicate = product -> product.getPrice() > price;
        Predicate<ProductInterface> booleanIsCategoryEqualToPredicate = product -> product.getCategoryName().equals(categoryName);
        products.removeIf(booleanIsPriceMoreThanPredicate.and(booleanIsCategoryEqualToPredicate));
    }
}
