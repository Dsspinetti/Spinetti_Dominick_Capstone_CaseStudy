package com.example.spinetti_case_study.services;

import com.example.spinetti_case_study.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);

    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}

