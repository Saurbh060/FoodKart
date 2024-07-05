package com.foodkart.repositories;

import com.foodkart.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantRepositoryTest {
    private RestaurantRepository restaurantRepository;

    @BeforeEach
    void setUp() {
        restaurantRepository = new RestaurantRepository();
    }

    @Test
    void testAddRestaurant() {
        Restaurant restaurant = new Restaurant("Food Court-1", Arrays.asList("BTM", "HSR"), new FoodItem("NI Thali", 100, 5), new ArrayList<>());
        restaurantRepository.addRestaurant(restaurant);
        assertEquals(restaurant, restaurantRepository.getRestaurantByName("Food Court-1"));
    }

    @Test
    void testGetRestaurantByName() {
        Restaurant restaurant = new Restaurant("Food Court-1",Arrays.asList("BTM", "HSR"), new FoodItem("NI Thali", 100, 5), new ArrayList<>());
        restaurantRepository.addRestaurant(restaurant);
        assertNotNull(restaurantRepository.getRestaurantByName("Food Court-1"));
        assertNull(restaurantRepository.getRestaurantByName("Food Court-2"));
    }
}