package com.daniil.supportapp.services;

import com.daniil.supportapp.repositories.UserRepository;
import com.daniil.supportapp.models.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	public User createUser(User user){
		return userRepository.save(user);
	}
	public Optional<User> getUserById(Long id){
		return userRepository.findById(id);
	}
	public User updateUser(Long id, String name, String comment){
		User user = userRepository.findById(id).orElseThrow();

		user.setName(name);
		user.setComment(comment);

		return userRepository.save(user);

	}
	
}
