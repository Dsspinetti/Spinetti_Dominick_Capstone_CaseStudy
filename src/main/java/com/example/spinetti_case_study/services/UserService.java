package com.example.spinetti_case_study.services;

import com.example.spinetti_case_study.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);
}

