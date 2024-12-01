package FunctionalProgramming;

import java.util.*;
import java.util.function.Function;

public class FunctionsDemoCollections {

    private static final double DISCOUNT_RATE = 0.05;

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        // Here a function is used to infuse new key-value pair
        System.out.println("Function type:");
        System.out.println("map.get(4) " + map.get(4));
        map.computeIfAbsent(4, key -> Integer.toString(key));
        System.out.println("map.get(4) " + map.get(4));

        // A Method Reference however can also be used in the same way:
        map.computeIfAbsent(5, FunctionsDemoCollections::convertIntToString);
        System.out.println("map.get(5) " + map.get(5));

        // Now here using the BiFunction FunctionalInterface:
        map.computeIfPresent(3, (key, value) -> key + " : " + value);
        System.out.println("map.get(3) " + map.get(3));
        map.computeIfPresent(4, FunctionsDemoCollections::combineIntAndString);
        System.out.println("map.get(4) " + map.get(4));

        System.out.println("/////////////");
        System.out.println("\n");

        System.out.println("Compose Functions:");
        HashMap<Product, Double> productDiscountMap = new HashMap<>();

        List<Product> productList = new ArrayList<>(Arrays.asList(new Product(1, 69.99), new Product(2, 79.99), new Product(3, 49.99)));

        // now going through the list we can combine the following functions into one
        for (Product product : productList) {
            Function<Product, Double> getPriceFunction = Product::getPrice;
            Function<Double, Double> getDiscountFunction = price -> price * DISCOUNT_RATE;
            Function<Product, Double> getPriceAndThenDiscountFunction = getPriceFunction.andThen(getDiscountFunction);

            Function<Product, Double> getPriceAndThenDiscountFunctionCompose = getDiscountFunction.compose(getPriceFunction);
            productDiscountMap.computeIfAbsent(product, getPriceAndThenDiscountFunctionCompose);
        }
        System.out.println(productDiscountMap);

        System.out.println("/////////////");
        System.out.println("\n");

        System.out.println("Comparator.comparing():");
        // the next two lines are essentially the same
        productList.sort(Comparator.comparing(Product::getPrice));
        productList.sort(Comparator.comparing(product -> product.getPrice()));
        System.out.println(productList);
    }

    public static String convertIntToString(Integer integer) {
        return Integer.toString(integer);
    }

    public static String combineIntAndString(Integer integer, String string) {
        return integer + " : " + string;
    }
}

class Product {
    private int id;
    private double price;

    public Product(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
