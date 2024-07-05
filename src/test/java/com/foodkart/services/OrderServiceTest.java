package com.foodkart.services;


import com.foodkart.models.*;
import com.foodkart.repositories.OrderRepository;
import com.foodkart.repositories.RestaurantRepository;
import com.foodkart.repositories.UserRepository;
import com.foodkart.services.impl.OrderServiceImpl;
import com.foodkart.services.impl.RestaurantServiceImpl;
import com.foodkart.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    private OrderService orderService;
    private RestaurantService restaurantService;
    private UserService userService;
    private OrderRepository orderRepository;
    private RestaurantRepository restaurantRepository;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        restaurantRepository = new RestaurantRepository();
        orderRepository = new OrderRepository();
        userService = new UserServiceImpl(userRepository);
        restaurantService = new RestaurantServiceImpl(restaurantRepository, userService);
        orderService = new OrderServiceImpl(orderRepository, restaurantRepository, userService);
    }

    @Test
    void testPlaceOrder() {
        User user = new User("1", "Pralove", "M", "phoneNumber-1", "HSR");
        userService.registerUser(user);
        userService.loginUser("phoneNumber-1");

        Restaurant restaurant = new Restaurant("Food Court-1", Arrays.asList("BTM", "HSR"), new FoodItem("NI Thali", 100, 5), new ArrayList<>());
        restaurantService.registerRestaurant(restaurant);

        orderService.placeOrder("Food Court-1", 2);
        assertEquals(3, restaurantRepository.getRestaurantByName("Food Court-1").getFoodItem().getQuantity());
    }

    @Test
    void testFetchOrderHistory() {
        User user = new User("1", "Pralove", "M", "phoneNumber-1", "HSR");
        userService.registerUser(user);
        userService.loginUser("phoneNumber-1");

        Restaurant restaurant = new Restaurant("Food Court-1", Arrays.asList("BTM", "HSR"), new FoodItem("NI Thali", 100, 5), new ArrayList<>());
        restaurantService.registerRestaurant(restaurant);

        orderService.placeOrder("Food Court-1", 2);
        List<Order> orders = orderService.fetchOrderHistory();
        assertEquals(1, orders.size());
    }
}