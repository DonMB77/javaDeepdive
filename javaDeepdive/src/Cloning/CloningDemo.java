package Cloning;

import IO.Serialization.User;

import java.util.ArrayList;
import java.util.List;

public class CloningDemo {

    public static void main (String[] args) throws CloneNotSupportedException {
        User user = new User();
//      user.clone(); since clone has protected status, this will not run. So we have to Override it within the type to change the access modifier level.

        List<Product> products = new ArrayList<>();
        Product prod1 = new Product("prod1", 50.00, 20);
        products.add(prod1);
        Order order = new Order("12313", products, 1);
        System.out.println("Original order: " + order);

        Order clonedOrder = (Order) order.clone();
        System.out.println("Cloned order: " + clonedOrder);

        List<Product> products2 = new ArrayList<>();
        Product prod2 = new Product("prod1", 50.00, 20);
        products2.add(prod2);
        OrderUsingDeepCloning order2 = new OrderUsingDeepCloning("12313", products2, 1);
        System.out.println("Original order: " + order2);

        OrderUsingDeepCloning clonedOrder2 = (OrderUsingDeepCloning) order2.clone();
        System.out.println("Cloned order: " + clonedOrder2);
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
