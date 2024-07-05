package com.foodkart;

import com.foodkart.models.FoodItem;
import com.foodkart.models.Rating;
import com.foodkart.models.Restaurant;
import com.foodkart.models.User;

import java.util.ArrayList;
import java.util.Arrays;

public class FoodKartAppDriver {
    public static void main(String[] args) {
        FoodKartApp app = new FoodKartApp();

        app.getUserService().registerUser(new User("1", "Pralove", "M", "phoneNumber-1", "HSR"));
        app.getUserService().registerUser(new User("2", "Nitesh", "M", "phoneNumber-2", "BTM"));
        app.getUserService().registerUser(new User("3", "Vatsal", "M", "phoneNumber-3", "BTM"));

        app.getUserService().loginUser("phoneNumber-1");

        app.getRestaurantService().registerRestaurant(
                new Restaurant("Food Court-1", Arrays.asList("BTM", "HSR"), new FoodItem("NI Thali", 100, 5), new ArrayList<>())
        );

        app.getRestaurantService().registerRestaurant(
                new Restaurant("Food Court-2", Arrays.asList("BTM"), new FoodItem("Burger", 120, 3), new ArrayList<>())
        );

        app.getUserService().loginUser("phoneNumber-2");

        app.getRestaurantService().registerRestaurant(
                new Restaurant("Food Court-3", Arrays.asList("HSR"), new FoodItem("SI Thali", 150, 1), new ArrayList<>())
        );

        app.getUserService().loginUser("phoneNumber-3");
        System.out.println(app.getRestaurantService().showRestaurants("price"));

        app.getOrderService().placeOrder("Food Court-1", 2);
        app.getOrderService().placeOrder("Food Court-2", 7);

        app.getRestaurantService().rateRestaurant("Food Court-2", new Rating(app.getUserService().getCurrentUser(), 3, "Good Food"));
        app.getRestaurantService().rateRestaurant("Food Court-1", new Rating(app.getUserService().getCurrentUser(), 5, "Nice Food"));
        System.out.println(app.getRestaurantService().showRestaurants("rating"));

        app.getUserService().loginUser("phoneNumber-1");
        app.getRestaurantService().updateQuantity("Food Court-2", 5);

        app.getRestaurantService().registerRestaurant(
                new Restaurant("Food Court-2", Arrays.asList("BTM", "HSR"), new FoodItem("Burger", 120, 8), new ArrayList<>())
        );
    }
}