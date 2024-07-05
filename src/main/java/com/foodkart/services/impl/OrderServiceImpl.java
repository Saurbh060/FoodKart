package com.foodkart.services.impl;

import com.foodkart.models.Order;
import com.foodkart.models.Restaurant;
import com.foodkart.repositories.OrderRepository;
import com.foodkart.repositories.RestaurantRepository;
import com.foodkart.services.OrderService;
import com.foodkart.services.UserService;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private RestaurantRepository restaurantRepository;
    private UserService userService;
    private static final Logger logger = Logger.getLogger(OrderServiceImpl.class.getName());

    public OrderServiceImpl(OrderRepository orderRepository, RestaurantRepository restaurantRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
        this.userService = userService;
    }

    @Override
    public void placeOrder(String restaurantName, int quantity) {
        Restaurant restaurant = restaurantRepository.getRestaurantByName(restaurantName);
        if (restaurant != null && restaurant.getFoodItem().getQuantity() >= quantity) {
            restaurant.updateQuantity(-quantity);
            Order order = new Order(UUID.randomUUID().toString(), userService.getCurrentUser(), restaurant, quantity);
            orderRepository.addOrder(order);
            logger.info("Order placed: " + order.getOrderId());
        } else {
            logger.warning("Order cannot be placed: insufficient quantity or restaurant not found.");
        }
    }

    @Override
    public List<Order> fetchOrderHistory() {
        return orderRepository.getOrdersByUser(userService.getCurrentUser().getUserId());
    }
}