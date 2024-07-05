package com.foodkart.services;

import com.foodkart.models.Order;

import java.util.List;

public interface OrderService {
    void placeOrder(String restaurantName, int quantity);
    List<Order> fetchOrderHistory();
}