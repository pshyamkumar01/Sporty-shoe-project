package com.shyam.springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shyam.springboot.entity.User;
import com.shyam.springboot.repository.UserRepository;
import com.shyam.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	 private UserRepository userRepository;
	
	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public User addNewUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public User getUserByPass(String password) {
		// TODO Auto-generated method stub
		return userRepository.findByPassword(password);
	}

}
