package com.curso.mongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.mongodb.dto.UserDTO;
import com.curso.mongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;

	// @GetMapping outra maneira
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {

		return ResponseEntity.ok(userService.
				findAll().stream()
				.map(u -> new UserDTO(u))
				.collect(Collectors.toList()));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {

		return ResponseEntity.ok().body(new UserDTO(userService.findById(id)));
	}

}
