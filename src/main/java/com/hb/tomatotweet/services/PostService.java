package com.hb.tomatotweet.services;

import com.hb.blog.configuration.SecurityConfig;
import com.hb.blog.dtos.PostDTO;
import com.hb.blog.models.Post;
import com.hb.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
					postsDtos.add(new PostDTO(post.getId().toString(), post.getTitle(), post.getContent())); 
				});
		
		return postsDtos;
	}
	
	public void addPost(PostDTO postDTO) {
		Post post = new Post();
		post.setTitle(postDTO.title());
		post.setContent(postDTO.content());
		post.setCreatorName(SecurityConfig.getUserName());
		post.setCreationDate(new Date());
		
		postRepository.save(post);
	}
	
}
