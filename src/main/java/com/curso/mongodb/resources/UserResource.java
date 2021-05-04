package com.curso.mongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.mongodb.domain.User;
import com.curso.mongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	// @GetMapping outra maneira
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
	
		return ResponseEntity.ok(userService.findAll());
	}

}