package com.foodkart;

import com.foodkart.repositories.OrderRepository;
import com.foodkart.repositories.RestaurantRepository;
import com.foodkart.repositories.UserRepository;
import com.foodkart.services.OrderService;
import com.foodkart.services.UserService;
import com.foodkart.services.impl.OrderServiceImpl;
import com.foodkart.services.impl.UserServiceImpl;
import com.foodkart.services.RestaurantService;
import com.foodkart.services.impl.RestaurantServiceImpl;

public class FoodKartApp {

    private UserService userService;
    private RestaurantService restaurantService;
    private OrderService orderService;

    public FoodKartApp() {
        UserRepository userRepository = new UserRepository();
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        OrderRepository orderRepository = new OrderRepository();

        userService = new UserServiceImpl(userRepository);
        restaurantService = new RestaurantServiceImpl(restaurantRepository, userService);
        orderService = new OrderServiceImpl(orderRepository, restaurantRepository, userService);
    }

    public UserService getUserService() {
        return userService;
    }

    public RestaurantService getRestaurantService() {
        return restaurantService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}