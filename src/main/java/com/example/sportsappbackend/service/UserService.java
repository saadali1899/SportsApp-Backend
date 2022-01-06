package com.example.sportsappbackend.service;

import com.example.sportsappbackend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUsers();
	User getUserById(long id);
	User updateUser(User user, long id);
	User getUserByEmailAndPassword(String email, String password);
	void deleteUser(long id);
}
