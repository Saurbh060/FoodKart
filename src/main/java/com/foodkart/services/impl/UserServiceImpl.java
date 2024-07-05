package com.foodkart.services.impl;

import com.foodkart.models.User;
import com.foodkart.repositories.UserRepository;
import com.foodkart.services.UserService;

import java.util.logging.Logger;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private User currentUser;
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        userRepository.addUser(user);
        logger.info("User registered: " + user.getName());
    }

    @Override
    public void loginUser(String phoneNumber) {
        User user = userRepository.getUserByPhoneNumber(phoneNumber);
        if (user != null) {
            currentUser = user;
            logger.info("User logged in: " + user.getName());
        } else {
            logger.warning("User not found: " + phoneNumber);
        }
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }
}