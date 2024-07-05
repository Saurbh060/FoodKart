package com.foodkart.repositories;

import com.foodkart.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrdersByUser(String userId) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUser().getUserId().equals(userId)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }
}