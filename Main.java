package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Creiamo alcuni prodotti
        Product product1 = new Product("Laptop", "Electronics", 1200.00);
        Product product2 = new Product("Smartphone", "Electronics", 700.00);
        Product product3 = new Product("Chair", "Furniture", 150.00);
        Product product4 = new Product("Table", "Furniture", 300.00);

        // Creiamo alcuni clienti
        Customer customer1 = new Customer("John Doe");
        Customer customer2 = new Customer("Jane Smith");

        // Creiamo alcuni ordini
        List<Order> orders = Arrays.asList(
                new Order(customer1, product1, 1, new Date()),
                new Order(customer1, product2, 2, new Date()),
                new Order(customer2, product3, 5, new Date()),
                new Order(customer2, product4, 1, new Date()));

        // Esercizio #1
        Map<Customer, List<Order>> ordersByCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));

        // Stampa ordine per cliente
        ordersByCustomer.forEach((customer, orderList) -> {
            System.out.println(customer.getName() + ": " + orderList.size() + " ordini.");
        });

        // Esercizio #2
        Map<Customer, Double> totalSalesByCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(Order::getTotalPrice)));

        // Stampa totale vendite per cliente
        totalSalesByCustomer.forEach((customer, total) -> {
            System.out.println(customer.getName() + ": vendite totali = " + total);
        });

        // Esercizio #3
        Optional<Product> mostExpensiveProduct = Arrays.asList(product1, product2, product3, product4).stream()
                .max(Comparator.comparingDouble(Product::getPrice));

        mostExpensiveProduct.ifPresent(product -> {
            System.out.println("Prodotto più costoso: " + product.getName() + " prezzo = " + product.getPrice());
        });

        // Esercizio #4
        double averageOrderAmount = orders.stream()
                .mapToDouble(Order::getTotalPrice)
                .average()
                .orElse(0);

        System.out.println("Media degli importi degli ordini: " + averageOrderAmount);

        // Esercizio #5
        Map<String, Double> totalByCategory = Arrays.asList(product1, product2, product3, product4).stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));

        totalByCategory.forEach((category, sum) -> {
            System.out.println("Categoria: " + category + " - Somma: " + sum);
        });
    }
}