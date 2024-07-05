package com.foodkart.models;

import java.util.List;

public class Restaurant {

    private String name;
    private List<String> serviceablePincodes;
    private FoodItem foodItem;
    private List<Rating> ratings;
    private double averageRating;


    public Restaurant(String name, List<String> serviceablePincodes, FoodItem foodItem, List<Rating> ratings) {
        this.name = name;
        this.serviceablePincodes = serviceablePincodes;
        this.foodItem = foodItem;
        this.ratings = ratings;
    }

    public double getAverageRating() {
        return ratings.stream().mapToInt(Rating::getRating).average().orElse(0.0);
    }

    public boolean isServiceable(String pincode) {
        return serviceablePincodes.contains(pincode);
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public void updateQuantity(int quantity) {
        foodItem.setQuantity(foodItem.getQuantity() + quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getServiceablePincodes() {
        return serviceablePincodes;
    }

    public void setServiceablePincodes(List<String> serviceablePincodes) {
        this.serviceablePincodes = serviceablePincodes;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}