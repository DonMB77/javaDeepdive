package ComparisonDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparisonDemo {

    // Sorting Integers (as a type that implements Comparable)
    public static void main(String[] args) {
        System.out.println("Integers ----- : ");

        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 12, 5, 77, 120));
        System.out.println("Originial List " + integers);

        integers.sort(Comparator.reverseOrder());

        System.out.println("Reversed Order: " + integers);

        integers.sort(Comparator.naturalOrder());

        System.out.println("Natural Order: " + integers);

        /* in case natural order has to be used but cannot be implemented we have a few possibilities:
        1. Anonymous class
        2. Separate Class
        3. Lambda expression
        4. Method reference
         */

        /*products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return product1.getProductName().compareTo(product2.getProductName());
            }
        });
        */
        //products.sort(new ProductNameComparator());

        //and so on...
    }
}
