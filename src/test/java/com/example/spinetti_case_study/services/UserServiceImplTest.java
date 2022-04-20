package com.example.spinetti_case_study.services;

import com.example.spinetti_case_study.models.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceImplTest {

    @Autowired
    private UserService userService;


    @Test
    void getAllUsers() {

        List<User> allUsers = userService.getAllUsers();
        int beforeAddingMoreUsers = allUsers.size();

        User user = new User();
        user.setUserName("testName");
        user.setEmail("test@email.com");
        user.setFirstName("testFirstName");
        user.setLastName("testLastName");
        user.setPassword("testPassword");
        userService.saveUser(user);
        int afterAddingMoreUsers = userService.getAllUsers().size();

        Assertions.assertThat(afterAddingMoreUsers).isEqualTo(beforeAddingMoreUsers + 1);
        Assertions.assertThat(allUsers.contains(user));

    }

    @Test
    void saveUser() {
        User user = new User();
        user.setUserName("testName");
        user.setEmail("test@email.com");
        user.setFirstName("testFirstName");
        user.setLastName("testLastName");
        user.setPassword("testPassword");
        userService.saveUser(user);
        Assertions.assertThat(userService.getAllUsers().contains(user));
    }

    @Test
    void getUserById() {
        List<User> allUsers = userService.getAllUsers();
        User user = allUsers.get(0);
        if (user != null) {
            User userById = userService.getUserById(user.getId());
            Assertions.assertThat(userById).isEqualTo(userById);
        }
    }

    @Test
    void deleteUserById() {
        List<User> allUsers = userService.getAllUsers();
        User user = allUsers.get(0);
        if (user != null) {
            userService.deleteUserById(user.getId());
            Assertions.assertThat(userService.getAllUsers().contains(user)).isFalse();
        }
    }
}