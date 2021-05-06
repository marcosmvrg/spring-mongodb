package com.curso.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.mongodb.domain.User;
import com.curso.mongodb.repository.UserRepository;
import com.curso.mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
		
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(String.format("Usuário do id: %s não encontrado.", id)));
		
		return user;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
}
