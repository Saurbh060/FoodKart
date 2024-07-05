package com.foodkart.repositories;

import com.foodkart.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getPhoneNumber(), user);
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        return users.get(phoneNumber);
    }
}