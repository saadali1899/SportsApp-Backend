package com.example.sportsappbackend.repository;


import com.example.sportsappbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
    User findUserById(long id);
}
