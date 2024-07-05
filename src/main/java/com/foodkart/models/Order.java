package com.foodkart.models;


public class Order {
    private String orderId;
    private User user;
    private Restaurant restaurant;
    private int quantity;
    private double totalPrice;

    public Order(String orderId, User user, Restaurant restaurant, int quantity) {
        this.orderId = orderId;
        this.user = user;
        this.restaurant = restaurant;
        this.quantity = quantity;
        this.totalPrice = restaurant.getFoodItem().getPrice() * quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}