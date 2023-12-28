package com.example.springsocial.payment;
public class CartItem {
    private String id;
    private String productName;
    private double price;
    private int quantity;
    private String currency;

    public CartItem(String id, String productName, double price, int quantity, String currency) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.currency = currency;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

