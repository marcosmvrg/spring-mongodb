package com.curso.mongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.mongodb.domain.Post;
import com.curso.mongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService postService;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {

		return ResponseEntity.ok().body(postService.findById(id));
	}

}
