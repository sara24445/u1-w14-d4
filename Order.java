package com.example;

import java.util.Date;

public class Order {
    private Customer customer;
    private Product product;
    private int quantity;
    private Date orderDate;

    public Order(Customer customer, Product product, int quantity, Date orderDate) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}