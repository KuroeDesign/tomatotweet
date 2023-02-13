package com.hb.tomatotweet.services;


import com.hb.tomatotweet.dtos.PostDTO;
import com.hb.tomatotweet.models.Post;
import com.hb.tomatotweet.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
	
	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public List<PostDTO> getPosts() {
		List<Post> posts = postRepository.getPosts();
		List<PostDTO> postsDtos = new ArrayList<>();
		
		posts.forEach((post) -> { 
					postsDtos.add(new PostDTO(post.getId().toString(), post.getCategory(), post.getContent())); 
				});
		
		return postsDtos;
	}
	
	public void addPost(PostDTO postDTO) {
		Post post = new Post();
		post.setContent(postDTO.content());
		post.setCategory(postDTO.category());
		postRepository.save(post);
	}
	
}
