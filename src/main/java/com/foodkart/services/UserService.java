package com.foodkart.services;

import com.foodkart.models.User;

public interface UserService {
    void registerUser(User user);
    void loginUser(String phoneNumber);

    User getCurrentUser();
}