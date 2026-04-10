package com.example;
import com.example.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static List<Product> products = new ArrayList<>();

    public static  List<Product> getProductsAbovePrice(double price) {
        return products.stream()
                .filter(p -> p.getPrice() > price)
                .toList();
    }
    public static List<String> getProductNames() {
        return products.stream()
                .map(p -> p.getName()) // Function
                .toList();
    }
    public static void main(String[] args) {
        products.add(new Product(1L, "Laptop", 500.0));
        products.add(new Product(2L, "Phone", 300.0));
        products.add(new Product(3L, "Tablet", 200.0));
        products.add(new Product(4L, "Monitor", 150.0));

        Product p = new Product(1L, "Laptop", 500.0);

        Predicate<Product> isExpensive = product -> product.getPrice() > 100;
        System.out.println(isExpensive.test(p));

        Function<Product, Double> fetchPrice = product -> product.getPrice();
        System.out.println(fetchPrice.apply(p));

        Consumer<Product> logName = product -> System.out.println("product name is: "+product.getName());
        logName.accept(p);


        List<Product> productList = getProductsAbovePrice(200);
        List<String> productNames = getProductNames();

        Consumer<Product> logPrice = product ->
                Optional.ofNullable(product)
                        .map(Product::getPrice)
                        .ifPresent(price -> System.out.println("product price is: " + price));
        logPrice.accept(p);
    }
}