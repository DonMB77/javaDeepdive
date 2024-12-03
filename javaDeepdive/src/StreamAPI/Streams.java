package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        System.out.println("filter() & map() & collect():  ");
        List<Product> productList = new ArrayList<>(Arrays.asList(
                new Product("Phone", 800.99, 450),
                new Product("Sneaker", 300.99, 800),
                new Product("Laptop", 1800, 300),
                new Product("RAM", 120.99, 120),
                new Product("PlayStation 4", 400.99, 320)
        ));

        //create a stream
        List<Product> modifiedProducts = productList.stream().filter(product -> product.getItemsInWarehouse() > 300).map(product -> {
            product.setPrice(product.getPrice() - (product.getPrice() * 0.10));
            return product;
        }).collect(Collectors.toList());

        modifiedProducts.stream().forEach(System.out::println);

        System.out.println("///////");
        System.out.println("\n");
        System.out.println("flatMap(): ");

        Warehouse warehouse1 = new Warehouse();
        Warehouse warehouse2 = new Warehouse();
        Warehouse warehouse3 = new Warehouse();

        warehouse1.setProducts(Arrays.asList(new Product("Phone", 800.99, 450)));
        warehouse2.setProducts(Arrays.asList(
                new Product("Sneaker", 300.99, 800),
                new Product("Laptop", 1800, 300)
        ));
        warehouse3.setProducts(Arrays.asList(
                new Product("RAM", 120.99, 120),
                new Product("PlayStation 4", 400.99, 320)
        ));

        List<Warehouse> warehousesList = new ArrayList<>(Arrays.asList(warehouse1, warehouse2, warehouse3));
    }
}

class Product {
    private String name;
    private double price;
    private int itemsInWarehouse;

    public Product(String name, double price, int itemsInWarehouse) {
        this.name = name;
        this.price = price;
        this.itemsInWarehouse = itemsInWarehouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemsInWarehouse() {
        return itemsInWarehouse;
    }

    public void setItemsInWarehouse(int itemsInWarehouse) {
        this.itemsInWarehouse = itemsInWarehouse;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", itemsInWarehouse=" + itemsInWarehouse +
                '}';
    }
}

class Warehouse {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
