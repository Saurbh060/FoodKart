package com.foodkart.services.impl;

import com.foodkart.models.Rating;
import com.foodkart.models.Restaurant;
import com.foodkart.repositories.RestaurantRepository;
import com.foodkart.services.RestaurantService;
import com.foodkart.services.UserService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository restaurantRepository;
    private UserService userService;
    private static final Logger logger = Logger.getLogger(RestaurantServiceImpl.class.getName());

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, UserService userService) {
        this.restaurantRepository = restaurantRepository;
        this.userService = userService;
    }

    @Override
    public void registerRestaurant(Restaurant restaurant) {
        restaurantRepository.addRestaurant(restaurant);
        logger.info("Restaurant registered: " + restaurant.getName());
    }

    @Override
    public void updateQuantity(String restaurantName, int quantity) {
        Restaurant restaurant = restaurantRepository.getRestaurantByName(restaurantName);
        if (restaurant != null) {
            restaurant.updateQuantity(quantity);
            logger.info("Quantity updated for restaurant: " + restaurantName);
        } else {
            logger.warning("Restaurant not found: " + restaurantName);
        }
    }

    @Override
    public void rateRestaurant(String restaurantName, Rating rating) {
        Restaurant restaurant = restaurantRepository.getRestaurantByName(restaurantName);
        if (restaurant != null) {
            restaurant.addRating(rating);
            logger.info("Restaurant rated: " + restaurantName + " with rating " + rating.getRating());
        } else {
            logger.warning("Restaurant not found: " + restaurantName);
        }
    }

    @Override
    public List<Restaurant> showRestaurants(String sortBy) {
        List<Restaurant> serviceableRestaurants = new ArrayList<>();
        String userPincode = userService.getCurrentUser().getPincode();
        for (Restaurant restaurant : restaurantRepository.getAllRestaurants()) {
            if (restaurant.isServiceable(userPincode)) {
                serviceableRestaurants.add(restaurant);
            }
        }

        if (sortBy.equals("rating")) {
            serviceableRestaurants.sort(Comparator.comparingDouble(Restaurant::getAverageRating).reversed());
        } else if (sortBy.equals("price")) {
            serviceableRestaurants.sort(Comparator.comparingDouble(r -> r.getFoodItem().getPrice()));
        }

        return serviceableRestaurants;
    }
}