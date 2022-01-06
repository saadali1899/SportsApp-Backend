package com.example.sportsappbackend.controller;


import com.example.sportsappbackend.model.User;
import com.example.sportsappbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// build create user REST API
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody User user) {
		User user1 = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
		if (user1 != null) {
			return new ResponseEntity<String>("User logged in successfully!", HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("No User found",HttpStatus.NOT_FOUND);
	}


	// build get all user REST API
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	// build get user by id REST API
	// http://localhost:8080/api/user/1
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long userId){
		User user = userService.getUserById(userId);
		if (user != null) {
			return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
		}
		else
			return new ResponseEntity<User>((User) null, HttpStatus.NOT_FOUND);

	}
	
	// build update user REST API
	// http://localhost:8080/api/user/1
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id
												  ,@RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
	}
	
	// build delete user REST API
	// http://localhost:8080/api/user/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
		// delete user from DB
		User user = userService.getUserById(id);
		if (user != null) {
			userService.deleteUser(id);
			return new ResponseEntity<String>("User deleted successfully!.", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
		}
	}
}
