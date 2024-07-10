package com.daniil.supportapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniil.supportapp.models.User;
import com.daniil.supportapp.services.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return userService.getAllUser();
	}
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id).orElseThrow();
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userData) {
		User updatedUser = userService.updateUser(id, userData.getName(), userData.getComment());
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	@PostMapping("/add/user")
	public ResponseEntity<User> createUser(@RequestBody User userData) {
		User newUser = userService.createUser(userData);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
