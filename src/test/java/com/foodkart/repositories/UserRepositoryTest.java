package com.foodkart.repositories;

import com.foodkart.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    void testAddUser() {
        User user = new User("1", "Pralove", "M", "phoneNumber-1", "HSR");
        userRepository.addUser(user);
        assertEquals(user, userRepository.getUserByPhoneNumber("phoneNumber-1"));
    }

    @Test
    void testGetUserByPhoneNumber() {
        User user = new User("1", "Pralove", "M", "phoneNumber-1", "HSR");
        userRepository.addUser(user);
        assertNotNull(userRepository.getUserByPhoneNumber("phoneNumber-1"));
        assertNull(userRepository.getUserByPhoneNumber("phoneNumber-2"));
    }
}