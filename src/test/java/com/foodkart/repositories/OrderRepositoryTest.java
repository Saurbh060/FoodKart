package com.foodkart.repositories;

import com.foodkart.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class OrderRepositoryTest {
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
    }

    @Test
    void testAddOrder() {
        User user = new User("1", "Pralove", "M", "phoneNumber-1", "HSR");
        Restaurant restaurant = new Restaurant("Food Court-1", Arrays.asList("BTM", "HSR"), new FoodItem("NI Thali", 100, 5), new ArrayList<>());
        Order order = new Order("1", user, restaurant, 2);
        orderRepository.addOrder(order);
        assertTrue(orderRepository.getOrdersByUser("1").contains(order));
    }

    @Test
    void testGetOrdersByUser() {
        User user1 = new User("1", "Pralove", "M", "phoneNumber-1", "HSR");
        User user2 = new User("2", "Nitesh", "M", "phoneNumber-2", "BTM");
        Restaurant restaurant = new Restaurant("Food Court-1", Arrays.asList("BTM", "HSR"), new FoodItem("NI Thali", 100, 5), new ArrayList<>());
        Order order1 = new Order("1", user1, restaurant, 2);
        Order order2 = new Order("2", user2, restaurant, 3);
        orderRepository.addOrder(order1);
        orderRepository.addOrder(order2);

        assertEquals(1, orderRepository.getOrdersByUser("1").size());
        assertEquals(1, orderRepository.getOrdersByUser("2").size());
    }
}