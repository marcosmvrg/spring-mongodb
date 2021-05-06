package com.curso.mongodb.services;

import java.util.Date;
import java.util.List;

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
		
	public List<Post> findByTitle(String title) {
		return this.postRepository.searchTitle(title);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
				
		return this.postRepository.fullSearch(text, minDate, maxDate);
	}
	
}
