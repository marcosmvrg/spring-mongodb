package com.curso.mongodb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.mongodb.domain.Post;
import com.curso.mongodb.repository.PostRepository;
import com.curso.mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
				
	public Post findById(String id) {
		Post post = postRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(String.format("Post do id: %s não encontrado.", id)));
		
		return post;
	}
}
