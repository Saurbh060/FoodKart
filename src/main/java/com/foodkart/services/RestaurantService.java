package com.foodkart.services;

import com.foodkart.models.Rating;
import com.foodkart.models.Restaurant;

import java.util.List;

public interface RestaurantService {
    void registerRestaurant(Restaurant restaurant);
    void updateQuantity(String restaurantName, int quantity);
    void rateRestaurant(String restaurantName, Rating rating);
    List<Restaurant> showRestaurants(String sortBy);
}