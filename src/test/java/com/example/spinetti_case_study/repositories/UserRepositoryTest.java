package com.example.spinetti_case_study.repositories;

import com.example.spinetti_case_study.models.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByEmail_should_return_user_given_valid_email() {
        User user = userRepository.findByEmail("basic@email.com");
        Assertions.assertThat(user.getEmail()).isEqualTo("basic@email.com");
    }
}