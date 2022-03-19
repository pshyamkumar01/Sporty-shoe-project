package com.shyam.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shyam.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	
	User findByPassword(String password);
}
