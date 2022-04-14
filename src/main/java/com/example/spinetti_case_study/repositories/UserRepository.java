package com.example.spinetti_case_study.repositories;

import com.example.spinetti_case_study.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long Id);
    User findByEmail(String email);
}
