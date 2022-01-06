package com.example.sportsappbackend.service.impl;

import com.example.sportsappbackend.exception.ResourceNotFoundException;
import com.example.sportsappbackend.model.User;
import com.example.sportsappbackend.repository.UserRepository;
import com.example.sportsappbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		return userRepository.findUserById(id);
		
	}

	public User getUserByEmailAndPassword(String email, String password){
		User user = userRepository.findByEmailAndPassword(email,password);
		return userRepository.findByEmailAndPassword(email,password);
	}

	@Override
	public User updateUser(User user, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		User existingUser = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "Id", id));
		
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		// save existing employee to DB
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		
		// check whether a employee exist in a DB or not
		userRepository.findById(id).orElseThrow(() ->
								new ResourceNotFoundException("User", "Id", id));
		userRepository.deleteById(id);
	}
	
}
