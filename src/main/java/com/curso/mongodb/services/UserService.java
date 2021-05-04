package com.curso.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.mongodb.domain.User;
import com.curso.mongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
		
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
}
