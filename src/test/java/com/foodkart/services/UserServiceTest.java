package com.foodkart.services;

import com.foodkart.repositories.UserRepository;

import com.foodkart.models.*;
import com.foodkart.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void testRegisterUser() {
        User user = new User("1", "Pralove", "M", "phoneNumber-1", "HSR");
        userService.registerUser(user);
        assertEquals(user, userRepository.getUserByPhoneNumber("phoneNumber-1"));
    }

    @Test
    void testLoginUser() {
        User user = new User("1", "Pralove", "M", "phoneNumber-1", "HSR");
        userService.registerUser(user);
        userService.loginUser("phoneNumber-1");
        assertEquals(user, ((UserServiceImpl) userService).getCurrentUser());
    }
}