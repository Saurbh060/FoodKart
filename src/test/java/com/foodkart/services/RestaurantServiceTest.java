package com.foodkart.services;

import com.foodkart.models.*;
import com.foodkart.repositories.RestaurantRepository;
import com.foodkart.repositories.UserRepository;
import com.foodkart.services.impl.RestaurantServiceImpl;
import com.foodkart.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
public class RestaurantServiceTest {

    private RestaurantService restaurantService;
    private UserService userService;
    private RestaurantRepository restaurantRepository;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        restaurantRepository = new RestaurantRepository();
        userService = new UserServiceImpl(userRepository);
        restaurantService = new RestaurantServiceImpl(restaurantRepository, userService);
    }

    @Test
    void testRegisterRestaurant() {
        User user = new User("1", "Pralove", "M", "phoneNumber-1", "HSR");
        userService.registerUser(user);
        userService.loginUser("phoneNumber-1");

        Restaurant restaurant = new Restaurant("Food Court-1", Arrays.asList("BTM", "HSR"), new FoodItem("NI Thali", 100, 5), new ArrayList<>());
        restaurantService.registerRestaurant(restaurant);
        assertEquals(restaurant, restaurantRepository.getRestaurantByName("Food Court-1"));
    }

    @Test
    void testUpdateQuantity() {
        User user = new User("1", "Pralove", "M", "phoneNumber-1", "HSR");
        userService.registerUser(user);
        userService.loginUser("phoneNumber-1");

        Restaurant restaurant = new Restaurant("Food Court-1", Arrays.asList("BTM", "HSR"), new FoodItem("NI Thali", 100, 5), new ArrayList<>());
        restaurantService.registerRestaurant(restaurant);

        restaurantService.updateQuantity("Food Court-1", 10);
        assertEquals(15, restaurantRepository.getRestaurantByName("Food Court-1").getFoodItem().getQuantity());
    }

    @Test
    void testRateRestaurant() {
        User user = new User("1", "Pralove", "M", "phoneNumber-1", "HSR");
        userService.registerUser(user);
        userService.loginUser("phoneNumber-1");

        Restaurant restaurant = new Restaurant("Food Court-1", Arrays.asList("BTM", "HSR"), new FoodItem("NI Thali", 100, 5), new ArrayList<>());
        restaurantService.registerRestaurant(restaurant);

        Rating rating = new Rating(user, 5, "Nice Food");
        restaurantService.rateRestaurant("Food Court-1", rating);

        assertTrue(restaurantRepository.getRestaurantByName("Food Court-1").getRatings().contains(rating));
    }

    @Test
    void testShowRestaurantsByPrice() {
        User user = new User("1", "Pralove", "M", "phoneNumber-1", "HSR");
        userService.registerUser(user);
        userService.loginUser("phoneNumber-1");

        Restaurant restaurant1 = new Restaurant("Food Court-1",Arrays.asList("BTM", "HSR"), new FoodItem("NI Thali", 100, 5), new ArrayList<>());
        Restaurant restaurant2 = new Restaurant("Food Court-2", Arrays.asList("BTM"), new FoodItem("Burger", 120, 3), new ArrayList<>());

        restaurantService.registerRestaurant(restaurant1);
        restaurantService.registerRestaurant(restaurant2);

        List<Restaurant> restaurants = restaurantService.showRestaurants("price");
        assertEquals("Food Court-2", restaurants.get(0).getName());
        assertEquals("Food Court-1", restaurants.get(1).getName());
    }
}