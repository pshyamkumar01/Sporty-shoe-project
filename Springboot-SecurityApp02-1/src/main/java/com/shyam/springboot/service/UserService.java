package com.shyam.springboot.service;

import java.util.List;

import com.shyam.springboot.entity.User;

public interface UserService {

	List<User> getUserList();
	
	User getUserById(Long id);
	
	User addNewUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(Long id);
	
	User getUserByName(String username);
	
	User getUserByPass(String password);
}
